package view;

import interfaces.BoardLayoutAndControls;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.Serial;
import javax.swing.JPanel;
import model.Board;

/**
 * Sets up the information side of the game GUI.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class InformationPanel extends JPanel {

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

    /** Stores reference to next piece panel. */
    private NextPiecePanel myNextPiecePanel;

    /** Stores reference to score panel. */
    private ScoreInfoPanel myScoreInfoPanel;



    // constructor

    /**
     * Creates the panel where all info for player will be visible.
     */
    public InformationPanel() {
        super();
        this.myBoard = new Board(INFO_PANEL_WIDTH, INFO_PANEL_HEIGHT);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(INFO_PANEL_WIDTH, INFO_PANEL_HEIGHT));
        this.setUpInfoPanel();
        this.setVisible(true);
    }

    /** Sets up all the panels required for the info panel. */
    private void setUpInfoPanel() {
        this.myNextPiecePanel = new NextPiecePanel();
        this.myBoard.addPropertyChangeListener(myNextPiecePanel);
        this.add(myNextPiecePanel, BorderLayout.NORTH);

        myScoreInfoPanel = new ScoreInfoPanel();
        this.myBoard.addPropertyChangeListener(myScoreInfoPanel);
        this.add(myScoreInfoPanel, BorderLayout.CENTER);

        final DisplayControlsPanel displayControlsPanel = new DisplayControlsPanel();
        this.add(displayControlsPanel, BorderLayout.SOUTH);
    }

}
