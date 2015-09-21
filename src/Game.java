/**
 * @author Mark Channer
 */
public class Game {

    private Grid grid1;

    public Game() {
        this.grid1 = new Grid();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    public void start() {
        System.out.println();
        grid1.populateGrid();
        grid1.displayGrid();
        System.out.println();
        /*grid1.selectEmoticon(6,0);
        grid1.selectEmoticon(6,0);
        grid1.selectEmoticon(6,1);
        grid1.selectEmoticon(3,3);
        grid1.selectEmoticon(3,4);*/

        grid1.selectEmoticon(4,0);
        grid1.selectEmoticon(4,3);
        grid1.selectEmoticon(4,4);







        //grid1.exchangeEmoticon(6,0, new SadFaceIcon());
        //grid1.displayGrid();
    }
}
