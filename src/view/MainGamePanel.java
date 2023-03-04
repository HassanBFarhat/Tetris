package view;

import model.Board;
import model.BoardLayoutAndControls;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serial;
import javax.swing.*;

/**
 * Class holds the main game panel with menu bar.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class MainGamePanel extends JPanel {

    /**  A generated serial version UID for object Serialization. */
    @Serial
    private static final long serialVersionUID = 3714869667229553345L;

    /**The Board.*/
    private final BoardLayoutAndControls myBoard;


    /** This timer. */
    private final Timer myTimer;



    /**
     * MainGamePanel Constructor allows the main panel and MenuBar to be set up.
     */
    public MainGamePanel() {
        super();
        this.setLayout(new BorderLayout());

        this.myBoard = new Board();
        this.myTimer = new Timer(1000, this::handleTimer);

        addKeyListener(new ControlKeyListener());
        setFocusable(true);
        requestFocus();


        final MenuBar menuBar = new MenuBar();
        this.add(menuBar, BorderLayout.NORTH);

        final InformationPanel infoPanel = new InformationPanel();
        this.add(infoPanel, BorderLayout.EAST);

        final GameBoardPanel gameBoardPanel = new GameBoardPanel();
        this.add(gameBoardPanel, BorderLayout.CENTER);
    }

    private void handleTimer(final ActionEvent theEvent) {
        myBoard.step();
    }







    class ControlKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(final KeyEvent theEvent) {
            if (theEvent.getKeyCode() == KeyEvent.VK_S || theEvent.getKeyCode() == KeyEvent.VK_DOWN) {
                myBoard.down();
                System.out.println("down");
            } else if (theEvent.getKeyCode() == KeyEvent.VK_A || theEvent.getKeyCode() == KeyEvent.VK_LEFT) {
                myBoard.left();
                System.out.println("left");
            } else if (theEvent.getKeyCode() == KeyEvent.VK_D || theEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
                myBoard.right();
                System.out.println("right");
            } else if (theEvent.getKeyCode() == KeyEvent.VK_W || theEvent.getKeyCode() == KeyEvent.VK_UP) {
                myBoard.rotateCW();
                System.out.println("rotateCW");
            } else if (theEvent.getKeyCode() == KeyEvent.VK_SPACE) {
                myBoard.drop();
                System.out.println("drop");
            }
        }
    }




}
