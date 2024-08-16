package BussinesLogic;

import java.util.List;

import DataAccess.CSProvinciaDAO;
import DataAccess.DTO.CSProvinciaDTO;

public class CSProvinciaBL {
    private CSProvinciaDTO csProvinciaDTO;
    private CSProvinciaDAO csProvinciaDAO = new CSProvinciaDAO();
    
    public boolean add(CSProvinciaDTO csProvinciaDTO) throws Exception {
        return csProvinciaDAO.create(csProvinciaDTO);
    }

    public List<CSProvinciaDTO> getAll() throws Exception {
        List<CSProvinciaDTO> csLst = csProvinciaDAO.readAll();
        return csLst;
    }

    public boolean update(CSProvinciaDTO csProvinciaDTO) throws Exception {
        return csProvinciaDAO.update(csProvinciaDTO);
    }

    public boolean delete(int n) throws Exception {
        return csProvinciaDAO.delete(n);
    }

    public CSProvinciaDTO getBy(int n) throws Exception {
        csProvinciaDTO = csProvinciaDAO.readBy(n);
        return csProvinciaDTO;
    }

    public Integer getRowCount() throws Exception {
        return csProvinciaDAO.getMaxRow();
    }
}