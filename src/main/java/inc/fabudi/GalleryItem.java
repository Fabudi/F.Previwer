package inc.fabudi;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GalleryItem extends JLabel {
    private final String name;

    public GalleryItem(String name, Icon icon) {
        setBackground(Resources.DARK_GRAY);
        setOpaque(true);
        setBorder(Resources.border);
        setIcon(icon);
        this.name = name.toLowerCase().trim().replace(".png", "").replaceAll("-", " ");
        addMouseListener(mouseListener);
    }

    MouseListener mouseListener = new MouseListener(){

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setBackground(Resources.HALF_GRAY);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setBackground(Resources.DARK_GRAY);
        }
    };

    @Override
    public String getName() {
        return name;
    }
}
