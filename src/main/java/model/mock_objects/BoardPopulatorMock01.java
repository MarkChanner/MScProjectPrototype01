package model.mock_objects;

import model.gameboard.BoardPopulator;
import model.gameboard.BoardPopulatorImpl;
import model.gameboard.GameBoard;
import model.gamepieces.*;

/**
 * Populates the board with MockEmoticons. To enable testing, each MockEmoticon is assigned
 * a unique type value based on the counter variable that is incremented after each MockEmoticon
 * is set on the GameBoard.
 *
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class BoardPopulatorMock01 extends BoardPopulatorImpl implements BoardPopulator {

    private static final int ROW_START = 0;
    private static final int COLUMN_TOP = 0;

    /**
     * Populates the board with MockEmoticons. So that no matches are
     * initially possible, the type of each MockEmoticon is a unique number
     *
     * @param board The GameBoard to be populated with game pieces
     */
    @Override
    public void populate(GameBoard board) {
        int cols = board.getCols();
        int rows = board.getRows();
        int counter = 0;
        for (int x = ROW_START; x < cols; x++) {
            for (int y = COLUMN_TOP; y < rows; y++) {
                String type = counter <= 9 ? "0" + counter : "" + counter;
                board.setGamePiece(x, y, new MockEmoticon(type, x, y));
                counter++;
            }
        }

        positionRealEmoticonsOnBoard(board);
    }

    private void positionRealEmoticonsOnBoard(GameBoard board) {
        // Adds emoticons to GameBoard so that a vertical match of HappyEmoticons
        // and a horizontal match of EmbarrassedEmoticons can occur when the
        // emoticons at positions (0,3) and (0,4) are swapped
        // when tiles 3,0 and 4,0 are selected
        board.setGamePiece(0, 1, new HappyEmoticon(0, 1));
        board.setGamePiece(0, 2, new HappyEmoticon(0, 2));
        board.setGamePiece(0, 3, new EmbarrassedEmoticon(0, 3));
        board.setGamePiece(0, 4, new HappyEmoticon(0, 4));
        board.setGamePiece(1, 4, new EmbarrassedEmoticon(1, 4));
        board.setGamePiece(2, 4, new EmbarrassedEmoticon(2, 4));

        // Adds emoticons to GameBoard so that a horizontal and vertical match of
        // SadEmoticons can occur when the emoticons at positions (2,1) and (3,1) are swapped
        board.setGamePiece(3, 0, new SadEmoticon(3, 0));
        board.setGamePiece(3, 1, new AngryEmoticon(3, 1));
        board.setGamePiece(3, 2, new SadEmoticon(3, 2));
        board.setGamePiece(3, 3, new SadEmoticon(3, 3));
        board.setGamePiece(2, 1, new SadEmoticon(2, 1));
        board.setGamePiece(4, 1, new SadEmoticon(4, 1));
        board.setGamePiece(5, 1, new SadEmoticon(5, 1));
    }

}
