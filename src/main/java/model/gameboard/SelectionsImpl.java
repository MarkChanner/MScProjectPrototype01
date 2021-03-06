package model.gameboard;

/**
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class SelectionsImpl implements Selections {

    private static final int X = 0;
    private static final int Y = 1;
    private int[] selection01 = new int[2];
    private int[] selection02 = new int[2];
    private boolean selection01AlreadyBeenMade;

    public SelectionsImpl() {
        reset();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reset() {
        selection01[X] = -2;
        selection01[Y] = -2;
        selection02[X] = -1;
        selection02[Y] = -1;
        selection01AlreadyBeenMade = false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[] getSelection01() {
        return selection01;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSelection01(int x, int y) {
        selection01[X] = x;
        selection01[Y] = y;
        selection01AlreadyBeenMade = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean selection01AlreadyMade() {
        return selection01AlreadyBeenMade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[] getSelection02() {
        return selection02;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSelection02(int x, int y) {
        selection02[X] = x;
        selection02[Y] = y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean sameSelectionMadeTwice() {
        return (selection01[X] == selection02[X] && selection01[Y] == selection02[Y]);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean areNotAdjacent() {
        if ((selection01[X] == selection02[X]) &&
                (selection01[Y] == (selection02[Y] + 1) || selection01[Y] == (selection02[Y] - 1))) {
            return false;
        } else if ((selection01[Y] == selection02[Y]) &&
                (selection01[X] == (selection02[X] + 1) || selection01[X] == (selection02[X] - 1))) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void secondSelectionBecomesFirstSelection() {
        selection01[X] = selection02[X];
        selection01[Y] = selection02[Y];
        selection02[X] = -1;
        selection02[Y] = -1;
    }
}
