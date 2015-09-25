package gameboard;

import gamepieces.GamePiece;

/**
 * @author Mark Channer
 *
 * Tile represents each square on the grid
 */
public interface Tile {

    int getRow();

    int getColumn();

    GamePiece getGamePiece();

    void setGamePiece(GamePiece gp);

    String getPieceType();

}
