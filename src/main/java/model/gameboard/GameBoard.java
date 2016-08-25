package model.gameboard;

/**
 * The board on which the game will take place. This interface provides methods that all
 * the user to know the board size by retrieving the number of columns and rows it has.
 * It can also retrieve the Tiles that make up the board and. The Tiles may hold GamePiece
 * references. The board's contenBts can be printed out with the displayBoard method, and
 * certain tiles can be selected by the user by way of the selectTile method.
 *
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public interface Board {

    /**
     * Returns the number of rows in this board
     *
     * @return the number of rows that the board has
     */
    int getRows();

    /**
     * Returns the number of columns in this board
     *
     * @return the number of columns that the board has
     */
    int getCols();

    /**
     * Returns the number of columns in this board
     *
     * @return the number of columns that the board has
     * @throws null pointer exception if tiles not initialized
     */
    Tile[][] getTiles();

    /**
     * Prints out the board
     */
    void displayBoard();

    /**
     * Chooses a Tile on the board. Based on if it is the
     * first or second Tile to be selected, implemented
     * results may differ
     *
     * @param row the location of the row in the array
     * @param column the location of the column in the array
     */
    void selectTile(int row, int column);

}
