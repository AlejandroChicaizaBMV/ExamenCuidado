package UserInterface.CustomerControl;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import UserInterface.CSStyles;

public class CSLabel extends JLabel {

    public CSLabel() {
        customizeComponent();
    }

    public CSLabel(String text) {
        setText(text);
        customizeComponent();
    }

    private void customizeComponent() {
        setCustomizeComponent(getText(), CSStyles.FONT, CSStyles.COLOR_FONT, CSStyles.ALIGNMENT_LEFT);
    }

    public void setCustomizeComponent(String text, Font font, Color color, int alignment) {
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(CSStyles.COLOR_FONT);
        setHorizontalAlignment(alignment);
        // setIcon(new ImageIcon(iconPath));
    }
}