package UserInterface.Form;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import UserInterface.CustomerControl.CSButton;

import java.awt.*;

public class CSPnlSeccionExperimentos extends JPanel {
    private CSButton csBtn11;
    private CSButton csBtn12;
    private CSButton csBtn13;
    private CSButton csBtn14;
    private CSButton csBtn15;
    private CSButton csBtn16;
    private CSButton csBtn21;
    private CSButton csBtn22;
    private CSButton csBtn23;
    private CSButton csBtn24;
    private CSButton csBtn25;
    private CSButton csBtn26;
    private CSButton csBtn31;
    private CSButton csBtn32;
    private CSButton csBtn33;
    private CSButton csBtn34;
    private CSButton csBtn35;
    private CSButton csBtn36;

    public CSPnlSeccionExperimentos(){
        csCustomizeComponent();
    }

    public void csCustomizeComponent(){
        setLayout(new GridLayout(3, 6, 7, 5));
        setBorder(new EmptyBorder(10, 30, 10, 30));


        csBtn11 = new CSButton("1,1");
        csBtn12 = new CSButton("1,2");
        csBtn13 = new CSButton("1,3");
        csBtn14 = new CSButton("1,4");
        csBtn15 = new CSButton("1,5");
        csBtn16 = new CSButton("1,6");

        csBtn21 = new CSButton("2,1");
        csBtn22 = new CSButton("2,2");
        csBtn23 = new CSButton("2,3");
        csBtn24 = new CSButton("2,4");
        csBtn25 = new CSButton("2,5");
        csBtn26 = new CSButton("2,6");

        csBtn31 = new CSButton("3,1");
        csBtn32 = new CSButton("3,2");
        csBtn33 = new CSButton("3,3");
        csBtn34 = new CSButton("3,4");
        csBtn35 = new CSButton("3,5");
        csBtn36 = new CSButton("3,6");

        add(csBtn11);
        add(csBtn12);
        add(csBtn13);
        add(csBtn14);
        add(csBtn15);
        add(csBtn16);

        add(csBtn21);
        add(csBtn22);
        add(csBtn23);
        add(csBtn24);
        add(csBtn25);
        add(csBtn26); 
        
        add(csBtn31);
        add(csBtn32);
        add(csBtn33);
        add(csBtn34);
        add(csBtn35);
        add(csBtn36);

    }
}