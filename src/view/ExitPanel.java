package view;

import java.awt.Color;
import java.awt.Dimension;
import java.io.Serial;
import javax.swing.JPanel;

/**
 * Sets up the exit panel the user can leave the game from.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class ExitPanel extends JPanel {

    /**  A generated serial version UID for object Serialization. */
    @Serial
    private static final long serialVersionUID = 5325683154823768841L;

    /** Width constant. */
    private static final int EXIT_WIDTH = 400;

    /** Height constant. */
    private static final int EXIT_HEIGHT = 210;


    /**
     * sets up panel where exit button will be.
     */
    public ExitPanel() {
        super();
        this.setBackground(Color.GREEN);
        this.setPreferredSize(new Dimension(EXIT_WIDTH, EXIT_HEIGHT));
        this.setVisible(true);
    }

}
