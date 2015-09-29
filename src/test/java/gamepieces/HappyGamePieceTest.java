package gamepieces;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mark Channer
 */
public class HappyGamePieceTest {

    @Test
    public void testRetrieveGamePieceAndShowType() throws Exception {
        GamePiece gp = new HappyGamePiece();
        GamePiece retrievedPiece = gp.retrieveGamePiece();
        assertEquals("H", retrievedPiece.showType());
    }
}