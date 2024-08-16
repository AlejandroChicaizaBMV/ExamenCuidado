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

    @Override
    public boolean create(CSHormigaDTO entity) throws Exception {
        String csQuery = "INSERT INTO CSHormiga (TipoHormiga, Sexo, Provincia, GenoAlimento, IngestaNativa) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection csConn = csOpenConnection();
            PreparedStatement csPstmt = csConn.prepareStatement(csQuery);

            csPstmt.setString(1, entity.getTipoHormiga());
            csPstmt.setObject(2, entity.getSexo(), java.sql.Types.INTEGER); // Manejo de tipos nulos
            csPstmt.setObject(3, entity.getProvincia(), java.sql.Types.INTEGER);
            csPstmt.setObject(4, entity.getGenoAlimento(), java.sql.Types.INTEGER);
            csPstmt.setObject(5, entity.getIngestaNativa(), java.sql.Types.INTEGER);

            csPstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<CSHormigaDTO> readAll() throws Exception {
        List<CSHormigaDTO> csLst = new ArrayList<>();
        String csQuery = "SELECT nHormiga, TipoHormiga, Sexo, Provincia, GenoAlimento, IngestaNativa, Estado, FechaCrea, FechaModifica FROM CSHormiga WHERE Estado = 'A'";
        try {
            Connection csConn = csOpenConnection();
            Statement csStmt  = csConn.createStatement();
            ResultSet csRs    = csStmt.executeQuery(csQuery);

            while (csRs.next()) {
                CSHormigaDTO csHormigaDTO = new CSHormigaDTO(
                    csRs.getInt(1),
                    csRs.getString(2),
                    csRs.getObject(3, Integer.class), // Manejo de tipos nulos
                    csRs.getObject(4, Integer.class),
                    csRs.getObject(5, Integer.class),
                    csRs.getObject(6, Integer.class),
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
            csPstmt.setString(1, entity.getTipoHormiga());
            csPstmt.setObject(2, entity.getSexo(), java.sql.Types.INTEGER);
            csPstmt.setObject(3, entity.getProvincia(), java.sql.Types.INTEGER);
            csPstmt.setObject(4, entity.getGenoAlimento(), java.sql.Types.INTEGER);
            csPstmt.setObject(5, entity.getIngestaNativa(), java.sql.Types.INTEGER);
            csPstmt.setString(6, csDtf.format(csNow).toString());
            csPstmt.setInt(7, entity.getnHormiga());

            csPstmt.executeUpdate();
            return true;    
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer n) throws Exception {
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

    @Override
    public CSHormigaDTO readBy(Integer n) throws Exception {
        CSHormigaDTO csHormigaDTO = new CSHormigaDTO();
        String csQuery = "SELECT nHormiga, TipoHormiga, Sexo, Provincia, GenoAlimento, IngestaNativa, Estado, FechaCrea, FechaModifica FROM CSHormiga WHERE Estado = 'A' AND nHormiga = ?";
        try {
            Connection csConn = csOpenConnection();
            PreparedStatement csPstmt = csConn.prepareStatement(csQuery);
            csPstmt.setInt(1, n);
            ResultSet csRs = csPstmt.executeQuery();

            if (csRs.next()) {
                csHormigaDTO = new CSHormigaDTO(
                    csRs.getInt(1),
                    csRs.getString(2),
                    csRs.getObject(3, Integer.class),
                    csRs.getObject(4, Integer.class),
                    csRs.getObject(5, Integer.class),
                    csRs.getObject(6, Integer.class),
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