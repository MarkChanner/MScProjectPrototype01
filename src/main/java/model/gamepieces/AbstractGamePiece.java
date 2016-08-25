package model.gamepieces;

/**
 * AbstractGamePiece to be subclassed by different game piece types. Implements the GamePiece interface.
 * Each GamePiece is passed as a String to the constructor (via super(type) which allows each method call to
 * get behaviour specific to each subclass without the need for duplicating the code within each.
 *
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public abstract class AbstractGamePiece {

    private String type;
    private int x = -1;
    private int y = -1;

    public AbstractGamePiece(String type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String showType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
