package model.gameboard;

import controller.GameController;
import model.gamepieces.AbstractGamePiece;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class GameModelImpl implements GameModel {

    private GameController controller;
    private GameBoard board;
    private MatchFinder matchFinder;
    private BoardPopulator populator;
    private BoardManipulator swapHandler;
    private Selections selections;

    public GameModelImpl(GameController controller, GameBoard board, MatchFinder matchFinder, BoardPopulator populator) {
        this.controller = controller;
        this.board = board;
        this.matchFinder = matchFinder;
        this.populator = populator;
        this.swapHandler = new BoardManipulatorImpl(board);
        this.selections = new SelectionsImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleSelection(int x, int y) {
        if ((y >= board.getRows() || x >= board.getCols()) || (y < 0 || x < 0)) {
            controller.notify("Selection out of board range");
        } else if (!selections.selection01AlreadyMade()) {
            controller.notify("Selection 1: (" + board.getGamePiece(x, y).showType() + ")");
            selections.setSelection01(x, y);
        } else {
            handleSecondSelection(x, y);
        }
    }

    /**
     * A private method that is called from handleSelection(int, int) if the user has already
     * made a first selection. The method checks that the second selection is valid in relation
     * to the first selection (it cannot be the same as the first selection, but must be horizontally
     * or vertically adjacent to it.) If valid, it will swap the selected emoticons and then check the
     * board for matches.
     */
    private void handleSecondSelection(int x, int y) {
        controller.notify("Selection 2: (" + board.getGamePiece(x, y).showType() + ")");
        selections.setSelection02(x, y);
        if (selections.sameSelectionMadeTwice()) {
            controller.notify("Same selection made twice. Resetting.");
            selections.reset();
        } else if (selections.areNotAdjacent()) {
            controller.notify("Selections are not adjacent. Last selection is now first selection.");
            selections.secondSelectionBecomesFirstSelection();
        } else {
            swapHandler.swap(selections);
            controller.notify("Selections swapped.");
            controller.displayBoard();
            checkForMatches();
            selections.reset();
        }
    }

    /**
     * A private method that uses a MatchFinder object to locate matches on the board.
     * If matches on the board are present, the handleMatches method is called. If no
     * matches are present, the previously swapped emoticons are swapped back.
     */
    private void checkForMatches() {
        ArrayList<LinkedList<AbstractGamePiece>> matchingX = matchFinder.findVerticalMatches(board);
        ArrayList<LinkedList<AbstractGamePiece>> matchingY = matchFinder.findHorizontalMatches(board);
        if (matchesFound(matchingX, matchingY)) {
            handleMatches(matchingX, matchingY);
        } else {
            controller.notify("No matching Lines. Swapping pieces back to previous position");
            swapHandler.swap(selections);
            controller.displayBoard();
        }
    }

    /**
     * This method handles the bulk of the requirements for handling a match on the board. It
     * does this within a loop until no more matches are present on the board.
     *
     * @param matchingX An ArrayList containing a LinkedList of matching vertical GamePieces
     * @param matchingY An ArrayList containing a LinkedList of matching horizontal GamePieces
     */
    private void handleMatches(ArrayList<LinkedList<AbstractGamePiece>> matchingX, ArrayList<LinkedList<AbstractGamePiece>> matchingY) {
        do {
            giveReward(matchingX, matchingY);
            swapHandler.removeFromBoard(matchingX);
            swapHandler.removeFromBoard(matchingY);
            swapHandler.lowerGamePieces();
            swapHandler.insertNewIcons(populator);
            controller.notify("Board updated.");
            controller.displayBoard();
            matchingX = matchFinder.findVerticalMatches(board);
            matchingY = matchFinder.findHorizontalMatches(board);
        } while (matchesFound(matchingX, matchingY));
    }

    /**
     * A private method that rewards the player with a message when a set of matches is made.
     * This will be improved to show an animation, play a jingle, increase the score, and
     * maybe make a tablet vibrate, if it has that functionality
     *
     * @param matchingX An ArrayList containing a LinkedList of matching vertical GamePieces
     * @param matchingY An ArrayList containing a LinkedList of matching horizontal GamePieces
     */
    private void giveReward(ArrayList<LinkedList<AbstractGamePiece>> matchingX, ArrayList<LinkedList<AbstractGamePiece>> matchingY) {
        controller.notify("Well done, you have made one or more matches!");
        printList("Vertical matches: ", matchingX);
        printList("Horizontal matches: ", matchingY);
    }

    /**
     * A private method that indicates if the board has matches or not
     *
     * @param matchingX An ArrayList containing a LinkedList of matching vertical GamePieces
     * @param matchingY An ArrayList containing a LinkedList of matching horizontal GamePieces
     * @return a boolean indicating if matches are present or not
     */
    private boolean matchesFound(ArrayList<LinkedList<AbstractGamePiece>> matchingX, ArrayList<LinkedList<AbstractGamePiece>> matchingY) {
        return (!(matchingX.isEmpty() && matchingY.isEmpty()));
    }

    /**
     * A private method that brings game pieces down from above rows to fill
     * any empty spaces on the board
     */


    /**
     * A temporary method for printing output of matching rows and matching columns
     * @param str the message to print
     * @param matches the matches to print the coordinates of
     */
    private void printList(String str, ArrayList<LinkedList<AbstractGamePiece>> matches) {
        if (!(matches.isEmpty())) {
            System.out.print(str + matches.get(0).get(0).toString() + " ");
            for (List<AbstractGamePiece> list : matches) {
                for (AbstractGamePiece gp : list) {
                    System.out.print("(" + gp.getX() + "," + gp.getY() + ") ");
                }
            }
            System.out.println();
        }
    }
}
