package gameboard;

import gamepieces.*;
import java.util.Random;

/**
 * @author Mark Channer
 *
 */
public class BoardPopulatorCrossMatch implements BoardPopulator {

    public final static String ANGRY_FACE = "AN";
    public final static String CONFUSED_FACE = "CO";
    public final static String EXCITED_FACE = "EX";
    public final static String HAPPY_FACE = "HA";
    public final static String SAD_FACE = "SA";

    @Override
    public void populate(Board board) {
        int rows = board.getRows();
        int cols = board.getCols();
        Tile[][] tiles = board.getAllTiles();
        int counter = 10;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                tiles[row][col] = new TileImpl(row, col, new HappyGamePiece("" + counter));
                counter++;
            }
        }
        tiles[0][0] = new TileImpl(0, 0, new SadGamePiece("SA"));
        tiles[1][0] = new TileImpl(1, 0, new ConfusedGamePiece("CO"));
        tiles[2][0] = new TileImpl(2, 0, new ConfusedGamePiece("CO"));
        tiles[3][0] = new TileImpl(3, 0, new HappyGamePiece("HA"));
        tiles[4][0] = new TileImpl(4, 0, new ExcitedGamePiece("EX"));
        tiles[5][0] = new TileImpl(5, 0, new HappyGamePiece("HA"));
        tiles[6][0] = new TileImpl(6, 0, new HappyGamePiece("HA"));

        tiles[0][1] = new TileImpl(0, 1, new ConfusedGamePiece("CO"));
        tiles[1][1] = new TileImpl(1, 1, new AngryGamePiece("AN"));
        tiles[2][1] = new TileImpl(2, 1, new SadGamePiece("SA"));
        tiles[3][1] = new TileImpl(3, 1, new ExcitedGamePiece("EX"));
        tiles[4][1] = new TileImpl(4, 1, new HappyGamePiece("HA"));
        tiles[5][1] = new TileImpl(5, 1, new HappyGamePiece("HA"));
        tiles[6][1] = new TileImpl(6, 1, new SadGamePiece("SA"));

        tiles[0][2] = new TileImpl(0, 2, new ExcitedGamePiece("EX"));
        tiles[1][2] = new TileImpl(1, 2, new ConfusedGamePiece("CO"));
        tiles[2][2] = new TileImpl(2, 2, new HappyGamePiece("HA"));
        tiles[3][2] = new TileImpl(3, 2, new ExcitedGamePiece("EX"));
        tiles[4][2] = new TileImpl(4, 2, new SadGamePiece("SA"));
        tiles[5][2] = new TileImpl(5, 2, new SadGamePiece("SA"));
        tiles[6][2] = new TileImpl(6, 2, new ConfusedGamePiece("CO"));
    }

    @Override
    public GamePiece generateGamePiece() {
        GamePiece gp = null;
        Random random = new Random();
        int value = random.nextInt(5);
        switch (value) {
            case 0:
                gp = new AngryGamePiece(ANGRY_FACE);
                break;
            case 1:
                gp = new ConfusedGamePiece(CONFUSED_FACE);
                break;
            case 2:
                gp = new ExcitedGamePiece(EXCITED_FACE);
                break;
            case 3:
                gp = new HappyGamePiece(HAPPY_FACE);
                break;
            case 4:
                gp = new SadGamePiece(SAD_FACE);
                break;
            default:
                System.out.println("Error in BoardPopulatorImpl, generateGamePiece()");
                break;
        }
        return gp;
    }
}
