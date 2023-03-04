package view;

import static model.PropertyChangeGamePieces.PROPERTY_CHANGED;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serial;
import javax.swing.JPanel;
import model.Board;
import model.BoardLayoutAndControls;

/**
 * Sets up the Game board where player will see and play the game.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class GameBoardPanel extends JPanel implements PropertyChangeListener {

    // instance fields

    /**  A generated serial version UID for object Serialization. */
    @Serial
    private static final long serialVersionUID = 7129745753499709311L;

    /** Width constant. */
    private static final int GAME_BOARD_WIDTH = 100;

    /** Height constant. */
    private static final int GAME_BOARD_HEIGHT = 400;

    /** The width for the rectangle. */
    private static final int RECTANGLE_WIDTH = 37;

    /** The height for the rectangle. */
    private static final int RECTANGLE_HEIGHT = 37;

    /** This Board. */
    private final BoardLayoutAndControls myBoard;

    /** This TEST PIECE. */
    private final RectangularShape myTestPiece;


    // constructor

    /**
     * Constructor sets up the panel for the game board.
     */
    public GameBoardPanel() {
        super();

        this.myBoard = new Board(GAME_BOARD_WIDTH, GAME_BOARD_HEIGHT);
        myTestPiece = new Ellipse2D.Double(0, 0, RECTANGLE_WIDTH, RECTANGLE_HEIGHT);

        myBoard.addPropertyChangeListener(this);


        this.setBackground(Color.RED);
        this.setPreferredSize(new Dimension(GAME_BOARD_WIDTH, GAME_BOARD_HEIGHT));
        this.setVisible(true);
    }

    // public methods

    /**
     * Helps to draw the game board grid layout and display a
     * TEST PIECE on the board.
     *
     * @param theGraphics the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setPaint(Color.BLACK);
        for (int row = 0; row < myBoard.getHeight(); row++) {
            for (int col = 0; col < myBoard.getWidth(); col++) {
                g2d.draw(new Rectangle2D.Double(col * RECTANGLE_WIDTH,
                        row * RECTANGLE_HEIGHT + 1,
                        RECTANGLE_WIDTH,
                        RECTANGLE_HEIGHT));
            }
        }

        g2d.setPaint(Color.GREEN);
        g2d.fill(myTestPiece);
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
