package model.gameboard;

import model.gameboard.*;
import model.gamepieces.*;

import java.util.Random;

/**
 * Populates the board with numbers, starting with 0 and incrementing by 1. This is so
 * that no matches can occur except for on the tiles that are set with GamePieces at
 * strategic places for testing
 *
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class BoardPopulatorMock01 implements BoardPopulator {

    @Override
    public void populate(Board board) {
        int rows = board.getRows();
        int cols = board.getCols();
        Tile[][] tiles = board.getTiles();

        // Populates the board with numbers that increment by 1 so that no
        // matches are possible yet
        int counter = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (tiles[row][col] == null) {
                    String str = counter <= 9 ? "0" + counter : "" + counter;
                    tiles[row][col] = new TileImpl(row, col, new MockGamePiece(str));
                    counter++;
                }
            }
        }

        // Sets up tiles so that a match of HappyGamePieces in a row
        // and a match of ExcitedGamePieces in a column can occur
        // when tiles 3,0 and 4,0 are selected
        tiles[1][0] = new TileImpl(1, 0, new HappyGamePiece());
        tiles[2][0] = new TileImpl(2, 0, new HappyGamePiece());
        tiles[3][0] = new TileImpl(3, 0, new ExcitedGamePiece());
        tiles[4][0] = new TileImpl(4, 0, new HappyGamePiece());
        tiles[4][1] = new TileImpl(4, 1, new ExcitedGamePiece());
        tiles[4][2] = new TileImpl(4, 2, new ExcitedGamePiece());

        // Sets up tiles so that a match of AngryGamePieces in a row
        // and amatchi of SadGamePieces in a column can occur
        // when tiles 3,3 and 3,4 are selected
        tiles[3][3] = new TileImpl(3, 3, new SadGamePiece());
        tiles[3][4] = new TileImpl(3, 4, new AngryGamePiece());
        tiles[3][5] = new TileImpl(3, 5, new SadGamePiece());
        tiles[3][6] = new TileImpl(3, 6, new SadGamePiece());
        tiles[4][4] = new TileImpl(4, 4, new SadGamePiece());
        tiles[5][4] = new TileImpl(5, 4, new SadGamePiece());
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
