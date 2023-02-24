package main;

import javax.swing.JFrame;
import view.MainGamePanel;

/**
 * This is the main window that'll hold/start our tetris game application.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public final class Application {

    /** Constant value for frame width. */
    private static final int FRAME_WIDTH = 800;

    /** Constant value for frame height. */
    private static final int FRAME_HEIGHT = 700;



    /** Private default constructor. */
    private Application() {

    }

    /**
     * This is the main method that'll run our tetris application.
     * @param theArgs allows us to run array of string arguments to
     *                be executed in our program.
     */
    public static void main(final String[] theArgs) {
        final JFrame gameFrame = new JFrame("Tetris");
        final MainGamePanel mainPanel = new MainGamePanel();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        gameFrame.setContentPane(mainPanel);
        gameFrame.setVisible(true);
    }

}
