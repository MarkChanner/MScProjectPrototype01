package model.gameboard;

import model.gamepieces.AbstractGamePiece;

/**
 * Implementations of this interface are used to populate the Board with game pieces.
 * For testing purposes, an implementation can populate the board with a set layout,
 * rather than at random, which would make testing difficult.
 *
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 *
 */
public interface BoardPopulator {

    /**
     * Populates the given Board with game pieces
     *
     * @param board element to be populated with game pieces
     */
    void populate(GameBoard board);

    /**
     * Creates a game piece
     *
     * @return a game piece
     */
    AbstractGamePiece createRandomGamePiece(int x, int y);

}
