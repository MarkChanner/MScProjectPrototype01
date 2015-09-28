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
        tiles[4][2] = new TileImpl(4, 2, new HappyGamePiece("XX"));
        tiles[3][2] = new TileImpl(3, 2, new HappyGamePiece("XX"));

        tiles[5][0] = new TileImpl(5, 0, new HappyGamePiece("XX"));
        tiles[5][1] = new TileImpl(5, 1, new HappyGamePiece("XX"));
        tiles[5][3] = new TileImpl(5, 3, new HappyGamePiece("XX"));

    }

    @Override
    public GamePiece generateGamePiece() {
        return new HappyGamePiece("H");
    }


}
