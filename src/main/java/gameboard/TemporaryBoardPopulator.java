package gameboard;

import gamepieces.*;
import java.util.Random;

/**
 * @author Mark Channer
 *         TemporaryBoardPopulator is used as a replacement for BoardPopulator for testing
 *         Instead of populating the board with randomly generated game pieces, this board
 *         is populated with fixed game pieces.
 */
public class TemporaryBoardPopulator {

    public TemporaryBoardPopulator(Tile[][] tiles, int rows, int cols) {
        populateWithNoMatches(tiles, rows, cols);
    }

    public void populateWithFixedMatches(Tile[][] tiles, int rows, int cols) {
        int counter = 10;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                tiles[row][col] = new TileImpl(row, col, new HappyGamePiece("" + counter));
                counter++;
            }
        }
        tiles[6][1] = new TileImpl(6, 1, new HappyGamePiece("--"));
        tiles[5][1] = new TileImpl(5, 1, new HappyGamePiece("--"));
        tiles[4][1] = new TileImpl(4, 1, new HappyGamePiece("--"));
        tiles[3][1] = new TileImpl(3, 1, new HappyGamePiece("--"));
        tiles[2][1] = new TileImpl(2, 1, new HappyGamePiece("--"));

        tiles[5][0] = new TileImpl(5, 0, new HappyGamePiece("--"));
        tiles[5][1] = new TileImpl(5, 1, new HappyGamePiece("--"));
        tiles[5][2] = new TileImpl(5, 2, new HappyGamePiece("--"));

        tiles[0][6] = new TileImpl(0, 6, new HappyGamePiece("--"));
        tiles[1][6] = new TileImpl(1, 6, new HappyGamePiece("--"));
        tiles[2][6] = new TileImpl(2, 6, new HappyGamePiece("--"));
    }

    public void populateWithNoMatches(Tile[][] tiles, int rows, int cols) {
        int counter = 10;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                tiles[row][col] = new TileImpl(row, col, new HappyGamePiece("" + counter));
                counter++;
            }
        }
        tiles[1][1] = new TileImpl(1, 1, new HappyGamePiece("17"));
        tiles[1][3] = new TileImpl(1, 3, new HappyGamePiece("17"));

    }
}
