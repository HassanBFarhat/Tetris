package view;

import interfaces.BoardLayoutAndControls;
import model.Board;

import java.awt.*;
import java.io.Serial;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

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
    private static final int EXIT_HEIGHT = 210;

    /***/
    private BoardLayoutAndControls myBoard;

    /** Font used to display the message. */
    private static final Font Text_FONT = new Font("IMPACT", Font.ITALIC, 18);


    // constructor

    /**
     * sets up panel where exit button will be.
     */
    public ExitPanel(final Board theBoard) {
        super();
        myBoard = theBoard;
        this.setBackground(Color.GREEN);
        this.setPreferredSize(new Dimension(EXIT_WIDTH, EXIT_HEIGHT));
        this.setVisible(true);

        controlsBorder();
    }
    /**
     * A border that wraps around the game controls panel
     * helps it look clean and differentiate from other panels.
     */
    private void controlsBorder(){
        final int thickness = 4;
        final Border outerLine = BorderFactory.createLineBorder(Color.BLACK, thickness, true);

        final TitledBorder namePanel = BorderFactory.createTitledBorder(outerLine,
                "Game Controls ", TitledBorder.CENTER,
                TitledBorder.BOTTOM, Text_FONT,
                Color.BLACK);


        setBorder(namePanel);
    }

}
