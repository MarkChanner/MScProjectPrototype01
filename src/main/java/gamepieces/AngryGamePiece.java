package gamepieces;

/**
 * @author Mark Channer
 */
public class AngryGamePiece extends AbstractGamePiece {

    /* Consider making type a variable that is automatically set */

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
