package interfaces;

import java.beans.PropertyChangeListener;
import java.util.List;
import model.TetrisPiece;

/**
 * This is an interface which lays out all the public API methods
 * that will be utilized within our Board.java class.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public interface BoardLayoutAndControls {

    // Property Name

    /** A property name for current game piece to drop down. */
    String PROPERTY_CHANGED = "changed on board";


    // public methods

    /**
     * Get the width of the board.
     *
     * @return Width of the board.
     */
    int getWidth();

    /**
     * Get the height of the board.
     *
     * @return Height of the board.
     */
    int getHeight();

    /**
     * Resets the board for a new game.
     * This method must be called before the first game
     * and before each new game.
     */
    void newGame();

    /**
     * Sets a non random sequence of pieces to loop through.
     *
     * @param thePieces the List of non random TetrisPieces.
     */
    void setPieceSequence(List<TetrisPiece> thePieces);

    /**
     * Advances the board by one 'step'.
     *
     * This could include
     * - moving the current piece down 1 line
     * - freezing the current piece if appropriate
     * - clearing full lines as needed
     */
    void step();

    /**
     * Try to move the movable piece down.
     * Freeze the Piece in position if down tries to move into an illegal state.
     * Clear full lines.
     */
    void down();

    /**
     * Try to move the movable piece left.
     */
    void left();

    /**
     * Try to move the movable piece right.
     */
    void right();

    /**
     * Try to rotate the movable piece in the clockwise direction.
     */
    void rotateCW();

    /**
     * Try to rotate the movable piece in the counter-clockwise direction.
     */
    void rotateCCW();

    /**
     * Drop the piece until piece is set.
     */
    void drop();

    /**
     * Displays a string representation of the Game Board.
     */
    String toString();

    /**
     * Adds an observer to list of observers maintains by PCS.
     *
     * @param theListener the observer to be added.
     */
    void addPropertyChangeListener(PropertyChangeListener theListener);

    /**
     * Removes an observer from a list of observers maintains by PCS.
     *
     * @param theListener the observer to be removed.
     */
    void removePropertyChangeListener(PropertyChangeListener theListener);
}
