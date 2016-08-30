package model.gameboard;

import model.gamepieces.AbstractGamePiece;
import model.gamepieces.BlankTile;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class BoardManipulatorImpl implements BoardManipulator {

    private static final int ROW_START = 0;
    private static final int COLUMN_TOP = 0;
    private static final int X = 0;
    private static final int Y = 1;
    private GameBoard board;

    public BoardManipulatorImpl(GameBoard board) {
        this.board = board;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void swap(Selections selections) {
        int[] sel1 = selections.getSelection01();
        int[] sel2 = selections.getSelection02();
        AbstractGamePiece tempPiece = board.getGamePiece(sel1[X], sel1[Y]);
        board.setGamePiece(sel1[X], sel1[Y], board.getGamePiece(sel2[X], sel2[Y]));
        board.setGamePiece(sel2[X], sel2[Y], tempPiece);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeFromBoard(ArrayList<LinkedList<AbstractGamePiece>> matches) {
        for (List<AbstractGamePiece> gamePieces : matches) {
            for (AbstractGamePiece gp : gamePieces) {
                int x = gp.getX();
                int y = gp.getY();
                if (!(board.getGamePiece(x, y).showType().equals("EMPTY"))) {
                    board.setGamePiece(x, y, new BlankTile(x, y));
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void lowerGamePieces() {
        int cols = board.getCols();
        int rows = board.getRows();
        int runnerY;
        for (int x = 0; x < cols; x++) {
            for (int y = (rows - 1); y >= 0; y--) {
                if (board.getGamePiece(x, y).showType().equals("EMPTY")) {
                    /* get any pieces higher up the column and, if found, plug hole with it */
                    runnerY = y;
                    while ((runnerY >= 0) && (board.getGamePiece(x, runnerY).showType().equals("EMPTY"))) {
                        runnerY--;
                    }
                    if (runnerY >= 0) {
                        AbstractGamePiece gp = board.getGamePiece(x, runnerY);
                        board.setGamePiece(x, y, gp);
                        /* sets previous tile to be empty */
                        board.setGamePiece(x, runnerY, new BlankTile(x, y));
                    }
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertNewIcons(BoardPopulator populator) {
        int cols = board.getCols();
        int columnBottom = board.getRows() - 1;
        for (int x = ROW_START; x < cols; x++) {
            for (int y = columnBottom; y >= COLUMN_TOP; y--) {
                if (board.getGamePiece(x, y).showType().equals("EMPTY")) {
                    AbstractGamePiece gp = populator.createRandomGamePiece(x, y);
                    board.setGamePiece(x, y, gp);
                }
            }
        }
    }
}
