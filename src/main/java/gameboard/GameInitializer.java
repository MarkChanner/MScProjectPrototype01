package gameboard;
import java.util.Scanner;

/**
 * GameInitializer sets up the Board and passes it the necessary objects to populate the
 * board and find matches after GamePiece objects are swapped. For playing the game, the
 * BoardPopulatorImpl object is passed in, but when testing, a BoardPopulatorMock01 object
 * is passed instead, which populates the board in a set way for the tests
 *
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class GameInitializer {

    public static final int ROWS = 7;
    public static final int COLS = 7;
    private Board board;

    public GameInitializer() {
        board = new BoardImpl(ROWS, COLS, new BoardPopulatorImpl(), new MatchFinderImpl());
    }

    public static void main(String[] args) {
        GameInitializer gameInitializer = new GameInitializer();
        gameInitializer.takeCommands();
    }

    private void takeCommands() {
        board.displayBoard();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter board coordinates by row and column in the form 3,4 (q to quit):");
        String userInput;
        String[] coordinates;
        do {
            System.out.println("Coordinates: ");
            userInput = input.nextLine();
            if (notQuitting(userInput)) {
                coordinates = userInput.split(",");
                if (validInput(coordinates)) {
                    Integer x = Integer.parseInt(coordinates[0]);
                    Integer y = Integer.parseInt(coordinates[1]);
                    board.selectTile(x, y);
                } else {
                    System.out.println("Invalid input. Please enter again");
                }
            }
        } while (notQuitting(userInput));
    }

    private boolean validInput(String[] coordinates) {
        if (coordinates.length != 2) return false;

        for (String coordinate : coordinates) {
            char c = coordinate.charAt(0);
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public boolean notQuitting(String userInput) {
        return (!userInput.equals("q"));
    }
}
