package model.gameboard;

import model.gamepieces.AbstractGamePiece;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class GameBoardImpl implements GameBoard {

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

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCols() {
        return cols;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRows() {
        return rows;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setGamePiece(int x, int y, AbstractGamePiece gamePiece) {
        if (x >= cols || y >= rows) {
            throw new ArrayIndexOutOfBoundsException("setGamePiece arg larger than board");
        }
        gamePiece.setCoordinates(x, y); // updates Emoticon coordinates
        emoticons[x][y] = gamePiece;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractGamePiece getGamePiece(int x, int y) {
        if (x >= cols || y >= rows) {
            throw new ArrayIndexOutOfBoundsException("getGamePiece arg larger than board");
        }
        return emoticons[x][y];
    }
}
