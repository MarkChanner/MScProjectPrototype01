/**
 * @author Mark Channer
 */
public class ExcitedGamePiece implements GamePiece {

    private String face;
    
    public ExcitedGamePiece(String face) {
        this.face = face;
    }

    public String showFace() {
        return face;
    }
}
