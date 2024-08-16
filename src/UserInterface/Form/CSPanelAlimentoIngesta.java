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

    private Integer selectedHormigaId; // Variable para almacenar el ID de la hormiga seleccionada

    public CSPanelAlimentoIngesta(CSPnlSeccionExperimentos csPnlSeccionExperimentos) {
        this.csPnlSeccionExperimentos = csPnlSeccionExperimentos;
        csCustomizeComponent();
        try {
            csLlenarComboBoxes();
        } catch (Exception e) {
            e.printStackTrace(); // Agrega manejo de excepciones adecuado
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

        // Añadir ActionListeners para manejar los clics en los botones
        csBtnAlimentarGeno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verificar si hay una hormiga seleccionada
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
                // Verificar si hay una hormiga seleccionada
                if (selectedHormigaId != null) {
                    String selectedIngestaNativa = (String) csCBoxIngestaNativa.getSelectedItem();
                    System.out.println("Alimentar hormiga " + selectedHormigaId + " con Ingesta Nativa: " + selectedIngestaNativa);
                    int tipo = 0;
                    try {
                        tipo = csHormigaBL.readTipoBy(selectedHormigaId);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    if(!selectedIngestaNativa.equals("Carnivoro") && tipo == 2){
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

        // Agregar un ActionListener al csCBoxHormiga para actualizar el ID de la hormiga seleccionada
        csCBoxHormiga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedHormigaId = (Integer) csCBoxHormiga.getSelectedItem();
            }
        });
    }

    public void     csLlenarComboBoxes() throws Exception {
        // Obtener la lista de GenoAlimento desde el BL
        List<CSGenoAlimentoDTO> genoAlimentos = genoAlimentoBL.getAll();
        for (CSGenoAlimentoDTO geno : genoAlimentos) {
            csCBoxGenoAlimento.addItem(geno.getCsNombre()); // Ajusta según el campo en tu DTO
        }

        // Obtener la lista de IngestaNativa desde el BL
        List<CSIngestaNativaDTO> ingestasNativas = ingestaNativaBL.getAll();
        for (CSIngestaNativaDTO ingesta : ingestasNativas) {
            csCBoxIngestaNativa.addItem(ingesta.getCsNombre()); // Ajusta según el campo en tu DTO
        }

        // Obtener la lista de Hormigas desde el BL
        List<CSHormigaDTO> hormigas = csHormigaBL.getAll(); // Asegúrate de tener este método en CSHormigaBL
        csCBoxHormiga.removeAllItems();
        for (CSHormigaDTO hormiga : hormigas) {
            csCBoxHormiga.addItem(hormiga.getnHormiga()); // Añadir el ID de la hormiga
        }
    }

    private void updateExperimentPanel() throws Exception {
        if (csPnlSeccionExperimentos != null) {
            csPnlSeccionExperimentos.csLoadData(); // Llama al método para recargar los datos
        }
    }
}
