package gameboard;

/**
 * @author Mark Channer
 *         The Board on which the game will take place
 */
public interface Board {

    void populateBoard();

    int getRows();

    int getCols();

    //int getBoardSize();

    Tile[][] getAllTiles();

    void displayBoard();

    void selectTile(int row, int column);

}
