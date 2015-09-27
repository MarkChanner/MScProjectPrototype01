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

    private int size = 7;
    private Board board;
    BoardController controller;

    @Before
    public void setUp() throws Exception {
        board = new BoardImpl(size);
        board.populateBoard();
        controller = new BoardControllerImpl();
    }

    @Test
    public void testCheckRows() throws Exception {
        ArrayList<LinkedList<Tile>> matchingRows = controller.checkRows(board);
        LinkedList<Tile> list = matchingRows.get(0);
        assertEquals(5, list.get(0).getRow());
        assertEquals(0, list.get(0).getColumn());
        assertEquals(5, list.get(1).getRow());
        assertEquals(1, list.get(1).getColumn());
        assertEquals(5, list.get(2).getRow());
        assertEquals(2, list.get(2).getColumn());
    }

    @Test
    public void testCheckColumns() throws Exception {
        ArrayList<LinkedList<Tile>> matchingCols = controller.checkRows(board);
        LinkedList<Tile> list = matchingCols.get(0);
        assertEquals(6, list.get(0).getRow());
        assertEquals(1, list.get(0).getColumn());
        assertEquals(5, list.get(1).getRow());
        assertEquals(1, list.get(1).getColumn());
        assertEquals(4, list.get(2).getRow());
        assertEquals(1, list.get(2).getColumn());
        assertEquals(3, list.get(3).getRow());
        assertEquals(1, list.get(3).getColumn());
        assertEquals(2, list.get(4).getRow());
        assertEquals(1, list.get(4).getColumn());

        list = matchingCols.get(1);
        assertEquals(2, list.get(0).getRow());
        assertEquals(6, list.get(0).getColumn());
        assertEquals(1, list.get(1).getRow());
        assertEquals(6, list.get(1).getColumn());
        assertEquals(0, list.get(2).getRow());
        assertEquals(6, list.get(2).getColumn());
    }
}