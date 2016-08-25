package gamepieces;

/**
 * AbstractGamePiece to be subclassed by different game piece types. Implements the GamePiece interface.
 * Each GamePiece is passed as a String to the constructor (via super(type) which allows each method call to
 * get behaviour specific to each subclass without the need for duplicating the code within each.
 *
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCoordinates(int row, int column) {
        coordinates[0] = row;
        coordinates[1] = column;
    }

    /**
     * {@inheritDoc}
     */
    public abstract GamePiece retrieveGamePiece();

    /**
     * {@inheritDoc}
     */
    @Override
    public String showType() {
        return type;
    }

}
