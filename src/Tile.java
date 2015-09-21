/**
 * @author Mark Channer
 *         <p>
 *         Tile represents each square on the grid
 */
public interface Tile {

    int[] getCoordinates();

    String getFace();

    void setFace(GamePiece gp);

}
