package UserInterface.Form;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


import UserInterface.CSStyles;
import UserInterface.CustomerControl.CSButton;

import java.awt.*;

public class CSPnlAddDel extends JPanel{
    private CSButton btnDel;
    private CSButton btnAdd;

    public CSPnlAddDel (){
        csCustomizeComponent();
    }

    public void csCustomizeComponent(){
        setLayout(new FlowLayout(FlowLayout.CENTER,60,0));
        setBorder(new EmptyBorder(60, 30, 0, 30));

        btnDel = new CSButton("Eliminar");
        btnDel.setBackground(CSStyles.COLOR_FONT_LIGHTBLUE);
        btnAdd = new CSButton("Guardar");
        btnAdd.setBackground(CSStyles.COLOR_FONT_LIGHTBLUE);

        add(btnAdd);
        add(btnDel);
        setBackground(CSStyles.COLOR_FONT_LIGHT);

    }

}