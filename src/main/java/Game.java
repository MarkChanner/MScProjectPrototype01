
import gameboard.Board;
import gameboard.BoardImpl;

/**
 * @author Mark Channer
 */
public class Game {

    private Board board;
    public static final int SIZE = 7;

    public Game() {
        this.board = new BoardImpl(SIZE);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    public void start() {
        board.populateBoard();
        board.displayBoard();
        board.selectTile(6, 0);
        board.selectTile(6, 0);
        board.selectTile(6, 1);
        board.selectTile(3, 3);
        board.selectTile(3, 4);
    }
}
