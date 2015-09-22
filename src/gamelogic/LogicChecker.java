package gamelogic;

import gameboard.Grid;
import gameboard.Tile;

import java.util.List;

/**
 * @author Mark Channer
 */
public interface LogicChecker {

    List<Tile> check(Grid grid);
}
