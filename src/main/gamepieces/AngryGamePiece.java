package gamepieces;

/**
 * @author Mark Channer
 */
public class AngryGamePiece extends AbstractGamePiece {

    public AngryGamePiece(String type) {
        super(type);
    }

    @Override
    public GamePiece retrieveGamePiece() {
        return (this);
    }

}
