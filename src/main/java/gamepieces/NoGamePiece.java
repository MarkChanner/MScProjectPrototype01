package gamepieces;

/**
 * @author Mark Channer
 */
public class NoGamePiece extends AbstractGamePiece {

    public NoGamePiece() {
        super("XX");
    }

    @Override
    public GamePiece retrieveGamePiece() {
        return (this);
    }

    public String toString() {
        return "THERE IS NO GAME PIECE HERE";
    }

}
