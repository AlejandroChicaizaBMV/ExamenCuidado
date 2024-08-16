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

import DataAccess.DTO.CSProvinciaDTO;

public class CSProvinciaDAO extends CSSQLiteDataHelper implements IDAO<CSProvinciaDTO>{

    @Override
    public boolean create(CSProvinciaDTO entity) throws Exception {
        String csQuery = "INSERT INTO CSProvincia (nombre) VALUES (?)";
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
    public List<CSProvinciaDTO> readAll() throws Exception {
        List<CSProvinciaDTO> csLst = new ArrayList<>();
        String csQuery = "SELECT nProvincia, "
                       + "nombre,         "
                       + "Estado,         "
                       + "FechaCrea,      "
                       + "FechaModifica   "
                       + "FROM CSProvincia "
                       + "WHERE Estado = 'A' ";
        try {
            Connection csConn = csOpenConnection();
            Statement csStmt  = csConn.createStatement();
            ResultSet csRs    = csStmt.executeQuery(csQuery);

            while(csRs.next()){
                CSProvinciaDTO csProvinciaDTO = new CSProvinciaDTO(csRs.getInt(1),
                                                                   csRs.getString(2),
                                                                   csRs.getString(3),
                                                                   csRs.getString(4),
                                                                   csRs.getString(5));
                csLst.add(csProvinciaDTO);                                    
            }
        } catch (SQLException e) {
            throw e;
        }
        return csLst;
    }

    @Override
    public boolean update(CSProvinciaDTO entity) throws Exception {
        DateTimeFormatter csDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime csNow = LocalDateTime.now();
        String csQuery = "UPDATE CSProvincia SET nombre = ?, FechaModifica = ? WHERE nProvincia = ?";
        
        try {
            Connection csConn        = csOpenConnection();
            PreparedStatement csPstmt = csConn.prepareStatement(csQuery);
            csPstmt.setString(1, entity.getCsNombre());
            csPstmt.setString(2, csDtf.format(csNow).toString());
            csPstmt.setInt(3, entity.getCsNProvincia());

            csPstmt.executeUpdate();
            return true;    
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer n) throws Exception {
        String csQuery = "UPDATE CSProvincia SET Estado = ? WHERE nProvincia = ? ";
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
    public CSProvinciaDTO readBy(Integer n) throws Exception {
        CSProvinciaDTO csProvinciaDTO = new CSProvinciaDTO();
        String csQuery = "SELECT nProvincia, "
                       + "nombre,         "
                       + "Estado,         "
                       + "FechaCrea,      "
                       + "FechaModifica   "
                       + "FROM CSProvincia "
                       + "WHERE Estado = 'A' AND nProvincia = " + n.toString();
        try {
            Connection csConn = csOpenConnection();
            Statement csStmt  = csConn.createStatement();
            ResultSet csRs    = csStmt.executeQuery(csQuery);

            while(csRs.next()){
                csProvinciaDTO = new CSProvinciaDTO(csRs.getInt(1),
                                                    csRs.getString(2),
                                                    csRs.getString(3),
                                                    csRs.getString(4),
                                                    csRs.getString(5));
            }
                
        } catch (SQLException e) {
            throw e;
        }
        return csProvinciaDTO;
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String csQuery = "SELECT COUNT (*) TotalReg FROM CSProvincia WHERE Estado = 'A'";
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