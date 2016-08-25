package controller;

import model.gameboard.*;
import model.mockObjects.BoardPopulatorMock01;
import view.GameView;
import view.GameViewImpl;

import java.util.Scanner;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class GameControllerImpl implements GameController {

    private GameModel gameModel;
    private GameView gameView;

    public GameControllerImpl() {
        initialize();
    }

    public void initialize() {
        GameBoard board = new GameBoardImpl(10,10);
        BoardPopulator populator = new BoardPopulatorMock01();
        populator.populate(board);
        this.gameView = new GameViewImpl(board);
        this.gameModel = new GameModelImpl(this, board, new MatchFinderImpl(), populator);
        takeInputCommands();
    }

    @Override
    public void takeInputCommands() {
        Scanner input = new Scanner(System.in);
        String userInput;
        String[] coordinates;
        displayBoard();
        gameView.displayWithNewLine("Enter board coordinates by row and column in the form 3,4 (q to quit):");

        do {
            gameView.displayWithoutNewLine("Coordinates: ");
            userInput = input.nextLine();

            if (hasNotQuit(userInput)) {
                coordinates = userInput.split(",");

                if (isValidInput(coordinates)) {
                    Integer x = Integer.parseInt(coordinates[0]);
                    Integer y = Integer.parseInt(coordinates[1]);
                    gameModel.handleSelection(x, y);
                } else {
                    gameView.displayWithNewLine("Invalid input. Please enter again");
                }

            }
        } while (hasNotQuit(userInput));

    }

    @Override
    public void displayBoard() {
        gameView.drawGameBoard();
    }

    @Override
    public void notify(String str) {
        gameView.displayWithNewLine(str);
    }

    private boolean isValidInput(String[] coordinates) {
        if (coordinates.length != 2) return false;

        for (String coordinate : coordinates) {
            char c = coordinate.charAt(0);
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    private boolean hasNotQuit(String userInput) {
        return (!userInput.equals("q"));
    }

}
