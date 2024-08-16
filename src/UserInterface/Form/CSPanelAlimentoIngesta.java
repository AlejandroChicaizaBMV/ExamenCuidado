package UserInterface.Form;

import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BussinesLogic.CSGenoAlimentoBL;
import BussinesLogic.CSIngestaNativaBL;
import DataAccess.DTO.CSGenoAlimentoDTO;
import DataAccess.DTO.CSIngestaNativaDTO;
import UserInterface.CSStyles;
import UserInterface.CustomerControl.CSButton;

public class CSPanelAlimentoIngesta extends JPanel {

    private JComboBox<String> csCBoxGenoAlimento;
    private CSButton csBtnAlimentarGeno;
    private JComboBox<String> csCBoxIngestaNativa;
    private CSButton csBtnAlimentarIngesta;

    private CSGenoAlimentoBL genoAlimentoBL = new CSGenoAlimentoBL();
    private CSIngestaNativaBL ingestaNativaBL = new CSIngestaNativaBL();

    public CSPanelAlimentoIngesta() {
        csCustomizeComponent();
        try {
            csLlenarComboBoxes();
        } catch (Exception e) {
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

        csCBoxIngestaNativa = new JComboBox<>();
        add(csCBoxIngestaNativa);

        csBtnAlimentarIngesta = new CSButton("alimentar con Ingesta Nativa");
        csBtnAlimentarIngesta.setBackground(CSStyles.COLOR_BACKGROUND_DARKGRAY);
        csBtnAlimentarIngesta.setForeground(CSStyles.COLOR_FONT_WHITE);
        add(csBtnAlimentarIngesta);

        // Añadir ActionListeners para manejar los clics en los botones
        csBtnAlimentarGeno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedGenoAlimento = (String) csCBoxGenoAlimento.getSelectedItem();
                System.out.println("Seleccionaste GenoAlimento: " + selectedGenoAlimento);
                // Aquí puedes agregar la lógica para manejar la alimentación con el GenoAlimento seleccionado
            }
        });

        csBtnAlimentarIngesta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedIngestaNativa = (String) csCBoxIngestaNativa.getSelectedItem();
                System.out.println("Seleccionaste Ingesta Nativa: " + selectedIngestaNativa);
                // Aquí puedes agregar la lógica para manejar la alimentación con la Ingesta Nativa seleccionada
            }
        });
    }

    private void csLlenarComboBoxes() throws Exception {
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
    }
}
