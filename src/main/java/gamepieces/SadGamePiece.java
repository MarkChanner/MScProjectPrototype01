package main.java.gamepieces;

/**
 * @author Mark Channer
 */
public class SadGamePiece extends AbstractGamePiece {

    public SadGamePiece(String type) {
        super(type);
    }

    @Override
    public GamePiece retrieveGamePiece() {
        return (this);
    }
}
