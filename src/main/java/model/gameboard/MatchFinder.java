package model.gameboard;

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
     * Returns an ArrayList that contains a List/Lists of matching tiles on the board if
     * they are present. If no matches are present, the returned ArrayList will hold
     * an empty List.
     *
     * @param b the board to be checked for matching columns
     * @return An ArrayList that holds either a List/Lists of matching columns, or an empty list
     * if no matching columns are located on the board
     */
    ArrayList<LinkedList<Tile>> findMatchingColumns(Board b);

    /**
     * Returns an ArrayList that contains a List/Lists of matching tiles on the board if
     * they are present. If no matches are present, the returned ArrayList will hold
     * an empty List.
     *
     * @param b the board to be checked for matching rows
     * @return An ArrayList that holds either a List/Lists of matching rows, or an empty list
     * if no matching rows are located on the board
     */
    ArrayList<LinkedList<Tile>> findMatchingRows(Board b);



}