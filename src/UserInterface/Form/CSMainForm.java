package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

public class CSMainForm extends JFrame {
    CSPnlFormulario csPnlFormulario; 
    public CSMainForm (String csTitleApp){
        csPnlFormulario = new CSPnlFormulario();
        csCustomizeComponent (csTitleApp);
    }

    private void csCustomizeComponent(String csTitleApp){
        setTitle(csTitleApp);
        setSize(750, 750);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        container.add(csPnlFormulario, BorderLayout.CENTER);
        setVisible(true);
    }
}