package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTO.CSTipoHormigaDTO;

public class CSTipoHormigaDAO extends CSSQLiteDataHelper implements IDAO<CSTipoHormigaDTO>{

    @Override
    public boolean create(CSTipoHormigaDTO entity) throws Exception {
        String csQuery = "INSERT INTO CSTipoHormiga (nombre) VALUES (?)";
         try {
            Connection csConn = csOpenConnection();
            PreparedStatement csPstmt = csConn.prepareStatement(csQuery);

            csPstmt.setString(1, entity.getCsNombre());
            csPstmt.executeUpdate();

            return true;
         } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<CSTipoHormigaDTO> readAll() throws Exception {
        List <CSTipoHormigaDTO> csLst =  new ArrayList<>();
        String csQuery = "SELECT nTipoHormiga, "
                       + "nombre,               "
                       + "Estado,               "
                       + "FechaCrea,            "
                       + "FechaModifica        "
                       + "FROM CSTipoHormiga    "
                       + "WHERE Estado = 'A' ";
        try {
            Connection csConn = csOpenConnection();
            Statement csStmt  = csConn.createStatement();
            ResultSet csRs    = csStmt.executeQuery(csQuery);

            while(csRs.next()){
                CSTipoHormigaDTO csTipoHormigaDTO = new CSTipoHormigaDTO(csRs.getInt(1),
                                                    csRs.getString(2),
                                                    csRs.getString(3),
                                                    csRs.getString(4),
                                                    csRs.getString(5));
                csLst.add(csTipoHormigaDTO);                                    
            }
        } catch (SQLException e) {
            throw e;
        }
        return csLst;
    }

    @Override
    public boolean update(CSTipoHormigaDTO entity) throws Exception {
        DateTimeFormatter csDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime     csNow = LocalDateTime.now();
        String csQuery = "UPDATE CSTipoHormiga SET nombre = ?, FechaModifica = ? WHERE nTipoHormiga = ?";
        
        try {
            Connection csConn        = csOpenConnection();
            PreparedStatement csPstmt = csConn.prepareStatement(csQuery);
            csPstmt.setString(1, entity.getCsNombre());
            csPstmt.setString(2, csDtf.format(csNow).toString());
            csPstmt.setInt(3, entity.getCsNTipoHormiga());

            csPstmt.executeUpdate();
            return true;    
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer n) throws Exception {
        String csQuery = "UPDATE CSTipoHormiga SET Estado = ? WHERE nTipoHormiga = ? ";
        try {
            Connection csConn = csOpenConnection();
            PreparedStatement csPstmt = csConn.prepareStatement(csQuery);
            csPstmt.setString(1, "X");
            csPstmt.setInt(2, n);
            csPstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public CSTipoHormigaDTO readBy(Integer n) throws Exception {
        CSTipoHormigaDTO csTipoHormigaDTO = new CSTipoHormigaDTO();
        String csQuery = "SELECT nTipoHormiga, "
                       + "nombre,               "
                       + "Estado,               "
                       + "FechaCrea,            "
                       + "FechaModifica         "
                       + "FROM CSTipoHormiga    "
                       + "WHERE Estado = 'A' AND nTipoHormiga = " + n.toString();
        try {
            Connection csConn = csOpenConnection();
            Statement  csStmt = csConn.createStatement();
            ResultSet  csRs   = csStmt.executeQuery(csQuery);

            while(csRs.next()){
                csTipoHormigaDTO = new CSTipoHormigaDTO(csRs.getInt(1),
                                          csRs.getString(2),
                                          csRs.getString(3),
                                          csRs.getString(4),
                                          csRs.getString(5));
            }
                
        } catch (SQLException e) {
            throw e;
        }
        return csTipoHormigaDTO;
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String csQuery = "SELECT COUNT (*) TotalReg FROM CSTipoHormiga WHERE Estado = 'A'";
        try {
            Connection csConn =  csOpenConnection();
            Statement csStmt  =  csConn.createStatement();
            ResultSet csRs    =  csStmt.executeQuery(csQuery);
            while(csRs.next()){
                return csRs.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        }
        return 0;
    }

}
