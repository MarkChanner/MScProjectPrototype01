package gamepieces;

/**
 * @author Mark Channer
 */
public class MockGamePiece extends AbstractGamePiece {

    public MockGamePiece(String value) {
        super(value);
    }

    @Override
    public GamePiece retrieveGamePiece() {
        return (this);
    }

    public String toString() {
        return ("TEST GAME PIECE " + showType());
    }
}
