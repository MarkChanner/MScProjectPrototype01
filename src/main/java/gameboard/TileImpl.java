package gameboard;

import gamepieces.GamePiece;

/**
 * @author Mark Channer
 *
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

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public GamePiece getGamePiece() {
        return piece.retrieveGamePiece();
    }

    @Override
    public void setGamePiece(GamePiece gp) {
        piece = gp;
        piece.setCoordinates(row, column);
    }

    @Override
    public String getPieceType() {
        return piece.showType();
    }
}
