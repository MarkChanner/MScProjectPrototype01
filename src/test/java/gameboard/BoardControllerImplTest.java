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
        assertEquals(list.get(0).getRow(), 5);
        assertEquals(list.get(0).getColumn(), 0);
        assertEquals(list.get(1).getRow(), 5);
        assertEquals(list.get(1).getColumn(), 1);
        assertEquals(list.get(2).getRow(), 5);
        assertEquals(list.get(2).getColumn(), 2);
    }

    @Test
    public void testCheckColumns() throws Exception {
        ArrayList<LinkedList<Tile>> matchingCols = controller.checkRows(board);
        LinkedList<Tile> list = matchingCols.get(0);
        assertEquals(list.get(0).getRow(), 6);
        assertEquals(list.get(0).getColumn(), 1);
        assertEquals(list.get(1).getRow(), 5);
        assertEquals(list.get(1).getColumn(), 1);
        assertEquals(list.get(2).getRow(), 4);
        assertEquals(list.get(2).getColumn(), 1);
        assertEquals(list.get(3).getRow(), 3);
        assertEquals(list.get(3).getColumn(), 1);
        assertEquals(list.get(4).getRow(), 2);
        assertEquals(list.get(4).getColumn(), 1);

        list = matchingCols.get(1);
        assertEquals(list.get(0).getRow(), 2);
        assertEquals(list.get(0).getColumn(), 6);
        assertEquals(list.get(1).getRow(), 1);
        assertEquals(list.get(1).getColumn(), 6);
        assertEquals(list.get(2).getRow(), 0);
        assertEquals(list.get(2).getColumn(), 6);
    }
}