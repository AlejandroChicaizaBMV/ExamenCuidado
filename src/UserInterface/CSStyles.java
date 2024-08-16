package UserInterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public abstract class CSStyles {

    public static final Color COLOR_FONT = new Color(0,0,0);
    public static final Color COLOR_FONT_LIGHT = new Color(0xd1d1d1);
    public static final Color COLOR_FONT_WHITE = new Color(255,255,255);
    public static final Color COLOR_FONT_BLUE = new Color(0,0,255);
    public static final Color COLOR_FONT_LIGHTBLUE = new Color(0xc5e2f6);

    public static final Color COLOR_CURSOR = Color.black;
    public static final Color COLOR_BORDER_BUTTON= new Color(0x292929);
    public static final Color COLOR_BACKGROUND= new Color(0x014f01);
    public static final Color COLOR_BACKGROUND_DARKGRAY = new Color(0x828282);
    public static final Color COLOR_FOREGROUND_PRESSED = new Color(0xBD9402);
    public static final Font FONT = new Font("Inconsolata", Font.PLAIN, 14);
    public static final Font FONT_BOLD = new Font("Inconsolata", Font.BOLD | Font.PLAIN, 14);
    public static final Font FONT_BOLD_24 = new Font("Inconsolata", Font.BOLD| Font.PLAIN, 24);
    public static final Font FONT_SMALL = new Font("Inconsolata", Font.PLAIN | Font.PLAIN, 10);

    public static final int ALIGNMENT_LEFT = SwingConstants.LEFT;
    public static final int ALIGNMENT_RIGHT = SwingConstants.RIGHT;
    public static final int ALIGNMENT_CENTER = SwingConstants.CENTER;

    public static final Cursor CURSOR_HAND = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    public static final URL URL_HORMIGA1 = CSStyles.class.getResource("/UserInterface/Resourses/Img/hormiga1.png");
    public static final URL URL_HORMIGA = CSStyles.class.getResource("/UserInterface/Resources/Img/hormiga.jpg");

    public static final CompoundBorder createBorderRect() {
        return BorderFactory.createCompoundBorder(new LineBorder(Color.lightGray),
                new EmptyBorder(5, 5, 5, 5));
    }

    public static final void showMsg(String msg) {
        JOptionPane.showMessageDialog(null, msg, "🐶 PRODUCTOS", JOptionPane.INFORMATION_MESSAGE);
    }

    public static final void showMsgError(String msg) {
        JOptionPane.showMessageDialog(null, msg, "🦁 PRODUCTOS", JOptionPane.OK_CANCEL_OPTION);
    }

    public static final boolean showConfirmYesNo(String msg) {
        return (JOptionPane.showConfirmDialog(null, msg, "🤡 PRODUCTOS",
                JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION);
    }
}