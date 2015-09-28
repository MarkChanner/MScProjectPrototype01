package gameboard;

import gamepieces.*;

/**
 * @author Mark Channer
 *         TemporaryBoardPopulator is used as a replacement for BoardPopulatorImpl for testing
 *         Instead of populating the board with randomly generated game pieces, this board
 *         is populated with fixed game pieces.
 */
public class BoardPopulatorManyMatches implements BoardPopulator {

    /** For testing, populates board with consecutive icons of 3 or more alrady present */
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
        tiles[6][1] = new TileImpl(6, 1, new HappyGamePiece("--"));
        tiles[5][1] = new TileImpl(5, 1, new HappyGamePiece("--"));
        tiles[4][1] = new TileImpl(4, 1, new HappyGamePiece("--"));
        tiles[3][1] = new TileImpl(3, 1, new HappyGamePiece("--"));

        tiles[5][0] = new TileImpl(5, 0, new HappyGamePiece("--"));
        tiles[5][1] = new TileImpl(5, 1, new HappyGamePiece("--"));
        tiles[5][2] = new TileImpl(5, 2, new HappyGamePiece("--"));

        tiles[0][6] = new TileImpl(0, 6, new HappyGamePiece("--"));
        tiles[1][6] = new TileImpl(1, 6, new HappyGamePiece("--"));
        tiles[2][6] = new TileImpl(2, 6, new HappyGamePiece("--"));
        tiles[2][1] = new TileImpl(2, 1, new HappyGamePiece("--"));
    }

    @Override
    public GamePiece generateGamePiece() {
        return new HappyGamePiece("X");
    }
}
