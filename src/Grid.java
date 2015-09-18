/**
 * @author Mark Channer
 * The grid on which the game will take place
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
        for (FaceIcon e : emoticons) System.out.println(e + " ");
    }

    public String getEmotion(FaceIcon emoticon) {
        return emoticon.showEmotion();
    }

}
