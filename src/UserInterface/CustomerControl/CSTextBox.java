package UserInterface.CustomerControl;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import UserInterface.CSStyles;

public class CSTextBox extends JTextField {

    public CSTextBox() {
        customizeComponent();
    }

    private void customizeComponent() {
        setBorderRect();
        setFont(CSStyles.FONT);
        setForeground(CSStyles.COLOR_FONT);
        setBackground(CSStyles.COLOR_FONT_WHITE);
        setCaretColor(CSStyles.COLOR_CURSOR);
        setMargin(new Insets(5, 5, 5, 5));
        setOpaque(true);
    }

    public void setBorderRect() {
        Border lineBorder = BorderFactory.createLineBorder(CSStyles.COLOR_BORDER_BUTTON);
        Border emptyBorder = new EmptyBorder(5, 5, 5, 5);
        setBorder(new CompoundBorder(lineBorder, emptyBorder));
    }

    public void setBorderLine() {
        int thickness = 1;
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 0, thickness, 0),
                BorderFactory.createMatteBorder(0, 0, thickness, 0, CSStyles.COLOR_BORDER_BUTTON)));
    }
}