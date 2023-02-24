package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Sets up the exit panel the user can leave the game from.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class ExitPanel extends JPanel {


    /** Width constant. */
    private static final int EXIT_WIDTH = 400;

    /** Height constant. */
    private static final int EXIT_HEIGHT = 210;

    /**
     * sets up panel where exit button will be.
     */
    public ExitPanel() {
        super();
        this.setBackground(Color.MAGENTA);
        this.setPreferredSize(new Dimension(EXIT_WIDTH, EXIT_HEIGHT));
        this.setVisible(true);
    }

}
