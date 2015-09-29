package gamepieces;

/**
 * @author Mark Channer
 */
public class NoGamePiece extends AbstractGamePiece {

    public NoGamePiece(String type) {
        super(type);
    }

    @Override
    public GamePiece retrieveGamePiece() {
        return (this);
    }

    public String toString() {
        return "THERE IS NO GAME PIECE HERE";
    }

}
