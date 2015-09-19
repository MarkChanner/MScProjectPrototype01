/**
 * @author Mark Channer
 *         The grid on which the game will take place
 */
public class Grid {

    private FaceIcon[] emoticons; // This will just be a single array to start with
    private boolean firstEmoticonSelected;
    private int emoticon1;
    private int emoticon2;
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
        emoticons[2] = new SadFaceIcon();
        emoticons[3] = new ConfusedFaceIcon();
        emoticons[4] = new SadFaceIcon();
        emoticons[5] = new SadFaceIcon();

        emoticon1 = -1;
        emoticon2 = -1;
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
            emoticon1 = emoticon;
        } else {
            emoticon2 = emoticon;
            compareFirstEmoticonWithSecond();
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
            emoticon1 = -1;
        } else {
            System.out.println("Same emoticon button pushed twice. (Try a different one)"); // Loop input within this method later
        }
    }

    private boolean sameEmoticonPressedTwice() {
        return (emoticon1 == emoticon2);
    }

    private boolean selectedEmoticonsAreAdjacent() {
        return ((emoticon1 + 1) == emoticon2 || (emoticon1 - 1) == emoticon2);
    }

    private void attemptToSwap() {
        if (bothDisplaySameEmotion()) {
            System.out.println("Both icons same emotion. No point in swapping");
        } else {
            FaceIcon temp = emoticons[emoticon1];
            emoticons[emoticon1] = emoticons[emoticon2];
            emoticons[emoticon2] = temp;
            System.out.println("Swapped");
        }
        calculateConsecutiveEmotions();
        displayGrid();
    }

    private void calculateConsecutiveEmotions() {

    }

    private boolean bothDisplaySameEmotion() {
        System.out.println("Emoticon1: " + emoticons[emoticon1] + ", Emoticon2: " + emoticons[emoticon2]);
        return (emoticons[emoticon1].showEmotion().equals(emoticons[emoticon2].showEmotion()));
    }
}
