package model.gamepieces;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class AngryEmoticon extends AbstractGamePiece {

    public AngryEmoticon(int x, int y) {
        super("AN", x, y);
    }

    /**
     * Returns a String, giving the type of the game piece
     *
     * @return a String, giving the type of the game piece
     */
    public String toString() {
        return "ANGRY";
    }

}
