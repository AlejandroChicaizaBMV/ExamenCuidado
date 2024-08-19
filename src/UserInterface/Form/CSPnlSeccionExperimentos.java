package UserInterface.Form;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;
import BussinesLogic.CSHormigaBL;
import DataAccess.DTO.CSHormigaDTO;
import javax.swing.table.DefaultTableModel;

public class CSPnlSeccionExperimentos extends JPanel {

    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private CSHormigaBL csHormigaBL = new CSHormigaBL();

    public CSPnlSeccionExperimentos(){
        setLayout(new BorderLayout());

        // Configurar la tabla y su modelo
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("nHormiga");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Sexo");
        modeloTabla.addColumn("Provincia");
        modeloTabla.addColumn("IngestaNativa");
        modeloTabla.addColumn("Estado");

        tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);
        tabla.setPreferredScrollableViewportSize(new Dimension(500, 2000));
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // Llenar la tabla con los datos de la base de datos
        csLoadData(); 
    }

    public void csLoadData(){
        List<CSHormigaDTO> datos;
        try {
            // Vaciar la tabla antes de cargar nuevos datos
            modeloTabla.setRowCount(0);
            
            datos = csHormigaBL.getAll();
            for (CSHormigaDTO dato : datos) {
                modeloTabla.addRow(new Object[]{
                    dato.getCsNHormiga(),
                    dato.getCsTipoHormiga(),
                    dato.getCsSexo(),
                    dato.getCsProvincia(),
                    dato.getCsIngestaNativa(),
                    dato.getCsEstado()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
