package view;


import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * MenuBar class creates the menubar for the game panel and
 * it's respective menu buttons.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class MenuBar extends JMenuBar {


    /** Width constant. */
    private static final int MENU_BAR_WIDTH = 30;

    /** Height constant. */
    private static final int MENU_BAR_HEIGHT = 30;

    /**
     * Creates the menubar and menu buttons to be used in the game panel.
     */
    public MenuBar() {
        super();
        final JMenu newGameMenuBtn = new JMenu("New Game");
        final JMenu menuBtn = new JMenu("Menu");
        final JMenu aboutMenuBtn = new JMenu("About");
        this.add(newGameMenuBtn);
        this.add(menuBtn);
        this.add(aboutMenuBtn);
        this.setPreferredSize(new Dimension(MENU_BAR_WIDTH, MENU_BAR_HEIGHT));
        this.setBackground(Color.CYAN);
        this.setVisible(true);
    }

}
