package gameboard;

import gamepieces.*;

import java.util.Random;

/**
 * @author Mark Channer
 */
public class BoardPopulatorMock01 implements BoardPopulator {

    @Override
    public void populate(Board board) {
        int rows = board.getRows();
        int cols = board.getCols();
        Tile[][] tiles = board.getTiles();

        /* First Test set up */
        tiles[3][0] = new TileImpl(3, 0, new HappyGamePiece());
        tiles[2][0] = new TileImpl(2, 0, new ExcitedGamePiece());
        tiles[1][0] = new TileImpl(1, 0, new HappyGamePiece());
        tiles[0][0] = new TileImpl(0, 0, new HappyGamePiece());

        tiles[3][1] = new TileImpl(3, 1, new ExcitedGamePiece());
        tiles[3][2] = new TileImpl(3, 2, new ExcitedGamePiece());

        /* Second test set up */
        tiles[3][3] = new TileImpl(3, 3, new SadGamePiece());
        tiles[3][4] = new TileImpl(3, 4, new AngryGamePiece());
        tiles[3][5] = new TileImpl(3, 5, new SadGamePiece());
        tiles[3][6] = new TileImpl(3, 6, new SadGamePiece());

        tiles[4][4] = new TileImpl(4, 4, new SadGamePiece());
        tiles[5][4] = new TileImpl(5, 4, new SadGamePiece());


        int counter = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (tiles[row][col] == null) {
                    tiles[row][col] = new TileImpl(row, col, new TestGamePiece(counter));
                    counter++;
                }
            }
        }

        GamePiece newGamePiece;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (tiles[row][col] == null) {

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
