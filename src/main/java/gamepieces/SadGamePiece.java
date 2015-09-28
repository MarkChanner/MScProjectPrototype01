package gamepieces;

/**
 * @author Mark Channer
 */
public class SadGamePiece extends AbstractGamePiece {

    public SadGamePiece(String type) {
        super(type);
    }

    @Override
    public GamePiece retrieveGamePiece() {
        return (this);
    }

    public String toString() {
        return "OH, IT'S A SAD FACE!!!!!";
    }
}
