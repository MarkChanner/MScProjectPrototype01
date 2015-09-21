/**
 * @author Mark Channer
 */
public class ConfusedGamePiece extends AbstractGamePiece {

    public ConfusedGamePiece(String face) {
        super(face);
    }

    @Override
    public GamePiece showFace() {
        return this;
    }
}
