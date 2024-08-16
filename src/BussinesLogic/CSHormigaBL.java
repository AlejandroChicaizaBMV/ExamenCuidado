package BussinesLogic;

import java.util.List;

import DataAccess.CSHormigaDAO;
import DataAccess.DTO.CSHormigaDTO;

public class CSHormigaBL {
    private CSHormigaDTO csHormigaDTO;
    private CSHormigaDAO csHormigaDAO = new CSHormigaDAO();
    
    public boolean add(CSHormigaDTO csHormigaDTO) throws Exception {
        return csHormigaDAO.create(csHormigaDTO);
    }

    public List<CSHormigaDTO> getAll() throws Exception {
        List<CSHormigaDTO> csLst = csHormigaDAO.readAll();
        return csLst;
    }

    public boolean update(CSHormigaDTO csHormigaDTO) throws Exception {
        return csHormigaDAO.update(csHormigaDTO);
    }

    public boolean delete(int n) throws Exception {
        return csHormigaDAO.delete(n);
    }

    public CSHormigaDTO getBy(int n) throws Exception {
        csHormigaDTO = csHormigaDAO.readBy(n);
        return csHormigaDTO;
    }

    public Integer getRowCount() throws Exception {
        return csHormigaDAO.getMaxRow();
    }
}