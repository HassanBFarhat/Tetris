package view;

import interfaces.BoardLayoutAndControls;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serial;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.Board;


/**
 * Class holds the main game panel with menu bar.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class MainGamePanel extends JPanel implements PropertyChangeListener {

    // static field

    /**  A generated serial version UID for object Serialization. */
    @Serial
    private static final long serialVersionUID = 3714869667229553345L;


    // instance fields

    /** Stores the value of 1 second in milliseconds. */
    private static final int TIME_DELAY = 1000;

    /**The Board.*/
    private final BoardLayoutAndControls myBoard;

    /** This timer. */
    private final Timer myTimer;


    // constructor

    /**
     * MainGamePanel Constructor allows the main panel and MenuBar to be set up.
     */
    public MainGamePanel(final Board theBoard) {
        super();
        this.setLayout(new BorderLayout());
        this.myBoard = theBoard;
        this.myBoard.addPropertyChangeListener(this);
        this.myTimer = new Timer(TIME_DELAY, this::handleTimer);
        this.setUpKeyListener();
        setUpGUI();
    }


    // private methods

    /** This method handles Action Event to occur after the Timer delay. */
    private void handleTimer(final ActionEvent theEvent) {
        myBoard.step();
    }


    /** Sets up the main panels within the GUI. */
    private void setUpGUI() {
        final MenuBar menuBar = new MenuBar();
        this.add(menuBar, BorderLayout.NORTH);

        final InformationPanel infoPanel = new InformationPanel();
        this.add(infoPanel, BorderLayout.EAST);

        final GameBoardPanel gameBoardPanel = new GameBoardPanel();
        this.myBoard.addPropertyChangeListener(gameBoardPanel);
        this.add(gameBoardPanel, BorderLayout.CENTER);
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if (Board.PROPERTY_CHANGED.equals(theEvent.getPropertyName())) {
            repaint();
        }
    }

    /** Stops the timer on the game board. */
    public void stopTimer() {
        System.out.println("Stopped!!!");
        myTimer.stop();
    }

    /** Starts the timer on the game board. */
    public void startsTimer() {
        myTimer.start();
    }

    /** Sets up the focusable and adds key listener to innerclass. */
    private void setUpKeyListener() {
        this.addKeyListener(new ControlKeyListener());
        this.setFocusable(true);
        this.requestFocusInWindow();
    }


    // inner class

    /**
     * Inner class that helps to determine the key event and what to do
     * when a certain key is pressed.
     *
     * @author Hassan Farhat
     * @version Winter 2023
     */
    protected final class ControlKeyListener extends KeyAdapter {


        /** Private constructor to satisfy PMD. */
        private ControlKeyListener() {
            super(); }

        @Override
        public void keyPressed(final KeyEvent theEvent) {
            if (theEvent.getKeyCode() == KeyEvent.VK_S
                    || theEvent.getKeyCode() == KeyEvent.VK_DOWN) {
                myBoard.down();
            } else if (theEvent.getKeyCode() == KeyEvent.VK_A
                    || theEvent.getKeyCode() == KeyEvent.VK_LEFT) {
                myBoard.left();
            } else if (theEvent.getKeyCode() == KeyEvent.VK_D
                    || theEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
                myBoard.right();
            } else if (theEvent.getKeyCode() == KeyEvent.VK_W
                    || theEvent.getKeyCode() == KeyEvent.VK_UP) {
                myBoard.rotateCW();
            } else if (theEvent.getKeyCode() == KeyEvent.VK_SPACE) {
                myBoard.drop();
            } else if (theEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
                myTimer.stop();
                JOptionPane.showMessageDialog(MainGamePanel.this,
                        "YOUR GAME HAS BEEN PAUSED. Press OK or the Spacebar to resume");
                myTimer.start();
            }
        }
    }

}
