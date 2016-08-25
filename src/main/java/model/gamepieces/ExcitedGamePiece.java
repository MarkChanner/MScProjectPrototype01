package model.gamepieces;

import model.GamePiece;

/**
 * @author Mark Channer
 */
public class ExcitedGamePiece extends AbstractGamePiece {

    public ExcitedGamePiece() {
        super("EX");
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
        return "WEEEEEE! IT'S AN EXCITED FACE!!!!!";
    }

}
