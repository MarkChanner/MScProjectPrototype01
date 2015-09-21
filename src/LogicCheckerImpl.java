import java.util.ArrayList;
import java.util.List;

/**
 * @author Mark Channer
 */
public class LogicCheckerImpl implements LogicChecker {

    private Grid grid;

    /**
     * So far only check for horizontal matches
     */
    public List<Tile> check(Grid grid) {
        List<Tile> matchingTiles = new ArrayList<>();
        int rows = grid.getRows();
        int cols = grid.getCols();
        Tile[][] tiles = grid.getAllTiles();

        for (int i = (rows - 1); (i >= 0); i--) {
            for (int j = 0; (j < cols - 1); j++) {
                if (tiles[i][j].getEmotion().equals(tiles[i][j + 1].getEmotion())) {
                    matchingTiles.add(tiles[i][j]);
                }
            }
        }
        return matchingTiles;
    }
}