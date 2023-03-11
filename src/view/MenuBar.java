package view;


import interfaces.BoardLayoutAndControls;
import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serial;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import model.Board;


/**
 * MenuBar class creates the menubar for the game panel and
 * it's respective menu buttons.
 *
 * @author Hassan Farhat
 * @version Winter 2023
 */
public class MenuBar extends JMenuBar implements PropertyChangeListener {

    // static fields

    /**  A generated serial version UID for object Serialization. */
    @Serial
    private static final long serialVersionUID = -111659266189879540L;

    /** Width constant. */
    private static final int MENU_BAR_WIDTH = 30;

    /** Height constant. */
    private static final int MENU_BAR_HEIGHT = 30;


    // instance field

    /***/
    private final BoardLayoutAndControls myBoard;


    /**
     * Creates the menubar and menu buttons to be used in the game panel.
     */
    public MenuBar() {
        super();
        this.myBoard = new Board(MENU_BAR_WIDTH, MENU_BAR_HEIGHT);
        this.myBoard.addPropertyChangeListener(this);
        this.add(buildFileMenu());
        this.setPreferredSize(new Dimension(MENU_BAR_WIDTH, MENU_BAR_HEIGHT));
        this.setBackground(Color.GRAY);
        this.setVisible(true);
    }


    // private methods

    private JMenu buildFileMenu() {
        final JMenu fileMenu = new JMenu("File");
        fileMenu.add(buildMenuItem("New Game")).addActionListener(e -> myBoard.newGame());
        fileMenu.addSeparator();
        fileMenu.add(buildMenuItem("Exit")).addActionListener(e -> System.exit(0));
        fileMenu.addSeparator();
        fileMenu.add(buildMenuItem("About")).addActionListener(
                e -> JOptionPane.showMessageDialog(this, "THIS IS A TETRIS GAME ATTEMPT."));
        return fileMenu;
    }

    private JMenuItem buildMenuItem(final String theText) {
        return new JMenuItem(theText);
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        System.out.println("TEST 5");
    }

}
