package gameboard;

/**
 * @author Mark Channer
 *         The Board on which the game will take place
 */
public interface Board {

    void populateBoard();

    int getCols();

    int getRows();

    Tile[][] getAllTiles();

    void displayBoard();

    void selectTile(int newCol, int newRow);

    void compareTiles();

    boolean sameTileSelectedTwice();

    boolean selectedTilesAreAdjacent();

    void resetBothTiles();

    void swap();

    boolean matchingTypes();
}
