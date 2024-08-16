package BussinesLogic;

import java.util.List;

import DataAccess.CSIngestaNativaDAO;
import DataAccess.DTO.CSIngestaNativaDTO;

public class CSIngestaNativaBL {
    private CSIngestaNativaDTO csIngestaNativaDTO;
    private CSIngestaNativaDAO csIngestaNativaDAO = new CSIngestaNativaDAO();
    
    public boolean add(CSIngestaNativaDTO csIngestaNativaDTO) throws Exception {
        return csIngestaNativaDAO.create(csIngestaNativaDTO);
    }

    public List<CSIngestaNativaDTO> getAll() throws Exception {
        List<CSIngestaNativaDTO> csLst = csIngestaNativaDAO.readAll();
        return csLst;
    }

    public boolean update(CSIngestaNativaDTO csIngestaNativaDTO) throws Exception {
        return csIngestaNativaDAO.update(csIngestaNativaDTO);
    }

    public boolean delete(int n) throws Exception {
        return csIngestaNativaDAO.delete(n);
    }

    public CSIngestaNativaDTO getBy(int n) throws Exception {
        csIngestaNativaDTO = csIngestaNativaDAO.readBy(n);
        return csIngestaNativaDTO;
    }

    public Integer getRowCount() throws Exception {
        return csIngestaNativaDAO.getMaxRow();
    }
}