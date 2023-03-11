package view;

import static interfaces.BoardLayoutAndControls.PROPERTY_CHANGED;

import interfaces.BoardLayoutAndControls;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serial;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import model.Board;
import model.Rotation;
import model.TetrisPiece;


/**
 * Class holds the next piece panel with on the info panel.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class NextPiecePanel extends JPanel implements PropertyChangeListener {

    // static fields

    /**  A generated serial version UID for object Serialization. */
    @Serial
    private static final long serialVersionUID = -3254087614079880441L;

    /** Width constant. */
    private static final int NEXT_PIECE_WIDTH = 400;

    /** Height constant. */
    private static final int NEXT_PIECE_HEIGHT = 205;

    /** The width for the rectangle. */
    private static final int RECTANGLE_WIDTH = 37;

    /** The height for the rectangle. */
    private static final int RECTANGLE_HEIGHT = 37;

    /** Stores the number 2. */
    private static final int TWO = 2;

    /** Stores the number 60. */
    private static final int SIXTY = 60;

    /** Stores the number 65. */
    private static final int SIXTY_FIVE = 65;


    /** Font used to display the message. */
    private static final Font TEXT_FONT = new Font("IMPACT", Font.ITALIC, 18);

    /** Used to hold integer value for thickness of border. */
    private static final int THICKNESS = 4;


    // instance fields

    /** Piece to be drawn in next piece display panel.*/
    private TetrisPiece myNextPiece;

    /** Stores the shape of the square to be filled on the display panel. */
    private RectangularShape myShape;

    /** Stores the outline of myShape to be drawn on the display panel. */
    private RectangularShape myShapeOutline;

    /** Stores reference to the board. */
    private final BoardLayoutAndControls myBoard;


    // constructor

    /**
     * Sets up the next piece panel to display next piece to user.
     */
    public NextPiecePanel() {
        super();
        this.myBoard = new Board(NEXT_PIECE_WIDTH, NEXT_PIECE_HEIGHT);
        this.myBoard.addPropertyChangeListener(this);
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension(NEXT_PIECE_WIDTH, NEXT_PIECE_HEIGHT));
        this.setVisible(true);

        nextPieceBorder();
    }


    // methods

    /**
     * Helps to draw the next game piece (right now just TestPiece)
     * on the NextPiece display panel.
     *
     * @param theGraphics the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Stores piece that will be displayed in panel.
        myNextPiece = TetrisPiece.getRandomPiece();
        // Obtains the points of the blocks at given random rotation.
        final int[][] nextPiecePoints = myNextPiece.getPointsByRotation(Rotation.random());

        // Draws out the shape and shapes outline for the next piece to be played.
        for (final int[] nextPiecePoint : nextPiecePoints) {
            for (int j = 0; j < nextPiecePoint.length - 1; j++) {
                g2d.setPaint(Color.PINK);
                myShape = new Rectangle2D.Double(
                        nextPiecePoint[j] * RECTANGLE_WIDTH
                                + ((float) this.getWidth() / TWO - SIXTY_FIVE) + 1,
                        nextPiecePoint[j + 1] * RECTANGLE_WIDTH
                                + ((float) this.getHeight() / TWO - SIXTY),
                        RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
                g2d.fill(myShape);

                g2d.setPaint(Color.BLACK);
                myShapeOutline = new Rectangle2D.Double(
                        nextPiecePoint[j] * RECTANGLE_WIDTH
                                + ((float) this.getWidth() / TWO - SIXTY_FIVE) + 1,
                        nextPiecePoint[j + 1] * RECTANGLE_WIDTH
                                - 1 + ((float) this.getHeight() / TWO - SIXTY),
                        RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
                g2d.draw(myShapeOutline);
            }
        }

    }

    /**
     * A border that wraps around the next piece panel
     * helps it look clean and differentiate from other panels.
     */
    private void nextPieceBorder() {
        final Border outerLine = BorderFactory.createLineBorder(Color.MAGENTA,
                THICKNESS, true);

        final TitledBorder namePanel = BorderFactory.createTitledBorder(outerLine,
                "Next Piece ", TitledBorder.CENTER,
                TitledBorder.BOTTOM, TEXT_FONT,
                Color.MAGENTA);


        setBorder(namePanel);
    }


    /**
     * Once a certain property is changed within the model, a propertyChange
     * is fired and game board is updated.
     *
     * @param theEvent A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        System.out.println("TEST 6");
        if (PROPERTY_CHANGED.equals(theEvent.getPropertyName())) {
            repaint();
        }
    }

}
