package model.gamepieces;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class SadEmoticon extends AbstractGamePiece {

    public SadEmoticon(int x, int y) {
        super("SA", x, y);
    }

    /**
     * Returns a String, giving the type of the game piece
     *
     * @return a String, giving the type of the game piece
     */
    public String toString() {
        return "SAD";
    }
}
