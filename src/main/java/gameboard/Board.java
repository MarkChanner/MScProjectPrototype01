package gameboard;

/**
 * @author Mark Channer
 *         The Board on which the game will take place
 */
public interface Board {

    int getRows();

    int getCols();

    Tile[][] getTiles();

    void displayBoard();

    void selectTile(int row, int column);

}
