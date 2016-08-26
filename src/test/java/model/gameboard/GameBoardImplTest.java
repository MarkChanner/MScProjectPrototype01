package model.gameboard;

import model.gamepieces.HappyEmoticon;
import model.gamepieces.SadEmoticon;
import model.mock_objects.BoardPopulatorMock01;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class GameBoardImplTest {

    private GameBoard defaultSizedBoard;
    private GameBoard setSizedBoard;

    @Before
    public void setUp() throws Exception {
        defaultSizedBoard = new GameBoardImpl();
        setSizedBoard = new GameBoardImpl(10, 8);
    }

    @After
    public void tearDown() throws Exception {
        defaultSizedBoard = null;
        setSizedBoard = null;
    }

    @Test
    public void testGetCols() throws Exception {
        assertEquals(8, defaultSizedBoard.getCols());
        assertEquals(10, setSizedBoard.getCols());
    }

    @Test
    public void testGetRows() throws Exception {
        assertEquals(7, defaultSizedBoard.getRows());
        assertEquals(8, setSizedBoard.getRows());
    }

    @Test
    public void testSetAndGetGamePiece() throws Exception {
        BoardPopulator populator = new BoardPopulatorMock01();
        populator.populate(defaultSizedBoard);
        populator.populate(setSizedBoard);

        // Tests corner cases of default size GameBoard
        assertEquals("00", defaultSizedBoard.getGamePiece(0, 0).showType());
        assertEquals("06", defaultSizedBoard.getGamePiece(0, 6).showType());
        assertEquals("49", defaultSizedBoard.getGamePiece(7, 0).showType());
        assertEquals("55", defaultSizedBoard.getGamePiece(7, 6).showType());

        // Tests HappyEmoticon is set at (0,1) on the default sized GameBoard
        defaultSizedBoard.setGamePiece(0, 1, new HappyEmoticon(0, 1));
        assertEquals("HA", defaultSizedBoard.getGamePiece(0, 1).showType());

        // Tests corner cases of specified size GameBoard
        assertEquals("00", setSizedBoard.getGamePiece(0, 0).showType());
        assertEquals("07", setSizedBoard.getGamePiece(0, 7).showType());
        assertEquals("72", setSizedBoard.getGamePiece(9, 0).showType());
        assertEquals("79", setSizedBoard.getGamePiece(9, 7).showType());

        // Tests SadEmoticon is set at (0,2) on the specified size GameBoard
        setSizedBoard.setGamePiece(0, 2, new SadEmoticon(0, 2));
        assertEquals("SA", setSizedBoard.getGamePiece(0, 2).showType());
    }
}