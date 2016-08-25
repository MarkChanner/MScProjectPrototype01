package model.gameboard;

import model.gamepieces.AbstractGamePiece;

/**
 * This interface provides methods to set and manipulate the game pieces
 *
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public interface GameBoard {

    /**
     * Returns the number of columns in this board
     *
     * @return the number of columns that the board has
     */
    int getCols();

    /**
     * Returns the number of rows in this board
     *
     * @return the number of rows that the board has
     */
    int getRows();

    /**
     * Sets the given game piece at the position given by the x and y values
     */
    void setGamePiece(int x, int y, AbstractGamePiece gamePiece);


    /**
     * Returns the game piece located at the given coordinates
     *
     * @return a subclass of AbstractGamePiece
     */
    AbstractGamePiece getGamePiece(int x, int y);

    /**
     * swaps the game pieces in the given selection
     *
     */
    void swap(Selections selections);

}
