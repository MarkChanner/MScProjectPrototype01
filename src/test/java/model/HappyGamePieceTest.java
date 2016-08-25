package model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class HappyGamePieceTest {

    @Test
    public void testRetrieveGamePieceAndShowType() throws Exception {
        GamePiece gp = new HappyGamePiece();
        GamePiece retrievedPiece = gp.retrieveGamePiece();
        assertEquals("H", retrievedPiece.showType());
    }
}