
/**
 * @author Mark Channer
 *         The grid on which the game will take place
 */
public class Grid {

    private FaceIcon[][] emoticons; // This will just be a single array to start with
    private boolean firstEmoticonSelected;
    private int[] e1 = new int[2];
    private int[] e2 = new int[2];

    private static final int GRID_SIZE = 7;
    private static final int COL = 0;
    private static final int ROW = 1;
    private static final int MAX_ROW = GRID_SIZE;
    private static final int MAX_COL = GRID_SIZE;

    public Grid() {
        emoticons = new FaceIcon[MAX_ROW][MAX_COL];
        firstEmoticonSelected = false;
    }

    public void populateGrid() {
        for (int i = 0; i < MAX_ROW; i++) {
            for (int j = 0; j < MAX_COL; j++) {
                if (i % 2 == 0) {
                    if (j == 0) {
                        emoticons[i][j] = new AngryFaceIcon();
                    } else if (j == 1) {
                        emoticons[i][j] = new ConfusedFaceIcon();
                    } else if (j == 2) {
                        emoticons[i][j] = new HappyFaceIcon();
                    } else if (j == 3) {
                        emoticons[i][j] = new ExcitedFaceIcon();
                    } else if (j == 4) {
                        emoticons[i][j] = new AngryFaceIcon();
                    } else if (j == 5) {
                        emoticons[i][j] = new HappyFaceIcon();
                    } else {
                        emoticons[i][j] = new SadFaceIcon();
                    }
                } else {
                    if (j == 6) {
                        emoticons[i][j] = new AngryFaceIcon();
                    } else if (j == 5) {
                        emoticons[i][j] = new ConfusedFaceIcon();
                    } else if (j == 4) {
                        emoticons[i][j] = new HappyFaceIcon();
                    } else if (j == 3) {
                        emoticons[i][j] = new SadFaceIcon();
                    } else if (j == 2) {
                        emoticons[i][j] = new ExcitedFaceIcon();
                    } else if (j == 4) {
                        emoticons[i][j] = new ExcitedFaceIcon();
                    } else {
                        emoticons[i][j] = new HappyFaceIcon();
                    }
                }
            }
        }
        emoticons[3][0] = new HappyFaceIcon();
        emoticons[3][1] = new AngryFaceIcon();
        emoticons[3][2] = new AngryFaceIcon();
        emoticons[3][3] = new SadFaceIcon();
        emoticons[3][4] = new AngryFaceIcon();
        emoticons[3][5] = new SadFaceIcon();
        emoticons[3][6] = new SadFaceIcon();
        emoticons[4][6] = new ConfusedFaceIcon();
        emoticons[1][4] = new SadFaceIcon();
        emoticons[2][4] = new SadFaceIcon();
        emoticons[4][4] = new SadFaceIcon();
        emoticons[5][4] = new SadFaceIcon();
        emoticons[1][3] = new AngryFaceIcon();
        emoticons[2][3] = new AngryFaceIcon();
        emoticons[4][3] = new AngryFaceIcon();
        emoticons[5][3] = new AngryFaceIcon();

        e1[0] = -1;
        e1[1] = -1;
        e2[0] = -5;
        e2[1] = -5;
    }

    /*public void exchangeEmoticon(int col, int row, FaceIcon newEmoticon) {
        emoticons[col][row] = newEmoticon;
    }*/

