package gameboard;

import gamepieces.GamePiece;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Mark Channer
 */
public interface LogicChecker {

    ArrayList<LinkedList<Tile>> checkRows(Board b);

    ArrayList<LinkedList<Tile>> checkColumns(Board b);
}
