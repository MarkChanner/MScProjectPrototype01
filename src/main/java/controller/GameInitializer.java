package controller;

/**
 * GameInitializer initializes game objects and starts the game.
 *
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class GameInitializer {

    public static void main(String[] args) {
        new GameControllerImpl().initialize();
    }
}
