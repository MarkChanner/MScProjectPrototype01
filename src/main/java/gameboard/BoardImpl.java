package gameboard;

import gamepieces.*;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Mark Channer
 *         The board on which the game will take place
 */
public class BoardImpl implements Board {

    private static final int X = 0;
    private static final int Y = 1;
    private boolean firstSelectionMade;
    private final int rows;
    private final int cols;
    private Tile[][] tiles;
    private BoardController controller;
    private BoardPopulator populator;
    private int[] userSelection01 = new int[2];
    private int[] userSelection02 = new int[2];

    public BoardImpl(int r, int c, BoardController bc, BoardPopulator bp) {
        firstSelectionMade = false;
        rows = r;
        cols = c;
        tiles = new TileImpl[rows][cols];
        controller = bc;
        populator = bp;
        populator.populate(this);
        resetUserSelections();
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getCols() {
        return cols;
    }

    @Override
    public Tile[][] getTiles() {
        return tiles;
    }

    private void resetUserSelections() {
        firstSelectionMade = false;
        userSelection01[X] = -1;
        userSelection01[Y] = -1;
        userSelection02[X] = -1;
        userSelection02[Y] = -1;
    }

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

    @Override
    public void selectTile(int row, int column) {
        if ((row >= rows || column >= cols) || (row < 0 || column < 0)) {
            System.out.println("Selection out of board range");
        } else if (!(firstSelectionMade)) {
            System.out.println("Selection 1: (" + tiles[row][column].getPieceType() + ")");
            firstSelectionMade = true;
            userSelection01[X] = row;
            userSelection01[Y] = column;
        } else {
            System.out.println("Selection 2: (" + tiles[row][column].getPieceType() + ")");
            userSelection02[X] = row;
            userSelection02[Y] = column;
            checkValidSelections();
        }
    }

    private void checkValidSelections() {
        if (!sameTileSelectedTwice()) {
            if (selectedTilesAreAdjacent()) {
                compareTileContents();
            } else {
                System.out.println("Selections are NOT adjacent. Last selection is now first selection");
                userSelection01[X] = userSelection02[X];
                userSelection01[Y] = userSelection02[Y];
                userSelection02[X] = -2;
                userSelection02[Y] = -2;
            }
        } else {
            System.out.println("Same selection made twice. Resetting.");
            resetUserSelections();
        }
    }

    private boolean sameTileSelectedTwice() {
        return ((userSelection01[X] == userSelection02[X]) && (userSelection01[Y] == userSelection02[Y]));
    }

    private boolean selectedTilesAreAdjacent() {
        if ((userSelection01[X] == userSelection02[X]) &&
                (userSelection01[Y] == (userSelection02[Y] + 1) || userSelection01[Y] == (userSelection02[Y] - 1))) {
            return true;
        } else if ((userSelection01[Y] == userSelection02[Y]) &&
                (userSelection01[X] == (userSelection02[X] + 1) || userSelection01[X] == (userSelection02[X] - 1))) {
            return true;
        }
        return false;
    }

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

    private boolean differentPieceTypes() {
        return (!(tiles[userSelection01[X]][userSelection01[Y]].getPieceType().equals(tiles[userSelection02[X]][userSelection02[Y]].getPieceType())));
    }

    private void swapPieces() {
        GamePiece tempPiece = tiles[userSelection01[X]][userSelection01[Y]].getGamePiece();
        tiles[userSelection01[X]][userSelection01[Y]].setGamePiece(tiles[userSelection02[X]][userSelection02[Y]].getGamePiece());
        tiles[userSelection02[X]][userSelection02[Y]].setGamePiece(tempPiece);
        displayBoard();
    }

    private void findMatches() {
        ArrayList<LinkedList<Tile>> matchingColumns = controller.findMatchingColumns(this);
        ArrayList<LinkedList<Tile>> matchingRows = controller.findMatchingRows(this);
        if (matchesFound(matchingColumns, matchingRows)) {
            giveReward(matchingColumns, matchingRows);
            updateBoard(matchingColumns, matchingRows);
        } else {
            System.out.println("No matching Lines. Swapping pieces back to previous position");
            swapPieces();
        }
    }

    private boolean matchesFound(ArrayList<LinkedList<Tile>> matchingColumns, ArrayList<LinkedList<Tile>> matchingRows) {
        return (!(matchingColumns.isEmpty() && matchingRows.isEmpty()));
    }

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

    private void updateBoard(ArrayList<LinkedList<Tile>> matchingColumns, ArrayList<LinkedList<Tile>> matchingRows) {
        do {
            removeFromBoard(matchingColumns);
            removeFromBoard(matchingRows);
            shiftIconsDown();
            insertNewIcons();
            displayBoard();
            matchingColumns = controller.findMatchingColumns(this);
            matchingRows = controller.findMatchingRows(this);
        } while (matchesFound(matchingColumns, matchingRows));
    }

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

    private void shiftIconsDown() {
        for (int col = 0; col < cols; col++) {
            for (int row = (rows - 1); row >= 0; row--) {
                if (tiles[row][col].getPieceType().equals("XX")) {
                    /** get any pieces higher up the column and, if found, plug hole with it */
                    int tempRow = row;
                    while ((tempRow >= 0) && (tiles[tempRow][col].getPieceType().equals("XX"))) {
                        tempRow--;
                    }
                    if (tempRow >= 0) {
                        GamePiece gp = tiles[tempRow][col].getGamePiece();
                        tiles[row][col].setGamePiece(gp);
                        /** sets previous tile to be empty */
                        tiles[tempRow][col].setGamePiece(new NoGamePiece());
                    }
                }
            }
        }
    }

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