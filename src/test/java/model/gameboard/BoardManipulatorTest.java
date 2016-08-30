package model.gameboard;

import model.gamepieces.AbstractGamePiece;
import model.gamepieces.BlankTile;
import model.mock_objects.BoardPopulatorMock01;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class BoardManipulatorTest {

    private GameBoard defaultSizedBoard;
    private BoardPopulator populator;
    private BoardManipulator swapHandler;
    private String EMPTY = "EMPTY";

    @Before
    public void setUp() throws Exception {
        // Default size of GameBoard is (8 x 7)
        defaultSizedBoard = new GameBoardImpl();
        populator = new BoardPopulatorMock01();
        populator.populate(defaultSizedBoard);
        swapHandler = new BoardManipulatorImpl(defaultSizedBoard);
    }

    @After
    public void tearDown() throws Exception {
        defaultSizedBoard = null;
        populator = null;
        swapHandler = null;
    }

    @Test
    public void testGameBoardColumns() throws Exception {
        // Populated by BoardPopulatorMock01.
        // Tests GameBoard columns for default size of 8 x 7
        assertEquals("00", defaultSizedBoard.getGamePiece(0, 0).showType());
        assertEquals("HA", defaultSizedBoard.getGamePiece(0, 1).showType());
        assertEquals("HA", defaultSizedBoard.getGamePiece(0, 2).showType());
        assertEquals("EM", defaultSizedBoard.getGamePiece(0, 3).showType());
        assertEquals("HA", defaultSizedBoard.getGamePiece(0, 4).showType());
        assertEquals("05", defaultSizedBoard.getGamePiece(0, 5).showType());
        assertEquals("06", defaultSizedBoard.getGamePiece(0, 6).showType());

        assertEquals("07", defaultSizedBoard.getGamePiece(1, 0).showType());
        assertEquals("08", defaultSizedBoard.getGamePiece(1, 1).showType());
        assertEquals("09", defaultSizedBoard.getGamePiece(1, 2).showType());
        assertEquals("10", defaultSizedBoard.getGamePiece(1, 3).showType());
        assertEquals("EM", defaultSizedBoard.getGamePiece(1, 4).showType());
        assertEquals("12", defaultSizedBoard.getGamePiece(1, 5).showType());
        assertEquals("13", defaultSizedBoard.getGamePiece(1, 6).showType());

        assertEquals("14", defaultSizedBoard.getGamePiece(2, 0).showType());
        assertEquals("SA", defaultSizedBoard.getGamePiece(2, 1).showType());
        assertEquals("16", defaultSizedBoard.getGamePiece(2, 2).showType());
        assertEquals("17", defaultSizedBoard.getGamePiece(2, 3).showType());
        assertEquals("EM", defaultSizedBoard.getGamePiece(2, 4).showType());
        assertEquals("19", defaultSizedBoard.getGamePiece(2, 5).showType());
        assertEquals("20", defaultSizedBoard.getGamePiece(2, 6).showType());

        assertEquals("SA", defaultSizedBoard.getGamePiece(3, 0).showType());
        assertEquals("AN", defaultSizedBoard.getGamePiece(3, 1).showType());
        assertEquals("SA", defaultSizedBoard.getGamePiece(3, 2).showType());
        assertEquals("SA", defaultSizedBoard.getGamePiece(3, 3).showType());
        assertEquals("25", defaultSizedBoard.getGamePiece(3, 4).showType());
        assertEquals("26", defaultSizedBoard.getGamePiece(3, 5).showType());
        assertEquals("27", defaultSizedBoard.getGamePiece(3, 6).showType());

        assertEquals("28", defaultSizedBoard.getGamePiece(4, 0).showType());
        assertEquals("SA", defaultSizedBoard.getGamePiece(4, 1).showType());
        assertEquals("30", defaultSizedBoard.getGamePiece(4, 2).showType());
        assertEquals("31", defaultSizedBoard.getGamePiece(4, 3).showType());
        assertEquals("32", defaultSizedBoard.getGamePiece(4, 4).showType());
        assertEquals("33", defaultSizedBoard.getGamePiece(4, 5).showType());
        assertEquals("34", defaultSizedBoard.getGamePiece(4, 6).showType());

        assertEquals("35", defaultSizedBoard.getGamePiece(5, 0).showType());
        assertEquals("SA", defaultSizedBoard.getGamePiece(5, 1).showType());
        assertEquals("37", defaultSizedBoard.getGamePiece(5, 2).showType());
        assertEquals("38", defaultSizedBoard.getGamePiece(5, 3).showType());
        assertEquals("39", defaultSizedBoard.getGamePiece(5, 4).showType());
        assertEquals("40", defaultSizedBoard.getGamePiece(5, 5).showType());
        assertEquals("41", defaultSizedBoard.getGamePiece(5, 6).showType());

        assertEquals("42", defaultSizedBoard.getGamePiece(6, 0).showType());
        assertEquals("43", defaultSizedBoard.getGamePiece(6, 1).showType());
        assertEquals("44", defaultSizedBoard.getGamePiece(6, 2).showType());
        assertEquals("45", defaultSizedBoard.getGamePiece(6, 3).showType());
        assertEquals("46", defaultSizedBoard.getGamePiece(6, 4).showType());
        assertEquals("47", defaultSizedBoard.getGamePiece(6, 5).showType());
        assertEquals("48", defaultSizedBoard.getGamePiece(6, 6).showType());

        assertEquals("49", defaultSizedBoard.getGamePiece(7, 0).showType());
        assertEquals("50", defaultSizedBoard.getGamePiece(7, 1).showType());
        assertEquals("51", defaultSizedBoard.getGamePiece(7, 2).showType());
        assertEquals("52", defaultSizedBoard.getGamePiece(7, 3).showType());
        assertEquals("53", defaultSizedBoard.getGamePiece(7, 4).showType());
        assertEquals("54", defaultSizedBoard.getGamePiece(7, 5).showType());
        assertEquals("55", defaultSizedBoard.getGamePiece(7, 6).showType());
    }

    @Test
    public void testSwap() throws Exception {
        assertEquals("00", defaultSizedBoard.getGamePiece(0, 0).showType());
        assertEquals("HA", defaultSizedBoard.getGamePiece(0, 1).showType());
        assertEquals("HA", defaultSizedBoard.getGamePiece(0, 2).showType());
        assertEquals("EM", defaultSizedBoard.getGamePiece(0, 3).showType());
        assertEquals("HA", defaultSizedBoard.getGamePiece(0, 4).showType());

        Selections selections = new SelectionsImpl();
        selections.setSelection01(0, 3);
        selections.setSelection02(0, 4);
        swapHandler.swap(selections);
        assertEquals("HA", defaultSizedBoard.getGamePiece(0, 3).showType());
        assertEquals("EM", defaultSizedBoard.getGamePiece(0, 4).showType());
    }

    @Test
    public void testRemoveFromBoard() throws Exception {
        LinkedList<AbstractGamePiece> consecutiveEmoticons = new LinkedList<>();
        ArrayList<LinkedList<AbstractGamePiece>> bigList = new ArrayList<>();

        assertEquals("HA", defaultSizedBoard.getGamePiece(0, 1).showType());
        assertEquals("HA", defaultSizedBoard.getGamePiece(0, 2).showType());
        assertEquals("EM", defaultSizedBoard.getGamePiece(0, 3).showType());
        consecutiveEmoticons.add(defaultSizedBoard.getGamePiece(0, 1));
        consecutiveEmoticons.add(defaultSizedBoard.getGamePiece(0, 2));
        consecutiveEmoticons.add(defaultSizedBoard.getGamePiece(0, 3));
        bigList.add(consecutiveEmoticons);
        swapHandler.removeFromBoard(bigList);

        assertEquals(EMPTY, defaultSizedBoard.getGamePiece(0, 1).showType());
        assertEquals(EMPTY, defaultSizedBoard.getGamePiece(0, 2).showType());
        assertEquals(EMPTY, defaultSizedBoard.getGamePiece(0, 3).showType());

        // Checks that no error if given coordinates already contains a BlankTile
        swapHandler.removeFromBoard(bigList);
        assertEquals(EMPTY, defaultSizedBoard.getGamePiece(0, 1).showType());
        assertEquals(EMPTY, defaultSizedBoard.getGamePiece(0, 2).showType());
        assertEquals(EMPTY, defaultSizedBoard.getGamePiece(0, 3).showType());
    }

    @Test
    public void testShiftIconsDown() throws Exception {
        // Makes HappyEmoticon at (0,4) a BlankTile
        defaultSizedBoard.setGamePiece(0, 4, new BlankTile(0, 4));

        // Tests that when the BlankTile at (0,4) is found,
        // emoticons above are shifted down to fill the BlankTile.
        swapHandler.lowerGamePieces();
        assertEquals("00", defaultSizedBoard.getGamePiece(0, 1).showType());
        assertEquals("HA", defaultSizedBoard.getGamePiece(0, 2).showType());
        assertEquals("HA", defaultSizedBoard.getGamePiece(0, 3).showType());
        assertEquals("EM", defaultSizedBoard.getGamePiece(0, 4).showType());
        assertEquals("05", defaultSizedBoard.getGamePiece(0, 5).showType());
        assertEquals("06", defaultSizedBoard.getGamePiece(0, 6).showType());

        assertEquals("07", defaultSizedBoard.getGamePiece(1, 0).showType());
        assertEquals("08", defaultSizedBoard.getGamePiece(1, 1).showType());
        assertEquals("09", defaultSizedBoard.getGamePiece(1, 2).showType());
        assertEquals("10", defaultSizedBoard.getGamePiece(1, 3).showType());
        assertEquals("EM", defaultSizedBoard.getGamePiece(1, 4).showType());
        assertEquals("12", defaultSizedBoard.getGamePiece(1, 5).showType());
        assertEquals("13", defaultSizedBoard.getGamePiece(1, 6).showType());
    }

    @Test
    public void testInsertNewIcons() throws Exception {
        // Sets blank tiles in preparation for the new emoticons to be inserted
        defaultSizedBoard.setGamePiece(3, 0, new BlankTile(3, 0));
        defaultSizedBoard.setGamePiece(3, 1, new BlankTile(3, 1));
        defaultSizedBoard.setGamePiece(3, 2, new BlankTile(3, 2));

        // Calls method to be tested
        swapHandler.insertNewIcons(populator);

        // Checks that the previously BlankTile objects are no longer BlankTile, but are
        // still a subclass of AbstractGamePiece (and therefore one of the five emoticons)
        assertThat(defaultSizedBoard.getGamePiece(3, 0), instanceOf(AbstractGamePiece.class));
        assertNotEquals(EMPTY, defaultSizedBoard.getGamePiece(3, 0).showType());
        assertThat(defaultSizedBoard.getGamePiece(3, 1), instanceOf(AbstractGamePiece.class));
        assertNotEquals(EMPTY, defaultSizedBoard.getGamePiece(3, 1).showType());
        assertThat(defaultSizedBoard.getGamePiece(3, 2), instanceOf(AbstractGamePiece.class));
        assertNotEquals(EMPTY, defaultSizedBoard.getGamePiece(3, 2).showType());
    }
}