package model.gamepieces;

import model.GamePiece;

/**
 * @author Mark Channer
 */
public class HappyGamePiece extends AbstractGamePiece {

    public HappyGamePiece() {
        super("HA");
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
        return "HEY HEY! IT'S A HAPPY FACE!!!!!!";
    }

}
