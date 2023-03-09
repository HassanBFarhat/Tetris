package view;

import static interfaces.PropertyChangeGamePieces.PROPERTY_CHANGED;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serial;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import model.Board;
import interfaces.BoardLayoutAndControls;
import model.Rotation;
import model.TetrisPiece;


/**
 * Class holds the next piece panel with on the info panel.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class NextPiecePanel extends JPanel implements PropertyChangeListener {

    //instance fields

    /**  A generated serial version UID for object Serialization. */
    @Serial
    private static final long serialVersionUID = -3254087614079880441L;

    /** Width constant. */
    private static final int NEXT_PIECE_WIDTH = 400;

    /** Height constant. */
    private static final int NEXT_PIECE_HEIGHT = 205;

    /** TestPiece X coordinate value. */
    private static final int X_COOR_VALUE = 50;

    /** TestPiece Y coordinate value. */
    private static final int Y_COOR_VALUE = 50;

    /** The width for the rectangle. */
    private static final int RECTANGLE_WIDTH = 37;

    /** The height for the rectangle. */
    private static final int RECTANGLE_HEIGHT = 37;



    /** This TEST PIECE. */
    private RectangularShape myTestPiece;


    /**NEXT PIECE*/
    private TetrisPiece myNextPiece;

    /**The Board.*/
    private final BoardLayoutAndControls myBoard;

    /** Font used to display the message. */
    private static final Font TEXT_FONT = new Font("IMPACT", Font.ITALIC, 18);


    // constructor

    /**
     * Sets up the next piece panel to display next piece to user.
     */
    public NextPiecePanel(final Board theBoard) {
        super();
        myBoard = theBoard;
        myBoard.addPropertyChangeListener(this);
//        myTestPiece = new Rectangle2D.Double(0, 0,
//                RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension(NEXT_PIECE_WIDTH, NEXT_PIECE_HEIGHT));
        this.setVisible(true);

        nextPieceBorder();

    }


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

        myNextPiece = TetrisPiece.getRandomPiece();
        int[][] nextPiecePoints = myNextPiece.getPointsByRotation(Rotation.random());

        for (int i = 0; i < nextPiecePoints.length; i++) {
            for (int j = 0; j < nextPiecePoints[i].length - 1; j++) {
                g2d.setPaint(Color.PINK);
                g2d.fill(new Rectangle2D.Double(nextPiecePoints[i][j] * RECTANGLE_WIDTH + 1 + (this.getWidth() / 2 - 65),
                        nextPiecePoints[i][j + 1] * RECTANGLE_WIDTH + (this.getHeight() / 2 - 60),
                        RECTANGLE_WIDTH, RECTANGLE_HEIGHT));

                g2d.setPaint(Color.BLACK);
                g2d.draw(new Rectangle2D.Double(nextPiecePoints[i][j] * RECTANGLE_WIDTH + 1 + + (this.getWidth() / 2 - 65),
                        nextPiecePoints[i][j + 1] * RECTANGLE_WIDTH - 1 + + (this.getHeight() / 2 - 60),
                        RECTANGLE_WIDTH , RECTANGLE_HEIGHT ));
            }
        }

    }

    /**
     * A border that wraps around the next piece panel
     * helps it look clean and differentiate from other panels.
     */
    private void nextPieceBorder(){
        final int thickness = 4;
        final Border outerLine = BorderFactory.createLineBorder(Color.MAGENTA, thickness, true);

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
        if (PROPERTY_CHANGED.equals(theEvent.getPropertyName())) {
            // TODO: Need to implement what happens to update the board.
            final Point location = (Point) theEvent.getNewValue();

            myTestPiece.setFrame(location.getX() * RECTANGLE_WIDTH,
                    location.getY() * RECTANGLE_HEIGHT,
                    RECTANGLE_WIDTH, RECTANGLE_HEIGHT);

            repaint();
        }
    }

}
