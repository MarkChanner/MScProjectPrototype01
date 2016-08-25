package gameboard;

import gamepieces.*;
import java.util.Random;

/**
 * Implementation of the BoardPopulator interface that populates a Board with GamePieces
 * at random. However, as this class is used for a matching game where the objective is
 * to match 3 consecutive game pieces, it ensures that 3 consecutive pieces would not
 * be formed at the outset.
 *
 *  @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class BoardPopulatorImpl implements BoardPopulator {


    /**
     * Populates the given Board object with game pieces that are allocated at random. If
     * placing the game piece would result in a board that has 3 consecutive piece types at
     * the start of the game, another game piece is chosen until one that does not form a match is
     * found { @inheritDocs }
     */
    @Override
    public void populate(Board board) {
        int rows = board.getRows();
        int cols = board.getCols();
        Tile[][] tiles = board.getTiles();
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
    }

    /**
     * Returns one of five game piece objects that are chosen at random
     *
     * @return a subclass of AbstractGamePiece (AbstractGamePiece implements GamePiece interface)
     */
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