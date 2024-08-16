package UserInterface.Form;

import javax.swing.border.EmptyBorder;

import javax.swing.*;

import UserInterface.CSStyles;
import UserInterface.CustomerControl.CSTextBox;

import java.awt.*;

public class CSPnlDatos extends JPanel {
    
    private JLabel       csLblCedula;
    private CSTextBox    csCedulaField;
    private JLabel       csLblNombres;
    private CSTextBox    csNombresField;
    private static String csNombre = "Sebastian Chicaiza";
    private static String csCedula = "172743226-0";

    public CSPnlDatos(){
        csCustomizeComponent();
    }

    public void csCustomizeComponent(){
        setLayout(new GridLayout(2, 2, 10, 5));
        setBorder(new EmptyBorder(10, 30, 10, 30));

        
        csLblCedula = new JLabel("Cédula:", SwingConstants.CENTER);
        csCedulaField = new CSTextBox();
        csCedulaField.setPreferredSize(new Dimension(100, 20));
        csCedulaField.setText(csCedula);
        csLblNombres = new JLabel("Nombres", SwingConstants.CENTER);
        csNombresField = new CSTextBox();
        csNombresField.setPreferredSize(new Dimension(100, 20));
        csNombresField.setText(csNombre);


        
        
        
        add(csLblCedula);
        add(csCedulaField);
        add(csLblNombres);
        add(csNombresField);
        setBackground(CSStyles.COLOR_FONT_LIGHT);
    }
}