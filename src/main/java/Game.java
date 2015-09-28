
import gameboard.Board;
import gameboard.BoardImpl;

import java.util.Scanner;


/**
 * @author Mark Channer
 */
public class Game {

    private Board board;
    public static final int ROWS = 7;
    public static final int COLS = 7;

    public Game() {
        this.board = new BoardImpl(ROWS, COLS);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.takeCommands();
       // game.start();
    }

    private void start() {
        board.populateBoard();
        board.displayBoard();
        System.out.println();
        board.selectTile(3, 4);
        board.selectTile(3, 5);
    }

    private void takeCommands() {
        board.populateBoard();
        board.displayBoard();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter coordintes of tile on board (q to quit)");
        String command;
        String[] coordinates;
        do {
            command = input.nextLine();
            coordinates = command.split(",");
            if (!coordinates[0].equals("q")) {
                Integer x = Integer.parseInt(coordinates[0]);
                Integer y = Integer.parseInt(coordinates[1]);
                board.selectTile(x, y);
            }

        } while (!command.equals("q")); // toString() redundant
    }
}
