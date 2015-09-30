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
        board = new BoardImpl(rows, cols, new BoardControllerImpl(), new BoardPopulatorMock01());
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
        // Checks starting layout correct
        assertEquals("30", tiles[6][0].getPieceType());
        assertEquals("31", tiles[6][1].getPieceType());
        assertEquals("32", tiles[6][2].getPieceType());
        assertEquals("33", tiles[6][3].getPieceType());
        assertEquals("34", tiles[6][4].getPieceType());
        assertEquals("35", tiles[6][5].getPieceType());
        assertEquals("36", tiles[6][6].getPieceType());

        assertEquals("24", tiles[5][0].getPieceType());
        assertEquals("25", tiles[5][1].getPieceType());
        assertEquals("26", tiles[5][2].getPieceType());
        assertEquals("27", tiles[5][3].getPieceType());
        assertEquals("SA", tiles[5][4].getPieceType());
        assertEquals("28", tiles[5][5].getPieceType());
        assertEquals("29", tiles[5][6].getPieceType());

        assertEquals("HA", tiles[4][0].getPieceType());
        assertEquals("EX", tiles[4][1].getPieceType());
        assertEquals("EX", tiles[4][2].getPieceType());
        assertEquals("21", tiles[4][3].getPieceType());
        assertEquals("SA", tiles[4][4].getPieceType());
        assertEquals("22", tiles[4][5].getPieceType());
        assertEquals("23", tiles[4][6].getPieceType());

        assertEquals("EX", tiles[3][0].getPieceType());
        assertEquals("19", tiles[3][1].getPieceType());
        assertEquals("20", tiles[3][2].getPieceType());
        assertEquals("SA", tiles[3][3].getPieceType());
        assertEquals("AN", tiles[3][4].getPieceType());
        assertEquals("SA", tiles[3][5].getPieceType());
        assertEquals("SA", tiles[3][6].getPieceType());

        assertEquals("HA", tiles[2][0].getPieceType());
        assertEquals("13", tiles[2][1].getPieceType());
        assertEquals("14", tiles[2][2].getPieceType());
        assertEquals("15", tiles[2][3].getPieceType());
        assertEquals("16", tiles[2][4].getPieceType());
        assertEquals("17", tiles[2][5].getPieceType());
        assertEquals("18", tiles[2][6].getPieceType());

        assertEquals("HA", tiles[1][0].getPieceType());
        assertEquals("07", tiles[1][1].getPieceType());
        assertEquals("08", tiles[1][2].getPieceType());
        assertEquals("09", tiles[1][3].getPieceType());
        assertEquals("10", tiles[1][4].getPieceType());
        assertEquals("11", tiles[1][5].getPieceType());
        assertEquals("12", tiles[1][6].getPieceType());

        assertEquals("00", tiles[0][0].getPieceType());
        assertEquals("01", tiles[0][1].getPieceType());
        assertEquals("02", tiles[0][2].getPieceType());
        assertEquals("03", tiles[0][3].getPieceType());
        assertEquals("04", tiles[0][4].getPieceType());
        assertEquals("05", tiles[0][5].getPieceType());
        assertEquals("06", tiles[0][6].getPieceType());

        board.selectTile(3, 0);
        board.selectTile(4, 0);

        // Checks 13 and 14 have dropped down a row and
        // that SA, AN, SA, and SA have not been altered
        assertEquals("13", tiles[3][1].getPieceType());
        assertEquals("14", tiles[3][2].getPieceType());
        assertEquals("SA", tiles[3][3].getPieceType());
        assertEquals("AN", tiles[3][4].getPieceType());
        assertEquals("SA", tiles[3][5].getPieceType());
        assertEquals("SA", tiles[3][6].getPieceType());

        // Checks 01 and 02 have dropped down a row like
        // 13 and 14 did
        assertEquals("01", tiles[1][1].getPieceType());
        assertEquals("02", tiles[1][2].getPieceType());

        // Checks 15 - 18 have not moved position
        assertEquals("15", tiles[2][3].getPieceType());
        assertEquals("16", tiles[2][4].getPieceType());
        assertEquals("17", tiles[2][5].getPieceType());
        assertEquals("18", tiles[2][6].getPieceType());

        board.selectTile(3, 3);
        board.selectTile(3, 4);

        // checks bottom values haven't changed
        assertEquals("34", tiles[6][4].getPieceType());
        assertEquals("35", tiles[6][5].getPieceType());
        assertEquals("36", tiles[6][6].getPieceType());

        // checks column 4 dropped down values by 1 row
        assertEquals("16", tiles[5][4].getPieceType());
        assertEquals("10", tiles[4][4].getPieceType());
        assertEquals("04", tiles[3][4].getPieceType());

        // check column5 dropped down values by 1 row
        assertEquals("28", tiles[5][5].getPieceType());
        assertEquals("22", tiles[4][5].getPieceType());
        assertEquals("17", tiles[3][5].getPieceType());
        assertEquals("11", tiles[2][5].getPieceType());
        assertEquals("05", tiles[1][5].getPieceType());

        // checks column 6 dropped down values by 1 row
        assertEquals("29", tiles[5][6].getPieceType());
        assertEquals("23", tiles[4][6].getPieceType());
        assertEquals("18", tiles[3][6].getPieceType());
        assertEquals("12", tiles[2][6].getPieceType());
        assertEquals("06", tiles[1][6].getPieceType());
    }

    @Test
    public void testShiftColumnIconsDown() throws Exception {
        //Tile[][] tiles = board.getTiles();
        // board.selectTile(6, 5);
        // board.selectTile(6, 6);

        // assertEquals("18", tiles[6][1].getPieceType());


    }

    @Test
    public void testShiftRowIconsDown() throws Exception {

    }
}