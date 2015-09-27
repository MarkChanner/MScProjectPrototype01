package gameboard;

import gamepieces.*;

import java.util.Random;

/**
 * @author Mark Channer
 *         Populates the gameboard.
 */
public class BoardPopulator {

    public BoardPopulator(Tile[][] tiles, int rows, int cols) {
        populate(tiles, rows, cols);
    }

    public void populate(Tile[][] tiles, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                GamePiece newGamePiece = generateGamePiece();
                tiles[row][col] = new TileImpl(row, col, newGamePiece);
            }
        }
    }

    public GamePiece generateGamePiece() {
        GamePiece gp = null;
        Random random = new Random();
        int number = random.nextInt(5);
        switch (number) {
            case 0:
                gp = new AngryGamePiece("AA");
                break;
            case 1:
                gp = new ConfusedGamePiece("CC");
                break;
            case 2:
                gp = new ExcitedGamePiece("EE");
                break;
            case 3:
                gp = new HappyGamePiece("HH");
                break;
            case 4:
                gp = new SadGamePiece("SS");
                break;
            default:
                System.out.println("Error");
        }
        return gp;
    }

    public void testPopulator(Tile[][] tiles, int rows, int cols) {
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
}