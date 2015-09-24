package gameboard;

import gamepieces.GamePiece;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Mark Channer
 */
public interface LogicChecker {

    ArrayList<LinkedList<GamePiece>> checkRows();

    //List<List<GamePiece>> checkColumns();
}
