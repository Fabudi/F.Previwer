package inc.fabudi;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BlocksPanel extends JPanel {
    BlocksPanel(){
        Box box = Box.createVerticalBox();
        setLayout(new GridLayout(0,1));
        setBorder(new EmptyBorder(0,20,0,20));
        setBackground(Resources.DARK_GRAY);
        JTextField titleField = new JTextField("Title");
        configureJTextField(titleField);
        JTextField descriptionField = new JTextField("Description");
        configureJTextField(descriptionField);
        Box buttonsPanel = Box.createHorizontalBox();
        JLabel addLabel = new JLabel("Add");
        configureJLabel(addLabel);
        addLabel.setBackground(Resources.GREEN);
//        addLabel.setPreferredSize(new Dimension(400,40));
        addLabel.setMaximumSize(new Dimension(400,40));
        addLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel removeLabel = new JLabel("Remove");
        configureJLabel(removeLabel);
        removeLabel.setBackground(Resources.RED);
        removeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        removeLabel.setPreferredSize(new Dimension(100,40));
        removeLabel.setMaximumSize(new Dimension(400,40));
        buttonsPanel.add(addLabel);
        buttonsPanel.add(Box.createHorizontalStrut(15));
        buttonsPanel.add(removeLabel);
        buttonsPanel.setMaximumSize(new Dimension(800,70));
//        box.setPreferredSize(new Dimension(500,40));
        buttonsPanel.setOpaque(false);
        box.add(titleField);
        box.add(Box.createVerticalStrut(15));
        box.add(descriptionField);
        box.add(buttonsPanel);
        add(box);
    }
    private void configureJTextField(JTextField jTextField){
        jTextField.setBorder(Resources.border);
        jTextField.setBackground(Resources.HALF_GRAY);
        jTextField.setOpaque(true);
        jTextField.setFont(Resources.minecraft);
        jTextField.setForeground(Resources.WHITE);
        jTextField.setMaximumSize(new Dimension(jTextField.getMaximumSize().width, 40));
    }
    private void configureJLabel(JLabel jTextLabel){
        jTextLabel.setBorder(Resources.border);
        jTextLabel.setBackground(Resources.HALF_GRAY);
        jTextLabel.setOpaque(true);
        jTextLabel.setFont(Resources.minecraft);
        jTextLabel.setForeground(Resources.WHITE);
        jTextLabel.setMaximumSize(new Dimension(jTextLabel.getMaximumSize().width, 40));
    }
}
