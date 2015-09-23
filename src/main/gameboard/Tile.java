package gameboard;

import gamepieces.GamePiece;

/**
 * @author Mark Channer
 *
 * gameboard.Tile represents each square on the grid
 */
public interface Tile {

    int[] getCoordinates();

    GamePiece getGamePiece();

    void setGamePiece(GamePiece gp);

    String getPieceType();

}
