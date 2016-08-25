package model.gamepieces;

import model.gameboard.GamePiece;
import model.gamepieces.AbstractGamePiece;

/**
 * This game piece differs from others in that it takes a constructor which allows
 * its type to be set. This is used in the BoardPopulatorMock to populate the board
 * with a series of numbers that will not lead to a match and cause difficulties with
 * running tests
 *
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
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
