package gameboard;

import gamepieces.GamePiece;

import java.util.List;

/**
 * @author Mark Channer
 *         The board on which the game will take place
 */
public class Board {

    private static final int COL = 0;
    private static final int ROW = 1;
    private Tile[][] tiles;
    private LogicChecker checker;
    private final int cols;
    private final int rows;
    private boolean firstEmoticonSelected;
    private int[] e1 = new int[2];
    private int[] e2 = new int[2];

    public Board(int size) {
        this.cols = size;
        this.rows = size;
        this.tiles = new TileImpl[cols][rows];
        this.checker = new LogicCheckerImpl();
        this.firstEmoticonSelected = false;
    }

    public void populateBoard() {
        new BoardPopulator(tiles, cols, rows);
        resetBothButtons();
    }

    public int getCols() {
        return cols;
    }

    public Tile[][] getAllTiles() {
        return tiles;
    }

    public int getRows() {
        return rows;
    }

    public void displayBoard() {
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print("  " + i + " ");
            System.out.print("| ");
            for (int j = 0; j < cols; j++) {
                System.out.print(tiles[i][j].getPieceType() + " | ");
            }
            System.out.println();
        }
        System.out.print("      ");
        for (int k = 0; k < rows; k++) System.out.print(k + "   ");
        System.out.println();
    }

    public void selectEmoticon(int newCol, int newRow) {
        if (!firstEmoticonSelected) {
            System.out.println("Button1: (" + newCol + "," + newRow + ")");
            firstEmoticonSelected = true;
            e1[COL] = newCol;
            e1[ROW] = newRow;
        } else {
            System.out.println("Button2: (" + newCol + "," + newRow + ")");
            e2[COL] = newCol;
            e2[ROW] = newRow;
            compareFirstEmoticonWithSecond();
        }
    }

    private void compareFirstEmoticonWithSecond() {
        if (!sameButtonPressedTwice()) {
            if (selectedEmoticonsAreAdjacent()) {
                System.out.println("Selected buttons are valid to attempt swap");
                attemptToSwap();
            } else {
                System.out.println("Selected buttons are NOT adjacent. Last button pressed now first button pressed");
                e1[COL] = e2[COL];
                e1[ROW] = e2[ROW];
                e2[COL] = -5;
                e2[ROW] = -5;
            }
        } else {
            System.out.println("Same button pushed twice. Resetting.");
            firstEmoticonSelected = false;
            resetBothButtons();
        }
    }

    private boolean sameButtonPressedTwice() {
        return ((e1[COL] == e2[COL]) && (e1[ROW] == e2[ROW]));
    }

    private boolean selectedEmoticonsAreAdjacent() {
        if (e1[COL] == e2[COL]) {
            if (e1[ROW] == (e2[ROW] + 1) || e1[ROW] == (e2[ROW] - 1)) {
                return true;
            }
        } else {
            if (e1[ROW] == e2[ROW]) {
                if (e1[COL] == (e2[COL] + 1) || e1[COL] == (e2[COL] - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void resetBothButtons() {
        firstEmoticonSelected = false;
        e1[COL] = -1;
        e1[ROW] = -1;
        e2[COL] = -5;
        e2[ROW] = -5;
    }

    private void attemptToSwap() {
        System.out.println("Pre: First button: " + tiles[e1[COL]][e1[ROW]].getPieceType() + ", Second button: " + tiles[e2[COL]][e2[ROW]].getPieceType());
        if (bothDisplaySameEmotion()) {
            System.out.println("Both icons same emotion. No point in swapping");
        } else {
            GamePiece temp = tiles[e1[COL]][e1[ROW]].getGamePiece();
            tiles[e1[COL]][e1[ROW]].setGamePiece(tiles[e2[COL]][e2[ROW]].getGamePiece());
            tiles[e2[COL]][e2[ROW]].setGamePiece(temp);
            System.out.println("Post: First button: " + tiles[e1[COL]][e1[ROW]].getPieceType() + ", Second button: " + tiles[e2[COL]][e2[ROW]].getPieceType());
            //calculateConsecutiveEmotions();
            List<Tile> matchingTiles = checker.check(this);
            System.out.println("Received List<Tile> back");
            for (Tile t : matchingTiles) {
                System.out.print("Emotion: " + t.getPieceType() + " ");
                //int[] c = t.getCoordinates();
                System.out.println("Coordinates " + t.getCoordinates()[0] + "," + t.getCoordinates()[1]);
            }

        }
        displayBoard();
    }

    private boolean bothDisplaySameEmotion() {
        return ((tiles[e1[COL]][e1[ROW]].getGamePiece().equals(tiles[e2[COL]][e2[ROW]].getGamePiece())));
    }
}
