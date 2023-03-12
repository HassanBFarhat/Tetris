package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.Serial;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


/**
 * Sets up the exit panel the user can leave the game from.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class DisplayControlsPanel extends JPanel {

    // static fields

    /** String word "Impact". */
    private static final String IMPACT = "IMPACT";

    /** Font used to display the message. */
    private static final Font TEXT_FONT = new Font(IMPACT, Font.ITALIC, 22);

    /** Used to hold integer value for thickness of border. */
    private static final int THICKNESS = 4;

    /** Stores the number 20. */
    private static final int TWENTY = 20;


    // instance fields

    /**  A generated serial version UID for object Serialization. */
    @Serial
    private static final long serialVersionUID = 5325683154823768841L;

    /** Width constant. */
    private static final int EXIT_WIDTH = 400;

    /** Height constant. */
    private static final int EXIT_HEIGHT = 250;


    // constructor

    /**
     * sets up panel where exit button will be.
     */
    public DisplayControlsPanel() {
        super();
        this.setBackground(Color.GRAY);
        this.setPreferredSize(new Dimension(EXIT_WIDTH, EXIT_HEIGHT));
        this.setVisible(true);

        controlsBorder();
        controlsLabelSetUp();
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

    private void controlsLabelSetUp() {
        final JLabel leftKey = new JLabel("Move Left:     left arrow and 'a' and 'A' ");
        final JLabel rightKey = new JLabel("Move Right:     right arrow and 'd' and 'D' ");
        final JLabel rotateKey = new JLabel("Rotate:      up arrow and 'w' and 'W' ");
        final JLabel downKey = new JLabel("Move Down:     down arrow and 's' and 'S' ");
        final JLabel dropKey = new JLabel("Drop:       space");
        final JLabel pauseKey = new JLabel("How to Pause:      esc to pause game ");


        rightKey.setFont(new java.awt.Font(IMPACT, Font.PLAIN, TWENTY));
        leftKey.setFont(new java.awt.Font(IMPACT, Font.PLAIN, TWENTY));
        rotateKey.setFont(new java.awt.Font(IMPACT, Font.PLAIN, TWENTY));
        downKey.setFont(new java.awt.Font(IMPACT, Font.PLAIN, TWENTY));
        dropKey.setFont(new java.awt.Font(IMPACT, Font.PLAIN, TWENTY));
        pauseKey.setFont(new java.awt.Font(IMPACT, Font.PLAIN, TWENTY));


        add(pauseKey);
        add(downKey);
        add(rightKey);
        add(leftKey);
        add(rotateKey);
        add(dropKey);
    }

}
