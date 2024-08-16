package UserInterface.Form;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;

import UserInterface.CSStyles;
import UserInterface.CustomerControl.CSLabel;
import UserInterface.CustomerControl.CSTextBox;

public class CSPnlFormulario extends JPanel{
    public CSPnlDatos               csPnlDatos;

    public CSPnlSeccionExperimentos csPnlSeccionExperimentos = new CSPnlSeccionExperimentos();
    public CSPanelAlimentoIngesta   csPanelAlimentoIngesta = new CSPanelAlimentoIngesta(csPnlSeccionExperimentos);
    public CSPnlLogoHormiguero      csPnlLogoHormiguero = new CSPnlLogoHormiguero(csPnlSeccionExperimentos, csPanelAlimentoIngesta);
    public CSPnlAddDel              csPnlAddDel;
    
    public CSPnlFormulario(){
        csCustomizeComponent();
    }

    public void csCustomizeComponent(){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10, 30, 10, 30));


        csPnlDatos = new CSPnlDatos();
        add(csPnlDatos);

        
        csPnlLogoHormiguero.setPreferredSize(new Dimension(440,10));
        add(csPnlLogoHormiguero);

        add(csPnlSeccionExperimentos);

        add(csPanelAlimentoIngesta);

        csPnlAddDel = new CSPnlAddDel();
        add(csPnlAddDel);


    }
}