package gameboard;

import gamepieces.*;
import java.util.Random;

/**
 * @author Mark Channer
 *         Populates the gameboard at random.
 */
public class BoardPopulatorImpl implements BoardPopulator {

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
        GamePiece newGamePiece;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                do {
                    newGamePiece = generateGamePiece();
                } while ((row >= 2 &&
                        (newGamePiece.showType().equals(tiles[row - 1][col].getPieceType()) &&
                                newGamePiece.showType().equals(tiles[row - 2][col].getPieceType()))) ||
                        (col >= 2 &&
                                (newGamePiece.showType().equals(tiles[row][col - 1].getPieceType()) &&
                                        newGamePiece.showType().equals(tiles[row][col - 2].getPieceType()))));
                tiles[row][col] = new TileImpl(row, col, newGamePiece);
            }
        }
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