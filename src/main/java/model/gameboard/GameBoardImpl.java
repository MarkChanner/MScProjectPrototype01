package model.gameboard;

import model.gamepieces.AbstractGamePiece;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class GameBoardImpl implements GameBoard {

    private static final int X = 0;
    private static final int Y = 1;
    private int cols;
    private int rows;
    private AbstractGamePiece[][] emoticons;

    public GameBoardImpl() {
        cols = 8;
        rows = 7;
        emoticons = new AbstractGamePiece[cols][rows];
    }

    public GameBoardImpl(int x, int y) {
        cols = x;
        rows = y;
        emoticons = new AbstractGamePiece[cols][rows];
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public void setGamePiece(int x, int y, AbstractGamePiece gamePiece) {
        if (x >= cols || y >= rows) {
            throw new ArrayIndexOutOfBoundsException("setGamePiece arg larger than board");
        }
        gamePiece.setCoordinates(x, y); // updates Emoticon coordinates
        emoticons[x][y] = gamePiece;

    }

    public AbstractGamePiece getGamePiece(int x, int y) {
        if (x >= cols || y >= rows) {
            throw new ArrayIndexOutOfBoundsException("getGamePiece arg larger than board");
        }
        return emoticons[x][y];
    }

    @Override
    public void swap(Selections selections) {
        int[] sel1 = selections.getSelection01();
        int[] sel2 = selections.getSelection02();
        AbstractGamePiece tempPiece = getGamePiece(sel1[X], sel1[Y]);
        setGamePiece(sel1[X], sel1[Y], getGamePiece(sel2[X], sel2[Y]));
        setGamePiece(sel2[X], sel2[Y], tempPiece);
    }

}
