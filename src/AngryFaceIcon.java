/**
 * @author Mark Channer
 */
public class AngryFaceIcon implements FaceIcon {

    @Override
    public String showEmotion() {
        return "A";
    }

    @Override
    public boolean iconPressed() {
        return false;
    }

    @Override
    public void setGridPosition() {

    }

    @Override
    public int getGridPosition() {
        return 0;
    }

    @Override
    public String toString() {
        return "A"; // for Angry
    }
}
