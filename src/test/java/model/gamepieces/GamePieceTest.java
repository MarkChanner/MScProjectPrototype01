package model.gamepieces;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class GamePieceTest {

    private AbstractGamePiece angry;
    private AbstractGamePiece embarrassed;
    private AbstractGamePiece happy;
    private AbstractGamePiece sad;
    private AbstractGamePiece surprised;
    private AbstractGamePiece blank;

    @Before
    public void setUp() throws Exception {
        angry = new AngryEmoticon(0, 1);
        embarrassed = new EmbarrassedEmoticon(1, 2);
        happy = new HappyEmoticon(2, 3);
        sad = new SadEmoticon(3, 4);
        surprised = new SurprisedEmoticon(4, 5);
        blank = new BlankTile(5, 6);
    }

    @Test
    public void testShowType() throws Exception {
        assertEquals("AN", angry.showType());
        assertEquals("EM", embarrassed.showType());
        assertEquals("HA", happy.showType());
        assertEquals("SA", sad.showType());
        assertEquals("SU", surprised.showType());
        assertEquals("EMPTY", blank.showType());
    }

    @Test
    public void testGetCoordinates() throws Exception {
        assertEquals(0, angry.getX());
        assertEquals(1, angry.getY());
        assertEquals(1, embarrassed.getX());
        assertEquals(2, embarrassed.getY());
        assertEquals(2, happy.getX());
        assertEquals(3, happy.getY());
        assertEquals(3, sad.getX());
        assertEquals(4, sad.getY());
        assertEquals(4, surprised.getX());
        assertEquals(5, surprised.getY());
        assertEquals(5, blank.getX());
        assertEquals(6, blank.getY());
    }

    @Test
    public void testSetCoordinates() throws Exception {
        assertEquals(0, angry.getX());
        assertEquals(1, angry.getY());
        angry.setCoordinates(5, 6);
        assertEquals(5, angry.getX());
        assertEquals(6, angry.getY());
    }
}