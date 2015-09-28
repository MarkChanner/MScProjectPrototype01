package gameboard;

import gamepieces.GamePiece;
import gamepieces.HappyGamePiece;

/**
 * @author Mark Channer
 * Populates the board with no matches, but there is the possibility to
 * create 3 consecutive tiles at location if 1,2 and 1,3 are swapped
 */
public class BoardPopulatorCrossMatch implements BoardPopulator {

    @Override
    public void populate(Tile[][] tiles, int rows, int cols) {
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

    @Override
    public GamePiece generateGamePiece() {
        return new HappyGamePiece("H");
    }


}
