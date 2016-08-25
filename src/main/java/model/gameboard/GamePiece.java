package model.gameboard;

/**
 * A game piece, such as an emoticon for a tile matching game.
 *
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public interface GamePiece {

    /**
     * Sets the position of the element that implements GamePiece in the board.
     *
     * @param row the row number that the piece is located on the board
     * @param column the column number that the piece is located on the board
     */
    void setCoordinates(int row, int column);

    /**
     * Called from a board Tile that needs to access the GamePiece it is housing
     * @return the GamePiece situated on that Tile
     */
    GamePiece retrieveGamePiece();

    /**
     * Gives the particular type of the GamePiece (such as 'happy face emoticon',
     * 'angry face emoticon')
     * @return a String that gives the type of the GamePiece
     */
    String showType();

}

