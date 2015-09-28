
import gameboard.*;

import java.util.Scanner;


/**
 * @author Mark Channer
 */
public class Game {

    public static final int ROWS = 7;
    public static final int COLS = 7;
    private Board board;

    public Game() {
        board = new BoardImpl(ROWS, COLS, new BoardPopulatorCrossMatch());
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.takeCommands();
        //game.start();
    }

    private void start() {
        board.displayBoard();
        System.out.println();
        board.selectTile(5, 2);
        board.selectTile(5, 3);
    }

    private void takeCommands() {
        board.displayBoard();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter board coordinates (q to quit):");
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
