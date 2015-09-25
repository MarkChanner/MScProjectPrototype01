package gameboard;

import gamepieces.GamePiece;

/**
 * @author Mark Channer
 * ileImpl extends AbstractTile
 */
public class TileImpl implements Tile {

    /*public TileImpl(int row, int col, GamePiece gp) {
        super(row, col, gp);
    }*/

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
    public int[] getCoordinates() {
        int[] location = new int[2];
        location[0] = row;
        location[1] = column;
        return location;
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
