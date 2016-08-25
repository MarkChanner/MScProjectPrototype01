package model.gamepieces;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class HappyEmoticon extends AbstractGamePiece {

    public HappyEmoticon(int x, int y) {
        super("HA", x, y);
    }

    /**
     * Returns a String, giving the type of the game piece
     *
     * @return a String, giving the type of the game piece
     */
    public String toString() {
        return "HAPPY";
    }

}
