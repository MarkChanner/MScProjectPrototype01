package gameboard;

import gamepieces.GamePiece;

/**
 * @author Mark Channer
 *         <p>
 *         AbstractTile represents on of the squara tiles on the board. It
 *         holds a reference to a GamePiece, which it can call methods on
 */
public abstract class AbstractTile implements Tile {

    private int row;
    private int column;
    private GamePiece piece;

    public AbstractTile(int r, int c, GamePiece gp) {
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
