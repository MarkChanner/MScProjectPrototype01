package model.gameboard;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public interface Selections {

    void reset();

    int[] getSelection01();

    void setSelection01(int x, int y);

    boolean selection01AlreadyMade();

    int[] getSelection02();

    void setSelection02(int x, int y);

    boolean sameSelectionMadeTwice();

    boolean areNotAdjacent();

    void secondSelectionBecomesFirstSelection();

}


