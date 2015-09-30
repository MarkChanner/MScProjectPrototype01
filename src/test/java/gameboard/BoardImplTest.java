package gameboard;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mark Channer
 */
public class BoardImplTest {

    private int rows = 7;
    private int cols = 7;
    private Board board;

    @Before
    public void setUp() throws Exception {
        rows = 7;
        cols = 7;
        board = new BoardImpl(rows, cols, new BoardControllerImpl(), new BoardPopulatorCrossMatch());
    }

    @After
    public void tearDown() throws Exception {
        board = null;
    }

    @Test
    public void testGetRows() throws Exception {
        assertEquals(7, board.getRows());
    }

    @Test
    public void testGetColumns() throws Exception {
        assertEquals(7, board.getCols());
    }

    @Test
    public void testGetAllTiles() throws Exception {
        Tile[][] tiles = board.getTiles();
        assertEquals(7, tiles.length);
        assertEquals(7, tiles[0].length);
    }

    @Test
    public void testSwap() throws Exception {
        Tile[][] tiles = board.getTiles();
        assertEquals("35", tiles[3][4].getPieceType());
        assertEquals("36", tiles[3][5].getPieceType());
        board.selectTile(3, 4);
        board.selectTile(3, 5);
        assertEquals("36", tiles[3][4].getPieceType());
        assertEquals("35", tiles[3][5].getPieceType());
    }

    @Test
    public void testShiftColumnIconsDown() throws Exception {
        Tile[][] tiles = board.getTiles();
        assertEquals("--", tiles[6][1].getPieceType());
        assertEquals("--", tiles[5][1].getPieceType());
        assertEquals("--", tiles[4][1].getPieceType());
        assertEquals("--", tiles[3][1].getPieceType());
        assertEquals("--", tiles[2][1].getPieceType());
        assertEquals("18", tiles[1][1].getPieceType());
        assertEquals("11", tiles[0][1].getPieceType());

        assertEquals("--", tiles[0][6].getPieceType());
        assertEquals("--", tiles[1][6].getPieceType());
        assertEquals("--", tiles[2][6].getPieceType());
        assertEquals("37", tiles[3][6].getPieceType());

        assertEquals("57", tiles[6][5].getPieceType());
        assertEquals("58", tiles[6][6].getPieceType());

        board.selectTile(6, 5);
        board.selectTile(6, 6);

        assertEquals("18", tiles[6][1].getPieceType());
        assertEquals("11", tiles[5][1].getPieceType());
        assertEquals("NP", tiles[4][1].getPieceType());
        assertEquals("NP", tiles[3][1].getPieceType());
        assertEquals("NP", tiles[2][1].getPieceType());
        assertEquals("NP", tiles[1][1].getPieceType());
        assertEquals("NP", tiles[0][1].getPieceType());

        assertEquals("NP", tiles[0][6].getPieceType());
        assertEquals("NP", tiles[1][6].getPieceType());
        assertEquals("NP", tiles[2][6].getPieceType());
        assertEquals("37", tiles[3][6].getPieceType());

        assertEquals("58", tiles[6][5].getPieceType());
        assertEquals("57", tiles[6][6].getPieceType());

    }

    @Test
    public void testShiftRowIconsDown() throws Exception {
        Tile[][] tiles = board.getTiles();
        assertEquals("--", tiles[5][0].getPieceType());
        assertEquals("--", tiles[5][1].getPieceType());
        assertEquals("--", tiles[5][2].getPieceType());

        board.selectTile(6, 5);
        board.selectTile(6, 6);

        assertEquals("38", tiles[5][0].getPieceType());
        assertEquals("11", tiles[5][1].getPieceType());
        assertEquals("40", tiles[5][2].getPieceType());
    }
}