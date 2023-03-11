package view;

import interfaces.BoardLayoutAndControls;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serial;
import javax.swing.JPanel;
import model.Board;

/**
 * Sets up the information side of the game GUI.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class InformationPanel extends JPanel implements PropertyChangeListener {

    // static fields

    /**  A generated serial version UID for object Serialization. */
    @Serial
    private static final long serialVersionUID = -3071268708346186062L;

    /** Width constant. */
    private static final int INFO_PANEL_WIDTH = 400;

    /** Height constant. */
    private static final int INFO_PANEL_HEIGHT = 100;


    // instance field

    /** Stores reference to the Board. */
    private final BoardLayoutAndControls myBoard;


    // constructor

    /**
     * Creates the panel where all info for player will be visible.
     */
    public InformationPanel() {
        super();
        this.myBoard = new Board(INFO_PANEL_WIDTH, INFO_PANEL_HEIGHT);
        this.myBoard.addPropertyChangeListener(this);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(INFO_PANEL_WIDTH, INFO_PANEL_HEIGHT));
        this.setUpInfoPanel();
        this.setVisible(true);
    }

    /** Sets up all the panels required for the info panel. */
    private void setUpInfoPanel() {
        final NextPiecePanel nextPiecePanel = new NextPiecePanel();
        this.myBoard.addPropertyChangeListener(nextPiecePanel);
        this.add(nextPiecePanel, BorderLayout.NORTH);

        final ScoreInfoPanel scoreInfoPanel = new ScoreInfoPanel();
        this.myBoard.addPropertyChangeListener(scoreInfoPanel);
        this.add(scoreInfoPanel, BorderLayout.CENTER);

        final DisplayControlsPanel displayControlsPanel = new DisplayControlsPanel();
        this.myBoard.addPropertyChangeListener(displayControlsPanel);
        this.add(displayControlsPanel, BorderLayout.SOUTH);
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        System.out.println("TEST 3");
    }

}
