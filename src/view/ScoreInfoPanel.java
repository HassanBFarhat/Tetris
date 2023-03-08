package view;

import interfaces.BoardLayoutAndControls;
import model.Board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serial;
import javax.swing.JPanel;

/**
 * Class holds the score/high score panel of the information panel.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class ScoreInfoPanel extends JPanel implements PropertyChangeListener {

    /**  A generated serial version UID for object Serialization. */
    @Serial
    private static final long serialVersionUID = 6676899090276534542L;

    /** Width constant. */
    private static final int SCORE_WIDTH = 200;

    /** Height constant. */
    private static final int SCORE_HEIGHT = 255;

    /***/
    private BoardLayoutAndControls myBoard;


    /**
     * Sets up the panels for displaying score / high score.
     */
    public ScoreInfoPanel(final Board theBoard) {
        super();
        myBoard = theBoard;
        myBoard.addPropertyChangeListener(this);
        this.setLayout(new BorderLayout());

        final JPanel score = new JPanel();
        final JPanel highScore = new JPanel();

        score.setBackground(Color.GREEN);
        score.setPreferredSize(new Dimension(SCORE_WIDTH, SCORE_HEIGHT));
        highScore.setBackground(Color.GREEN);
        highScore.setPreferredSize(new Dimension(SCORE_WIDTH, SCORE_HEIGHT));

        this.add(score, BorderLayout.WEST);
        this.add(highScore, BorderLayout.EAST);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (Board.PROPERTY_CHANGED.equals(evt.getPropertyName())) {
            repaint();
        }
        repaint();
    }
}
