package model.gameboard;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public interface Selections {

    /**
     * Sets selections to value of -1
     */
    void reset();

    /**
     * Returns the user's first selection if it has been made
     *
     * @return an int[] array containing x and y values of first selection
     */
    int[] getSelection01();

    /**
     * Sets x and y values for the user's first selection
     *
     * @param x the x value to set for first selection
     * @param y the y value to set for first selection
     */
    void setSelection01(int x, int y);

    /**
     * @return true if user's has made first selection
     */
    boolean selection01AlreadyMade();

    /**
     * Returns the user's second selection if it has been made
     *
     * @return an int[] array containing x  y values of second selection
     */
    int[] getSelection02();

    /**
     * Sets x and y values for the user's second selection
     *
     * @param x the x value to set for second selection
     * @param y the y value to set for second selection
     */
    void setSelection02(int x, int y);

    /**
     * @return true if the x and y values of each selection are the same
     */
    boolean sameSelectionMadeTwice();

    /**
     * @return true if the second selection is NOT directly vertically
     * or horizontally adjacent to the first selection
     */
    boolean areNotAdjacent();

    /**
     * Makes the user's second selection become the user's first selection.
     * This method is called when the user's second selection is not directly
     * vertically or horizontally adjacent to the first selection
     */
    void secondSelectionBecomesFirstSelection();

}


