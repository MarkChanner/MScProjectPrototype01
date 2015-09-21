/**
 * @author Mark Channer
 *
 * Tile represents each square on the grid
 */
public interface Tile {

    int[] getCoordinates();

    GamePiece getFace();

    void setFace(GamePiece gp);

}
