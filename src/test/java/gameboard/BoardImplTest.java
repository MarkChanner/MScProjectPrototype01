package gameboard;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mark Channer
 */
public class BoardImplTest {

    private Board board;
    private int[] t1;
    private int[] t2;

    @Before
    public void setUp() throws Exception {
        t1 = new int[2];
        t2 = new int[2];
        int size = 7;
        board = new BoardImpl(size);
    }

    @After
    public void tearDown() throws Exception {
        board = null;
        t1 = null;
        t2 = null;
    }

    @Test
    public void testGetRows() throws Exception {
        int output =  board.getRows();
        int expected = 7;
        assertEquals(output, expected);
    }

    @Test
    public void testGetColumns() throws Exception {
        int output = board.getRows();
        int expected = 7;
        assertEquals(output, expected);
    }
}