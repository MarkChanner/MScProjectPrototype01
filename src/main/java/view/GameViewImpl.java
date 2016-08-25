package view;

import model.gameboard.GameBoard;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class GameViewImpl implements GameView {

    private static final int ROW_START = 0;
    private static final int COLUMN_TOP = 0;
    private GameBoard board;

    public GameViewImpl(GameBoard board) {
        this.board = board;
    }

    @Override
    public void drawGameBoard() {
        int cols = board.getCols();
        int rows = board.getRows();
        System.out.println();
        System.out.print("     ");
        for (int value = 0; value < cols; value++) System.out.print(" " + value + "   ");
        System.out.println();
        for (int y = COLUMN_TOP; y < rows; y++) {
            System.out.print("  " + y + " ");
            System.out.print("| ");

            for (int x = ROW_START; x < cols; x++) {
                System.out.print(board.getGamePiece(x, y).showType() + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void displayWithNewLine(String str) {
        System.out.println(str);
    }

    @Override
    public void displayWithoutNewLine(String str) {
        System.out.print(str);
    }
}
