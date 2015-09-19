/**
 * @author Mark Channer
 *         The grid on which the game will take place
 */
public class Grid {

    private FaceIcon[] emoticons; // This will just be a single array to start with
    private boolean firstEmoticonSelected;
    private int emoticon1;


    public Grid() {
        emoticons = new FaceIcon[6];
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

    public void selectEmoticon(int selectedEmoticon) {
        if (!firstEmoticonSelected) {
            System.out.println("First Emoticon Pressed");
            firstEmoticonSelected = true;
            emoticon1 = selectedEmoticon;
        } else {
            System.out.println("Second Emoticon Pressed");
            if (!sameEmoticonPressedTwice(selectedEmoticon)) {
                if (selectedEmoticonsAreAdjacent(selectedEmoticon)) {
                    System.out.println("Selected emoticons are adjacent!");
                } else {
                    System.out.println("Selected emoticons are NOT adjacent");
                }
                firstEmoticonSelected = false;
                emoticon1 = -1;
            } else {
                System.out.println("Same emoticon button pushed twice. (Try a different one)"); // Loop input within this method later
            }
        }
    }

    private boolean sameEmoticonPressedTwice(int selectedEmoticon) {
        return (emoticon1 == selectedEmoticon);
    }

    private boolean selectedEmoticonsAreAdjacent(int selectedEmoticon) {
        if ((emoticon1 + 1) == selectedEmoticon || (emoticon1 - 1) == selectedEmoticon) return true;
        return false;
    }

    public void swapIcons(int a, int b) {

    }
}
