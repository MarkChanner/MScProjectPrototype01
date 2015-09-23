package main.java;
import main.java.gameboard.Board;
import main.java.gameboard.BoardImpl;

/**
 * @author Mark Channer
 */
public class Game {

    private Board grid01;
    public static final int SIZE = 7;

    public Game() {
        this.grid01 = new BoardImpl(SIZE);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    public void start() {
        System.out.println();
        grid01.populateBoard();
        grid01.displayBoard();
        System.out.println();
        grid01.selectTile(6, 0);
        grid01.selectTile(6, 0);
        grid01.selectTile(6, 1);
        grid01.selectTile(3, 3);
        grid01.selectTile(3, 4);

        //grid01.selectTile(4,0);
        //grid01.selectTile(4,3);
        //grid01.selectTile(4,4);

    }
}
