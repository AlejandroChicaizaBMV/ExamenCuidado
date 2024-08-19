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

import DataAccess.DTO.CSHormigaDTO;

public class CSHormigaDAO extends CSSQLiteDataHelper implements IDAO<CSHormigaDTO> {

    public boolean superDelete(Integer n) throws Exception {
        String csQuery = "UPDATE CSHormiga SET Estado = 'X' WHERE nHormiga = ?";
        try {
            Connection csConn = csOpenConnection();
            PreparedStatement csPstmt = csConn.prepareStatement(csQuery);
            csPstmt.setInt(1, n);
            csPstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    public String readTipoBy(Integer nHormiga) throws SQLException{
        CSHormigaDTO csHormigaDTO = new CSHormigaDTO();
        String query = "SELECT TipoHormiga FROM CSHormiga WHERE Estado = 'VIVA' AND nHormiga = " + nHormiga;
        String Tipo;
        try {
            Connection csConn = csOpenConnection();
            Statement csStmt = csConn.createStatement();
            ResultSet csRs = csStmt.executeQuery(query);

            while (csRs.next()) {
                csHormigaDTO = new CSHormigaDTO(csRs.getString(1));
            }
            Tipo = csHormigaDTO.getCsTipoHormiga();

        } catch (SQLException e) {
            throw e;
        }
        return Tipo;
    }

    public boolean updateTipo(CSHormigaDTO entity) throws Exception {
        DateTimeFormatter csDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime     csNow = LocalDateTime.now();
        String csQuery = "UPDATE CSHormiga SET id_TipoHormiga = ?,id_IngestaNativa = ?, FechaModifica = ? WHERE nHormiga = ?";
        
        try {
            Connection csConn        = csOpenConnection();
            PreparedStatement csPstmt = csConn.prepareStatement(csQuery);

            csPstmt.setInt(1, entity.getCsId_TipoHormiga());
            csPstmt.setInt(2, entity.getCsId_IngestaNativa());
            csPstmt.setString(3, csDtf.format(csNow).toString());
            csPstmt.setInt(4, entity.getCsNHormiga());

            csPstmt.executeUpdate();
            return true;    
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean create(CSHormigaDTO entity) throws Exception {
        String csQuery = "INSERT INTO CSHormiga (id_TipoHormiga, id_Sexo, id_Provincia, id_GenoAlimento, id_IngestaNativa) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection csConn = csOpenConnection();
            PreparedStatement csPstmt = csConn.prepareStatement(csQuery);

            csPstmt.setInt(1, entity.getCsId_TipoHormiga());
            csPstmt.setInt(2, entity.getCsId_Sexo()); 
            csPstmt.setInt(3, entity.getCsId_Provincia());
            csPstmt.setInt(4, entity.getCsId_GenoAlimento());
            csPstmt.setInt(5, entity.getCsId_IngestaNativa());

            csPstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<CSHormigaDTO> readAll() throws Exception {
        List<CSHormigaDTO> csLst = new ArrayList<>();
        String csQuery = "SELECT nHormiga, TipoHormiga, Sexo, Provincia, GenoAlimento, IngestaNativa, Estado, FechaCrea, FechaModifica FROM CSHormiga WHERE Estado NOT IN ('X')";
        try {
            Connection csConn = csOpenConnection();
            Statement csStmt  = csConn.createStatement();
            ResultSet csRs    = csStmt.executeQuery(csQuery);

            while (csRs.next()) {
                CSHormigaDTO csHormigaDTO = new CSHormigaDTO(
                    csRs.getInt(1),
                    csRs.getString(2),
                    csRs.getString(3),
                    csRs.getString(4),
                    csRs.getString(5),
                    csRs.getString(6),
                    csRs.getString(7),
                    csRs.getString(8),
                    csRs.getString(9)
                );
                csLst.add(csHormigaDTO);                                    
            }
        } catch (SQLException e) {
            throw e;
        }
        return csLst;
    }

    @Override
    public boolean update(CSHormigaDTO entity) throws Exception {
        DateTimeFormatter csDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime     csNow = LocalDateTime.now();
        String csQuery = "UPDATE CSHormiga SET TipoHormiga = ?, Sexo = ?, Provincia = ?, GenoAlimento = ?, IngestaNativa = ?, FechaModifica = ? WHERE nHormiga = ?";
        
        try {
            Connection csConn        = csOpenConnection();
            PreparedStatement csPstmt = csConn.prepareStatement(csQuery);
            csPstmt.setInt(1, entity.getCsId_TipoHormiga());
            csPstmt.setInt(2, entity.getCsId_Sexo());
            csPstmt.setInt(3, entity.getCsId_Provincia());
            csPstmt.setInt(4, entity.getCsId_GenoAlimento());
            csPstmt.setInt(5, entity.getCsId_IngestaNativa());
            csPstmt.setString(6, csDtf.format(csNow).toString());
            csPstmt.setInt(7, entity.getCsNHormiga());

            csPstmt.executeUpdate();
            return true;    
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer n) throws Exception {
        String csQuery = "UPDATE CSHormiga SET Estado = 'MUERTA' WHERE nHormiga = "+n.toString();
        try {
            Connection csConn = csOpenConnection();
            PreparedStatement csPstmt = csConn.prepareStatement(csQuery);
            csPstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public CSHormigaDTO readBy(Integer n) throws Exception {
        CSHormigaDTO csHormigaDTO = new CSHormigaDTO();
        String csQuery = "SELECT nHormiga, TipoHormiga, Sexo, Provincia, GenoAlimento, IngestaNativa, Estado, FechaCrea, FechaModifica FROM CSHormiga WHERE Estado NOT IN ('X') AND nHormiga = ?";
        try {
            Connection csConn = csOpenConnection();
            PreparedStatement csPstmt = csConn.prepareStatement(csQuery);
            csPstmt.setInt(1, n);
            ResultSet csRs = csPstmt.executeQuery();

            if (csRs.next()) {
                csHormigaDTO = new CSHormigaDTO(csRs.getInt(1),
                csRs.getString(2),
                csRs.getString(3),
                csRs.getString(4),
                csRs.getString(5),
                csRs.getString(6),
                csRs.getString(7),
                csRs.getString(8),
                csRs.getString(9)
                );
            }
        } catch (SQLException e) {
            throw e;
        }
        return csHormigaDTO;
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String csQuery = "SELECT COUNT(*) TotalReg FROM CSHormiga WHERE Estado = 'A'";
        try {
            Connection csConn = csOpenConnection();
            Statement csStmt = csConn.createStatement();
            ResultSet csRs = csStmt.executeQuery(csQuery);

            if (csRs.next()) {
                return csRs.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        }
        return 0;
    }
}