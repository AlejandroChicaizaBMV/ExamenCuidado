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

import DataAccess.DTO.CSRegionDTO;

public class CSRegionDAO extends CSSQLiteDataHelper implements IDAO<CSRegionDTO>{

    @Override
    public boolean create(CSRegionDTO entity) throws Exception {
        String csQuery = "INSERT INTO CSRegion (nombre) VALUES (?)";
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
    public List<CSRegionDTO> readAll() throws Exception {
        List <CSRegionDTO> csLst =  new ArrayList<>();
        String csQuery = "SELECT nRegion, "
                       + "nombre,               "
                       + "Estado,               "
                       + "FechaCrea,            "
                       + "FechaModifica        "
                       + "FROM CSRegion         "
                       + "WHERE Estado = 'A' ";
        try {
            Connection csConn = csOpenConnection();
            Statement csStmt  = csConn.createStatement();
            ResultSet csRs    = csStmt.executeQuery(csQuery);

            while(csRs.next()){
                CSRegionDTO csRegionDTO = new CSRegionDTO(csRs.getInt(1),
                                                          csRs.getString(2),
                                                          csRs.getString(3),
                                                          csRs.getString(4),
                                                          csRs.getString(5));
                csLst.add(csRegionDTO);                                    
            }
        } catch (SQLException e) {
            throw e;
        }
        return csLst;
    }

    @Override
    public boolean update(CSRegionDTO entity) throws Exception {
        DateTimeFormatter csDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime     csNow = LocalDateTime.now();
        String csQuery = "UPDATE CSRegion SET nombre = ?, FechaModifica = ? WHERE nRegion = ?";
        
        try {
            Connection csConn        = csOpenConnection();
            PreparedStatement csPstmt = csConn.prepareStatement(csQuery);
            csPstmt.setString(1, entity.getCsNombre());
            csPstmt.setString(2, csDtf.format(csNow).toString());
            csPstmt.setInt(3, entity.getCsNRegion());

            csPstmt.executeUpdate();
            return true;    
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer n) throws Exception {
        String csQuery = "UPDATE CSRegion SET Estado = ? WHERE nRegion = ? ";
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
    public CSRegionDTO readBy(Integer n) throws Exception {
        CSRegionDTO csRegionDTO = new CSRegionDTO();
        String csQuery = "SELECT nRegion, "
                       + "nombre,               "
                       + "Estado,               "
                       + "FechaCrea,            "
                       + "FechaModifica         "
                       + "FROM CSRegion         "
                       + "WHERE Estado = 'A' AND nRegion = " + n.toString();
        try {
            Connection csConn = csOpenConnection();
            Statement  csStmt = csConn.createStatement();
            ResultSet  csRs   = csStmt.executeQuery(csQuery);

            while(csRs.next()){
                csRegionDTO = new CSRegionDTO(csRs.getInt(1),
                                              csRs.getString(2),
                                              csRs.getString(3),
                                              csRs.getString(4),
                                              csRs.getString(5));
            }
                
        } catch (SQLException e) {
            throw e;
        }
        return csRegionDTO;
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String csQuery = "SELECT COUNT (*) TotalReg FROM CSRegion WHERE Estado = 'A'";
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