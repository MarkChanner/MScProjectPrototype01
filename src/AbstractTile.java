/**
 * @author Mark Channer
 *
 * AbstractTile holds a reference to a GamePiece, which
 * it can call methods on
 */
public abstract class AbstractTile implements Tile {

    private GamePiece emoticon;

    public AbstractTile(GamePiece emoticon) {
        this.emoticon = emoticon;
    }

    @Override
    public String getFace() {
        return emoticon.showFace();
    }

    @Override
    public void setFace(GamePiece gp) {
        this.emoticon = gp;
    }
}
