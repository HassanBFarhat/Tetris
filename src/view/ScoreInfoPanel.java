package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Class holds the score/high score panel of the information panel.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class ScoreInfoPanel extends JPanel {

    /** Width constant. */
    private static final int SCORE_WIDTH = 200;

    /** Height constant. */
    private static final int SCORE_HEIGHT = 255;

    /**
     * Sets up the panels for displaying score / high score.
     */
    public ScoreInfoPanel() {
        super();
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
}
