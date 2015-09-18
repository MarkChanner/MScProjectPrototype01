/**
 * @author Mark Channer
 *         The grid on which the game will take place
 */
public class Grid {

    private FaceIcon[] emoticons; // This will just be a single array to start with

    public Grid() {
        this.emoticons = new FaceIcon[6];
        populateGrid();
    }

    public void populateGrid() {
        emoticons[0] = new AngryFaceIcon();
        emoticons[1] = new AngryFaceIcon();
        emoticons[2] = new SadFaceIcon();
        emoticons[3] = new ConfusedFaceIcon();
        emoticons[4] = new SadFaceIcon();
        emoticons[5] = new SadFaceIcon();
    }

    public void displayGrid() {
        System.out.print("| ");
        for (FaceIcon e : emoticons) System.out.print(e + " | ");
    }

    public String getEmotion(FaceIcon emoticon) {
        return emoticon.showEmotion();
    }

    public void selectIcon(int icon) {
        // If an icon has not yet been selected, just mark icon as selected.
        // If icon an icon has already been selected, check if recently selected
        // icon is next to previously selected one
        // Decide if there will be a boolean 'anIconHasBeenSelected' variable in Grid
        // or will there just be a flag inside the selected emoticon?
    }

    public void swapIcons(int a, int b) {

    }
}
