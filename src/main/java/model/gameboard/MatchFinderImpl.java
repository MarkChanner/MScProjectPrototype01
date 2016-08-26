package model.gameboard;

import model.gamepieces.AbstractGamePiece;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Finds and returns an ArrayList that contains a List/Lists of horizontal or vertical
 * GamePiece matches
 *
 * @author Mark Channer for first prototype of Birkbeck MSc Computer Science final project
 */
public class MatchFinderImpl implements MatchFinder {

    private static final int ROW_START = 0;
    private static final int COLUMN_TOP = 0;

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<LinkedList<AbstractGamePiece>> findVerticalMatches(GameBoard board) {
        int cols = board.getCols();
        int columnBottom = (board.getRows() - 1);
        LinkedList<AbstractGamePiece> consecutiveEmoticons = new LinkedList<>();
        ArrayList<LinkedList<AbstractGamePiece>> bigList = new ArrayList<>();
        AbstractGamePiece emo;
        for (int x = ROW_START; x < cols; x++) {
            consecutiveEmoticons.add(board.getGamePiece(x, columnBottom));

            for (int y = (columnBottom - 1); y >= COLUMN_TOP; y--) {
                emo = board.getGamePiece(x, y);
                if (!emo.showType().equals(consecutiveEmoticons.getLast().showType())) {
                    examineList(consecutiveEmoticons, bigList);
                    consecutiveEmoticons = new LinkedList<>();
                }
                consecutiveEmoticons.add(emo);
                if (y == COLUMN_TOP) {
                    examineList(consecutiveEmoticons, bigList);
                    consecutiveEmoticons = new LinkedList<>();
                }
            }
        }
        return bigList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<LinkedList<AbstractGamePiece>> findHorizontalMatches(GameBoard board) {
        int cols = board.getCols();
        int columnBottom = (board.getRows() - 1);
        int rowEnd = cols - 1;
        LinkedList<AbstractGamePiece> consecutiveEmoticons = new LinkedList<>();
        ArrayList<LinkedList<AbstractGamePiece>> bigList = new ArrayList<>();
        AbstractGamePiece emo;
        for (int y = columnBottom; y >= COLUMN_TOP; y--) {
            consecutiveEmoticons.add(board.getGamePiece(ROW_START, y));

            for (int x = (ROW_START + 1); x < cols; x++) {
                emo = board.getGamePiece(x, y);
                if (!(emo.showType().equals(consecutiveEmoticons.getLast().showType()))) {
                    examineList(consecutiveEmoticons, bigList);
                    consecutiveEmoticons = new LinkedList<>();
                }
                consecutiveEmoticons.add(emo);
                if (x == rowEnd) {
                    examineList(consecutiveEmoticons, bigList);
                    consecutiveEmoticons = new LinkedList<>();
                }
            }
        }
        return bigList;
    }

    /**
     * A private method to check that the consecutiveEmoticons list contains
     * more than 3 matching emoticons that are all of the same type
     *
     * @param consecutiveEmoticons the list of emoticons to be checked
     * @param bigList to add any non-empty consecutiveEmoticons lists to
     */
    private void examineList(LinkedList<AbstractGamePiece> consecutiveEmoticons, ArrayList<LinkedList<AbstractGamePiece>> bigList) {
        if ((consecutiveEmoticons.size() >= 3) && (allSameType(consecutiveEmoticons))) {
            bigList.add(consecutiveEmoticons);
        }
    }

    /**
     * A private metohd to check that the given consecutiveEmoticons list contains
     * only emoticons of the same type
     *
     * @param consecutiveEmoticons the list of emoticons to be checked
     * @return true if the consecutiveEmoticons list are all of the same type
     */
    private boolean allSameType(LinkedList<AbstractGamePiece> consecutiveEmoticons) {
        String previousEmo = consecutiveEmoticons.getFirst().showType();
        String nextEmo;
        for (int i = 1; i < consecutiveEmoticons.size(); i++) {
            nextEmo = consecutiveEmoticons.get(i).showType();
            if (!nextEmo.equals(previousEmo)) {
                return false;
            } else {
                previousEmo = nextEmo;
            }
        }
        return true;
    }
}