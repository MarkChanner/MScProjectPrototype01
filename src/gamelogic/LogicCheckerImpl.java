package gamelogic;

import gameboard.Grid;
import gameboard.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mark Channer
 */
public class LogicCheckerImpl implements LogicChecker {

    private Grid grid;

    /**
     * Not yet finished. Doesn't work for horizontal
     */
    public List<Tile> check(Grid grid) {
        int rows = grid.getRows();
        int cols = grid.getCols();
        Tile[][] tiles = grid.getAllTiles();
        List<Tile> matchingRows = getMatches(tiles, rows, cols);
        List<Tile> matchingCols = getMatches(tiles, cols, rows);
        List<Tile> mergedList = new ArrayList<>();
        mergedList.addAll(matchingRows);
        mergedList.addAll(matchingCols);
        return mergedList;
    }

    public List<Tile> getMatches(Tile[][] tiles, int rows, int cols) {
        List<Tile> matchingTiles = new ArrayList<>();
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