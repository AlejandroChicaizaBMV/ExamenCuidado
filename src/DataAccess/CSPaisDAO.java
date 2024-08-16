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

import DataAccess.DTO.CSPaisDTO;

public class CSPaisDAO extends CSSQLiteDataHelper implements IDAO<CSPaisDTO>{

    @Override
    public boolean create(CSPaisDTO entity) throws Exception {
        String csQuery = "INSERT INTO CSPais (nombre) VALUES (?)";
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
    public List<CSPaisDTO> readAll() throws Exception {
        List<CSPaisDTO> csLst = new ArrayList<>();
        String csQuery = "SELECT nPais, "
                       + "nombre,       "
                       + "Estado,       "
                       + "FechaCrea,    "
                       + "FechaModifica "
                       + "FROM CSPais   "
                       + "WHERE Estado = 'A' ";
        try {
            Connection csConn = csOpenConnection();
            Statement csStmt  = csConn.createStatement();
            ResultSet csRs    = csStmt.executeQuery(csQuery);

            while(csRs.next()){
                CSPaisDTO csPaisDTO = new CSPaisDTO(csRs.getInt(1),
                                                    csRs.getString(2),
                                                    csRs.getString(3),
                                                    csRs.getString(4),
                                                    csRs.getString(5));
                csLst.add(csPaisDTO);                                    
            }
        } catch (SQLException e) {
            throw e;
        }
        return csLst;
    }

    @Override
    public boolean update(CSPaisDTO entity) throws Exception {
        DateTimeFormatter csDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime csNow = LocalDateTime.now();
        String csQuery = "UPDATE CSPais SET nombre = ?, FechaModifica = ? WHERE nPais = ?";
        
        try {
            Connection csConn        = csOpenConnection();
            PreparedStatement csPstmt = csConn.prepareStatement(csQuery);
            csPstmt.setString(1, entity.getCsNombre());
            csPstmt.setString(2, csDtf.format(csNow).toString());
            csPstmt.setInt(3, entity.getCsNPais());

            csPstmt.executeUpdate();
            return true;    
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer n) throws Exception {
        String csQuery = "UPDATE CSPais SET Estado = ? WHERE nPais = ? ";
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
    public CSPaisDTO readBy(Integer n) throws Exception {
        CSPaisDTO csPaisDTO = new CSPaisDTO();
        String csQuery = "SELECT nPais, "
                       + "nombre,       "
                       + "Estado,       "
                       + "FechaCrea,    "
                       + "FechaModifica "
                       + "FROM CSPais   "
                       + "WHERE Estado = 'A' AND nPais = " + n.toString();
        try {
            Connection csConn = csOpenConnection();
            Statement csStmt  = csConn.createStatement();
            ResultSet csRs    = csStmt.executeQuery(csQuery);

            while(csRs.next()){
                csPaisDTO = new CSPaisDTO(csRs.getInt(1),
                                          csRs.getString(2),
                                          csRs.getString(3),
                                          csRs.getString(4),
                                          csRs.getString(5));
            }
                
        } catch (SQLException e) {
            throw e;
        }
        return csPaisDTO;
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String csQuery = "SELECT COUNT (*) TotalReg FROM CSPais WHERE Estado = 'A'";
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