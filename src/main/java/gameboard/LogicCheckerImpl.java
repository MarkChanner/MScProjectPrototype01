package gameboard;

import gamepieces.*;

import java.util.LinkedList;
import java.util.ArrayList;

/**
 * @author Mark Channer
 */
public class LogicCheckerImpl implements LogicChecker {

    @Override
    public ArrayList<LinkedList<GamePiece>> checkRows(Board board) {
        Tile[][] tiles = board.getAllTiles();
        int boardSize = board.getSize();

        LinkedList<GamePiece> consecutivePieces = new LinkedList<>();
        ArrayList<LinkedList<GamePiece>> bigList = new ArrayList<>();
        GamePiece gamePiece;
        for (int row = (boardSize - 1); row >= 0; row--) {
            consecutivePieces.add(tiles[row][0].getGamePiece());

            for (int col = 1; col < boardSize; col++) {
                gamePiece = tiles[row][col].getGamePiece();
                if (!gamePiece.showType().equals(consecutivePieces.getLast().showType())) {
                    examineList(consecutivePieces, bigList);
                    consecutivePieces = new LinkedList<>();
                }
                consecutivePieces.add(gamePiece);
                if (col == boardSize - 1) {
                    examineList(consecutivePieces, bigList);
                    consecutivePieces = new LinkedList<>();
                }
            }
        }
        return bigList;
    }

    @Override
    public ArrayList<LinkedList<GamePiece>> checkColumns(Board board) {
        Tile[][] tiles = board.getAllTiles();
        int boardSize = board.getSize();

        LinkedList<GamePiece> consecutivePieces = new LinkedList<>();
        ArrayList<LinkedList<GamePiece>> bigList = new ArrayList<>();
        GamePiece gamePiece;
        for (int col = 0; col < boardSize; col++) {
            consecutivePieces.add(tiles[boardSize - 1][col].getGamePiece());

            for (int row = (boardSize - 2); row >= 0; row--) {
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

    private void examineList(LinkedList<GamePiece> consecutivePieces, ArrayList<LinkedList<GamePiece>> bigList) {
        if (consecutivePieces.size() >= 3) {
            bigList.add(consecutivePieces);
        }
    }
}