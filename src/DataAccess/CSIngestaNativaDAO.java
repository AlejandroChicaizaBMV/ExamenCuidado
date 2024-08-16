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

import DataAccess.DTO.CSIngestaNativaDTO;

public class CSIngestaNativaDAO extends CSSQLiteDataHelper implements IDAO<CSIngestaNativaDTO>{

    @Override
    public boolean create(CSIngestaNativaDTO entity) throws Exception {
        String csQuery = "INSERT INTO CSIngestaNativa (nombre) VALUES (?)";
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
    public List<CSIngestaNativaDTO> readAll() throws Exception {
        List <CSIngestaNativaDTO> csLst =  new ArrayList<>();
        String csQuery = "SELECT nIngestaNativa, "
                       + "nombre,               "
                       + "Estado,               "
                       + "FechaCrea,            "
                       + "FechaModifica        "
                       + "FROM CSIngestaNativa   "
                       + "WHERE Estado = 'A' ";
        try {
            Connection csConn = csOpenConnection();
            Statement csStmt  = csConn.createStatement();
            ResultSet csRs    = csStmt.executeQuery(csQuery);

            while(csRs.next()){
                CSIngestaNativaDTO csIngestaNativaDTO = new CSIngestaNativaDTO(csRs.getInt(1),
                                                                            csRs.getString(2),
                                                                            csRs.getString(3),
                                                                            csRs.getString(4),
                                                                            csRs.getString(5));
                csLst.add(csIngestaNativaDTO);                                    
            }
        } catch (SQLException e) {
            throw e;
        }
        return csLst;
    }

    @Override
    public boolean update(CSIngestaNativaDTO entity) throws Exception {
        DateTimeFormatter csDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime     csNow = LocalDateTime.now();
        String csQuery = "UPDATE CSIngestaNativa SET nombre = ?, FechaModifica = ? WHERE nIngestaNativa = ?";
        
        try {
            Connection csConn        = csOpenConnection();
            PreparedStatement csPstmt = csConn.prepareStatement(csQuery);
            csPstmt.setString(1, entity.getCsNombre());
            csPstmt.setString(2, csDtf.format(csNow).toString());
            csPstmt.setInt(3, entity.getCsNIngestaNativa());

            csPstmt.executeUpdate();
            return true;    
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer n) throws Exception {
        String csQuery = "UPDATE CSIngestaNativa SET Estado = ? WHERE nIngestaNativa = ? ";
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
    public CSIngestaNativaDTO readBy(Integer n) throws Exception {
        CSIngestaNativaDTO csIngestaNativaDTO = new CSIngestaNativaDTO();
        String csQuery = "SELECT nIngestaNativa, "
                       + "nombre,               "
                       + "Estado,               "
                       + "FechaCrea,            "
                       + "FechaModifica         "
                       + "FROM CSIngestaNativa   "
                       + "WHERE Estado = 'A' AND nIngestaNativa = " + n.toString();
        try {
            Connection csConn = csOpenConnection();
            Statement  csStmt = csConn.createStatement();
            ResultSet  csRs   = csStmt.executeQuery(csQuery);

            while(csRs.next()){
                csIngestaNativaDTO = new CSIngestaNativaDTO(csRs.getInt(1),
                                                         csRs.getString(2),
                                                         csRs.getString(3),
                                                         csRs.getString(4),
                                                         csRs.getString(5));

            }
                
        } catch (SQLException e) {
            throw e;
        }
        return csIngestaNativaDTO;
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String csQuery = "SELECT COUNT (*) TotalReg FROM CSIngestaNativa WHERE Estado = 'A'";
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