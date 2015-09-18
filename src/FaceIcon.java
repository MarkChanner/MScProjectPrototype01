/**
 * @author Mark Channer
 * FaceIcon to be implemented by a variety of Emotions
 * to fill the grid with
 */
public interface FaceIcon {

    String showEmotion();

    boolean iconPressed();

    void setGridPosition();

    int getGridPosition();

}
