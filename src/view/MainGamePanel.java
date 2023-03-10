package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serial;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.Board;
import interfaces.BoardLayoutAndControls;

/**
 * Class holds the main game panel with menu bar.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class MainGamePanel extends JPanel implements PropertyChangeListener {

    // instance fields

    /**  A generated serial version UID for object Serialization. */
    @Serial
    private static final long serialVersionUID = 3714869667229553345L;

    /** Stores the value of 1 second in milliseconds. */
    private static final int TIME_DELAY = 1000;

    /**The Board.*/
    private final Board myBoard;

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
        System.out.println("Before adding");
        this.myBoard.addPropertyChangeListener(this);
        System.out.println("After adding to PCS");
        this.myTimer = new Timer(TIME_DELAY, this::handleTimer);
//        setUpKeyListener();
        setUpGUI(myBoard);
    }


    // private methods

    /** This method handles Action Event to occur after the Timer delay. */
    private void handleTimer(final ActionEvent theEvent) {
        myBoard.step();
    }

//    /** Sets up the focusable and adds key listener to innerclass. */
//    private void setUpKeyListener() {
//        this.addKeyListener(new ControlKeyListener());
//        this.setFocusable(true);
//        this.requestFocus();
//    }

    /** Sets up the main panels within the GUI. */
    private void setUpGUI(final Board theBoard) {
        final MenuBar menuBar = new MenuBar(theBoard);
        myBoard.addPropertyChangeListener(menuBar);
        this.add(menuBar, BorderLayout.NORTH);

        final InformationPanel infoPanel = new InformationPanel(theBoard);
        myBoard.addPropertyChangeListener(infoPanel);
        this.add(infoPanel, BorderLayout.EAST);

        final GameBoardPanel gameBoardPanel = new GameBoardPanel(theBoard);
        myBoard.addPropertyChangeListener(gameBoardPanel);
        this.add(gameBoardPanel, BorderLayout.CENTER);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("TEST 4");
        if (Board.PROPERTY_CHANGED.equals(evt.getPropertyName())) {
            repaint();
        }
        repaint();
    }

//    // inner class
//
//    /**
//     * Inner class that helps to determine the key event and what to do
//     * when a certain key is pressed.
//     *
//     * @author Hassan Farhat
//     * @version Winter 2023
//     */
//    final class ControlKeyListener extends KeyAdapter {
//
//        @Override
//        public void keyPressed(final KeyEvent theEvent) {
//            if (theEvent.getKeyCode() == KeyEvent.VK_S
//                    || theEvent.getKeyCode() == KeyEvent.VK_DOWN) {
//                myBoard.down();
//                System.out.println("down");
//            } else if (theEvent.getKeyCode() == KeyEvent.VK_A
//                    || theEvent.getKeyCode() == KeyEvent.VK_LEFT) {
//                myBoard.left();
//                System.out.println("left");
//            } else if (theEvent.getKeyCode() == KeyEvent.VK_D
//                    || theEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
//                myBoard.right();
//                System.out.println("right");
//            } else if (theEvent.getKeyCode() == KeyEvent.VK_W
//                    || theEvent.getKeyCode() == KeyEvent.VK_UP) {
//                myBoard.rotateCW();
//                System.out.println("rotateCW");
//            } else if (theEvent.getKeyCode() == KeyEvent.VK_SPACE) {
//                myBoard.drop();
//                System.out.println("drop");
//            }
//        }
//    }

}
