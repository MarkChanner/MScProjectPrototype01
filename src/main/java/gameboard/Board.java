package gameboard;

/**
 * @author Mark Channer
 *         The Board on which the game will take place
 */
public interface Board {

    void populateBoard();

    int getRows();

    int getColumns();

    Tile[][] getAllTiles();

    void displayBoard();

    void selectTile(int row, int column);

    void compareTiles();

    boolean sameTileSelectedTwice();

    boolean selectedTilesAreAdjacent();

    void resetBothTiles();

    void swap();

    boolean matchingTypes();

    void checkForMatches();
}
