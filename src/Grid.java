
/**
 * @author Mark Channer
 *         The grid on which the game will take place
 */
public class Grid {

    private static final int COL = 0;
    private static final int ROW = 1;
    private Tile[][] tiles;
    private final int cols;
    private final int rows;
    private boolean firstTileSelected;
    private int[] e1 = new int[2];
    private int[] e2 = new int[2];

    public Grid(int size) {
        this.cols = size;
        this.rows = size;
        this.tiles = new TileImpl[cols][rows];
        this.firstTileSelected = false;
    }

    public void populateGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i % 2 == 0) {
                    if (j == 0) {
                        tiles[i][j] = new TileImpl(i, j, new AngryGamePiece("A"));
                    } else if (j == 1) {
                        tiles[i][j] = new TileImpl(i, j, new ConfusedGamePiece("C"));
                    } else if (j == 2) {
                        tiles[i][j] = new TileImpl(i, j, new HappyGamePiece("H"));
                    } else if (j == 3) {
                        tiles[i][j] = new TileImpl(i, j, new ExcitedGamePiece("E"));
                    } else if (j == 4) {
                        tiles[i][j] = new TileImpl(i, j, new AngryGamePiece("A"));
                    } else if (j == 5) {
                        tiles[i][j] = new TileImpl(i, j, new HappyGamePiece("H"));
                    } else {
                        tiles[i][j] = new TileImpl(i, j, new SadGamePiece("S"));
                    }
                } else {
                    if (j == 6) {
                        tiles[i][j] = new TileImpl(i, j, new AngryGamePiece("A"));
                    } else if (j == 5) {
                        tiles[i][j] = new TileImpl(i, j, new ConfusedGamePiece("C"));
                    } else if (j == 4) {
                        tiles[i][j] = new TileImpl(i, j, new HappyGamePiece("H"));
                    } else if (j == 3) {
                        tiles[i][j] = new TileImpl(i, j, new SadGamePiece("S"));
                    } else if (j == 2) {
                        tiles[i][j] = new TileImpl(i, j, new ExcitedGamePiece("E"));
                    } else if (j == 4) {
                        tiles[i][j] = new TileImpl(i, j, new ExcitedGamePiece("E"));
                    } else {
                        tiles[i][j] = new TileImpl(i, j, new HappyGamePiece("H"));
                    }
                }
            }
        }
        tiles[3][0] = new TileImpl(3, 0, new HappyGamePiece("H"));
        tiles[3][1] = new TileImpl(3, 1, new AngryGamePiece("A"));
        tiles[3][2] = new TileImpl(3, 2, new AngryGamePiece("A"));
        tiles[3][3] = new TileImpl(3, 3, new SadGamePiece("S"));
        tiles[3][4] = new TileImpl(3, 4, new AngryGamePiece("A"));
        tiles[3][5] = new TileImpl(3, 5, new SadGamePiece("S"));
        tiles[3][6] = new TileImpl(3, 6, new SadGamePiece("S"));
        tiles[4][6] = new TileImpl(4, 6, new ConfusedGamePiece("C"));
        tiles[1][4] = new TileImpl(1, 4, new SadGamePiece("S"));
        tiles[2][4] = new TileImpl(2, 4, new SadGamePiece("S"));
        tiles[4][4] = new TileImpl(4, 4, new SadGamePiece("S"));
        tiles[5][4] = new TileImpl(5, 4, new SadGamePiece("S"));
        tiles[1][3] = new TileImpl(1, 3, new AngryGamePiece("A"));
        tiles[2][3] = new TileImpl(2, 3, new AngryGamePiece("A"));
        tiles[4][3] = new TileImpl(4, 3, new AngryGamePiece("A"));
        tiles[5][3] = new TileImpl(5, 3, new AngryGamePiece("A"));

        resetBothButtons();
    }

    public void displayGrid() {
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print("  " + i + " ");
            System.out.print("| ");
            for (int j = 0; j < cols; j++) {
                System.out.print(tiles[i][j].getFace() + " | ");
            }
            System.out.println();
        }
        System.out.print("      ");
        for (int k = 0; k < rows; k++) System.out.print(k + "   ");
        System.out.println();
    }

    public void selectEmoticon(int newCol, int newRow) {
        if (!firstTileSelected) {
            System.out.println("Button1: (" + newCol + "," + newRow + ")");
            firstTileSelected = true;
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
            firstTileSelected = false;
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
        firstTileSelected = false;
        e1[COL] = -1;
        e1[ROW] = -1;
        e2[COL] = -5;
        e2[ROW] = -5;
    }

    private void attemptToSwap() {
        System.out.println("Pre: First button: " + tiles[e1[COL]][e1[ROW]].getFace() + ", Second button: " + tiles[e2[COL]][e2[ROW]].getFace());
        if (bothDisplaySameEmotion()) {
            System.out.println("Both icons same emotion. No point in swapping");
        } else {
            GamePiece temp = tiles[e1[COL]][e1[ROW]].getFace();
            tiles[e1[COL]][e1[ROW]].setFace(tiles[e2[COL]][e2[ROW]].getFace());
            tiles[e2[COL]][e2[ROW]].setFace(temp);
            System.out.println("Post: First button: " + tiles[e1[COL]][e1[ROW]].getFace() + ", Second button: " + tiles[e2[COL]][e2[ROW]].getFace());
            //calculateConsecutiveEmotions();
        }
        displayGrid();
    }

    private boolean bothDisplaySameEmotion() {
        return ((tiles[e1[COL]][e1[ROW]].getFace().equals(tiles[e2[COL]][e2[ROW]].getFace())));
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
