package main.java.gamepieces;
/**
 * @author Mark Channer
 */
public abstract class AbstractGamePiece implements GamePiece {

    private String type;

    public AbstractGamePiece(String type) {
        this.type = type;
    }

    public abstract GamePiece retrieveGamePiece();

    @Override
    public String showType() {
        return type;
    }

}
