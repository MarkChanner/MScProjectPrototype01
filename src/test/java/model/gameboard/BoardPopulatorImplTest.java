package model.gameboard;

import model.gamepieces.AbstractGamePiece;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class BoardPopulatorImplTest {

    private GameBoard board;
    private BoardPopulator populator;

    @Before
    public void setUp() throws Exception {
        board = new GameBoardImpl();
        populator = new BoardPopulatorImpl();
        populator.populate(board);
    }

    @After
    public void tearDown() throws Exception {
        board = null;
        populator = null;
    }

    @Test
    public void testGenerateGamePiece() throws Exception {
        String EMPTY = "EMPTY";
        AbstractGamePiece gamePiece = populator.createRandomGamePiece(0, 3);
        assertThat(gamePiece, instanceOf(AbstractGamePiece.class));
        assertNotEquals(EMPTY, gamePiece.showType());
    }
}