package model.gameboard;

import model.gamepieces.*;

import java.util.Random;

/**
 * Implementation of the BoardPopulator interface that populates a GameBoard with GamePieces
 * at random. As this class is used for a matching game where the objective is
 * to match 3 consecutive game pieces, it ensures that 3 consecutive pieces would not
 * be formed at the outset.
 *
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class BoardPopulatorImpl implements BoardPopulator {

    private static final int ROW_START = 0;
    private static final int COLUMN_TOP = 0;

    /**
     * Populates the given GameBoard object with game pieces that are allocated at random. If
     * placing the game piece would result in a board that has 3 consecutive piece types at
     * the start of the game, another game piece is chosen until one that does not form a match is
     * found { @inheritDocs }
     */
    @Override
    public void populate(GameBoard board) {
        System.out.println("In populate(board)");
        int cols = board.getCols();
        int rows = board.getRows();
        AbstractGamePiece emoticon;
        for (int x = ROW_START; x < cols; x++) {
            for (int y = COLUMN_TOP; y < rows; y++) {

                do {
                    emoticon = generateGamePiece(x, y);
                } while (gamePieceTypeCausesMatch(x, y, board, emoticon.showType()));

                board.setGamePiece(x, y, emoticon);
            }
        }
    }

    private boolean gamePieceTypeCausesMatch(int x, int y, GameBoard board, String emoType) {
        if (y >= 2 && emoType.equals(board.getGamePiece(x, y - 1).showType()) &&
                emoType.equals(board.getGamePiece(x, y - 2).showType()))
            return true;
        else if (x >= 2 && emoType.equals(board.getGamePiece(x - 1, y).showType()) &&
                emoType.equals(board.getGamePiece(x - 2, y).showType())) {
            return true;
        }
        return false;
    }

    /**
     * Returns one of five game piece objects that are chosen at random
     *
     * @return a subclass of AbstractGamePiece (AbstractGamePiece implements GamePiece interface)
     */
    @Override
    public AbstractGamePiece generateGamePiece(int x, int y) {
        AbstractGamePiece emoticon = null;
        Random random = new Random();
        int value = random.nextInt(5);
        switch (value) {
            case 0:
                emoticon = new AngryEmoticon(x, y);
                break;
            case 1:
                emoticon = new SurprisedEmoticon(x, y);
                break;
            case 2:
                emoticon = new EmbarrassedEmoticon(x, y);
                break;
            case 3:
                emoticon = new HappyEmoticon(x, y);
                break;
            case 4:
                emoticon = new SadEmoticon(x, y);
                break;
            default:
                System.out.println("Error in BoardPopulatorImpl, generateGamePiece()");
                break;
        }
        return emoticon;
    }
}