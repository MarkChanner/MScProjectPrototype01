/**
 * @author Mark Channer
 */
public class Game {

    public static void main(String[] args) {
        System.out.println("Game Started!!");
        Grid grid = new Grid();
        System.out.println("Game class selecting first icon");
        grid.selectEmoticon(0);
        System.out.println("Game class selecting second icon");
        grid.selectEmoticon(0);
        System.out.println("Game class selecting a substitute icon");
        grid.selectEmoticon(1);

        System.out.println("Game class selecting first icon");
        grid.selectEmoticon(1);
        System.out.println("Game class selecting second icon");
        grid.selectEmoticon(1);
        grid.selectEmoticon(2);
    }
}
