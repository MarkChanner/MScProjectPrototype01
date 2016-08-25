package model.gameboard;

import model.gamepieces.AbstractGamePiece;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Finds and returns an ArrayList that contains Lists of rows or columns that have tiles
 * containing game pieces of the same type.
 *
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public interface MatchFinder {

    /**
     * Returns an ArrayList that contains a List/Lists of matching GamePieces on the board if
     * present. If no matches are present, the returned ArrayList will hold an empty List.
     *
     * @param board the board to be checked for vertical matches
     * @return An ArrayList that holds a List/Lists of vertical matches or an empty
     * list if no vertical matches are located on the board
     */
    ArrayList<LinkedList<AbstractGamePiece>> findVerticalMatches(GameBoard board);

    /**
     * Returns an ArrayList that contains a List/Lists of matching GamePieces on the board if
     * present. If no matches are present, the returned ArrayList will hold an empty List.
     *
     * @param board the board to be checked for horizontal matches
     * @return An ArrayList that holds either a List/Lists of horizontal matches or an empty
     * list if no horizontal matches are located on the board
     */
    ArrayList<LinkedList<AbstractGamePiece>> findHorizontalMatches(GameBoard board);

}
