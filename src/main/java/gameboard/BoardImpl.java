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

    public BoardImpl(int numberOfRows, int numberOfColumns, BoardPopulator boardPopulator) {
        rows = numberOfRows;
        cols = numberOfColumns;
        firstSelectionMade = false;
        tiles = new TileImpl[rows][cols];
        controller = new BoardControllerImpl();
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
            printList("Matching columns:", matchingColumns);
            printList("Matching rows:", matchingRows);
            //removeDuplicates(matchingRows, matchingColumns);
            removeMatches(matchingColumns, matchingRows);
            shiftColumnIconsDown(matchingColumns);
            shiftRowIconsDown(matchingRows);
            displayBoard();
            matchingColumns = controller.checkColumns(this);
            matchingRows = controller.checkRows(this);
        } while (matchesFound(matchingColumns, matchingRows));
    }

    private void giveReward(ArrayList<LinkedList<Tile>> matchingColumns, ArrayList<LinkedList<Tile>> matchingRows) {
        for (int i = 0; i < matchingColumns.size(); i++) {
            System.out.println(matchingColumns.get(i).getFirst().getGamePiece());
        }
        for (int i = 0; i < matchingRows.size(); i++) {
            System.out.println(matchingRows.get(i).getFirst().getGamePiece());
        }
    }

    /*private void removeDuplicates(ArrayList<LinkedList<Tile>> matchingRows, ArrayList<LinkedList<Tile>> matchingColumns) {
        for (List<Tile> rowList : matchingRows) {
            matchingColumns.forEach(rowList::removeAll);
        }
    }*/

    private void removeMatches(ArrayList<LinkedList<Tile>> matchingRows, ArrayList<LinkedList<Tile>> matchingColumns) {
        for (List<Tile> rowList : matchingRows) {
            for (Tile t : rowList) {
                int row = t.getRow();
                int col = t.getColumn();
                if (tiles[row][col] != null) tiles[row][col] = null;
            }
        }

        for (List<Tile> colList : matchingColumns) {
            for (Tile t : colList) {
                int row = t.getRow();
                int col = t.getColumn();
                if (tiles[row][col] != null) tiles[row][col] = null;
            }
        }
    }

    private void shiftColumnIconsDown(ArrayList<LinkedList<Tile>> columns) {
        int adjustment;
        int row = 0;
        int col = 0;
        for (List<Tile> list : columns) {
            adjustment = list.size();
            for (Tile tile : list) {
                row = tile.getRow();
                col = tile.getColumn();
                if ((row - adjustment) >= 0) {
                    GamePiece replacement = tiles[(row - adjustment)][col].getGamePiece();
                    tiles[row][col].setGamePiece(replacement);
                } else {
                    tiles[row][col].setGamePiece(populator.generateGamePiece());
                }
            }
            do {
                if ((row - adjustment) < 0) {
                    tiles[row][col].setGamePiece(populator.generateGamePiece());
                } else {
                    tiles[row][col].setGamePiece(tiles[(row - adjustment)][col].getGamePiece());
                }
                row--;
            } while (row >= 0);
        }
    }

    private void shiftRowIconsDown(ArrayList<LinkedList<Tile>> columns) {
        for (List<Tile> list : columns) {
            for (Tile tile : list) {
                int row = tile.getRow();
                int col = tile.getColumn();
                while (row != 0) {
                    GamePiece replacement = tiles[row - 1][col].getGamePiece();
                    tiles[row][col].setGamePiece(replacement);
                    row--;
                }
                tiles[row][col].setGamePiece(populator.generateGamePiece());
            }
        }
    }

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