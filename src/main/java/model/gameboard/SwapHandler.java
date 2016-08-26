package model.gameboard;

import model.gamepieces.AbstractGamePiece;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public interface SwapHandler {

    /**
     * swaps the game pieces in the given selection
     *
     * @param selections the selected game pieces to swap on the board
     */
    void swap(Selections selections);

    /**
     * Removes matches from that board
     *
     * @param matches an ArrayList containing a LinkedList of matches
     */
    void removeFromBoard(ArrayList<LinkedList<AbstractGamePiece>> matches);

    /**
     * Shifts game pieces down the board
     */
    void shiftIconsDown();

    /**
     * Generates new game pieces and places them
     * in vacant places on the board
     */
    void insertNewIcons(BoardPopulator populator);

}
