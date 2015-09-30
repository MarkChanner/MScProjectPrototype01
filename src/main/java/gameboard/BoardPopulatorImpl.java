package gameboard;

import gamepieces.*;
import java.util.Random;

/**
 * @author Mark Channer
 *         Populates the gameboard at random.
 */
public class BoardPopulatorImpl implements BoardPopulator {

    @Override
    public void populate(Board board) {
        int rows = board.getRows();
        int cols = board.getCols();
        Tile[][] tiles = board.getTiles();
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
                gp = new AngryGamePiece();
                break;
            case 1:
                gp = new ConfusedGamePiece();
                break;
            case 2:
                gp = new ExcitedGamePiece();
                break;
            case 3:
                gp = new HappyGamePiece();
                break;
            case 4:
                gp = new SadGamePiece();
                break;
            default:
                System.out.println("Error in BoardPopulatorImpl, generateGamePiece()");
                break;
        }
        return gp;
    }
}