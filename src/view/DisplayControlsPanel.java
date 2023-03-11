package view;

import interfaces.BoardLayoutAndControls;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serial;
import javax.swing.*;
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
    private static final Font TEXT_FONT = new Font("IMPACT", Font.ITALIC, 22);

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

        JLabel leftKey = new JLabel("Move Left:     left arrow and 'a' and 'A' ", SwingConstants.CENTER);
        JLabel rightKey = new JLabel("Move Right:     right arrow and 'd' and 'D' ", SwingConstants.CENTER);
        JLabel rotateKey = new JLabel("Rotate:      up arrow and 'w' and 'W' ", SwingConstants.CENTER);
        JLabel downKey = new JLabel("Move Down:     down arrow and 's' and 'S' ", SwingConstants.CENTER);
        JLabel dropKey = new JLabel("Drop:       space", SwingConstants.CENTER);
        JLabel pauseKey = new JLabel("How to Pause:      esc to pause game ", SwingConstants.CENTER);

//        String left = "Move Left:     left arrow and 'a' and 'A' ";
//        String right = "Move Right:     right arrow and 'd' and 'D' " ;
//        String rotate = "Rotate:      up arrow and 'w' and 'W' ";
//        String down = "Move Down:     down arrow and 's' and 'S' ";
//        String drop = "Drop:      space ";

        rightKey.setFont(new java.awt.Font("IMPACT", Font.PLAIN, 20));
        leftKey.setFont(new java.awt.Font("IMPACT", Font.PLAIN, 20));
        rotateKey.setFont(new java.awt.Font("IMPACT",Font.PLAIN, 20));
        downKey.setFont(new java.awt.Font("IMPACT", Font.PLAIN, 20));
        dropKey.setFont(new java.awt.Font("IMPACT", Font.PLAIN, 20));
        pauseKey.setFont(new java.awt.Font("IMPACT", Font.PLAIN, 20));



//        leftKey.setText(left + "\r\n");
//        rightKey.setText(right + "\r\n");
//        rotateKey.setText(rotate + "\r\n");
//        downKey.setText(down + "\r\n");
//        dropKey.setText(drop + "\r\n");




        add(pauseKey);
        add(downKey);
        add(rightKey);
        add(leftKey);
        add(rotateKey);
        add(dropKey);


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
