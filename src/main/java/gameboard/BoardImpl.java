package gameboard;

import gamepieces.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Mark Channer
 *         The board on which the game will take place
 */
public class BoardImpl implements Board {

    private static final int X = 0;
    private static final int Y = 1;
    private final int size;
    private final int rows;
    private final int columns;
    private boolean firstSelectionMade;
    private Tile[][] tiles;
    private BoardController controller;
    private int[] selection01 = new int[2];
    private int[] selection02 = new int[2];

    public BoardImpl(int boardSize) {
        size = boardSize;
        rows = size;
        columns = size;
        firstSelectionMade = false;
        tiles = new TileImpl[rows][columns];
        controller = new BoardControllerImpl();
    }

    @Override
    public void populateBoard() {
        new BoardPopulator(tiles, rows, columns);
        resetBothTiles();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public Tile[][] getAllTiles() {
        return tiles;
    }

    @Override
    public void displayBoard() {
        for (int i = 0; i < rows; i++) {
            System.out.print("  " + i + " ");
            System.out.print("| ");
            for (int j = 0; j < columns; j++) {
                System.out.print(tiles[i][j].getPieceType() + " | ");
            }
            System.out.println();
        }

        System.out.print("      ");
        for (int l = 0; l < rows; l++) System.out.print(" " + l + "   ");
        System.out.println();
    }

    @Override
    public void selectTile(int row, int column) {
        if (!firstSelectionMade) {
            System.out.println("Tile 1: (" + row + "," + column + ")");
            firstSelectionMade = true;
            selection01[X] = row;
            selection01[Y] = column;
        } else {
            System.out.println("Tile 2: (" + row + "," + column + ")");
            selection02[X] = row;
            selection02[Y] = column;
            compareTiles();
        }
    }

    private void compareTiles() {
        if (!sameTileSelectedTwice()) {
            if (selectedTilesAreAdjacent()) {
                swap();
            } else {
                System.out.println("Selected tiles are NOT adjacent. Last tile selected now first selected tile");
                selection01[X] = selection02[X];
                selection01[Y] = selection02[Y];
                selection02[X] = -5;
                selection02[Y] = -5;
            }
        } else {
            System.out.println("Same tile selected twice. Resetting.");
            firstSelectionMade = false;
            resetBothTiles();
        }
    }

    private boolean sameTileSelectedTwice() {
        return ((selection01[X] == selection02[X]) && (selection01[Y] == selection02[Y]));
    }

    private boolean selectedTilesAreAdjacent() {
        if (selection01[X] == selection02[X]) {
            if (selection01[Y] == (selection02[Y] + 1) || selection01[Y] == (selection02[Y] - 1)) {
                return true;
            }
        } else {
            if (selection01[Y] == selection02[Y]) {
                if (selection01[X] == (selection02[X] + 1) || selection01[X] == (selection02[X] - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void resetBothTiles() {
        firstSelectionMade = false;
        selection01[X] = -1;
        selection01[Y] = -1;
        selection02[X] = -5;
        selection02[Y] = -5;
    }

    private void swap() {
        System.out.println("Pre: First tile: " + tiles[selection01[X]][selection01[Y]].getPieceType()
                + ", Second tile: " + tiles[selection02[X]][selection02[Y]].getPieceType());
        if (matchingTypes()) {
            System.out.println("Both tiles contains same game piece type. Abandoning swap");
        } else {
            GamePiece tempPiece = tiles[selection01[X]][selection01[Y]].getGamePiece();
            tiles[selection01[X]][selection01[Y]].setGamePiece(tiles[selection02[X]][selection02[Y]].getGamePiece());
            tiles[selection02[X]][selection02[Y]].setGamePiece(tempPiece);
            System.out.println("Post: First tile: " + tiles[selection01[X]][selection01[Y]].getPieceType() +
                    ", Second tile: " + tiles[selection02[X]][selection02[Y]].getPieceType());
            checkForMatches();
        }
    }

    private boolean matchingTypes() {
        return ((tiles[selection01[X]][selection01[Y]].getPieceType().equals(tiles[selection02[X]][selection02[Y]].getPieceType())));
    }

    private void checkForMatches() {
        displayBoard();
        ArrayList<LinkedList<Tile>> matchingRows = controller.checkRows(this);
        ArrayList<LinkedList<Tile>> matchingColumns = controller.checkColumns(this);
        System.out.println();

        System.out.println("Rows with consecutive emoticons:");
        for (LinkedList<Tile> list : matchingRows) {
            for (Tile t : list) {
                System.out.print(t.getPieceType() + "(" + t.getRow() + "," + t.getColumn() + ") ");
            }
            System.out.println();
        }
        printList("rowList", matchingRows);

        System.out.println();
        System.out.println("Columns with consecutive emoticons:");
        for (LinkedList<Tile> list : matchingColumns) {
            for (Tile t : list) {
                System.out.print(t.getPieceType() + "(" + t.getRow() + "," + t.getColumn() + ") ");
            }
            System.out.println();
        }
        printList("colList", matchingColumns);

        /** Remove Duplicates */
        removeDuplicates(matchingRows, matchingColumns);
        printList("rowList without duplicates", matchingRows);
        shiftColumnIconsDown(matchingColumns);
        shiftRowIconsDown(matchingRows);

        System.out.println("Board after consecutive icons in row and columns are removed");
        displayBoard();
    }

    private void removeDuplicates(ArrayList<LinkedList<Tile>> rows, ArrayList<LinkedList<Tile>> columns) {
        for (List<Tile> rowList : rows) {
            columns.forEach(rowList::removeAll);
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
                tiles[row][col].setGamePiece(new HappyGamePiece("NP"));
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
                if ((row - adjustment) < 0) {
                    tiles[row][col].setGamePiece(new HappyGamePiece("NP"));
                } else {
                    tiles[row][col].setGamePiece(tiles[(row - adjustment)][col].getGamePiece());
                }
            }
            row--;
            while (row >= 0) {
                if ((row - adjustment) < 0) {
                    tiles[row][col].setGamePiece(new HappyGamePiece("NP"));
                } else {
                    tiles[row][col].setGamePiece(tiles[(row - adjustment)][col].getGamePiece());
                }
                row--;
            }
        }
    }

    private void printList(String title, ArrayList<LinkedList<Tile>> bigList) {
        System.out.println(title);
        for (List<Tile> colList : bigList) {
            for (Tile t : colList) {
                System.out.print(t.getPieceType() + "(" + t.getRow() + "," + t.getColumn() + ") ");
            }
            System.out.println();
        }
    }
}