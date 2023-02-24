package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 * Class holds the main game panel with menu bar.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class MainGamePanel extends JPanel {

    /** Width constant. */
    private static final int MENU_BAR_WIDTH = 30;

    /** Height constant. */
    private static final int MENU_BAR_HEIGHT = 30;


    /**
     * MainGamePanel Constructor allows the main panel and MenuBar to be set up.
     */
    public MainGamePanel() {
        super();
        this.setLayout(new BorderLayout());

        final JMenuBar menuBar = new JMenuBar();
        final JMenu newGameMenuBtn = new JMenu("New Game");
        final JMenu menuBtn = new JMenu("Menu");
        final JMenu aboutMenuBtn = new JMenu("About");
        menuBar.add(newGameMenuBtn);
        menuBar.add(menuBtn);
        menuBar.add(aboutMenuBtn);
        menuBar.setPreferredSize(new Dimension(MENU_BAR_WIDTH, MENU_BAR_HEIGHT));
        menuBar.setBackground(Color.CYAN);
        menuBar.setVisible(true);
        this.add(menuBar, BorderLayout.NORTH);

        final InformationPanel infoPanel = new InformationPanel();
        this.add(infoPanel, BorderLayout.EAST);

        final GameBoardPanel gameBoardPanel = new GameBoardPanel();
        this.add(gameBoardPanel, BorderLayout.CENTER);
    }
}
