/**
 * @author Mark Channer
 */
public class HappyGamePiece extends AbstractGamePiece {

    public HappyGamePiece(String face) {
        super(face);
    }

    @Override
    public GamePiece showFace() {
        return this;
    }

}
