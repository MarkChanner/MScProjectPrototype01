/**
 * @author Mark Channer
 */
public class HappyFaceIcon implements FaceIcon {

    @Override
    public String showEmotion() {
        return null;
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
        return "H"; // for Happy
    }
}
