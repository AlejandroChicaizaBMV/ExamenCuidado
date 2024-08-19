package UserInterface.Form;

import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BussinesLogic.CSGenoAlimentoBL;
import BussinesLogic.CSHormigaBL;
import BussinesLogic.CSIngestaNativaBL;
import DataAccess.DTO.CSGenoAlimentoDTO;
import DataAccess.DTO.CSHormigaDTO;
import DataAccess.DTO.CSIngestaNativaDTO;
import UserInterface.CSStyles;
import UserInterface.CustomerControl.CSButton;
import UserInterface.CustomerControl.CSLabel;

public class CSPanelAlimentoIngesta extends JPanel {

    private JComboBox<String> csCBoxGenoAlimento;
    private CSButton csBtnAlimentarGeno;
    private JComboBox<String> csCBoxIngestaNativa;
    private CSButton csBtnAlimentarIngesta;
    private JComboBox<Integer> csCBoxHormiga;

    private CSGenoAlimentoBL genoAlimentoBL = new CSGenoAlimentoBL();
    private CSIngestaNativaBL ingestaNativaBL = new CSIngestaNativaBL();
    private CSPnlSeccionExperimentos csPnlSeccionExperimentos;
    private CSHormigaBL csHormigaBL = new CSHormigaBL();

    private Integer selectedHormigaId; 

    public CSPanelAlimentoIngesta(CSPnlSeccionExperimentos csPnlSeccionExperimentos) {
        this.csPnlSeccionExperimentos = csPnlSeccionExperimentos;
        csCustomizeComponent();
        try {
            csLlenarComboBoxes();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    public void csCustomizeComponent() {
        setLayout(new GridLayout(2, 2, 5, 10));
        setBorder(new EmptyBorder(10, 30, 10, 30));

        csCBoxGenoAlimento = new JComboBox<>();
        add(csCBoxGenoAlimento);

        csBtnAlimentarGeno = new CSButton("alimentar con Genoalimento");
        csBtnAlimentarGeno.setBackground(CSStyles.COLOR_BACKGROUND_DARKGRAY);
        csBtnAlimentarGeno.setForeground(CSStyles.COLOR_FONT_WHITE);
        add(csBtnAlimentarGeno);

        CSLabel csLblHormiga = new CSLabel("nHormiga a Experimentar: ");
        add(csLblHormiga);

        csCBoxIngestaNativa = new JComboBox<>();
        add(csCBoxIngestaNativa);

        csBtnAlimentarIngesta = new CSButton("alimentar con Ingesta Nativa");
        csBtnAlimentarIngesta.setBackground(CSStyles.COLOR_BACKGROUND_DARKGRAY);
        csBtnAlimentarIngesta.setForeground(CSStyles.COLOR_FONT_WHITE);
        add(csBtnAlimentarIngesta);

        csCBoxHormiga = new JComboBox<>();
        add(csCBoxHormiga);

        csBtnAlimentarGeno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedHormigaId != null) {
                    String selectedGenoAlimento = (String) csCBoxGenoAlimento.getSelectedItem();
                    System.out.println("Alimentar hormiga " + selectedHormigaId + " con GenoAlimento: " + selectedGenoAlimento);

                    if(selectedGenoAlimento.equals("XY")){
                        try {
                            csHormigaBL.updateTipo(selectedHormigaId);
                            updateExperimentPanel();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona una hormiga.");
                }
            }
        });

        csBtnAlimentarIngesta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedHormigaId != null) {
                    String selectedIngestaNativa = (String) csCBoxIngestaNativa.getSelectedItem();
                    System.out.println("Alimentar hormiga " + selectedHormigaId + " con Ingesta Nativa: " + selectedIngestaNativa);
                    String tipo = "";
                    try {
                        tipo = csHormigaBL.readTipoBy(selectedHormigaId);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    if(!selectedIngestaNativa.equals("Carnivoro") && tipo.equals("Soldado")){
                        try {
                            csHormigaBL.delete(selectedHormigaId);
                            updateExperimentPanel();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona una hormiga.");
                }
            }
        });

        csCBoxHormiga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedHormigaId = (Integer) csCBoxHormiga.getSelectedItem();
            }
        });
    }

    public void     csLlenarComboBoxes() throws Exception {
        List<CSGenoAlimentoDTO> genoAlimentos = genoAlimentoBL.getAll();
        csCBoxGenoAlimento.removeAllItems();
        for (CSGenoAlimentoDTO geno : genoAlimentos) {
            csCBoxGenoAlimento.addItem(geno.getCsNombre()); 
        }

        
        List<CSIngestaNativaDTO> ingestasNativas = ingestaNativaBL.getAll();
        csCBoxIngestaNativa.removeAllItems();
        for (CSIngestaNativaDTO ingesta : ingestasNativas) {
            csCBoxIngestaNativa.addItem(ingesta.getCsNombre()); 
        }

        
        List<CSHormigaDTO> hormigas = csHormigaBL.getAll(); 
        csCBoxHormiga.removeAllItems();
        for (CSHormigaDTO hormiga : hormigas) {
            csCBoxHormiga.addItem(hormiga.getCsNHormiga()); 
        }
    }

    private void updateExperimentPanel() throws Exception {
        if (csPnlSeccionExperimentos != null) {
            csPnlSeccionExperimentos.csLoadData();; 
        }
    }
}
