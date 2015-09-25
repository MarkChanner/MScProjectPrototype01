package gameboard;

import java.util.LinkedList;
import java.util.ArrayList;

/**
 * @author Mark Channer
 */
public class BoardControllerImpl implements BoardController {

    @Override
    public ArrayList<LinkedList<Tile>> checkRows(Board board) {
        Tile[][] tiles = board.getAllTiles();
        int boardSize = board.getSize();
        LinkedList<Tile> consecutiveTiles = new LinkedList<>();
        ArrayList<LinkedList<Tile>> bigList = new ArrayList<>();
        Tile tile;

        for (int row = (boardSize - 1); row >= 0; row--) {
            consecutiveTiles.add(tiles[row][0]);

            for (int col = 1; col < boardSize; col++) {
                tile = tiles[row][col];
                if (!tile.getPieceType().equals(consecutiveTiles.getLast().getPieceType())) {
                    examineList(consecutiveTiles, bigList);
                    consecutiveTiles = new LinkedList<>();
                }
                consecutiveTiles.add(tile);
                if (col == boardSize - 1) {
                    examineList(consecutiveTiles, bigList);
                    consecutiveTiles = new LinkedList<>();
                }
            }
        }
        return bigList;
    }

    @Override
    public ArrayList<LinkedList<Tile>> checkColumns(Board board) {
        Tile[][] tiles = board.getAllTiles();
        int boardSize = board.getSize();

        LinkedList<Tile> consecutivePieces = new LinkedList<>();
        ArrayList<LinkedList<Tile>> bigList = new ArrayList<>();
        Tile tile;
        for (int col = 0; col < boardSize; col++) {
            consecutivePieces.add(tiles[boardSize - 1][col]);

            for (int row = (boardSize - 2); row >= 0; row--) {
                tile = tiles[row][col];
                if (!tile.getPieceType().equals(consecutivePieces.getLast().getPieceType())) {
                    examineList(consecutivePieces, bigList);
                    consecutivePieces = new LinkedList<>();
                }
                consecutivePieces.add(tile);
                if (row == 0) {
                    examineList(consecutivePieces, bigList);
                    consecutivePieces = new LinkedList<>();
                }
            }
        }
        return bigList;
    }

    private void examineList(LinkedList<Tile> consecutivePieces, ArrayList<LinkedList<Tile>> bigList) {
        if (consecutivePieces.size() >= 3) {
            bigList.add(consecutivePieces);
        }
    }
}