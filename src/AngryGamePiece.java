/**
 * @author Mark Channer
 */
public class AngryGamePiece extends AbstractGamePiece {

    public AngryGamePiece(String face) {
        super(face);
    }

    @Override
    public GamePiece showFace() {
        return this;
    }

}
