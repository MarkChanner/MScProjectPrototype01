/**
 * @author Mark Channer
 */
public abstract class AbstractGamePiece implements GamePiece {

    private String face;

    public AbstractGamePiece(String face) {
        this.face = face;
    }

    @Override
    public String showFace() {
        return this.face;
    }

    @Override
    public String toString() {
        return showFace();
    }
}
