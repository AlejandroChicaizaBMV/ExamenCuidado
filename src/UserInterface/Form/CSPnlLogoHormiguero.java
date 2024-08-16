package UserInterface.Form;

import javax.swing.*;

import UserInterface.CSStyles;
import UserInterface.CustomerControl.CSButton;
import UserInterface.CustomerControl.CSLabel;

import java.awt.*;

public class CSPnlLogoHormiguero extends JPanel {
    
    private ImageIcon csHormigaIcon;
    private JLabel    csLblHormiga;
    private CSLabel   csLblMessage;
    private CSButton   csBtnCrear; 

    public CSPnlLogoHormiguero(){
        csCustomizeComponent();
    }

    public void csCustomizeComponent(){
        setLayout(new GridLayout(1, 2, 10, 5));
        JPanel csPanelIzq = new JPanel(new FlowLayout());
        JPanel csPanelDer = new JPanel (new BorderLayout());

        csHormigaIcon = new ImageIcon (CSStyles.URL_HORMIGA1);
        Image originalImage = csHormigaIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        csHormigaIcon = new ImageIcon(resizedImage);
        csLblHormiga = new JLabel(csHormigaIcon);
        csLblMessage = new CSLabel("Hormiguero virtual");
        csLblMessage.setForeground(CSStyles.COLOR_FONT_BLUE);
        csPanelIzq.add(csLblHormiga);
        csPanelIzq.add(csLblMessage);

        csBtnCrear = new CSButton("Crear hormiga larva");
        csBtnCrear.setBackground(CSStyles.COLOR_BACKGROUND_DARKGRAY);
        csBtnCrear.setForeground(CSStyles.COLOR_FONT_WHITE);
        csPanelDer.add(csBtnCrear, BorderLayout.SOUTH);
        add(csPanelIzq);
        add(csPanelDer);
    }
}