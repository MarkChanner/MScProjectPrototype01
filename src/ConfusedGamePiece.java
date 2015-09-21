/**
 * @author Mark Channer
 */
public class ConfusedGamePiece implements GamePiece {

    private String face;

    public ConfusedGamePiece(String face) {
        this.face = face;
    }

    public String showFace() {
        return face;
    }
}
