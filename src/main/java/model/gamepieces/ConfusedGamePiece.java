package gamepieces;

/**
 * @author Mark Channer
 */
public class ConfusedGamePiece extends AbstractGamePiece {

    public ConfusedGamePiece() {
        super("CO");
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
        return "WELL, WELL! IT'S A CONFUSED FACE!!!";
    }
}
