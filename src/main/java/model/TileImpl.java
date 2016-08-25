package model;

/**
 * An implementation of the Tile interface. Implements all interface
 * methods. A GamePiece object
 *
 * @author Mark Channer for Birkbeck MSc Computer Science project
 */
public class TileImpl implements Tile {

    private int row;
    private int column;
    private GamePiece piece;

    public TileImpl(int r, int c, GamePiece gp) {
        row = r;
        column = c;
        piece = gp;
        piece.setCoordinates(row, column);
    }

    public TileImpl(int r, int c) {
        row = r;
        column = c;
        piece = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getColumn() {
        return column;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GamePiece getGamePiece() {
        if (piece != null) {
            return piece.retrieveGamePiece();
        } else {
            throw new NullPointerException("GamePiece is not set");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setGamePiece(GamePiece gp) {
        piece = gp;
        piece.setCoordinates(row, column);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPieceType() {
        if (piece != null) {
            return piece.showType();
        } else {
            throw new NullPointerException("GameInitializer Piece is not set");
        }

    }
}
