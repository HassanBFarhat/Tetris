package main;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import model.Board;
import view.MainGamePanel;

/**
 * This is the Utility Class for kicking off main GUI window that'll
 * hold/start our tetris game application.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public final class Application {

    /** Constant value for frame width. */
    private static final int FRAME_WIDTH = 787;

    /** Constant value for frame height. */
    private static final int FRAME_HEIGHT = 810;

    /** Play area Width constant. */
    private static final int GAME_BOARD_WIDTH = 100;

    /** Play area Height constant. */
    private static final int GAME_BOARD_HEIGHT = 400;


    /** Private default constructor. */
    private Application() {

    }

    /**
     * This is the main method that'll run our tetris application.
     * @param theArgs allows us to run array of string arguments to
     *                be executed in our program.
     */
    public static void main(final String[] theArgs) throws UnsupportedAudioFileException,
            IOException, LineUnavailableException, URISyntaxException {
        final JFrame gameFrame = new JFrame("Tetris");
        final Board board = new Board(GAME_BOARD_WIDTH, GAME_BOARD_HEIGHT);
        final MainGamePanel mainPanel = new MainGamePanel(board);
        final URL f = Application.class.getClassLoader().getResource("music/TetrisMusic.wav");
        assert f != null;
        final File soundFile = new File(f.toURI());
        final AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
        final Clip audioClip = AudioSystem.getClip();
        audioClip.open(audioStream);
        audioClip.loop(Clip.LOOP_CONTINUOUSLY);
        audioClip.start();

        board.addPropertyChangeListener(mainPanel);

        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        gameFrame.setResizable(false);
        gameFrame.setContentPane(mainPanel);
        gameFrame.setVisible(true);
    }

}
