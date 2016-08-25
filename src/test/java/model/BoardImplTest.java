package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Uses a BoardPopulatorMock01 to populate the board with in a predictable way for testing.
 *
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class BoardImplTest {

    private int rows = 7;
    private int cols = 7;
    private Board board;

    @Before
    public void setUp() throws Exception {
        rows = 7;
        cols = 7;
        board = new BoardImpl(rows, cols, new BoardPopulatorMock01(), new MatchFinderImpl());
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
        assertEquals("00", tiles[0][0].getPieceType());
        assertEquals("01", tiles[0][1].getPieceType());
        assertEquals("02", tiles[0][2].getPieceType());
        assertEquals("03", tiles[0][3].getPieceType());
        assertEquals("04", tiles[0][4].getPieceType());
        assertEquals("05", tiles[0][5].getPieceType());
        assertEquals("06", tiles[0][6].getPieceType());

        assertEquals("HA", tiles[1][0].getPieceType());
        assertEquals("08", tiles[1][1].getPieceType());
        assertEquals("09", tiles[1][2].getPieceType());
        assertEquals("10", tiles[1][3].getPieceType());
        assertEquals("11", tiles[1][4].getPieceType());
        assertEquals("12", tiles[1][5].getPieceType());
        assertEquals("13", tiles[1][6].getPieceType());

        assertEquals("HA", tiles[2][0].getPieceType());
        assertEquals("15", tiles[2][1].getPieceType());
        assertEquals("16", tiles[2][2].getPieceType());
        assertEquals("17", tiles[2][3].getPieceType());
        assertEquals("18", tiles[2][4].getPieceType());
        assertEquals("19", tiles[2][5].getPieceType());
        assertEquals("20", tiles[2][6].getPieceType());

        assertEquals("EX", tiles[3][0].getPieceType());
        assertEquals("22", tiles[3][1].getPieceType());
        assertEquals("23", tiles[3][2].getPieceType());
        assertEquals("SA", tiles[3][3].getPieceType());
        assertEquals("AN", tiles[3][4].getPieceType());
        assertEquals("SA", tiles[3][5].getPieceType());
        assertEquals("SA", tiles[3][6].getPieceType());

        assertEquals("HA", tiles[4][0].getPieceType());
        assertEquals("EX", tiles[4][1].getPieceType());
        assertEquals("EX", tiles[4][2].getPieceType());
        assertEquals("31", tiles[4][3].getPieceType());
        assertEquals("SA", tiles[4][4].getPieceType());
        assertEquals("33", tiles[4][5].getPieceType());
        assertEquals("34", tiles[4][6].getPieceType());

        assertEquals("35", tiles[5][0].getPieceType());
        assertEquals("36", tiles[5][1].getPieceType());
        assertEquals("37", tiles[5][2].getPieceType());
        assertEquals("38", tiles[5][3].getPieceType());
        assertEquals("SA", tiles[5][4].getPieceType());
        assertEquals("40", tiles[5][5].getPieceType());
        assertEquals("41", tiles[5][6].getPieceType());

        assertEquals("42", tiles[6][0].getPieceType());
        assertEquals("43", tiles[6][1].getPieceType());
        assertEquals("44", tiles[6][2].getPieceType());
        assertEquals("45", tiles[6][3].getPieceType());
        assertEquals("46", tiles[6][4].getPieceType());
        assertEquals("47", tiles[6][5].getPieceType());
        assertEquals("48", tiles[6][6].getPieceType());

        // selects tiles that are know to lead to 2 matches
        board.selectTile(3, 0);
        board.selectTile(4, 0);

        // Checks 00, 22 and 23 have dropped down a row
        // and are now on the same row
        assertEquals("00", tiles[4][0].getPieceType());
        assertEquals("22", tiles[4][1].getPieceType());
        assertEquals("23", tiles[4][2].getPieceType());
        assertEquals("31", tiles[4][3].getPieceType());


        // Checks 15 and 16 have dropped down a row like
        // 22 and 23 did
        assertEquals("15", tiles[3][1].getPieceType());
        assertEquals("16", tiles[3][2].getPieceType());
        assertEquals("SA", tiles[3][3].getPieceType());
        assertEquals("AN", tiles[3][4].getPieceType());
        assertEquals("SA", tiles[3][5].getPieceType());
        assertEquals("SA", tiles[3][6].getPieceType());

        // Checks 08 and 09 have dropped down a row like
        // 15 and 16 did
        assertEquals("08", tiles[2][1].getPieceType());
        assertEquals("09", tiles[2][2].getPieceType());

        // selects 2 more tiles that will lead to 2 matches
        board.selectTile(3, 3);
        board.selectTile(3, 4);

        // checks bottom values haven't changed
        assertEquals("46", tiles[6][4].getPieceType());
        assertEquals("47", tiles[6][5].getPieceType());
        assertEquals("48", tiles[6][6].getPieceType());

        // checks column 4 dropped down values by 3 rows
        assertEquals("18", tiles[5][4].getPieceType());
        assertEquals("11", tiles[4][4].getPieceType());
        assertEquals("04", tiles[3][4].getPieceType());

        // check column 5 dropped down values by 1 row
        // from row
        assertEquals("40", tiles[5][5].getPieceType());
        assertEquals("33", tiles[4][5].getPieceType());
        assertEquals("19", tiles[3][5].getPieceType());
        assertEquals("12", tiles[2][5].getPieceType());
        assertEquals("05", tiles[1][5].getPieceType());

        // checks column 6 dropped down values by 1 row
        assertEquals("41", tiles[5][6].getPieceType());
        assertEquals("34", tiles[4][6].getPieceType());
        assertEquals("20", tiles[3][6].getPieceType());
        assertEquals("13", tiles[2][6].getPieceType());
        assertEquals("06", tiles[1][6].getPieceType());
    }
}