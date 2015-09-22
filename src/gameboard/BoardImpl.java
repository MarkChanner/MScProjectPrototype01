package gameboard;

import gamepieces.GamePiece;

import java.util.List;

/**
 * @author Mark Channer
 *         The board on which the game will take place
 */
public class BoardImpl implements Board {

    private static final int ROW = 1;
    private static final int COL = 0;
    private Tile[][] tiles;
    private LogicChecker checker;
    private final int columns;
    private final int rows;
    private boolean firstTileSelected;
    private int[] t1 = new int[2];
    private int[] t2 = new int[2];

    public BoardImpl(int size) {
        rows = size;
        columns = size;
        tiles = new TileImpl[rows][columns];
        checker = new LogicCheckerImpl();
        firstTileSelected = false;
    }

    public void populateBoard() {
        new BoardPopulator(tiles, rows, columns);
        resetBothTiles();
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Tile[][] getAllTiles() {
        return tiles;
    }

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

    public void selectTile(int row, int column) {
        if (!firstTileSelected) {
            System.out.println("Tile 1: (" + row + "," + column + ")");
            firstTileSelected = true;
            t1[ROW] = row;
            t1[COL] = column;
        } else {
            System.out.println("Tile 2: (" + row + "," + column + ")");
            t2[ROW] = row;
            t2[COL] = column;
            compareTiles();
        }
    }

    public void compareTiles() {
        if (!sameTileSelectedTwice()) {
            if (selectedTilesAreAdjacent()) {
                System.out.println("Selected tiles are valid. Attempting swap");
                swap();
            } else {
                System.out.println("Selected tiles are NOT adjacent. Last tile selected now first selected tile");
                t1[ROW] = t2[ROW];
                t1[COL] = t2[COL];
                t2[ROW] = -5;
                t2[COL] = -5;
            }
        } else {
            System.out.println("Same tile selected twice. Resetting.");
            firstTileSelected = false;
            resetBothTiles();
        }
    }

    public boolean sameTileSelectedTwice() {
        return ((t1[ROW] == t2[ROW]) && (t1[COL] == t2[COL]));
    }

    public boolean selectedTilesAreAdjacent() {
        if (t1[ROW] == t2[ROW]) {
            if (t1[COL] == (t2[COL] + 1) || t1[COL] == (t2[COL] - 1)) {
                return true;
            }
        } else {
            if (t1[COL] == t2[COL]) {
                if (t1[ROW] == (t2[ROW] + 1) || t1[ROW] == (t2[ROW] - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void resetBothTiles() {
        firstTileSelected = false;
        t1[ROW] = -1;
        t1[COL] = -1;
        t2[ROW] = -5;
        t2[COL] = -5;
    }

    public void swap() {
        System.out.println("Pre: First tile: " + tiles[t1[ROW]][t1[COL]].getPieceType() + ", Second tile: " + tiles[t2[ROW]][t2[COL]].getPieceType());
        if (matchingTypes()) {
            System.out.println("Both tiles contains same game piece type. Abandoning swap");
        } else {
            GamePiece tempPiece = tiles[t1[ROW]][t1[COL]].getGamePiece();
            tiles[t1[ROW]][t1[COL]].setGamePiece(tiles[t2[ROW]][t2[COL]].getGamePiece());
            tiles[t2[ROW]][t2[COL]].setGamePiece(tempPiece);
            System.out.println("Post: First tile: " + tiles[t1[ROW]][t1[COL]].getPieceType() + ", Second tile: " + tiles[t2[ROW]][t2[COL]].getPieceType());
            //calculateConsecutiveEmotions();
            List<Tile> matchingTiles = checker.check(this);
            System.out.println("Received List<Tile> back");
            for (Tile t : matchingTiles) {
                System.out.print("Piece type: " + t.getPieceType() + " ");
                //int[] c = t.getCoordinates();
                System.out.println("Tile Coordinates " + t.getCoordinates()[0] + "," + t.getCoordinates()[1]);
            }
        }
        displayBoard();
    }

    public boolean matchingTypes() {
        return ((tiles[t1[ROW]][t1[COL]].getGamePiece().equals(tiles[t2[ROW]][t2[COL]].getGamePiece())));
    }
}
