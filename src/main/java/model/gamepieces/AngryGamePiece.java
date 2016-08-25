package gamepieces;

/**
 * @author Mark Channer
 */
public class AngryGamePiece extends AbstractGamePiece {

    public AngryGamePiece() {
        super("AN");
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
        return "OOOOH, IT'S AN ANGRY FACE!";
    }

}
