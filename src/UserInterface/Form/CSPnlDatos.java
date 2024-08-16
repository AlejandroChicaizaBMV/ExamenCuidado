package UserInterface.Form;

import javax.swing.border.EmptyBorder;

import javax.swing.*;

import UserInterface.CSStyles;
import UserInterface.CustomerControl.CSLabel;
import UserInterface.CustomerControl.CSTextBox;

import java.awt.*;

public class CSPnlDatos extends JPanel {
    
    private JLabel       csLblCedula;
    private CSLabel    csLblNumeroCed;
    private JLabel       csLblNombres;
    private CSLabel    csLblNomApellido;
    private static String csNombre = "Sebastian Chicaiza";
    private static String csCedula = "172743226-0";

    public CSPnlDatos(){
        csCustomizeComponent();
    }

    public void csCustomizeComponent(){
        setLayout(new GridLayout(2, 2, 10, 5));
        setBorder(new EmptyBorder(10, 30, 10, 30));

        
        csLblCedula = new JLabel("Cédula:", SwingConstants.CENTER);
        csLblNumeroCed = new CSLabel();
        
        csLblNumeroCed.setPreferredSize(new Dimension(100, 20));
        csLblNumeroCed.setText(csCedula);
        csLblNumeroCed.setBackground(CSStyles.COLOR_FONT_WHITE);

        csLblNombres = new JLabel("Nombres:", SwingConstants.CENTER);
        csLblNomApellido = new CSLabel();
        csLblNomApellido.setPreferredSize(new Dimension(100, 20));
        csLblNomApellido.setText(csNombre);
        csLblNomApellido.setBackground(CSStyles.COLOR_FONT_WHITE);


        
        
        
        add(csLblCedula);
        add(csLblNumeroCed);
        add(csLblNombres);
        add(csLblNomApellido);
        setBackground(CSStyles.COLOR_FONT_LIGHT);
    }
}