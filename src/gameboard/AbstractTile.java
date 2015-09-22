package gameboard;

import gamepieces.GamePiece;

/**
 * @author Mark Channer
 *
 * gameboard.AbstractTile holds a reference to a gamepieces.GamePiece, which
 * it can call methods on
 */
public abstract class AbstractTile implements Tile {

    private int col;
    private int row;
    private GamePiece emoticon;

    public AbstractTile(int col, int row, GamePiece emoticon) {
        this.col = col;
        this.row = row;
        this.emoticon = emoticon;
    }

    @Override
    public int[] getCoordinates() {
        int[] result = new int[2];
        result[0] = this.col;
        result[1] = this.row;
        return result;
    }

    @Override
    public GamePiece getFace() {
        return emoticon.showFace();
    }

    @Override
    public void setFace(GamePiece gp) {
        this.emoticon = gp;
    }

    @Override
    public String getEmotion() {
        return emoticon.revealEmotion();
    }
}
