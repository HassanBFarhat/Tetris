package view;

import java.awt.BorderLayout;
import java.io.Serial;
import javax.swing.JPanel;

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

    /**
     * MainGamePanel Constructor allows the main panel and MenuBar to be set up.
     */
    public MainGamePanel() {
        super();
        this.setLayout(new BorderLayout());

        final MenuBar menuBar = new MenuBar();
        this.add(menuBar, BorderLayout.NORTH);

        final InformationPanel infoPanel = new InformationPanel();
        this.add(infoPanel, BorderLayout.EAST);

        final GameBoardPanel gameBoardPanel = new GameBoardPanel();
        this.add(gameBoardPanel, BorderLayout.CENTER);
    }
}
