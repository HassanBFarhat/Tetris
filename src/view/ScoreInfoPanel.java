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
import javax.swing.JLabel;
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

    /** Stores the String for "IMPACT". */
    private static final String IMPACT = "IMPACT";

    /** Font used to display the message. */
    private static final Font TEXT_FONT = new Font(IMPACT, Font.ITALIC, 22);

    /** The value clearing 1 line. */
    private static final int LINE_1_POINTS = 40;

    /** The value clearing 2 lines. */
    private static final int LINE_2_POINTS = 100;

    /** The value clearing 3 lines. */
    private static final int LINE_3_POINTS = 300;

    /** The value clearing 4 lines. */
    private static final int LINE_4_POINTS = 1200;

    /** The value 1. */
    private static final int ONE = 1;

    /** The value 2. */
    private static final int TWO = 2;

    /** The value 3. */
    private static final int THREE = 3;

    /** The value 4. */
    private static final int FOUR = 4;

    /** The value 20. */
    private static final int TWENTY = 20;

    /** The Game Score. */
    private JLabel myGameScore;

    /** Lines cleared. */
    private JLabel myLinesCleared;

    /** The Current level. */
    private JLabel myCurrentLevel;

    /** The next level. */
    private JLabel myNextLevel;

    /** The number of cleared lines. */
    private int myLines;

    /** The score number. */
    private int myScore;

    /** The level number. */
    private int myGameLevel;

    /**  When the next level is.  */
    private int myNextGameLevel;

    /** The current level. */
    private int myCurrentIntLevel;

    /** The current score. */
    private int myIntScore;

    /** My frozen list of blocks on board. */
    private Integer[] myFrozenBlocks;

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
        scorePanelValues();

    }

    /**
     * Sets up starting values for the current game,
     * NOT SURE IF NEXT LEVEL IS SET UP RIGHT.
     */

    private void scorePanelValues() {

        myGameLevel = 1;
        myScore = 0;
        myLines = 0;
        myNextGameLevel = 2;

    }

    /**
     * Sets up the two panels current score,
     * and high score with the information needed.
     */

    private void setUpScorePanels() {
        final JPanel score = new JPanel();
        final JPanel highScore = new JPanel();
        score.setBackground(Color.GRAY);
        score.setPreferredSize(new Dimension(SCORE_WIDTH, SCORE_HEIGHT));
        highScore.setBackground(Color.GRAY);
        highScore.setPreferredSize(new Dimension(SCORE_WIDTH, SCORE_HEIGHT));
        this.add(score, BorderLayout.WEST);
        this.add(highScore, BorderLayout.EAST);

        final Border outerLine = BorderFactory.createLineBorder(Color.BLACK, 4, true);
        score.setBorder(BorderFactory.createTitledBorder(outerLine,
                "Current Score ", TitledBorder.CENTER,
                TitledBorder.BOTTOM, TEXT_FONT,
                Color.BLACK));
        final Color gold = new Color(255, 204, 51);

        highScore.setBorder(BorderFactory.createTitledBorder(outerLine,
                "High Score ", TitledBorder.CENTER,
                TitledBorder.BOTTOM, TEXT_FONT,
                gold));


        final JLabel gameScore = new JLabel("Score:  " + myScore);
        final JLabel linesCleared = new JLabel("Lines Cleared:  " + myLinesCleared);
        final JLabel currentLevel = new JLabel("Level:  " + myGameLevel + "     ");
        final JLabel nextLevel = new JLabel("Next Level: " + myNextGameLevel);

        final JLabel highLevel = new JLabel("Level: " + myGameLevel);
        final JLabel highLinesCleared = new JLabel("Lines Cleared: " + myLinesCleared);
        final JLabel highGameScore = new JLabel("Score:   " + myScore);

        highGameScore.setFont(new java.awt.Font(IMPACT, Font.PLAIN, TWENTY));
        highLinesCleared.setFont(new java.awt.Font(IMPACT, Font.PLAIN, TWENTY));
        highLevel.setFont(new java.awt.Font(IMPACT, Font.PLAIN, TWENTY));


        gameScore.setFont(new java.awt.Font(IMPACT, Font.PLAIN, TWENTY));
        linesCleared.setFont(new java.awt.Font(IMPACT, Font.PLAIN, TWENTY));
        currentLevel.setFont(new java.awt.Font(IMPACT, Font.PLAIN, TWENTY));
        nextLevel.setFont(new java.awt.Font(IMPACT, Font.PLAIN, TWENTY));

        final Color gold2 = new Color(255, 204, 51);


        highGameScore.setForeground(gold2);
        highLinesCleared.setForeground(gold2);
        highLevel.setForeground(gold2);

        score.add(gameScore);
        score.add(linesCleared);
        score.add(currentLevel);
        score.add(nextLevel);

        highScore.add(highGameScore);
        highScore.add(highLinesCleared);
        highScore.add(highLevel);

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
        myIntScore = calculateScore();
        repaint();
    }

    /**
     * Calculates the score a user gets once certain rows are cleared.
     *
     * @return integer value of new score
     */
    private int calculateScore() {
        final int linesCompleted = myFrozenBlocks.length;

        switch (linesCompleted) {
            case ONE:
                myScore += myCurrentIntLevel * LINE_1_POINTS;
                break;
            case TWO:
                myScore += myCurrentIntLevel * LINE_2_POINTS;
                break;
            case THREE:
                myScore += myCurrentIntLevel * LINE_3_POINTS;
                break;
            case FOUR:
                myScore += myCurrentIntLevel * LINE_4_POINTS;
                break;
            default:
                break;
        }
        return myScore;
    }
}
