import gameboard.Board;

/**
 * @author Mark Channer
 */
public class Game {

    private Board grid01;
    public static final int SIZE = 7;

    public Game() {
        this.grid01 = new Board(SIZE);
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
        grid01.selectEmoticon(6,0);
        grid01.selectEmoticon(6,0);
        grid01.selectEmoticon(6,1);
        grid01.selectEmoticon(3,3);
        grid01.selectEmoticon(3,4);

        //grid01.selectEmoticon(4,0);
        //grid01.selectEmoticon(4,3);
        //grid01.selectEmoticon(4,4);

    }
}
