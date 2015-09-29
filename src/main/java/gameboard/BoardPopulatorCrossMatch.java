package gameboard;

import gamepieces.*;
import java.util.Random;

/**
 * @author Mark Channer
 */
public class BoardPopulatorCrossMatch implements BoardPopulator {

    @Override
    public void populate(Board board) {
        int rows = board.getRows();
        int cols = board.getCols();
        Tile[][] tiles = board.getAllTiles();
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
        tiles[4][0] = new TileImpl(4, 0, new SadGamePiece());
        tiles[5][0] = new TileImpl(5, 0, new ConfusedGamePiece());
        tiles[6][0] = new TileImpl(6, 0, new ConfusedGamePiece());
        tiles[2][0] = new TileImpl(2, 0, new ExcitedGamePiece());
        tiles[0][0] = new TileImpl(0, 0, new HappyGamePiece());
        tiles[1][0] = new TileImpl(1, 0, new HappyGamePiece());
        tiles[3][0] = new TileImpl(3, 0, new HappyGamePiece());

        tiles[0][1] = new TileImpl(0, 1, new ConfusedGamePiece());
        tiles[1][1] = new TileImpl(1, 1, new AngryGamePiece());
        tiles[2][1] = new TileImpl(2, 1, new SadGamePiece());
        tiles[3][1] = new TileImpl(3, 1, new ExcitedGamePiece());
        tiles[4][1] = new TileImpl(4, 1, new HappyGamePiece());
        tiles[5][1] = new TileImpl(5, 1, new HappyGamePiece());
        tiles[6][1] = new TileImpl(6, 1, new SadGamePiece());

        tiles[0][2] = new TileImpl(0, 2, new ExcitedGamePiece());
        tiles[1][2] = new TileImpl(1, 2, new ConfusedGamePiece());
        tiles[2][2] = new TileImpl(2, 2, new HappyGamePiece());
        tiles[3][2] = new TileImpl(3, 2, new ExcitedGamePiece());
        tiles[4][2] = new TileImpl(4, 2, new SadGamePiece());
        tiles[5][2] = new TileImpl(5, 2, new SadGamePiece());
        tiles[6][2] = new TileImpl(6, 2, new ConfusedGamePiece());
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
