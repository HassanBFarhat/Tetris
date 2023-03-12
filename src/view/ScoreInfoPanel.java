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
    private static final Font TEXT_FONT = new Font("IMPACT", Font.ITALIC, 22);

    /** The Game Score */
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


        JLabel gameScore = new JLabel("Score:   " + myScore);
        JLabel linesCleared = new JLabel("Lines Cleared: " + myLinesCleared);
        JLabel currentLevel = new JLabel("Level: " + myGameLevel + "     ");
        JLabel nextLevel = new JLabel("Next Level: " + myNextGameLevel);

        JLabel highLevel = new JLabel("Level: " + myGameLevel);
        JLabel highLinesCleared = new JLabel("Lines Cleared: " + myLinesCleared);
        JLabel highGameScore = new JLabel("Score:   " + myScore);

        highGameScore.setFont(new java.awt.Font("IMPACT", Font.PLAIN, 20));
        highLinesCleared.setFont(new java.awt.Font("IMPACT", Font.PLAIN, 20));
        highLevel.setFont(new java.awt.Font("IMPACT",Font.PLAIN, 20));


        gameScore.setFont(new java.awt.Font("IMPACT", Font.PLAIN, 20));
        linesCleared.setFont(new java.awt.Font("IMPACT", Font.PLAIN, 20));
        currentLevel.setFont(new java.awt.Font("IMPACT",Font.PLAIN, 20));
        nextLevel.setFont(new java.awt.Font("IMPACT", Font.PLAIN, 20));

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



//    private void score() {
//
//        final Box box = Box.createVerticalBox();
//
//        myGameScore = new JLabel("Score: " + myScore);
//        myLinesCleared = new JLabel("Lines Cleared: " + myLines);
//        myCurrentLevel = new JLabel(" Current Level: " + myGameLevel);
//        myNextLevel = new JLabel("Next Level: " + myNextGameLevel);
//
//        myGameScore.setAlignmentX(Component.LEFT_ALIGNMENT);
//        myLinesCleared.setAlignmentX(Component.LEFT_ALIGNMENT);
//        myCurrentLevel.setAlignmentX(Component.LEFT_ALIGNMENT);
//        myNextLevel.setAlignmentX(Component.LEFT_ALIGNMENT);
//
//
//        myGameScore.setForeground(Color.WHITE);
//        myLinesCleared.setForeground(Color.WHITE);
//        myCurrentLevel.setForeground(Color.WHITE);
//        myNextLevel.setForeground(Color.WHITE);
//
//
//        box.add(myGameScore);
//        box.add(myLinesCleared);
//        box.add(myCurrentLevel);
//        box.add(myNextLevel);
//
//
//        add(box);
//    }


    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        System.out.println("TEST 7");
        if (Board.PROPERTY_CHANGED.equals(theEvent.getPropertyName())) {
            repaint();
        }
        repaint();
    }
}
