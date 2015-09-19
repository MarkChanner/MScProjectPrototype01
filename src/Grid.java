/**
 * @author Mark Channer
 *         The grid on which the game will take place
 */
public class Grid {

    private FaceIcon[] emoticons; // This will just be a single array to start with
    private boolean firstEmoticonSelected;
    private int emoticon1;
    private static final int GRID_SIZE = 6;


    public Grid() {
        emoticons = new FaceIcon[GRID_SIZE];
        firstEmoticonSelected = false;
        populateGrid();
        displayGrid();
    }

    public void populateGrid() {
        emoticons[0] = new AngryFaceIcon();
        emoticons[1] = new AngryFaceIcon();
        emoticons[2] = new SadFaceIcon();
        emoticons[3] = new ConfusedFaceIcon();
        emoticons[4] = new SadFaceIcon();
        emoticons[5] = new SadFaceIcon();

        emoticon1 = -1;
    }

    public void displayGrid() {
        System.out.print("| ");
        for (FaceIcon e : emoticons) System.out.print(e + " | ");
        System.out.println();
    }

    public String getEmoticon(FaceIcon emoticon) {
        return emoticon.showEmotion();
    }

    public void selectEmoticon(int emoticon) {
        if (!firstEmoticonSelected) {
            System.out.println("First Emoticon Pressed");
            firstEmoticonSelected = true;
            emoticon1 = emoticon;
        } else {
            compareFirstEmoticonWithSecond(emoticon);
        }
    }

    public void compareFirstEmoticonWithSecond(int emoticon2) {
        System.out.println("Second Emoticon Pressed");
        if (!sameEmoticonPressedTwice(emoticon2)) {
            if (selectedEmoticonsAreAdjacent(emoticon2)) {
                System.out.println("Selected emoticons are adjacent");
                attemptToSwap(emoticon2);
            } else {
                System.out.println("Selected emoticons are NOT adjacent");
            }
            firstEmoticonSelected = false;
            emoticon1 = -1;
        } else {
            System.out.println("Same emoticon button pushed twice. (Try a different one)"); // Loop input within this method later
        }
    }

    private boolean sameEmoticonPressedTwice(int selectedEmoticon) {
        return (emoticon1 == selectedEmoticon);
    }

    private boolean selectedEmoticonsAreAdjacent(int selectedEmoticon) {
        if ((emoticon1 + 1) == selectedEmoticon || (emoticon1 - 1) == selectedEmoticon) return true;
        return false;
    }

    public void attemptToSwap(int emoticon2) {
        if (bothDisplaySameEmotion(emoticon2)) {
            System.out.println("Both icons same emotion. No point in swapping");
        } else {
            FaceIcon temp = emoticons[emoticon1];
            emoticons[emoticon1] = emoticons[emoticon2];
            emoticons[emoticon2] = temp;
            System.out.println("Swapped");
        }
        displayGrid();
    }

    public boolean bothDisplaySameEmotion(int emoticon2) {
        System.out.println("Emoticon1: " + emoticons[emoticon1] + ", Emoticon2: " + emoticons[emoticon2]);
        if (emoticons[emoticon1].showEmotion().equals(emoticons[emoticon2].showEmotion())) return true;
        else return false;
    }
}
