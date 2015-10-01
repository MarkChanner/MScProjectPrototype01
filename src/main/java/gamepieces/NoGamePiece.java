package gamepieces;

/**
 * @author Mark Channer
 */
public class NoGamePiece extends AbstractGamePiece {

    public NoGamePiece() {
        super("XX");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GamePiece retrieveGamePiece() {
        return (this);
    }

    /**
     * Returns a String, giving the type of the game piece
     *
     * @return a String, giving the type of the game piece
     */
    public String toString() {
        return "THERE IS NO GAME PIECE HERE";
    }

}
