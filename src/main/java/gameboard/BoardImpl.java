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

    private static final int ROW = 1;
    private static final int COL = 0;
    private final int size;
    private final int rows;
    private final int columns;
    private boolean firstTileSelected;
    private Tile[][] tiles;
    private BoardController controller;
    private int[] tile1 = new int[2];
    private int[] tile2 = new int[2];

    public BoardImpl(int boardSize) {
        size = boardSize;
        rows = size;
        columns = size;
        firstTileSelected = false;
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
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print("  " + i + " ");
            System.out.print("| ");
            for (int j = 0; j < columns; j++) {
                System.out.print(tiles[i][j].getPieceType() + " | ");
            }
            System.out.println();
        }
        System.out.print("      ");
        for (int k = 0; k < rows; k++) System.out.print(k + "   ");
        System.out.println();
    }

    @Override
    public void selectTile(int row, int column) {
        if (!firstTileSelected) {
            System.out.println("Tile 1: (" + row + "," + column + ")");
            firstTileSelected = true;
            tile1[ROW] = row;
            tile1[COL] = column;
        } else {
            System.out.println("Tile 2: (" + row + "," + column + ")");
            tile2[ROW] = row;
            tile2[COL] = column;
            compareTiles();
        }
    }

    private void compareTiles() {
        if (!sameTileSelectedTwice()) {
            if (selectedTilesAreAdjacent()) {
                System.out.println("Selected tiles are valid. Attempting swap");
                swap();
            } else {
                System.out.println("Selected tiles are NOT adjacent. Last tile selected now first selected tile");
                tile1[ROW] = tile2[ROW];
                tile1[COL] = tile2[COL];
                tile2[ROW] = -5;
                tile2[COL] = -5;
            }
        } else {
            System.out.println("Same tile selected twice. Resetting.");
            firstTileSelected = false;
            resetBothTiles();
        }
    }

    private boolean sameTileSelectedTwice() {
        return ((tile1[ROW] == tile2[ROW]) && (tile1[COL] == tile2[COL]));
    }

    private boolean selectedTilesAreAdjacent() {
        if (tile1[ROW] == tile2[ROW]) {
            if (tile1[COL] == (tile2[COL] + 1) || tile1[COL] == (tile2[COL] - 1)) {
                return true;
            }
        } else {
            if (tile1[COL] == tile2[COL]) {
                if (tile1[ROW] == (tile2[ROW] + 1) || tile1[ROW] == (tile2[ROW] - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void resetBothTiles() {
        firstTileSelected = false;
        tile1[ROW] = -1;
        tile1[COL] = -1;
        tile2[ROW] = -5;
        tile2[COL] = -5;
    }

    private void swap() {
        System.out.println("Pre: First tile: " + tiles[tile1[ROW]][tile1[COL]].getPieceType() + ", Second tile: " +
                tiles[tile2[ROW]][tile2[COL]].getPieceType());
        if (matchingTypes()) {
            System.out.println("Both tiles contains same game piece type. Abandoning swap");
        } else {
            GamePiece tempPiece = tiles[tile1[ROW]][tile1[COL]].getGamePiece();
            tiles[tile1[ROW]][tile1[COL]].setGamePiece(tiles[tile2[ROW]][tile2[COL]].getGamePiece());
            tiles[tile2[ROW]][tile2[COL]].setGamePiece(tempPiece);
            System.out.println("Post: First tile: " + tiles[tile1[ROW]][tile1[COL]].getPieceType() +
                    ", Second tile: " + tiles[tile2[ROW]][tile2[COL]].getPieceType());
            checkForMatches();
        }
    }

    private boolean matchingTypes() {
        return ((tiles[tile1[ROW]][tile1[COL]].getPieceType().equals(tiles[tile2[ROW]][tile2[COL]].getPieceType())));
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
        System.out.println();
        System.out.println("Columns with consecutive emoticons:");
        for (LinkedList<Tile> list : matchingColumns) {
            for (Tile t : list) {
                System.out.print(t.getPieceType() + "(" + t.getRow() + "," + t.getColumn() + ") ");
            }
            System.out.println();
        }
        printList("rowList", matchingRows);
        printList("colList", matchingColumns);

        /** Remove Duplicates */
        removeDuplicates(matchingRows, matchingColumns);
        printList("rowList without duplicates", matchingRows);
        shiftColumnIconsDown(matchingColumns);
        displayBoard();
    }

    private void removeDuplicates(ArrayList<LinkedList<Tile>> rows, ArrayList<LinkedList<Tile>> columns) {
        for (List<Tile> rowList : rows) {
            columns.forEach(rowList::removeAll);
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
                    tiles[row][col].setGamePiece(new HappyGamePiece("69"));
                } else {
                    tiles[row][col].setGamePiece(tiles[(row - adjustment)][col].getGamePiece());
                }
            }
            row--;
            while (row >= 0) {
                if ((row - adjustment) < 0) {
                    tiles[row][col].setGamePiece(new HappyGamePiece("69"));
                } else {
                    tiles[row][col].setGamePiece(tiles[(row - adjustment)][col].getGamePiece());
                }
                row--;
            }
        }
    }

    private void printList(String title, ArrayList<LinkedList<Tile>> bigList) {
        System.out.println();
        System.out.println(title);
        for (List<Tile> colList : bigList) {
            for (Tile t : colList) {
                System.out.print(t.getPieceType() + "(" + t.getRow() + "," + t.getColumn() + ") ");
            }
            System.out.println();
        }
    }
}