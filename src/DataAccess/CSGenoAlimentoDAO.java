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

import DataAccess.DTO.CSGenoAlimentoDTO;

public class CSGenoAlimentoDAO extends CSSQLiteDataHelper implements IDAO<CSGenoAlimentoDTO>{

    @Override
    public boolean create(CSGenoAlimentoDTO entity) throws Exception {
        String csQuery = "INSERT INTO CSGenoAlimento (nombre) VALUES (?)";
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
    public List<CSGenoAlimentoDTO> readAll() throws Exception {
        List <CSGenoAlimentoDTO> csLst =  new ArrayList<>();
        String csQuery = "SELECT nGenoAlimento, "
                       + "nombre,               "
                       + "Estado,               "
                       + "FechaCrea,            "
                       + "FechaModifica        "
                       + "FROM CSGenoAlimento   "
                       + "WHERE Estado = 'A' ";
        try {
            Connection csConn = csOpenConnection();
            Statement csStmt  = csConn.createStatement();
            ResultSet csRs    = csStmt.executeQuery(csQuery);

            while(csRs.next()){
                CSGenoAlimentoDTO csGenoAlimentoDTO = new CSGenoAlimentoDTO(csRs.getInt(1),
                                                                            csRs.getString(2),
                                                                            csRs.getString(3),
                                                                            csRs.getString(4),
                                                                            csRs.getString(5));
                csLst.add(csGenoAlimentoDTO);                                    
            }
        } catch (SQLException e) {
            throw e;
        }
        return csLst;
    }

    @Override
    public boolean update(CSGenoAlimentoDTO entity) throws Exception {
        DateTimeFormatter csDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime     csNow = LocalDateTime.now();
        String csQuery = "UPDATE CSGenoAlimento SET nombre = ?, FechaModifica = ? WHERE nGenoAlimento = ?";
        
        try {
            Connection csConn        = csOpenConnection();
            PreparedStatement csPstmt = csConn.prepareStatement(csQuery);
            csPstmt.setString(1, entity.getCsNombre());
            csPstmt.setString(2, csDtf.format(csNow).toString());
            csPstmt.setInt(3, entity.getCsNGenoAlimento());

            csPstmt.executeUpdate();
            return true;    
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer n) throws Exception {
        String csQuery = "UPDATE CSGenoAlimento SET Estado = ? WHERE nGenoAlimento = ? ";
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
    public CSGenoAlimentoDTO readBy(Integer n) throws Exception {
        CSGenoAlimentoDTO csGenoAlimentoDTO = new CSGenoAlimentoDTO();
        String csQuery = "SELECT nGenoAlimento, "
                       + "nombre,               "
                       + "Estado,               "
                       + "FechaCrea,            "
                       + "FechaModifica         "
                       + "FROM CSGenoAlimento   "
                       + "WHERE Estado = 'A' AND nGenoAlimento = " + n.toString();
        try {
            Connection csConn = csOpenConnection();
            Statement  csStmt = csConn.createStatement();
            ResultSet  csRs   = csStmt.executeQuery(csQuery);

            while(csRs.next()){
                csGenoAlimentoDTO= new CSGenoAlimentoDTO(csRs.getInt(1),
                                                         csRs.getString(2),
                                                         csRs.getString(3),
                                                         csRs.getString(4),
                                                         csRs.getString(5));

            }
                
        } catch (SQLException e) {
            throw e;
        }
        return csGenoAlimentoDTO;
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String csQuery = "SELECT COUNT (*) TotalReg FROM CSGenoAlimento WHERE Estado = 'A'";
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