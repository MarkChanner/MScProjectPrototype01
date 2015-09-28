package gameboard;

import gamepieces.GamePiece;

/**
 * @author Mark Channer
 * BoardPopulator interface allows different game pieces to populate the Board.
 * Useful for creating a non-randomly generated board for testing
 */
public interface BoardPopulator {

    void populate(Board board);

    GamePiece generateGamePiece();

}
