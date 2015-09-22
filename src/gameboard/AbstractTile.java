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
    private int col;
    private GamePiece gp;

    public AbstractTile(int row, int col, GamePiece gp) {
        this.row = row;
        this.col = col;
        this.gp = gp;
    }

    @Override
    public int[] getCoordinates() {
        /**DO LIKE THIS int[] test = {row, col} */
        int[] location = new int[2];
        location[0] = row;
        location[1] = col;
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
