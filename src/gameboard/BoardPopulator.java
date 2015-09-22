package gameboard;

import gamepieces.*;

/**
 * @author Mark Channer
 * Populates the gameboard.
 */
public class BoardPopulator {

    public BoardPopulator(Tile[][] tiles, int cols, int rows) {
        populate(tiles, cols, rows);
    }

    public void populate(Tile[][] tiles, int cols, int rows) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i % 2 == 0) {
                    if (j == 0) {
                        tiles[i][j] = new TileImpl(i, j, new AngryGamePiece("A"));
                    } else if (j == 1) {
                        tiles[i][j] = new TileImpl(i, j, new ConfusedGamePiece("C"));
                    } else if (j == 2) {
                        tiles[i][j] = new TileImpl(i, j, new HappyGamePiece("H"));
                    } else if (j == 3) {
                        tiles[i][j] = new TileImpl(i, j, new ExcitedGamePiece("E"));
                    } else if (j == 4) {
                        tiles[i][j] = new TileImpl(i, j, new AngryGamePiece("A"));
                    } else if (j == 5) {
                        tiles[i][j] = new TileImpl(i, j, new HappyGamePiece("H"));
                    } else {
                        tiles[i][j] = new TileImpl(i, j, new SadGamePiece("S"));
                    }
                } else {
                    if (j == 6) {
                        tiles[i][j] = new TileImpl(i, j, new AngryGamePiece("A"));
                    } else if (j == 5) {
                        tiles[i][j] = new TileImpl(i, j, new ConfusedGamePiece("C"));
                    } else if (j == 4) {
                        tiles[i][j] = new TileImpl(i, j, new HappyGamePiece("H"));
                    } else if (j == 3) {
                        tiles[i][j] = new TileImpl(i, j, new SadGamePiece("S"));
                    } else if (j == 2) {
                        tiles[i][j] = new TileImpl(i, j, new ExcitedGamePiece("E"));
                    } else if (j == 4) {
                        tiles[i][j] = new TileImpl(i, j, new ExcitedGamePiece("E"));
                    } else {
                        tiles[i][j] = new TileImpl(i, j, new HappyGamePiece("H"));
                    }
                }
            }
        }
        tiles[3][0] = new TileImpl(3, 0, new HappyGamePiece("H"));
        tiles[3][1] = new TileImpl(3, 1, new AngryGamePiece("A"));
        tiles[3][2] = new TileImpl(3, 2, new AngryGamePiece("A"));
        tiles[3][3] = new TileImpl(3, 3, new SadGamePiece("S"));
        tiles[3][4] = new TileImpl(3, 4, new AngryGamePiece("A"));
        tiles[3][5] = new TileImpl(3, 5, new SadGamePiece("S"));
        tiles[3][6] = new TileImpl(3, 6, new SadGamePiece("S"));
        tiles[4][6] = new TileImpl(4, 6, new ConfusedGamePiece("C"));
        tiles[1][4] = new TileImpl(1, 4, new SadGamePiece("S"));
        tiles[2][4] = new TileImpl(2, 4, new SadGamePiece("S"));
        tiles[4][4] = new TileImpl(4, 4, new SadGamePiece("S"));
        tiles[5][4] = new TileImpl(5, 4, new SadGamePiece("S"));
        tiles[1][3] = new TileImpl(1, 3, new AngryGamePiece("A"));
        tiles[2][3] = new TileImpl(2, 3, new AngryGamePiece("A"));
        tiles[4][3] = new TileImpl(4, 3, new AngryGamePiece("A"));
        tiles[5][3] = new TileImpl(5, 3, new AngryGamePiece("A"));
    }
}
