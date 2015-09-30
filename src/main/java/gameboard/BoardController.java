package gameboard;

import gamepieces.GamePiece;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Mark Channer
 */
public interface BoardController {

    ArrayList<LinkedList<Tile>> findMatchingRows(Board b);

    ArrayList<LinkedList<Tile>> findMatchingColumns(Board b);
}
