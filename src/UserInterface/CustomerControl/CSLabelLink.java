package UserInterface.CustomerControl;

import javax.swing.ImageIcon;

import UserInterface.CSStyles;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CSLabelLink extends CSLabel implements MouseListener {

    public CSLabelLink(String text) {
        super(text);
        setPersonalizacion();
    }

    public CSLabelLink(String text, String iconPath) {
        super(text);
        setPersonalizacion();
        setIcon(new ImageIcon(iconPath));
    }

    void setPersonalizacion() {
        addMouseListener(this);
        setOpaque(false);
        setForeground(CSStyles.COLOR_FONT);
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
        this.setCursor(CSStyles.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setCursor(CSStyles.CURSOR_DEFAULT);
    }

}