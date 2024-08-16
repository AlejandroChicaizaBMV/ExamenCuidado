import com.formdev.flatlaf.FlatLightLaf;

import BussinesLogic.CSHormigaBL;
import DataAccess.CSAlimentoDAO;
import DataAccess.CSGenoAlimentoDAO;
import DataAccess.CSHormigaDAO;
import DataAccess.DTO.CSAlimentoDTO;
import DataAccess.DTO.CSGenoAlimentoDTO;
import DataAccess.DTO.CSHormigaDTO;

import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager;
import UserInterface.Form.CSMainForm;

public class App {
    public static void main(String[] args) throws Exception {
        FlatLightLaf.setup();
        FlatLightLaf.supportsNativeWindowDecorations();
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new CSMainForm("EcuaFauna 2K24A");
        
        
        //----HORMIGA BL TESTING -------
        // CSHormigaBL csHormigaBL = new CSHormigaBL();
        // csHormigaBL.add(new CSHormigaDTO(1,1,1,1,1));
    }
}