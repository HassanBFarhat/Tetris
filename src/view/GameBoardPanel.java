package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Sets up the Game board where player will see and play the game.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class GameBoardPanel extends JPanel {

    /** Width constant. */
    private static final int GAME_BOARD_WIDTH = 400;

    /** Height constant. */
    private static final int GAME_BOARD_HEIGHT = 100;


    /**
     * Constructor sets up the panel for the game board.
     */
    public GameBoardPanel() {
        super();
        this.setBackground(Color.RED);
        this.setPreferredSize(new Dimension(GAME_BOARD_WIDTH, GAME_BOARD_HEIGHT));
        this.setVisible(true);
    }
}
