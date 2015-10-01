package gameboard;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Mark Channer
 */
public interface MatchFinder {

    ArrayList<LinkedList<Tile>> findMatchingRows(Board b);

    ArrayList<LinkedList<Tile>> findMatchingColumns(Board b);

}
