package UserInterface.CustomerControl;

import javax.swing.*;

import java.awt.BorderLayout;

import UserInterface.CSStyles;

public class CSLabelText extends JPanel {
    private CSLabel lblEtiqueta = new CSLabel();
    private CSTextBox txtContenido = new CSTextBox();

    public CSLabelText(String etiqueta) {
        setLayout(new BorderLayout());

        lblEtiqueta.setCustomizeComponent(etiqueta, CSStyles.FONT_SMALL, CSStyles.COLOR_FONT_LIGHT, CSStyles.ALIGNMENT_LEFT);

        txtContenido.setBorderLine();
        add(lblEtiqueta, BorderLayout.NORTH);
        add(txtContenido, BorderLayout.CENTER);
    }
}