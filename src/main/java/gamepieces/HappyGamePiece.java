package gamepieces;

/**
 * @author Mark Channer
 */
public class HappyGamePiece extends AbstractGamePiece {

    public HappyGamePiece() {
        super("HA");
    }

    @Override
    public GamePiece retrieveGamePiece() {
        return (this);
    }

    public String toString() {
        return "HEY HEY! IT'S A HAPPY FACE!!!!!!";
    }

}
