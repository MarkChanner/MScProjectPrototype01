package model.gameboard;

import controller.GameController;
import model.gamepieces.AbstractGamePiece;
import model.gamepieces.BlankTile;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class GameModelImpl implements GameModel {

    private static final int ROW_START = 0;
    private static final int COLUMN_TOP = 0;

    private GameController controller;
    private GameBoard board;
    private MatchFinder matchHandler;
    private BoardPopulator populator;
    private Selections selections;

    public GameModelImpl(GameController controller, GameBoard board, MatchFinder matchHandler, BoardPopulator populator) {
        this.controller = controller;
        this.board = board;
        this.matchHandler = matchHandler;
        this.populator = populator;
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
            board.swap(selections);
            controller.notify("Selections swapped.");
            controller.displayBoard();
            checkForMatches();
            selections.reset();
        }
    }

    /**
     * A private method that examines the board and returns any matches.
     * It does this by calling methods within the MatchFinder class
     */
    private void checkForMatches() {
        ArrayList<LinkedList<AbstractGamePiece>> matchingX = matchHandler.findVerticalMatches(board);
        ArrayList<LinkedList<AbstractGamePiece>> matchingY = matchHandler.findHorizontalMatches(board);
        if (matchesFound(matchingX, matchingY)) {
            handleMatches(matchingX, matchingY);
        } else {
            controller.notify("No matching Lines. Swapping pieces back to previous position");
            board.swap(selections);
            controller.displayBoard();
        }
    }

    /**
     * This method handles the bulk of the requirements for handling a match on the board. It
     * does this within a loop until the manipulated board no longer contains matches.
     *
     * @param matchingX An ArrayList containing a LinkedList of matching vertical GamePieces
     * @param matchingY An ArrayList containing a LinkedList of matching horizontal GamePieces
     */
    private void handleMatches(ArrayList<LinkedList<AbstractGamePiece>> matchingX, ArrayList<LinkedList<AbstractGamePiece>> matchingY) {
        do {
            giveReward(matchingX, matchingY);
            removeFromBoard(matchingX);
            removeFromBoard(matchingY);
            shiftIconsDown();
            insertNewIcons();
            controller.notify("Board updated.");
            controller.displayBoard();
            matchingX = matchHandler.findVerticalMatches(board);
            matchingY = matchHandler.findHorizontalMatches(board);
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
     * A private method to remove matches from that board
     *
     * @param matches an ArrayList containing a LinkedList of matches
     */
    private void removeFromBoard(ArrayList<LinkedList<AbstractGamePiece>> matches) {
        for (List<AbstractGamePiece> gamePieces : matches) {
            for (AbstractGamePiece gp : gamePieces) {
                int x = gp.getX();
                int y = gp.getY();
                if (!(board.getGamePiece(x, y).showType().equals("EMPTY"))) {
                    board.setGamePiece(x, y, new BlankTile(x, y));
                }
            }
        }
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
    private void shiftIconsDown() {
        int cols = board.getCols();
        int rows = board.getRows();

        for (int x = 0; x < cols; x++) {
            for (int y = (rows - 1); y >= 0; y--) {
                if (board.getGamePiece(x, y).showType().equals("EMPTY")) {
                    /* get any pieces higher up the column and, if found, plug hole with it */
                    int tempRow = y;
                    while ((tempRow >= 0) && (board.getGamePiece(x, tempRow).showType().equals("EMPTY"))) {
                        tempRow--;
                    }
                    if (tempRow >= 0) {
                        AbstractGamePiece gp = board.getGamePiece(x, tempRow);
                        board.setGamePiece(x, y, gp);
                        /* sets previous tile to be empty */
                        board.setGamePiece(x, tempRow, new BlankTile(x, y));
                    }
                }
            }
        }
    }

    /**
     * A private method that generates new game pieces and places them
     * in vacant places on the board
     */
    private void insertNewIcons() {
        int cols = board.getCols();
        int columnBottom = board.getRows() - 1;
        for (int x = ROW_START; x < cols; x++) {
            for (int y = columnBottom; y >= COLUMN_TOP; y--) {
                if (board.getGamePiece(x, y).showType().equals("EMPTY")) {
                    AbstractGamePiece gp = populator.generateGamePiece(x, y);
                    board.setGamePiece(x, y, gp);
                }
            }
        }
    }

    /**
     * temporary method for printing output of matching rows and matching columns
     * @param str message to print
     * @param matches matches to print coordinates of
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
