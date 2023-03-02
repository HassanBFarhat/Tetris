package view;

import static model.PropertyChangeGamePieces.PROPERTY_CHANGED;
import model.Board;
import model.PropertyChangeGamePieces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serial;
import javax.swing.*;

/**
 * Sets up the Game board where player will see and play the game.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class GameBoardPanel extends JPanel implements PropertyChangeListener {

    /**  A generated serial version UID for object Serialization. */
    @Serial
    private static final long serialVersionUID = 7129745753499709311L;

    /** Width constant. */
    private static final int GAME_BOARD_WIDTH = 400;

    /** Height constant. */
    private static final int GAME_BOARD_HEIGHT = 100;

    /** This Board. */
    private final PropertyChangeGamePieces myBoard;

    /** This timer. */
    private final Timer myTimer;


    /**
     * Constructor sets up the panel for the game board.
     */
    public GameBoardPanel() {
        super();
        this.setBackground(Color.RED);
        this.setPreferredSize(new Dimension(GAME_BOARD_WIDTH, GAME_BOARD_HEIGHT));
        this.setVisible(true);
        this.myBoard = new Board();
        this.myTimer = new Timer(1000, this::handleTimer);
    }


    private void handleTimer(final ActionEvent theEvent) {
        myBoard.step();
    }





    //_________________________________________________________________
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if (PROPERTY_CHANGED.equals(theEvent.getPropertyName())) {
            // TODO: Need to implement what happens to update the board.
        }
    }





}
