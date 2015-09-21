/**
 * @author Mark Channer
 */
public class ExcitedGamePiece extends AbstractGamePiece {

    public ExcitedGamePiece(String face) {
        super(face);
    }

    @Override
    public GamePiece showFace() {
        return this;
    }

}
