package gamepieces;

/**
 * @author Mark Channer
 */
public class SadGamePiece extends AbstractGamePiece {

    public SadGamePiece(String face) {
        super(face);
    }

    @Override
    public GamePiece showFace() {
        return this;
    }
}
