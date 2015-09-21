/**
 * @author Mark Channer
 */
public class AngryGamePiece implements GamePiece {

    private String face;

    public AngryGamePiece(String face) {
        this.face = face;
    }

    public String showFace() {
        return face;
    }
}
