package model.mock_objects;

import model.gamepieces.AbstractGamePiece;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class MockEmoticon extends AbstractGamePiece {

    public MockEmoticon(String type, int x, int y) {
        super(type, x, y);
    }

    /**
     * Returns a String, giving the type of the game piece
     *
     * @return a String, giving the type of the game piece
     */
    public String toString() {
        return "Mock Faces";
    }
}
