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

    @Override
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
                if (col == cols - 1) {
                    examineList(consecutivePieces, bigList);
                    consecutivePieces = new LinkedList<>();
                }
            }
        }
        return bigList;
    }

    private void examineList(LinkedList<GamePiece> consecutivePieces, ArrayList<LinkedList<GamePiece>> bigList) {
        if (consecutivePieces.size() >= 3) {
            bigList.add(consecutivePieces);
        }
    }

    @Override
    public ArrayList<LinkedList<GamePiece>> checkColumns() {

        LinkedList<GamePiece> consecutivePieces = new LinkedList<>();
        ArrayList<LinkedList<GamePiece>> bigList = new ArrayList<>();
        GamePiece gamePiece;
        for (int col = 0; col < cols; col++) {
            consecutivePieces.add(tiles[rows - 1][col].getGamePiece());

            for (int row = (rows - 2); row >= 0; row--) {
                gamePiece = tiles[row][col].getGamePiece();
                if (!gamePiece.showType().equals(consecutivePieces.getLast().showType())) {
                    examineList(consecutivePieces, bigList);
                    consecutivePieces = new LinkedList<>();
                }
                consecutivePieces.add(gamePiece);
                if (row == 0) {
                    examineList(consecutivePieces, bigList);
                    consecutivePieces = new LinkedList<>();
                }
            }
        }
        return bigList;
    }
}