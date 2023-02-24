package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.Serial;
import javax.swing.JPanel;


/**
 * Sets up the information side of the game GUI.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class InformationPanel extends JPanel {

    /**  A generated serial version UID for object Serialization. */
    @Serial
    private static final long serialVersionUID = -3071268708346186062L;

    /** Width constant. */
    private static final int INFO_PANEL_WIDTH = 400;

    /** Height constant. */
    private static final int INFO_PANEL_HEIGHT = 100;



    /**
     * Creates the panel where all info for player will be visible.
     */
    public InformationPanel() {
        super();
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(INFO_PANEL_WIDTH, INFO_PANEL_HEIGHT));

        final NextPiecePanel nextPiecePanel = new NextPiecePanel();
        this.add(nextPiecePanel, BorderLayout.NORTH);

        final ScoreInfoPanel scoreInfoPanel = new ScoreInfoPanel();
        this.add(scoreInfoPanel, BorderLayout.CENTER);

        final ExitPanel exitPanel = new ExitPanel();
        this.add(exitPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
