package view;

import interfaces.BoardLayoutAndControls;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serial;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import model.Board;

/**
 * Sets up the exit panel the user can leave the game from.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class DisplayControlsPanel extends JPanel implements PropertyChangeListener {

    // static fields

    /** Font used to display the message. */
    private static final Font TEXT_FONT = new Font("IMPACT", Font.ITALIC, 18);

    /** Used to hold integer value for thickness of border. */
    private static final int THICKNESS = 4;


    // instance fields

    /**  A generated serial version UID for object Serialization. */
    @Serial
    private static final long serialVersionUID = 5325683154823768841L;

    /** Width constant. */
    private static final int EXIT_WIDTH = 400;

    /** Height constant. */
    private static final int EXIT_HEIGHT = 250;

    /***/
    private final BoardLayoutAndControls myBoard;


    // constructor

    /**
     * sets up panel where exit button will be.
     */
    public DisplayControlsPanel() {
        super();
        this.myBoard = new Board(EXIT_WIDTH, EXIT_HEIGHT);
        this.myBoard.addPropertyChangeListener(this);
        this.setBackground(Color.GRAY);
        this.setPreferredSize(new Dimension(EXIT_WIDTH, EXIT_HEIGHT));
        this.setVisible(true);

        controlsBorder();
    }

    /**
     * A border that wraps around the game controls panel
     * helps it look clean and differentiate from other panels.
     */
    private void controlsBorder() {
        final Border outerLine = BorderFactory.createLineBorder(Color.BLACK, THICKNESS, true);

        final TitledBorder namePanel = BorderFactory.createTitledBorder(outerLine,
                "Game Controls ", TitledBorder.CENTER,
                TitledBorder.BOTTOM, TEXT_FONT,
                Color.BLACK);


        setBorder(namePanel);
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        System.out.println("TEST 1");
    }
}
