package gameboard;

import gamepieces.GamePiece;

/**
 * Each Tile represents a square on the board. It provides methods for
 * accessing the location of the Tile on the board, and for retrieving
 * both the type of GamePiece occupying it and the type GamePiece it is
 *
 * @author Mark Channer
 */
public interface Tile {

    /**
     * Returns the row at the specified position in the array
     *
     * @return the row location of this tile
     */
    int getRow();

    /**
     * Returns the column at the specified position in the array
     *
     * @return the column location of the Tile
     */
    int getColumn();

    /**
     * Returns the Game Piece occupying the Tile
     *
     * @return the Game Piece occupying the Tile
     */
    GamePiece getGamePiece();

    /**
     * Sets a GamePiece to occupy the Tile
     *
     * @param gp the GamePiece to occupy the Tile
     */
    void setGamePiece(GamePiece gp);

    /**
     * Returns a String representing the type of the game piece
     *
     * @return the game piece type
     */
    String getPieceType();

}