    public void displayGrid() {
        System.out.println();
        for (int i = 0; i < MAX_ROW; i++) {
            System.out.print("  " + i + " ");
            System.out.print("| ");
            for (int j = 0; j < MAX_COL; j++) {
                System.out.print(emoticons[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.print("      ");
        for (int k = 0; k < MAX_ROW; k++) System.out.print(k + "   ");
        System.out.println();
    }

    public void selectEmoticon(int newCol, int newRow) {
        if (!firstEmoticonSelected) {
            System.out.println("Button1: (" + newCol + "," + newRow + ")");
            firstEmoticonSelected = true;
            e1[COL] = newCol;
            e1[ROW] = newRow;
        } else {
            System.out.println("Button2: (" + newCol + "," + newRow + ")");
            e2[COL] = newCol;
            e2[ROW] = newRow;
            compareFirstEmoticonWithSecond();
        }
    }

    private void compareFirstEmoticonWithSecond() {
        if (!sameButtonPressedTwice()) {
            if (selectedEmoticonsAreAdjacent()) {
                System.out.println("Selected buttons are valid to attempt swap");
                attemptToSwap();
            } else {
                System.out.println("Selected buttons are NOT adjacent. Last button pressed now first button pressed");
                e1[COL] = e2[COL];
                e1[ROW] = e2[ROW];
                e2[COL] = -5;
                e2[ROW] = -5;
            }
        } else {
            System.out.println("Same button pushed twice. Resetting.");
            firstEmoticonSelected = false;
            resetBothButtons();
        }
    }

    private boolean sameButtonPressedTwice() {
        return ((e1[COL] == e2[COL]) && (e1[ROW] == e2[ROW]));
    }

    private boolean selectedEmoticonsAreAdjacent() {
        if (e1[COL] == e2[COL]) {
            if (e1[ROW] == (e2[ROW] + 1) || e1[ROW] == (e2[ROW] - 1)) {
                return true;
            }
        } else {
            if (e1[ROW] == e2[ROW]) {
                if (e1[COL] == (e2[COL] + 1) || e1[COL] == (e2[COL] - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void resetBothButtons() {
        firstEmoticonSelected = false;
        e1[COL] = -1;
        e1[ROW] = -1;
        e2[COL] = -5;
        e2[ROW] = -5;
    }

    private void attemptToSwap() {
        System.out.println("Pre: First button: " + emoticons[e1[COL]][e1[ROW]] + ", Second button: " + emoticons[e2[COL]][e2[ROW]]);
        if (bothDisplaySameEmotion()) {
            System.out.println("Both icons same emotion. No point in swapping");
        } else {
            FaceIcon temp = emoticons[e1[COL]][e1[ROW]];
            emoticons[e1[COL]][e1[ROW]] = emoticons[e2[COL]][e2[ROW]];
            emoticons[e2[COL]][e2[ROW]] = temp;
            System.out.println("Post: First button: " + emoticons[e1[COL]][e1[ROW]] + ", Second button: " + emoticons[e2[COL]][e2[ROW]]);
            //calculateConsecutiveEmotions();
        }
        displayGrid();
    }

    private boolean bothDisplaySameEmotion() {
        if ((emoticons[e1[COL]][e1[ROW]].showEmotion().equals(emoticons[e2[COL]][e2[ROW]].showEmotion()))) return true;
        else return false;
    }

    /*private void calculateConsecutiveEmotions() {
        int counter = 1;
        Integer consecutiveLeft = checkConsecutiveLeft(e1, counter);
        ConsecutiveEmoticonsWrapper emoticonsLeft = new ConsecutiveEmoticonsWrapper(emoticons[e1], consecutiveLeft);
        System.out.println("Emotion: " + emoticonsLeft.getEmoticon() + " in a row: " + emoticonsLeft.getConsecutiveEmotions());
        Integer consecutiveRight = checkConsecutiveRight(e2, counter);
        ConsecutiveEmoticonsWrapper emoticonsRight = new ConsecutiveEmoticonsWrapper(emoticons[e2], consecutiveRight);
        System.out.println("Emotion: " + emoticonsRight.getEmoticon() + " in a row: " + emoticonsRight.getConsecutiveEmotions());
    }

    private Integer checkConsecutiveLeft(int gridPointer, int result) {
        if (gridPointer >= 1 && emoticons[gridPointer].showEmotion().equals(emoticons[gridPointer - 1].showEmotion())) {
            return (1 + checkConsecutiveLeft(gridPointer - 1, result));
        }
        return result;
    }

    private Integer checkConsecutiveRight(int gridPointer, int result) {
        if (gridPointer <= (GRID_SIZE - 2) && emoticons[gridPointer].showEmotion().equals(emoticons[gridPointer + 1].showEmotion())) {
            return (1 + checkConsecutiveRight(gridPointer + 1, result));
        }
        return result;
    }*/
}
