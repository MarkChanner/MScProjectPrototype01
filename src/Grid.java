import java.util.HashMap;
import java.util.Map;

/**
 * @author Mark Channer
 *         The grid on which the game will take place
 */
public class Grid {

    private FaceIcon[] emoticons; // This will just be a single array to start with
    private boolean firstEmoticonSelected;
    private int e1;
    private int e2;
    private static final int GRID_SIZE = 6;


    public Grid() {
        emoticons = new FaceIcon[GRID_SIZE];
        firstEmoticonSelected = false;
        populateGrid();
        displayGrid();
    }

    private void populateGrid() {
        emoticons[0] = new AngryFaceIcon();
        emoticons[1] = new AngryFaceIcon();
        emoticons[2] = new AngryFaceIcon();
        emoticons[3] = new AngryFaceIcon();
        emoticons[4] = new ConfusedFaceIcon();
        emoticons[5] = new AngryFaceIcon();
        e1 = -1;
        e2 = -1;
    }

    private void displayGrid() {
        System.out.print("| ");
        for (FaceIcon e : emoticons) System.out.print(e + " | ");
        System.out.println();
    }

    public void selectEmoticon(int emoticon) {
        if (!firstEmoticonSelected) {
            System.out.println("First Emoticon Pressed");
            firstEmoticonSelected = true;
            e1 = emoticon;
        } else {
            e2 = emoticon;
            makeE2HigherThanE1();
            compareFirstEmoticonWithSecond();
        }
    }

    private void makeE2HigherThanE1() {
        if (e1 > e2) {
            int temp = e1;
            e1 = e2;
            e2 = temp;
        }
    }

    private void compareFirstEmoticonWithSecond() {
        System.out.println("Second Emoticon Pressed");
        if (!sameEmoticonPressedTwice()) {
            if (selectedEmoticonsAreAdjacent()) {
                System.out.println("Selected emoticons are adjacent");
                attemptToSwap();
            } else {
                System.out.println("Selected emoticons are NOT adjacent");
            }
            firstEmoticonSelected = false;
            e1 = -1;
            e2 = -1;
        } else {
            System.out.println("Same emoticon button pushed twice. (Try a different one)"); // Loop input within this method later
        }
    }

    private boolean sameEmoticonPressedTwice() {
        return (e1 == e2);
    }

    private boolean selectedEmoticonsAreAdjacent() {
        return ((e1 + 1) == e2 || (e1 - 1) == e2);
    }

    private void attemptToSwap() {
        System.out.println("Pre-swap: Emoticon1: " + emoticons[e1] + ", Emoticon2: " + emoticons[e2]);
        if (bothDisplaySameEmotion()) {
            System.out.println("Both icons same emotion. No point in swapping");
        } else {
            FaceIcon temp = emoticons[e1];
            emoticons[e1] = emoticons[e2];
            emoticons[e2] = temp;
            System.out.println("Post-swap: Emoticon1: " + emoticons[e1] + ", Emoticon2: " + emoticons[e2]);
            calculateConsecutiveEmotions();
        }
        displayGrid();
    }

    private boolean bothDisplaySameEmotion() {
        return (emoticons[e1].showEmotion().equals(emoticons[e2].showEmotion()));
    }

    private void calculateConsecutiveEmotions() {
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
    }
}
