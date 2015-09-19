/**
 * @author Mark Channer
 */
public class SadFaceIcon implements FaceIcon {
    @Override
    public String showEmotion() {
        return "S";
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
        return "S"; // for Sad
    }
}
