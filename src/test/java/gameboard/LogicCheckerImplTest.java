package gameboard;

import java.util.LinkedList;
import java.util.ArrayList;

import gamepieces.GamePiece;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mark Channer
 */
public class LogicCheckerImplTest {

    @Test
    public void testCheckRows() throws Exception {
        LinkedList<String> consecutivePieces = new LinkedList<>();
        ArrayList<LinkedList<String>> bigList = new ArrayList<>();
        String gamePiece;
        String[] tiles = {"H", "A", "C", "C", "C", "S", "E"};
        assertEquals(tiles[0], "H");
        assertEquals(tiles[6], "E");

        gamePiece = tiles[0]; // gamePiece is "H"
        consecutivePieces.add(gamePiece);// adds "H" to the List
        for (int col = 1; col < 7; col++) {
            gamePiece = tiles[col]; // gamePiece is "A"
            /* if "A" is not equal to "H" */
            if (!gamePiece.equals(consecutivePieces.getLast())) {
                /* if List is 3 or more, add the List to bigList*/
                if (consecutivePieces.size() >= 3) {
                    bigList.add(consecutivePieces);
                    assertEquals(1, bigList.size());
                }
                consecutivePieces.clear();// wipe the list regardless
                consecutivePieces.add(gamePiece); // add "A" to the list and loop
            }
        }

        //assertEquals(3, bigList.size());


    }

    @Test
    public void testExamineList() throws Exception {

    }
}