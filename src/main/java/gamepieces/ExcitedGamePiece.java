package gamepieces;

/**
 * @author Mark Channer
 */
public class ExcitedGamePiece extends AbstractGamePiece {

    public ExcitedGamePiece() {
        super("EX");
    }

    @Override
    public GamePiece retrieveGamePiece() {
        return (this);
    }

    public String toString() {
        return "WEEEEEE! IT'S AN EXCITED FACE!!!!!";
    }

}
