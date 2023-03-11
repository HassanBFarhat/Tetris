package view;

import interfaces.BoardLayoutAndControls;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serial;
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
        this.myBoard.addPropertyChangeListener(menuBar);
        this.add(menuBar, BorderLayout.NORTH);

        final InformationPanel infoPanel = new InformationPanel();
        this.myBoard.addPropertyChangeListener(infoPanel);
        this.add(infoPanel, BorderLayout.EAST);

        final GameBoardPanel gameBoardPanel = new GameBoardPanel();
        this.myBoard.addPropertyChangeListener(gameBoardPanel);
        this.add(gameBoardPanel, BorderLayout.CENTER);
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        System.out.println("TEST 4");
        if (Board.PROPERTY_CHANGED.equals(theEvent.getPropertyName())) {
            repaint();
        }
        repaint();
    }

}
