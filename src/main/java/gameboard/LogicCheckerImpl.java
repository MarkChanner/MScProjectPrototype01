package gameboard;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Mark Channer
 */
public class LogicCheckerImpl implements LogicChecker {

    private Board board;
    private Tile[][] tiles;
    private int rows;
    private int cols;

    public LogicCheckerImpl(Board b) {
        board = b;
        tiles = board.getAllTiles();
        rows = board.getRows();
        cols = board.getColumns();
    }

    /*public List<Tile> checkRows() {
        List<Tile> matchingTiles = new ArrayList<>();
        for (int row = (rows - 1); row > 0; row--) {
            for (int col = 0; col < (cols - 1); col++) {
                if (tiles[row][col].getPieceType().equals(tiles[row][col + 1].getPieceType())) {
                    matchingTiles.add(tiles[row][col]);
                }
            }
        }
        return matchingTiles;
    }*/

    public List<Tile> checkRows() {
        List<Tile> matchingTiles = new ArrayList<>();
        for (int row = (rows - 1); row > 0; row--) {
            for (int col = 1; col < (cols - 2); col++) {
                if (tiles[row][col].getPieceType().equals(tiles[row][col - 1].getPieceType()) &&
                        tiles[row][col].getPieceType().equals(tiles[row][col + 1].getPieceType())) {
                    matchingTiles.add(tiles[row][col-1]);
                    matchingTiles.add(tiles[row][col]);
                    matchingTiles.add(tiles[row][col+1]);
                    int tempCount = (col + 1);
                    while (tiles[row][tempCount].getPieceType().equals(tiles[row][(tempCount + 1)].getPieceType())) {
                        matchingTiles.add(tiles[row][tempCount+1]);
                        tempCount++;
                    }
                }

            }
        }
        return matchingTiles;
    }

    public List<Tile> checkColumns() {
        List<Tile> matchingTiles = new ArrayList<>();
        for (int col = 0; col < cols; col++) {
            for (int row = (rows - 1); row > 0; row--) {
                if (tiles[row][col].getPieceType().equals(tiles[row - 1][col].getPieceType())) {
                    matchingTiles.add(tiles[row][col]);
                }
            }
        }
        return matchingTiles;
    }
}