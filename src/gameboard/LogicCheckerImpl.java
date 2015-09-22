package gameboard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mark Channer
 */
public class LogicCheckerImpl implements LogicChecker {

    public List<Tile> check(Board board) {
        int rows = board.getRows();
        int cols = board.getColumns();
        Tile[][] tiles = board.getAllTiles();

        List<Tile> consecutiveInRows = getConsecutiveInRows(tiles, rows, cols);
        List<Tile> consecutiveInCols = getConsecutiveInCols(tiles, rows, cols);

        System.out.println("Print rows found");
        for (Tile t1 : consecutiveInRows) {
            System.out.print(t1.getPieceType() + ", ");
        }
        System.out.println();

        System.out.println("Print cols found");
        for (Tile t2 : consecutiveInCols) {
            System.out.print(t2.getPieceType() + ", ");
        }

        //List<Tile> mergedList = new ArrayList<>();
        //mergedList.addAll(consecutiveInRows);
        //mergedList.addAll(consecutiveInCols);
        //return mergedList;
        return consecutiveInCols;
    }

    public List<Tile> getConsecutiveInRows(Tile[][] tiles, int rows, int cols) {
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

    public List<Tile> getConsecutiveInCols(Tile[][] tiles, int rows, int cols) {
        List<Tile> matchingTiles = new ArrayList<>();
        for (int i = 0; i < (cols-1); i++) {
            for (int j = (rows - 1); j >= 0; j--) {
                if (tiles[i][j].getPieceType().equals(tiles[i+1][j].getPieceType())) {
                    matchingTiles.add(tiles[i][j]);
                }
            }
        }
        return matchingTiles;
    }
}