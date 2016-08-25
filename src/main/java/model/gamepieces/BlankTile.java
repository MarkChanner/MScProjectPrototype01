package model.gamepieces;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class BlankTile extends AbstractGamePiece {

    public BlankTile(int x, int y) {
        super("EMPTY", x, y);
    }

    /**
     * Returns a String, giving the type of the game piece
     *
     * @return a String, giving the type of the game piece
     */
    public String toString() {
        return "EMPTY";
    }

}
