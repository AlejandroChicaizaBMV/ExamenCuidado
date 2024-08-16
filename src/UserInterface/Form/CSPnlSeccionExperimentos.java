package UserInterface.Form;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;
import BussinesLogic.CSHormigaBL;
import DataAccess.DTO.CSHormigaDTO;

public class CSPnlSeccionExperimentos extends JPanel {


    private JTextArea csTextArea;
    private JScrollPane csScrollPane;
    private CSHormigaBL csHormigaBL;

    public CSPnlSeccionExperimentos() {
        csHormigaBL = new CSHormigaBL(); // Inicializa la capa de negocio
        csCustomizeComponent();
        csLoadData(); // Carga los datos al iniciar el panel
    }

    public void csCustomizeComponent() {
        setBorder(new EmptyBorder(10, 30, 10, 30));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(250, 2000));

        // Configuración del JTextArea
        csTextArea = new JTextArea();
        csTextArea.setEditable(false);
       // csTextArea.setPreferredSize(new Dimension(250, 50)); // El JTextArea es solo para lectura

        // Agrega el JTextArea a un JScrollPane
        csScrollPane = new JScrollPane(csTextArea);
        add(csScrollPane, BorderLayout.CENTER);
    }

    public void csLoadData() {
        try {
            // Obtener todos los registros de la base de datos
            List<CSHormigaDTO> csLstHormigas = csHormigaBL.getAll();

            // Construir un String con los datos para mostrar en el JTextArea
            StringBuilder csDataBuilder = new StringBuilder();
            for (CSHormigaDTO hormiga : csLstHormigas) {
                csDataBuilder.append(hormiga.toString()).append("\n\n");
            }

            // Mostrar los datos en el JTextArea
            csTextArea.setText(csDataBuilder.toString());
        } catch (Exception e) {
            // Muestra un mensaje de error si ocurre una excepción
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
