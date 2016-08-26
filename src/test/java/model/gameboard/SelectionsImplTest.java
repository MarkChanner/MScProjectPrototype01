package model.gameboard;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class SelectionsImplTest {

    private static final int X = 0;
    private static final int Y = 1;
    private Selections selections;

    @Before
    public void setUp() throws Exception {
        selections = new SelectionsImpl();
    }

    @After
    public void tearDown() throws Exception {
        selections = null;
    }

    @Test
    public void testSetAndGetSelection01() throws Exception {
        selections.setSelection01(5, 4);
        assertEquals(5, selections.getSelection01()[X]);
        assertEquals(4, selections.getSelection01()[Y]);

        selections.reset();
        assertEquals(-2, selections.getSelection01()[X]);
        assertEquals(-2, selections.getSelection01()[Y]);
    }

    @Test
    public void testSelection01AlreadyMade() throws Exception {
        assertFalse(selections.selection01AlreadyMade());
        selections.setSelection01(3, 5);
        assertTrue(selections.selection01AlreadyMade());
    }

    @Test
    public void testSetAndGetSelection02() throws Exception {
        selections.setSelection02(2, 3);
        assertEquals(2, selections.getSelection02()[X]);
        assertEquals(3, selections.getSelection02()[Y]);
    }

    @Test
    public void testSameSelectionMadeTwice() throws Exception {
        assertFalse(selections.sameSelectionMadeTwice());
        selections.setSelection01(0, 0);
        selections.setSelection02(0, 0);
        assertTrue(selections.sameSelectionMadeTwice());
    }

    @Test
    public void testAreNotAdjacent() throws Exception {
        assertTrue(selections.areNotAdjacent());
        selections.setSelection01(0, 0);
        selections.setSelection02(0, 1);
        assertFalse(selections.areNotAdjacent());
    }

    @Test
    public void testSecondSelectionBecomesFirstSelection() throws Exception {
        selections.setSelection01(3, 4);
        selections.setSelection02(5, 6);
        assertEquals(3, selections.getSelection01()[X]);
        assertEquals(4, selections.getSelection01()[Y]);
        assertEquals(5, selections.getSelection02()[X]);
        assertEquals(6, selections.getSelection02()[Y]);

        selections.secondSelectionBecomesFirstSelection();
        assertEquals(5, selections.getSelection01()[X]);
        assertEquals(6, selections.getSelection01()[Y]);
        assertEquals(-1, selections.getSelection02()[X]);
        assertEquals(-1, selections.getSelection02()[Y]);
    }
}