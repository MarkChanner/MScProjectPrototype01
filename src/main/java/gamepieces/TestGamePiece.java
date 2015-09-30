package gamepieces;

/**
 * @author Mark Channer
 */
public class TestGamePiece extends AbstractGamePiece {

    public TestGamePiece(String value) {
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
