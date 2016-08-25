package model;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This class implements the methods of Board and also has private
 * methods that are called once two valid selections are made.
 *
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class BoardImpl implements Board {

    private static final int R = 0;
    private static final int C = 1;

    private final int rows;
    private final int cols;
    private MatchFinder matchFinder;
    private BoardPopulator populator;
    private Tile[][] tiles;
    private int[] userSelection01 = new int[2];
    private int[] userSelection02 = new int[2];
    private boolean firstSelectionMade;

    public BoardImpl(int r, int c, BoardPopulator bp, MatchFinder mf) {
        rows = r;
        cols = c;
        tiles = new TileImpl[rows][cols];
        matchFinder = mf;
        populator = bp;
        populator.populate(this);
        resetUserSelections();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRows() {
        return rows;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCols() {
        return cols;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tile[][] getTiles() {
        if (tiles == null) {
            throw new NullPointerException();
        } else {
            return tiles;
        }
    }

    /**
     * Private method to reset the user selections
     * This is important as whether or not a selected icon
     * should be compared yet or not is based on this
     */
    private void resetUserSelections() {
        firstSelectionMade = false;
        userSelection01[R] = -1;
        userSelection01[C] = -1;
        userSelection02[R] = -1;
        userSelection02[C] = -1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayBoard() {
        System.out.println();
        for (int row = 0; row < rows; row++) {
            System.out.print("  " + row + " ");
            System.out.print("| ");
            for (int col = 0; col < cols; col++) {
                System.out.print(tiles[row][col].getPieceType() + " | ");
            }
            System.out.println();
        }
        System.out.print("      ");
        for (int value = 0; value < rows; value++) System.out.print(" " + value + "   ");
        System.out.println();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void selectTile(int row, int column) {
        if ((row >= rows || column >= cols) || (row < 0 || column < 0)) {
            System.out.println("Selection out of board range");
        } else if (!(firstSelectionMade)) {
            System.out.println("Selection 1: (" + tiles[row][column].getPieceType() + ")");
            firstSelectionMade = true;
            userSelection01[R] = row;
            userSelection01[C] = column;
        } else {
            System.out.println("Selection 2: (" + tiles[row][column].getPieceType() + ")");
            userSelection02[R] = row;
            userSelection02[C] = column;
            checkValidSelections();
        }
    }

    /**
     * This private method one of the methods called from the SelectTile class
     */
    private void checkValidSelections() {
        if (!sameTileSelectedTwice()) {
            if (selectedTilesAreAdjacent()) {
                compareTileContents();
            } else {
                System.out.println("Selections are NOT adjacent. Last selection is now first selection");
                userSelection01[R] = userSelection02[R];
                userSelection01[C] = userSelection02[C];
                userSelection02[R] = -1;
                userSelection02[C] = -1;
            }
        } else {
            System.out.println("Same selection made twice. Resetting.");
            resetUserSelections();
        }
    }

    /**
     * A private method determines if the two selected tiles are the same or not
     *
     * @return A boolean that determines if the selected tiles were in fact
     * the same or not
     */
    private boolean sameTileSelectedTwice() {
        return ((userSelection01[R] == userSelection02[R]) && (userSelection01[C] == userSelection02[C]));
    }

    private boolean selectedTilesAreAdjacent() {
        if ((userSelection01[R] == userSelection02[R]) &&
                (userSelection01[C] == (userSelection02[C] + 1) || userSelection01[C] == (userSelection02[C] - 1))) {
            return true;
        } else if ((userSelection01[C] == userSelection02[C]) &&
                (userSelection01[R] == (userSelection02[R] + 1) || userSelection01[R] == (userSelection02[R] - 1))) {
            return true;
        }
        return false;
    }

    /**
     * A private method that checks that the two game pieces are not of the same type,
     * and then calls the swap method on the tiles
     */
    private void compareTileContents() {
        if (differentPieceTypes()) {
            System.out.println("Swapping Pieces");
            swapPieces();
            findMatches();
        } else {
            System.out.println("Both selections are the same game piece type. Aborting operation");
        }
        resetUserSelections();
    }

    /**
     * Privete method that determines if the two piece types are different or not.
     *
     * @return A boolean which will state the result
     */
    private boolean differentPieceTypes() {
        return (!(tiles[userSelection01[R]][userSelection01[C]].getPieceType().equals(tiles[userSelection02[R]][userSelection02[C]].getPieceType())));
    }

    /**
     * Private method that simply switches the game pieces of the two icons selected
     */
    private void swapPieces() {
        GamePiece tempPiece = tiles[userSelection01[R]][userSelection01[C]].getGamePiece();
        tiles[userSelection01[R]][userSelection01[C]].setGamePiece(tiles[userSelection02[R]][userSelection02[C]].getGamePiece());
        tiles[userSelection02[R]][userSelection02[C]].setGamePiece(tempPiece);
        displayBoard();
    }

    /**
     * A private method that examines the board and returns any matches.
     * It does this by calling methods within the MatchFinder class
     */
    private void findMatches() {
        ArrayList<LinkedList<Tile>> matchingColumns = matchFinder.findMatchingColumns(this);
        ArrayList<LinkedList<Tile>> matchingRows = matchFinder.findMatchingRows(this);
        if (matchesFound(matchingColumns, matchingRows)) {
            updateBoard(matchingColumns, matchingRows);
        } else {
            System.out.println("No matching Lines. Swapping pieces back to previous position");
            swapPieces();
        }
    }

    /**
     * A private method that indicates if the board has matches or not
     *
     * @param matchingColumns the list of columns that will contain matches if they are present
     * @param matchingRows    the list of rows that will contain matches if they are present
     * @return a boolean indicating if matches are present or not
     */
    private boolean matchesFound(ArrayList<LinkedList<Tile>> matchingColumns, ArrayList<LinkedList<Tile>> matchingRows) {
        return (!(matchingColumns.isEmpty() && matchingRows.isEmpty()));
    }

    /**
     * A private method that rewards the player with a message when a set of matches is made.
     * This will be improved to show an animation, play a jingle, increase the score, and
     * maybe make a tablet vibrate, if it has that functionality
     *
     * @param matchingColumns the list of Tiles that may contain matches
     * @param matchingRows    the list of Tiles that may contain matches
     */
    private void giveReward(ArrayList<LinkedList<Tile>> matchingColumns, ArrayList<LinkedList<Tile>> matchingRows) {
        for (LinkedList<Tile> matchingColumn : matchingColumns) {
            System.out.println(matchingColumn.getFirst().getGamePiece());
        }
        for (LinkedList<Tile> matchingRow : matchingRows) {
            System.out.println(matchingRow.getFirst().getGamePiece());
        }
        printList("Matching columns:", matchingColumns); // to be removed
        printList("Matching rows:", matchingRows); // to be removed
    }

    /**
     * A private method that updates the board once a match has been found. It calls a succession of methods
     * in this class, that remove matches, and then bring above rows down to filly the slots, and introduce
     * newly random-generated pieces
     *
     * @param matchingColumns the list of Tiles that may contain matches
     * @param matchingRows    the list of Tiles that may contain matches
     */
    private void updateBoard(ArrayList<LinkedList<Tile>> matchingColumns, ArrayList<LinkedList<Tile>> matchingRows) {
        do {
            giveReward(matchingColumns, matchingRows);
            removeFromBoard(matchingColumns);
            removeFromBoard(matchingRows);
            shiftIconsDown();
            insertNewIcons();
            displayBoard();
            matchingColumns = matchFinder.findMatchingColumns(this);
            matchingRows = matchFinder.findMatchingRows(this);
        } while (matchesFound(matchingColumns, matchingRows));
    }

    /**
     * A private method to remove matches from that board
     *
     * @param matches a list of matches
     */
    private void removeFromBoard(ArrayList<LinkedList<Tile>> matches) {
        for (List<Tile> rowList : matches) {
            for (Tile t : rowList) {
                int row = t.getRow();
                int col = t.getColumn();
                if (!(tiles[row][col].getPieceType().equals("XX"))) {
                    tiles[row][col].setGamePiece(new NoGamePiece());
                }
            }
        }
    }

    /**
     * A private method that brings game pieces down from above rows to fill
     * any empty spaces on the board
     */
    private void shiftIconsDown() {
        for (int col = 0; col < cols; col++) {
            for (int row = (rows - 1); row >= 0; row--) {
                if (tiles[row][col].getPieceType().equals("XX")) {
                    /* get any pieces higher up the column and, if found, plug hole with it */
                    int tempRow = row;
                    while ((tempRow >= 0) && (tiles[tempRow][col].getPieceType().equals("XX"))) {
                        tempRow--;
                    }
                    if (tempRow >= 0) {
                        GamePiece gp = tiles[tempRow][col].getGamePiece();
                        tiles[row][col].setGamePiece(gp);
                        /* sets previous tile to be empty */
                        tiles[tempRow][col].setGamePiece(new NoGamePiece());
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
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (tiles[row][col].getPieceType().equals("XX")) {
                    GamePiece gp = populator.generateGamePiece();
                    tiles[row][col].setGamePiece(gp);
                }
            }
        }
    }

    /* temporary method for printing output of matching rows and matching columns */
    private void printList(String title, ArrayList<LinkedList<Tile>> matchingLine) {
        if (!(matchingLine.isEmpty())) {
            System.out.print(title + " ");
            for (List<Tile> list : matchingLine) {
                for (Tile t : list) {
                    System.out.print("(" + t.getRow() + "," + t.getColumn() + ") ");
                }
            }
            System.out.println();
        }
    }
}