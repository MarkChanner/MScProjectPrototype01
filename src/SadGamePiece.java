/**
 * @author Mark Channer
 */
public class SadGamePiece implements GamePiece {

    private String face;

    public SadGamePiece(String face) {
        this.face = face;
    }

    public String showFace() {
        return face;
    }
}
