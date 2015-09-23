package main.java.gamepieces;

/**
 * @author Mark Channer
 */
public class ConfusedGamePiece extends AbstractGamePiece {

    public ConfusedGamePiece(String type) {
        super(type);
    }

    @Override
    public GamePiece retrieveGamePiece() {
        return (this);
    }
}
