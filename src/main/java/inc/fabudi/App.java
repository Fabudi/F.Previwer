package inc.fabudi;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * App class
 */
public class App extends JFrame {
    private final static int WIDTH = 1400, HEIGHT = 710;
    private final Container container;
    App() {
        container = getContentPane();
        init();
        initUI();
    }

    private void init() {
        setSize(WIDTH, HEIGHT);
        setLocation((getToolkit().getScreenSize().width - WIDTH) / 2,
                (getToolkit().getScreenSize().height - HEIGHT) / 2);
        setTitle("F.Previewer");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initUI(){
        Box box = Box.createHorizontalBox();
        box.setBackground(Resources.DARK_GRAY);
        box.add(new GalleryPanel("Images", GalleryType.IMAGES), BorderLayout.WEST);
        box.add(new BlocksPanel(), BorderLayout.CENTER);
        box.add(new GalleryPanel("Icons", GalleryType.ICONS), BorderLayout.EAST);
        box.setBorder(new EmptyBorder(50,50,50,50));
        container.setBackground(Resources.DARK_GRAY);
        container.add(box);
        setVisible(true);
    }

}
