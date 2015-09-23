package main.java.gameboard;

import main.java.gamepieces.GamePiece;

/**
 * @author Mark Channer
 *
 * Tile represents each square on the grid
 */
public interface Tile {

    int[] getCoordinates();

    GamePiece getGamePiece();

    void setGamePiece(GamePiece gp);

    String getPieceType();

}
