package model.gameboard;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public interface GameModel {

    /**
     * Receives the x and y coordinates of the user selection.
     *
     * @param x the x value of user selection
     * @param y the y value of user selection
     */
    void handleSelection(int x, int y);

}

