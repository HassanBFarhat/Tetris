package view;

import static interfaces.BoardLayoutAndControls.PROPERTY_CHANGED;

import interfaces.BoardLayoutAndControls;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serial;
import javax.swing.JPanel;
import model.Board;
import model.MovableTetrisPiece;
import model.Rotation;
import model.TetrisPiece;


/**
 * Sets up the Game board where player will see and play the game.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class GameBoardPanel extends JPanel implements PropertyChangeListener {

    // static fields

    /**  A generated serial version UID for object Serialization. */
    @Serial
    private static final long serialVersionUID = 7129745753499709311L;

    /** Stores the number 3. */
    private static final int THREE = 3;


    // instance fields

    /** Width constant. */
    private static final int GAME_BOARD_WIDTH = 100;

    /** Height constant. */
    private static final int GAME_BOARD_HEIGHT = 400;

    /** GameGrid Number of Rows. */
    private static final int GAME_BOARD_ROWS = 20;

    /** GameGrid Number of Columns. */
    private static final int GAME_BOARD_COLS = 10;

    /** The width for the rectangle. */
    private static final int RECTANGLE_WIDTH = 37;

    /** The height for the rectangle. */
    private static final int RECTANGLE_HEIGHT = 37;


    /** This is reference to the Board. */
    private final BoardLayoutAndControls myBoard;

    /** Piece to be drawn on Board. */
    private MovableTetrisPiece myMoveablePiece;

    /** Stores the shape of the square to be filled on the board. */
    private RectangularShape myShape;

    /** Stores the outline of myShape to be drawn on the board. */
    private RectangularShape myShapeOutline;


    // constructor

    /**
     * Constructor sets up the panel for the game board.
     */
    public GameBoardPanel() {
        super();
        this.myBoard = new Board(GAME_BOARD_WIDTH, GAME_BOARD_HEIGHT);
        this.myBoard.addPropertyChangeListener(this);
        this.setUpKeyListener();
        this.setBackground(Color.WHITE);
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

        // Draws out the grid of the game board.
        g2d.setPaint(Color.BLACK);
        for (int row = 0; row < GAME_BOARD_ROWS; row++) {
            for (int col = 0; col < GAME_BOARD_COLS; col++) {
                g2d.draw(new Rectangle2D.Double(col * RECTANGLE_WIDTH + 1,
                        row * RECTANGLE_HEIGHT - 1,
                        RECTANGLE_WIDTH,
                        RECTANGLE_HEIGHT));
            }
        }

        // Stores piece to be played on the board.
        myMoveablePiece = new MovableTetrisPiece(TetrisPiece.getRandomPiece(),
                new model.Point(RECTANGLE_WIDTH * THREE, 0),
                Rotation.random());
        // Obtains the points of the blocks at given random rotation.
        final int[][] nextCurrPiecePoints =
                myMoveablePiece.getTetrisPiece().getPointsByRotation(Rotation.random());

        // Draws out the shape and shapes outline for the given piece to be played.
        for (final int[] nextCurrPiecePoint : nextCurrPiecePoints) {
            for (int j = 0; j < nextCurrPiecePoint.length - 1; j++) {
                g2d.setPaint(Color.MAGENTA);
                myShape = new Rectangle2D.Double(nextCurrPiecePoint[j] * RECTANGLE_WIDTH + 1,
                        nextCurrPiecePoint[j + 1] * RECTANGLE_WIDTH,
                        RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
                g2d.fill(myShape);

                g2d.setPaint(Color.BLACK);
                myShapeOutline = new Rectangle2D.Double(
                        nextCurrPiecePoint[j] * RECTANGLE_WIDTH + 1,
                        nextCurrPiecePoint[j + 1] * RECTANGLE_WIDTH - 1,
                        RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
                g2d.draw(myShapeOutline);
            }
        }
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
            System.out.println("TEST 2");
            final model.Point location = (model.Point) theEvent.getNewValue();
            myShape.setFrame(location.x() * RECTANGLE_WIDTH,
                    location.y() * RECTANGLE_HEIGHT,
                    RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
            myShapeOutline.setFrame(location.x() * RECTANGLE_WIDTH,
                    location.y() * RECTANGLE_HEIGHT,
                    RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
            repaint();
        }
    }

    /** Sets up the focusable and adds key listener to innerclass. */
    private void setUpKeyListener() {
        this.addKeyListener(new ControlKeyListener());
        this.setFocusable(true);
        this.requestFocusInWindow();
    }


    // inner class

    /**
     * Inner class that helps to determine the key event and what to do
     * when a certain key is pressed.
     *
     * @author Hassan Farhat
     * @version Winter 2023
     */
    protected final class ControlKeyListener extends KeyAdapter {

        /** Private constructor to satisfy PMD. */
        private ControlKeyListener() { super(); }

        @Override
        public void keyPressed(final KeyEvent theEvent) {
            if (theEvent.getKeyCode() == KeyEvent.VK_S
                    || theEvent.getKeyCode() == KeyEvent.VK_DOWN) {
                myBoard.down();
                System.out.println("down");
            } else if (theEvent.getKeyCode() == KeyEvent.VK_A
                    || theEvent.getKeyCode() == KeyEvent.VK_LEFT) {
                myBoard.left();
                System.out.println("left");
            } else if (theEvent.getKeyCode() == KeyEvent.VK_D
                    || theEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
                myBoard.right();
                System.out.println("right");
            } else if (theEvent.getKeyCode() == KeyEvent.VK_W
                    || theEvent.getKeyCode() == KeyEvent.VK_UP) {
                myBoard.rotateCW();
                System.out.println("rotateCW");
            } else if (theEvent.getKeyCode() == KeyEvent.VK_SPACE) {
                myBoard.drop();
                System.out.println("drop");
            }
        }
    }

}
