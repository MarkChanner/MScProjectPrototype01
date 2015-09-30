package gamepieces;

/**
 * @author Mark Channer
 */
public class AngryGamePiece extends AbstractGamePiece {

    public AngryGamePiece() {
        super("AN");
    }

    @Override
    public GamePiece retrieveGamePiece() {
        return (this);
    }

    public String toString() {
        return "OOOOH, IT'S AN ANGRY FACE!";
    }

}
