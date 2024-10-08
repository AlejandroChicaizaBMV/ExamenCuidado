package UserInterface.Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import BussinesLogic.CSHormigaBL;
import DataAccess.DTO.CSHormigaDTO;
import UserInterface.CSStyles;
import UserInterface.CustomerControl.CSButton;
import UserInterface.CustomerControl.CSLabel;

public class CSPnlLogoHormiguero extends JPanel {
    private CSHormigaBL csHormigaBL = new CSHormigaBL();
    private CSPnlSeccionExperimentos csPnlSeccionExperimentos;
    private CSPanelAlimentoIngesta csPanelAlimentoIngesta;
    private ImageIcon csHormigaIcon;
    private JLabel csLblHormiga;
    private CSLabel csLblMessage;
    private CSButton csBtnCrear;

    public CSPnlLogoHormiguero(CSPnlSeccionExperimentos csPnlSeccionExperimentos, CSPanelAlimentoIngesta csPanelAlimentoIngesta) {
        this.csPnlSeccionExperimentos = csPnlSeccionExperimentos;
        this.csPanelAlimentoIngesta = csPanelAlimentoIngesta;
        csCustomizeComponent();
    }

    public void csCustomizeComponent() {
        setLayout(new GridLayout(1, 2, 10, 5));
        JPanel csPanelIzq = new JPanel(new FlowLayout());
        JPanel csPanelDer = new JPanel(new BorderLayout());

        csHormigaIcon = new ImageIcon(CSStyles.URL_HORMIGA1);
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

        csBtnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(
                        CSPnlLogoHormiguero.this,
                        "¿Estás seguro de que deseas crear una Hormiga Larva?",
                        "Confirmar Creación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (respuesta == JOptionPane.YES_OPTION) {
                    Random random = new Random();
                    int provincia = random.nextInt((24 - 1) + 1) + 1;
                    try {
                        csHormigaBL.add(new CSHormigaDTO(1, 1, provincia, 1, 1));
                        updateExperimentPanel(); 
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                
            }
        });

        csPanelDer.add(csBtnCrear, BorderLayout.SOUTH);
        add(csPanelIzq);
        add(csPanelDer);
    }

    private void updateExperimentPanel() throws Exception {
        if (csPnlSeccionExperimentos != null) {
            csPnlSeccionExperimentos.csLoadData(); 
        }
        if (csPanelAlimentoIngesta != null) {
            csPanelAlimentoIngesta.csLlenarComboBoxes(); 
        }
    }
}
