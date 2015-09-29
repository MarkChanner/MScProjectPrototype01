package gamepieces;

/**
 * @author Mark Channer
 */
public class ConfusedGamePiece extends AbstractGamePiece {

    public ConfusedGamePiece() {
        super("CO");
    }

    @Override
    public GamePiece retrieveGamePiece() {
        return (this);
    }

    public String toString() {
        return "WELL, WELL! IT'S A CONFUSED FACE!!!";
    }
}
