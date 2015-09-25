package gameboard;

import gamepieces.*;

/**
 * @author Mark Channer
 *         Populates the gameboard.
 */
public class BoardPopulator {

    public BoardPopulator(Tile[][] tiles, int rows, int cols) {
        populate(tiles, rows, cols);
    }

    public void populate(Tile[][] tiles, int rows, int cols) {
        int counter = 10;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                /** Populates the board with X for testing visual output */
                tiles[row][col] = new TileImpl(row, col, new HappyGamePiece("" + counter));
                counter++;
            }
        }
        tiles[6][1] = new TileImpl(6, 1, new HappyGamePiece("00"));
        tiles[5][1] = new TileImpl(5, 1, new HappyGamePiece("00"));
        tiles[4][1] = new TileImpl(4, 1, new HappyGamePiece("00"));
        tiles[3][1] = new TileImpl(3, 1, new HappyGamePiece("00"));
        tiles[2][1] = new TileImpl(2, 1, new HappyGamePiece("00"));

        tiles[5][0] = new TileImpl(5, 0, new HappyGamePiece("00"));
        tiles[5][1] = new TileImpl(5, 1, new HappyGamePiece("00"));
        tiles[5][2] = new TileImpl(5, 2, new HappyGamePiece("00"));
        tiles[4][2] = new TileImpl(4, 2, new HappyGamePiece("00"));

        tiles[0][6] = new TileImpl(0, 6, new HappyGamePiece("00"));
        tiles[1][6] = new TileImpl(1, 6, new HappyGamePiece("00"));
        tiles[2][6] = new TileImpl(2, 6, new HappyGamePiece("00"));
    }
}
               /* if (row % 2 == 0) {
                    if (col == 0) {
                        tiles[row][col] = new TileImpl(row, col, new AngryGamePiece("A"));
                    } else if (col == 1) {
                        tiles[row][col] = new TileImpl(row, col, new ConfusedGamePiece("C"));
                    } else if (col == 2) {
                        tiles[row][col] = new TileImpl(row, col, new HappyGamePiece("H"));
                    } else if (col == 3) {
                        tiles[row][col] = new TileImpl(row, col, new ExcitedGamePiece("E"));
                    } else if (col == 4) {
                        tiles[row][col] = new TileImpl(row, col, new AngryGamePiece("A"));
                    } else if (col == 5) {
                        tiles[row][col] = new TileImpl(row, col, new HappyGamePiece("H"));
                    } else {
                        tiles[row][col] = new TileImpl(row, col, new SadGamePiece("S"));
                    }
                } else {
                    if (col == 6) {
                        tiles[row][col] = new TileImpl(row, col, new AngryGamePiece("A"));
                    } else if (col == 5) {
                        tiles[row][col] = new TileImpl(row, col, new ConfusedGamePiece("C"));
                    } else if (col == 4) {
                        tiles[row][col] = new TileImpl(row, col, new HappyGamePiece("H"));
                    } else if (col == 3) {
                        tiles[row][col] = new TileImpl(row, col, new SadGamePiece("S"));
                    } else if (col == 2) {
                        tiles[row][col] = new TileImpl(row, col, new ExcitedGamePiece("E"));
                    } else if (col == 4) {
                        tiles[row][col] = new TileImpl(row, col, new ExcitedGamePiece("E"));
                    } else {
                        tiles[row][col] = new TileImpl(row, col, new HappyGamePiece("H"));
                    }
                }
            }
        tiles[0][0] = new TileImpl(0, 0, new AngryGamePiece("H"));
        tiles[1][0] = new TileImpl(1, 0, new AngryGamePiece("H"));
        tiles[1][1] = new TileImpl(1, 1, new AngryGamePiece("H"));
        tiles[1][2] = new TileImpl(1, 2, new AngryGamePiece("H"));
        tiles[1][3] = new TileImpl(1, 3, new AngryGamePiece("H"));
        tiles[1][4] = new TileImpl(1, 4, new AngryGamePiece("H"));
        tiles[1][5] = new TileImpl(1, 5, new AngryGamePiece("H"));
        tiles[1][6] = new TileImpl(1, 6, new AngryGamePiece("H"));
        tiles[3][0] = new TileImpl(3, 0, new HappyGamePiece("H"));
        tiles[3][1] = new TileImpl(3, 1, new AngryGamePiece("A"));
        tiles[3][2] = new TileImpl(3, 2, new AngryGamePiece("A"));
        tiles[3][3] = new TileImpl(3, 3, new AngryGamePiece("C"));
        tiles[3][4] = new TileImpl(3, 4, new AngryGamePiece("A"));
        tiles[3][5] = new TileImpl(3, 5, new ConfusedGamePiece("C"));
        tiles[3][6] = new TileImpl(3, 6, new ConfusedGamePiece("C"));
        tiles[4][6] = new TileImpl(4, 6, new ConfusedGamePiece("C"));
        tiles[2][4] = new TileImpl(2, 4, new SadGamePiece("P"));
        tiles[4][4] = new TileImpl(4, 4, new SadGamePiece("P"));
        tiles[5][4] = new TileImpl(5, 4, new SadGamePiece("P"));
        tiles[1][3] = new TileImpl(1, 3, new AngryGamePiece("A"));
        tiles[2][3] = new TileImpl(2, 3, new AngryGamePiece("A"));
        tiles[4][3] = new TileImpl(4, 3, new AngryGamePiece("A"));
        tiles[5][3] = new TileImpl(5, 3, new AngryGamePiece("A"));
        tiles[6][4] = new TileImpl(6, 4, new AngryGamePiece("P"));
        tiles[6][3] = new TileImpl(6, 3, new AngryGamePiece("A"));
        tiles[5][2] = new TileImpl(5, 2, new HappyGamePiece("H"));
        tiles[1][2] = new TileImpl(1, 2, new HappyGamePiece("H"));
        tiles[1][3] = new TileImpl(1, 3, new HappyGamePiece("H"));
        tiles[2][6] = new TileImpl(2, 6, new HappyGamePiece("X"));
        tiles[5][6] = new TileImpl(5, 6, new AngryGamePiece("C"));*/