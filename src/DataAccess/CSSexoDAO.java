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

import DataAccess.DTO.CSSexoDTO;

public class CSSexoDAO extends CSSQLiteDataHelper implements IDAO<CSSexoDTO>{

    @Override
    public boolean create(CSSexoDTO entity) throws Exception {
        String csQuery = "INSERT INTO CSSexo (nombre) VALUES (?)";
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
    public List<CSSexoDTO> readAll() throws Exception {
        List <CSSexoDTO> csLst =  new ArrayList<>();
        String csQuery = "SELECT nSexo, "
                       + "nombre,               "
                       + "Estado,               "
                       + "FechaCrea,            "
                       + "FechaModifica        "
                       + "FROM CSSexo           "
                       + "WHERE Estado = 'A' ";
        try {
            Connection csConn = csOpenConnection();
            Statement csStmt  = csConn.createStatement();
            ResultSet csRs    = csStmt.executeQuery(csQuery);

            while(csRs.next()){
                CSSexoDTO csSexoDTO = new CSSexoDTO(csRs.getInt(1),
                                                    csRs.getString(2),
                                                    csRs.getString(3),
                                                    csRs.getString(4),
                                                    csRs.getString(5));
                csLst.add(csSexoDTO);                                    
            }
        } catch (SQLException e) {
            throw e;
        }
        return csLst;
    }

    @Override
    public boolean update(CSSexoDTO entity) throws Exception {
        DateTimeFormatter csDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime     csNow = LocalDateTime.now();
        String csQuery = "UPDATE CSSexo SET nombre = ?, FechaModifica = ? WHERE nSexo = ?";
        
        try {
            Connection csConn        = csOpenConnection();
            PreparedStatement csPstmt = csConn.prepareStatement(csQuery);
            csPstmt.setString(1, entity.getCsNombre());
            csPstmt.setString(2, csDtf.format(csNow).toString());
            csPstmt.setInt(3, entity.getCsNSexo());

            csPstmt.executeUpdate();
            return true;    
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer n) throws Exception {
        String csQuery = "UPDATE CSSexo SET Estado = ? WHERE nSexo = ? ";
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
    public CSSexoDTO readBy(Integer n) throws Exception {
        CSSexoDTO csSexoDTO = new CSSexoDTO();
        String csQuery = "SELECT nSexo, "
                       + "nombre,               "
                       + "Estado,               "
                       + "FechaCrea,            "
                       + "FechaModifica         "
                       + "FROM CSSexo           "
                       + "WHERE Estado = 'A' AND nSexo = " + n.toString();
        try {
            Connection csConn = csOpenConnection();
            Statement  csStmt = csConn.createStatement();
            ResultSet  csRs   = csStmt.executeQuery(csQuery);

            while(csRs.next()){
                csSexoDTO = new CSSexoDTO(csRs.getInt(1),
                                          csRs.getString(2),
                                          csRs.getString(3),
                                          csRs.getString(4),
                                          csRs.getString(5));
            }
                
        } catch (SQLException e) {
            throw e;
        }
        return csSexoDTO;
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String csQuery = "SELECT COUNT (*) TotalReg FROM CSSexo WHERE Estado = 'A'";
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