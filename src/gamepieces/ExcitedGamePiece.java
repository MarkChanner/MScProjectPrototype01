package gamepieces;

/**
 * @author Mark Channer
 */
public class ExcitedGamePiece extends AbstractGamePiece {

    public ExcitedGamePiece(String type) {
        super(type);
    }

    @Override
    public GamePiece retrieveGamePiece() {
        return (this);
    }

}