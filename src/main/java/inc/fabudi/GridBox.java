package inc.fabudi;

import javax.swing.*;
import java.util.ArrayList;

public class GridBox extends Box {

    public GridBox(ArrayList<GalleryItem> items) {
        super(BoxLayout.Y_AXIS);
        addItems(items);
        setBackground(Resources.LIGHT_GRAY);
        setOpaque(true);
        setAlignmentX(LEFT_ALIGNMENT);
        setAlignmentY(TOP_ALIGNMENT);
    }

    private void addItems(ArrayList<GalleryItem> items){
        int elemInRowCounter = 0;
        Box box = null;
        for (GalleryItem item : items) {
            if (elemInRowCounter == 1 || box == null) {
                elemInRowCounter = 0;
                box = Box.createHorizontalBox();
                box.setAlignmentX(LEFT_ALIGNMENT);
                add(box);
                add(Box.createVerticalStrut(15));
            } else {
                elemInRowCounter++;
                box.add(Box.createHorizontalStrut(15));
            }
            box.add(item);
        }
    }

    public void updateElements(ArrayList<GalleryItem> items){
        removeAll();
        addItems(items);
    }
}
