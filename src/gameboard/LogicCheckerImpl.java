package gameboard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mark Channer
 */
public class LogicCheckerImpl implements LogicChecker {

    private Board board;

    /**
     * Not yet finished. Doesn't work for horizontal
     */
    public List<Tile> check(Board board) {
        int rows = board.getRows();
        int cols = board.getCols();
        Tile[][] tiles = board.getAllTiles();
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
                if (tiles[i][j].getPieceType().equals(tiles[i][j + 1].getPieceType())) {
                    matchingTiles.add(tiles[i][j]);
                }
            }
        }
        return matchingTiles;
    }
}