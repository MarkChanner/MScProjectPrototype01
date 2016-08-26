package model.gameboard;

import model.gamepieces.AbstractGamePiece;
import model.gamepieces.EmbarrassedEmoticon;
import model.gamepieces.HappyEmoticon;
import model.mock_objects.BoardPopulatorMock01;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Uses BoardPopulatorMock testing to overcome the problem of random allocation of emoticons
 *
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class MatchFinderImplTest {


    private GameBoard board;
    private BoardPopulator populator;
    private MatchFinder matchFinder;

    @Before
    public void setUp() throws Exception {
        board = new GameBoardImpl();
        populator = new BoardPopulatorMock01();
        populator.populate(board);
        matchFinder = new MatchFinderImpl();
    }

    @After
    public void tearDown() throws Exception {
        board = null;
        populator = null;
        matchFinder = null;
    }

    @Test
    public void testFindVerticalMatches() throws Exception {
        ArrayList<LinkedList<AbstractGamePiece>> matchingX = matchFinder.findVerticalMatches(board);
        assertTrue(matchingX.isEmpty());

        board.setGamePiece(0, 3, new HappyEmoticon(0, 3));
        matchingX = matchFinder.findVerticalMatches(board);

        assertEquals(1, matchingX.size());
        assertEquals(4, matchingX.get(0).size());
        assertEquals("HA", matchingX.get(0).get(0).showType());
        assertEquals("HA", matchingX.get(0).get(3).showType());
    }

    @Test
    public void testFindHorizontalMatches() throws Exception {
        ArrayList<LinkedList<AbstractGamePiece>> matchingY = matchFinder.findHorizontalMatches(board);
        assertTrue(matchingY.isEmpty());

        board.setGamePiece(3, 4, new EmbarrassedEmoticon(3, 4));
        matchingY = matchFinder.findHorizontalMatches(board);

        assertEquals(1, matchingY.size());
        assertEquals(3, matchingY.get(0).size());
        assertEquals("EM", matchingY.get(0).get(0).showType());
        assertEquals("EM", matchingY.get(0).get(2).showType());
    }
}