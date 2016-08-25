package model.gamepieces;

import model.GamePiece;

/**
 * @author Mark Channer
 */
public class SadGamePiece extends AbstractGamePiece {

    public SadGamePiece() {
        super("SA");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GamePiece retrieveGamePiece() {
        return (this);
    }

    /**
     * Returns a String, giving the type of the game piece
     *
     * @return a String, giving the type of the game piece
     */
    public String toString() {
        return "OH, IT'S A SAD FACE!!!!!";
    }
}
