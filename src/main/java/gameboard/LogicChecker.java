package main.java.gameboard;

import java.util.List;

/**
 * @author Mark Channer
 */
public interface LogicChecker {

    List<Tile> checkRows();

    List<Tile> checkColumns();
}
