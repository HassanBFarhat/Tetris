package view;


import java.awt.Color;
import java.awt.Dimension;
import java.io.Serial;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * MenuBar class creates the menubar for the game panel and
 * it's respective menu buttons.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class MenuBar extends JMenuBar {

    /**  A generated serial version UID for object Serialization. */
    @Serial
    private static final long serialVersionUID = -111659266189879540L;

    /** Width constant. */
    private static final int MENU_BAR_WIDTH = 30;

    /** Height constant. */
    private static final int MENU_BAR_HEIGHT = 30;


    /**
     * Creates the menubar and menu buttons to be used in the game panel.
     */
    public MenuBar() {
        super();
        this.add(buildFileMenu());
        this.setPreferredSize(new Dimension(MENU_BAR_WIDTH, MENU_BAR_HEIGHT));
        this.setBackground(Color.CYAN);
        this.setVisible(true);
    }


    private JMenu buildFileMenu() {
        final JMenu fileMenu = new JMenu("File");
        fileMenu.add(buildMenuItem("New Game"));
        fileMenu.addSeparator();
        fileMenu.add(buildMenuItem("Exit"));
        fileMenu.addSeparator();
        fileMenu.add(buildMenuItem("About"));
        return fileMenu;
    }

    private JMenuItem buildMenuItem(final String theText) {
        final JMenuItem menuItem = new JMenuItem(theText);
        menuItem.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "This will do something soon."));
        return menuItem;
    }

}
