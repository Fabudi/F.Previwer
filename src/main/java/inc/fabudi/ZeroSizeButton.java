package inc.fabudi;

import javax.swing.*;
import java.awt.*;

public class ZeroSizeButton extends JButton {
    @Override public Dimension getPreferredSize() {
        return new Dimension();
    }
}