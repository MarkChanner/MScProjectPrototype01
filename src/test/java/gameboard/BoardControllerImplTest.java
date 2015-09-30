package gameboard;

import java.util.LinkedList;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mark Channer
 */
public class BoardControllerImplTest {

    private Board board;
    private BoardController controller;

    @Before
    public void setUp() throws Exception {
        final int rows = 7;
        final int cols = 7;
        board = new BoardImpl(rows, cols, new BoardControllerImpl(), new BoardPopulatorMock01());
    }

    @Test
    public void testCheckColumns() throws Exception {
        board.selectTile(3, 0);
        board.selectTile(4, 0);
        ArrayList<LinkedList<Tile>> matchingCols = controller.findMatchingColumns(board);
        LinkedList<Tile> list = matchingCols.get(0);

        /** Needs sorting out */
        //assertEquals("SA", list.get(0).getRow());
        assertEquals(1, list.get(0).getColumn());
        assertEquals(5, list.get(1).getRow());
        assertEquals(1, list.get(1).getColumn());
        assertEquals(4, list.get(2).getRow());
        assertEquals(1, list.get(2).getColumn());
        assertEquals(3, list.get(3).getRow());
        assertEquals(1, list.get(3).getColumn());

        list = matchingCols.get(1);
        assertEquals(2, list.get(0).getRow());
        assertEquals(6, list.get(0).getColumn());
        assertEquals(1, list.get(1).getRow());
        assertEquals(6, list.get(1).getColumn());
        assertEquals(0, list.get(2).getRow());
        assertEquals(6, list.get(2).getColumn());
    }

    @Test
    public void testCheckRows() throws Exception {
        ArrayList<LinkedList<Tile>> matchingRows = controller.findMatchingRows(board);
        LinkedList<Tile> list = matchingRows.get(0);
        assertEquals(5, list.get(0).getRow());
        assertEquals(0, list.get(0).getColumn());
        assertEquals(5, list.get(1).getRow());
        assertEquals(1, list.get(1).getColumn());
        assertEquals(5, list.get(2).getRow());
        assertEquals(2, list.get(2).getColumn());
    }
}