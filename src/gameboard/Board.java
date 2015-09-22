package gameboard;

/**
 * @author Mark Channer
 *         The Board on which the game will take place
 */
public interface Board {

    void populateBoard();

    int getCols();

    int getRows();

    Tile[][] getAllTiles();

    void displayBoard();

    void selectEmoticon(int newCol, int newRow);

    void compareFirstEmoticonWithSecond();

    boolean sameButtonPressedTwice();

    boolean selectedEmoticonsAreAdjacent();

    void resetBothButtons();

    void attemptToSwap();

    boolean bothDisplaySameEmotion();
}
