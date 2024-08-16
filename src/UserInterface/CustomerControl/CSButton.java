package UserInterface.CustomerControl;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import UserInterface.CSStyles;

public class CSButton extends JButton implements MouseListener {

    public CSButton(String text) {
        customizeComponent(text);
    }

    public CSButton(String text, String iconPath) {
        customizeComponent(text, iconPath);
    }

    public void customizeComponent(String text, String iconPath) {

        setSize(20, 70);
        addMouseListener(this);
        customizeComponent(text);
        setBounds(50, 30, 90, 20);

        setIcon(new ImageIcon(iconPath));
        setFont(CSStyles.FONT);
    }

    public void customizeComponent(String text) {
        setText(text);
        setOpaque(true);
        setFocusPainted(false);
        setBorderPainted(false);

        setContentAreaFilled(true);
        setForeground(CSStyles.COLOR_FONT);
        setHorizontalAlignment(CSStyles.ALIGNMENT_LEFT);
        setFont(CSStyles.FONT);

        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

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
        setForeground(Color.BLACK);
        setCursor(CSStyles.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(Color.GRAY);
        setCursor(CSStyles.CURSOR_DEFAULT);
    }

}