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

import DataAccess.DTO.CSAlimentoDTO;

public class CSAlimentoDAO extends CSSQLiteDataHelper implements IDAO<CSAlimentoDTO> {

    @Override
    public boolean create(CSAlimentoDTO entity) throws Exception {
        String csQuery = "INSERT INTO CSAlimento (IngestaNativa, GenoAlimento) VALUES (?, ?)";
        try {
            Connection csConn = csOpenConnection();
            PreparedStatement csPstmt = csConn.prepareStatement(csQuery);

            csPstmt.setObject(1, entity.getIngestaNativa(), java.sql.Types.INTEGER); // Manejo de tipos nulos
            csPstmt.setObject(2, entity.getGenoAlimento(), java.sql.Types.INTEGER);

            csPstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<CSAlimentoDTO> readAll() throws Exception {
        List<CSAlimentoDTO> csLst = new ArrayList<>();
        String csQuery = "SELECT nAlimento, IngestaNativa, GenoAlimento, Estado, FechaCrea, FechaModifica FROM CSAlimento WHERE Estado = 'A'";
        try {
            Connection csConn = csOpenConnection();
            Statement csStmt  = csConn.createStatement();
            ResultSet csRs    = csStmt.executeQuery(csQuery);

            while (csRs.next()) {
                CSAlimentoDTO csAlimentoDTO = new CSAlimentoDTO(
                    csRs.getInt(1),
                    csRs.getObject(2, Integer.class), // Manejo de tipos nulos
                    csRs.getObject(3, Integer.class),
                    csRs.getString(4),
                    csRs.getString(5),
                    csRs.getString(6)
                );
                csLst.add(csAlimentoDTO);                                    
            }
        } catch (SQLException e) {
            throw e;
        }
        return csLst;
    }

    @Override
    public boolean update(CSAlimentoDTO entity) throws Exception {
        DateTimeFormatter csDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime     csNow = LocalDateTime.now();
        String csQuery = "UPDATE CSAlimento SET IngestaNativa = ?, GenoAlimento = ?, FechaModifica = ? WHERE nAlimento = ?";
        
        try {
            Connection csConn        = csOpenConnection();
            PreparedStatement csPstmt = csConn.prepareStatement(csQuery);
            csPstmt.setObject(1, entity.getIngestaNativa(), java.sql.Types.INTEGER);
            csPstmt.setObject(2, entity.getGenoAlimento(), java.sql.Types.INTEGER);
            csPstmt.setString(3, csDtf.format(csNow).toString());
            csPstmt.setInt(4, entity.getnAlimento());

            csPstmt.executeUpdate();
            return true;    
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer n) throws Exception {
        String csQuery = "UPDATE CSAlimento SET Estado = 'X' WHERE nAlimento = ?";
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
    public CSAlimentoDTO readBy(Integer n) throws Exception {
        CSAlimentoDTO csAlimentoDTO = new CSAlimentoDTO();
        String csQuery = "SELECT nAlimento, IngestaNativa, GenoAlimento, Estado, FechaCrea, FechaModifica FROM CSAlimento WHERE Estado = 'A' AND nAlimento = ?";
        try {
            Connection csConn = csOpenConnection();
            PreparedStatement csPstmt = csConn.prepareStatement(csQuery);
            csPstmt.setInt(1, n);
            ResultSet csRs = csPstmt.executeQuery();

            if (csRs.next()) {
                csAlimentoDTO = new CSAlimentoDTO(
                    csRs.getInt(1),
                    csRs.getObject(2, Integer.class),
                    csRs.getObject(3, Integer.class),
                    csRs.getString(4),
                    csRs.getString(5),
                    csRs.getString(6)
                );
            }
        } catch (SQLException e) {
            throw e;
        }
        return csAlimentoDTO;
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String csQuery = "SELECT COUNT(*) TotalReg FROM CSAlimento WHERE Estado = 'A'";
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