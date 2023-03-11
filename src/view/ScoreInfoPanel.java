package view;

import interfaces.BoardLayoutAndControls;
import java.awt.BorderLayout;
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
 * Class holds the score/high score panel of the information panel.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class ScoreInfoPanel extends JPanel implements PropertyChangeListener {

    // static fields

    /**  A generated serial version UID for object Serialization. */
    @Serial
    private static final long serialVersionUID = 6676899090276534542L;

    /** Width constant. */
    private static final int SCORE_WIDTH = 200;

    /** Height constant. */
    private static final int SCORE_HEIGHT = 255;

    /** Font used to display the message. */
    private static final Font TEXT_FONT = new Font("IMPACT", Font.ITALIC, 18);


    // instance field

    /** Reference to the Board. */
    private final BoardLayoutAndControls myBoard;


    // constructor

    /**
     * Sets up the panels for displaying score / high score.
     * Added border to separate current score / high score.
     */
    public ScoreInfoPanel() {
        super();
        this.myBoard = new Board(SCORE_WIDTH, SCORE_HEIGHT);
        this.myBoard.addPropertyChangeListener(this);
        this.setLayout(new BorderLayout());

        setUpScorePanels();
    }

    private void setUpScorePanels() {
        final JPanel score = new JPanel();
        final JPanel highScore = new JPanel();
        score.setBackground(Color.GREEN);
        score.setPreferredSize(new Dimension(SCORE_WIDTH, SCORE_HEIGHT));
        highScore.setBackground(Color.CYAN);
        highScore.setPreferredSize(new Dimension(SCORE_WIDTH, SCORE_HEIGHT));
        this.add(score, BorderLayout.WEST);
        this.add(highScore, BorderLayout.EAST);

        final Border outerLine = BorderFactory.createLineBorder(Color.BLACK, 4, true);
        score.setBorder(BorderFactory.createTitledBorder(outerLine,
                "Current Score ", TitledBorder.CENTER,
                TitledBorder.BOTTOM, TEXT_FONT,
                Color.BLACK));

        highScore.setBorder(BorderFactory.createTitledBorder(outerLine,
                "High Score ", TitledBorder.CENTER,
                TitledBorder.BOTTOM, TEXT_FONT,
                Color.BLACK));
    }


    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        System.out.println("TEST 7");
        if (Board.PROPERTY_CHANGED.equals(theEvent.getPropertyName())) {
            repaint();
        }
        repaint();
    }
}
