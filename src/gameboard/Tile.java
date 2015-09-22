package gameboard;

import gamepieces.GamePiece;

/**
 * @author Mark Channer
 *
 * gameboard.Tile represents each square on the grid
 */
public interface Tile {

    int[] getCoordinates();

    GamePiece getFace();

    void setFace(GamePiece gp);

    String getEmotion();

}
