package view;

import interfaces.BoardLayoutAndControls;
import model.Board;

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

    // instance fields

    /**  A generated serial version UID for object Serialization. */
    @Serial
    private static final long serialVersionUID = 5325683154823768841L;

    /** Width constant. */
    private static final int EXIT_WIDTH = 400;

    /** Height constant. */
    private static final int EXIT_HEIGHT = 250;

    /***/
    private BoardLayoutAndControls myBoard;


    // constructor

    /**
     * sets up panel where exit button will be.
     */
    public ExitPanel(final Board theBoard) {
        super();
        myBoard = theBoard;
        this.setBackground(Color.YELLOW);
        this.setPreferredSize(new Dimension(EXIT_WIDTH, EXIT_HEIGHT));
        this.setVisible(true);
    }

}
