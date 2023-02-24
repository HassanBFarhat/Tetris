package view;

import java.awt.Color;
import java.awt.Dimension;
import java.io.Serial;
import javax.swing.JPanel;

/**
 * Class holds the next piece panel with on the info panel.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class NextPiecePanel extends JPanel {

    /**  A generated serial version UID for object Serialization. */
    @Serial
    private static final long serialVersionUID = -3254087614079880441L;

    /** Width constant. */
    private static final int NEXT_PIECE_WIDTH = 400;

    /** Height constant. */
    private static final int NEXT_PIECE_HEIGHT = 205;


    /**
     * Sets up the next piece panel to display next piece to user.
     */
    public NextPiecePanel() {
        super();
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension(NEXT_PIECE_WIDTH, NEXT_PIECE_HEIGHT));
        this.setVisible(true);
    }

}
