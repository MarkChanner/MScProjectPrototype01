package gamepieces;

/**
 * @author Mark Channer
 */
public abstract class AbstractGamePiece implements GamePiece {

    private String type;
    private int[] coordinates;

    public AbstractGamePiece(String t) {
        type = t;
        coordinates = new int[2];
        coordinates[0] = -1;
        coordinates[1] = -1;
    }

    @Override
    public void setCoordinates(int row, int column) {
        coordinates[0] = row;
        coordinates[1] = column;
    }

    public abstract GamePiece retrieveGamePiece();

    @Override
    public String showType() {
        return type;
    }

}
