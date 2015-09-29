package gamepieces;

/**
 * @author Mark Channer
 * GamePiece to become part of a Tile
 */
public interface GamePiece {

    void setCoordinates(int row, int column);

    GamePiece retrieveGamePiece();

    String showType();

}
