package gameboard;

import gamepieces.*;

import java.util.LinkedList;
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

    public ArrayList<LinkedList<GamePiece>> checkRows() {

        LinkedList<GamePiece> consecutivePieces = new LinkedList<>();
        ArrayList<LinkedList<GamePiece>> bigList = new ArrayList<>();
        GamePiece gamePiece;
        for (int row = (rows - 1); row >= 0; row--) {
            consecutivePieces.add(tiles[row][0].getGamePiece());
            for (int col = 1; col < cols; col++) {
                gamePiece = tiles[row][col].getGamePiece();
                if (!gamePiece.showType().equals(consecutivePieces.getLast().showType())) {
                    examineList(consecutivePieces, bigList);
                    consecutivePieces = new LinkedList<>();
                }
                consecutivePieces.add(gamePiece);
            }
        }
        return bigList;
    }

    public void examineList(LinkedList<GamePiece> consecutivePieces, ArrayList<LinkedList<GamePiece>> bigList) {
        if (consecutivePieces.size() >= 3) {
            bigList.add(consecutivePieces);
        }
    }

    /*public List<GamePiece> checkColumns() {
        List<GamePiece> matchingTiles = new ArrayList<>();
        for (int col = 0; col < cols; col++) {
            for (int row = (rows - 1); row > 0; row--) {
                if (tiles[row][col].getPieceType().equals(tiles[row - 1][col].getPieceType())) {
                    matchingTiles.add(tiles[row][col]);
                }
            }
        }
        return matchingTiles;
    }*/
}