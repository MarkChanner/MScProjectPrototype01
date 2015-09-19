/**
 * @author Mark Channer
 */
public class Game {

    public static void main(String[] args) {
        System.out.println("Constructing Grid1");
        Grid grid1 = new Grid();
        System.out.println("Grid1 selecting first icon");
        grid1.selectEmoticon(1);
        System.out.println("Grid1 selecting second icon");
        grid1.selectEmoticon(1);
        System.out.println("Grid1 selecting a substitute icon");
        grid1.selectEmoticon(2);
        System.out.println();

        System.out.println("Grid1 selecting first icon");
        grid1.selectEmoticon(3);
        System.out.println("Grid1 selecting second icon");
        grid1.selectEmoticon(4);
        System.out.println();

        System.out.println("Constructing Grid2");
        Grid grid2 = new Grid();
        System.out.println("Grid2 selecting first icon");
        grid2.selectEmoticon(0);
        System.out.println("Grid2 selecting second icon");
        grid2.selectEmoticon(1);
        System.out.println();

        System.out.println("Constructing Grid3");
        Grid grid3 = new Grid();
        System.out.println("Grid3 selecting first icon");
        grid3.selectEmoticon(5);
        System.out.println("Grid3 selecting second icon");
        grid3.selectEmoticon(4);
    }
}
