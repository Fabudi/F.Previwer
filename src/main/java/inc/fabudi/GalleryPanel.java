package inc.fabudi;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class GalleryPanel extends JPanel {
    private final JTextField searchField;
    private final GridBox galleryGrid;
    private final ArrayList<GalleryItem> items = new ArrayList<>();

    GalleryPanel(String title, GalleryType galleryType) {
        setLayout(new BorderLayout());
        setBackground(Resources.LIGHT_GRAY);
        JPanel box = new JPanel(new GridLayout(2, 1));
        box.setOpaque(false);
        box.setAlignmentX(LEFT_ALIGNMENT);
        setBorder(Resources.border);
        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(Resources.WHITE);
        titleLabel.setFont(Resources.minecraft);
        titleLabel.setPreferredSize(new Dimension(titleLabel.getPreferredSize().width, 40));
        titleLabel.setBorder(new EmptyBorder(0, 0, 10, 0));
        box.add(titleLabel);
        searchField = new HintTextField("Search...");
        searchField.setBorder(Resources.border);
        searchField.setBackground(Resources.DARK_GRAY);
        searchField.setForeground(Resources.HALF_GRAY);
        searchField.setFont(Resources.minecraft);
        searchField.setPreferredSize(new Dimension(titleLabel.getPreferredSize().width, 40));

        searchField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                galleryGrid.removeAll();
                galleryGrid.updateElements(find(searchField.getText().toLowerCase()));
                galleryGrid.revalidate();
                galleryGrid.repaint();
            }
        });

        box.add(searchField);
        box.setPreferredSize(new Dimension(360, 120));
        box.setBorder(new EmptyBorder(20, 20, 20, 20));
        add(box, BorderLayout.NORTH);
        GridLayout galleryLayout = new GridLayout();
        galleryLayout.setColumns(2);
        galleryLayout.setRows(0);
        galleryLayout.setHgap(30);
        galleryLayout.setVgap(30);

        File dir = new File("C:\\Users\\evgen\\IdeaProjects\\F.Previwer\\src\\main\\resources\\images\\icons\\");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null && galleryType == GalleryType.ICONS) {
            for (File child : directoryListing) {
                try {
                    items.add(new GalleryItem(child.getName(), new ImageIcon(ImageIO.read(child))));
                } catch (IOException e) {
                    System.out.println("error: " + e);
                }
            }
        }
        galleryGrid = new GridBox(items);
        //items.forEach(item -> galleryGrid.add(item));
        JScrollPane scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBackground(Resources.LIGHT_GRAY);
        scrollPane.setViewportView(galleryGrid);
        scrollPane.setAlignmentY(TOP_ALIGNMENT);
        scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        scrollPane.setMaximumSize(new Dimension(360, 500));
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBackground(Resources.HALF_GRAY);
        scrollBar.setForeground(Resources.WHITE);
        scrollBar.setBorder(new EmptyBorder(2, 3, 2, 2));
        scrollBar.setUnitIncrement(50);
        scrollBar.setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Resources.WHITE;
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return new ZeroSizeButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return new ZeroSizeButton();
            }
        });
        scrollPane.setVerticalScrollBar(scrollBar);
        add(scrollPane, BorderLayout.CENTER);
        setMaximumSize(new Dimension(400, getMaximumSize().height));
        setBackground(Resources.LIGHT_GRAY);
    }

    private ArrayList<GalleryItem> find(String name) {
        return items.stream().filter(item -> item.getName().contains(name)).collect(Collectors.toCollection(ArrayList::new));
    }
}
