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
    private final int rows;
    private final int cols;
    private boolean firstSelectionMade;
    private Tile[][] tiles;
    private BoardController controller;
    private BoardPopulator populator;
    private int[] selection01 = new int[2];
    private int[] selection02 = new int[2];

    public BoardImpl(int numberOfRows, int numberOfColumns, BoardController boardController, BoardPopulator boardPopulator) {
        rows = numberOfRows;
        cols = numberOfColumns;
        firstSelectionMade = false;
        tiles = new TileImpl[rows][cols];
        controller = boardController;
        populator = boardPopulator;
        populator.populate(this);
        resetSelections();
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
    public Tile[][] getAllTiles() {
        return tiles;
    }

    private void resetSelections() {
        firstSelectionMade = false;
        selection01[X] = -1;
        selection01[Y] = -1;
        selection02[X] = -5;
        selection02[Y] = -5;
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
        } else if (!firstSelectionMade) {
            System.out.println("Selection 1: (" + tiles[row][column].getPieceType() + ")");
            firstSelectionMade = true;
            selection01[X] = row;
            selection01[Y] = column;
        } else {
            System.out.println("Selection 2: (" + tiles[row][column].getPieceType() + ")");
            selection02[X] = row;
            selection02[Y] = column;
            compareTiles();
        }
    }

    private void compareTiles() {
        if (!sameTileSelectedTwice()) {
            if (selectedTilesAreAdjacent()) {
                attemptSwap();
            } else {
                System.out.println("Selections are NOT adjacent. Last selection is now first selection");
                selection01[X] = selection02[X];
                selection01[Y] = selection02[Y];
                selection02[X] = -5;
                selection02[Y] = -5;
            }
        } else {
            System.out.println("Same selection made twice. Resetting.");
            resetSelections();
        }
    }

    private boolean sameTileSelectedTwice() {
        return ((selection01[X] == selection02[X]) && (selection01[Y] == selection02[Y]));
    }

    private boolean selectedTilesAreAdjacent() {
        if ((selection01[X] == selection02[X]) &&
                (selection01[Y] == (selection02[Y] + 1) || selection01[Y] == (selection02[Y] - 1))) {
            return true;
        } else if ((selection01[Y] == selection02[Y]) &&
                (selection01[X] == (selection02[X] + 1) || selection01[X] == (selection02[X] - 1))) {
            return true;
        }
        return false;
    }

    private void attemptSwap() {
        if (differentPieceTypes()) {
            System.out.println("Swapping Pieces");
            swapGamePieces();
            ArrayList<LinkedList<Tile>> matchingColumns = controller.checkColumns(this);
            ArrayList<LinkedList<Tile>> matchingRows = controller.checkRows(this);

            if (matchesFound(matchingColumns, matchingRows)) {
                manipulateBoard(matchingColumns, matchingRows);
            } else {
                System.out.println("No matching Lines. Swapping pieces back to previous position");
                swapGamePieces();
            }

        } else {
            System.out.println("Both selections are the same game piece type. Aborting operation");
        }
        resetSelections();
    }

    private boolean differentPieceTypes() {
        return (!(tiles[selection01[X]][selection01[Y]].getPieceType().equals(tiles[selection02[X]][selection02[Y]].getPieceType())));
    }

    private void swapGamePieces() {
        GamePiece tempPiece = tiles[selection01[X]][selection01[Y]].getGamePiece();
        tiles[selection01[X]][selection01[Y]].setGamePiece(tiles[selection02[X]][selection02[Y]].getGamePiece());
        tiles[selection02[X]][selection02[Y]].setGamePiece(tempPiece);
        displayBoard();
    }

    private boolean matchesFound(ArrayList<LinkedList<Tile>> matchingColumns, ArrayList<LinkedList<Tile>> matchingRows) {
        return (!(matchingColumns.isEmpty() && matchingRows.isEmpty()));
    }

    private void manipulateBoard(ArrayList<LinkedList<Tile>> matchingColumns, ArrayList<LinkedList<Tile>> matchingRows) {
        do {
            giveReward(matchingColumns, matchingRows);

            printList("Matching columns:", matchingColumns); // to be removed
            printList("Matching rows:", matchingRows); // to be removed
            removeMatches(matchingColumns, matchingRows);
            shiftIconsDown();
            insertNewIcons();
            displayBoard();
            matchingColumns = controller.checkColumns(this);
            matchingRows = controller.checkRows(this);
        } while (matchesFound(matchingColumns, matchingRows));
    }

    private void giveReward(ArrayList<LinkedList<Tile>> matchingColumns, ArrayList<LinkedList<Tile>> matchingRows) {
        for (LinkedList<Tile> matchingColumn : matchingColumns) {
            System.out.println(matchingColumn.getFirst().getGamePiece());
        }
        for (LinkedList<Tile> matchingRow : matchingRows) {
            System.out.println(matchingRow.getFirst().getGamePiece());
        }
    }

    /* !!! Extract the duplicate code into a separate method !!! */
    private void removeMatches(ArrayList<LinkedList<Tile>> matchingRows, ArrayList<LinkedList<Tile>> matchingColumns) {
        for (List<Tile> rowList : matchingRows) {
            for (Tile t : rowList) {
                int row = t.getRow();
                int col = t.getColumn();
                if (!(tiles[row][col].getPieceType().equals("XX"))) {
                    tiles[row][col].setGamePiece(new NoGamePiece());
                }
            }
        }
        for (List<Tile> colList : matchingColumns) {
            for (Tile t : colList) {
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