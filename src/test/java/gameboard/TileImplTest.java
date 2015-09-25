package gameboard;

import gamepieces.AngryGamePiece;
import gamepieces.GamePiece;
import gamepieces.HappyGamePiece;
import gamepieces.SadGamePiece;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.rmi.server.ExportException;

import static org.junit.Assert.*;

/**
 * @author Mark Channer
 */
public class TileImplTest {

    private Tile tile;
    private GamePiece gp;

    @Before
    public void setUp() throws Exception {
        gp = new HappyGamePiece("H");
        tile = new TileImpl(7, 7, gp);
    }

    @After
    public void tearDown() throws Exception {
        tile = null;
        gp = null;
    }

    @Test
    public void testGetCoordinates() {
        int output = tile.getRow();
        int expected = 7;
        assertEquals(expected, output);
        assertEquals(expected, output);
    }

    @Test
    public void testSetGetGamePiece() {
        assertEquals("H", tile.getGamePiece().showType());

        tile.setGamePiece(new SadGamePiece("S"));
        assertEquals("S", tile.getGamePiece().showType());

        tile.setGamePiece(new AngryGamePiece("A"));
        assertEquals("A", tile.getGamePiece().showType());
    }
}