package gameboard;

import gamepieces.GamePiece;

/**
 * @author Mark Channer
 *         <p>
 *         AbstractTile represents on of the squara tiles on the board. It
 *         holds a reference to a GamePiece, which it can call methods on
 */
public abstract class AbstractTile implements Tile {

    private int col;
    private int row;
    private GamePiece gp;

    public AbstractTile(int col, int row, GamePiece gp) {
        this.col = col;
        this.row = row;
        this.gp = gp;
    }

    @Override
    public int[] getCoordinates() {
        int[] location = new int[2];
        location[0] = this.col;
        location[1] = this.row;
        return location;
    }

    @Override
    public GamePiece getGamePiece() {
        return gp.retrieveGamePiece();
    }

    @Override
    public void setGamePiece(GamePiece gp) {
        this.gp = gp;
    }

    @Override
    public String getPieceType() {
        return gp.showType();
    }
}
