/**
 * @author Mark Channer
 */
public class HappyGamePiece implements GamePiece {

    private String face;

    public HappyGamePiece(String face) {
        this.face = face;
    }

    public String showFace() {
        return face;
    }
}
