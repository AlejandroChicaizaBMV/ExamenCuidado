package BussinesLogic;

import java.util.List;

import DataAccess.CSPaisDAO;
import DataAccess.DTO.CSPaisDTO;

public class CSPaisBL {
    private CSPaisDTO csPaisDTO;
    private CSPaisDAO csPaisDAO = new CSPaisDAO();
    
    public boolean add(CSPaisDTO csPaisDTO) throws Exception {
        return csPaisDAO.create(csPaisDTO);
    }

    public List<CSPaisDTO> getAll() throws Exception {
        List<CSPaisDTO> csLst = csPaisDAO.readAll();
        return csLst;
    }

    public boolean update(CSPaisDTO csPaisDTO) throws Exception {
        return csPaisDAO.update(csPaisDTO);
    }

    public boolean delete(int n) throws Exception {
        return csPaisDAO.delete(n);
    }

    public CSPaisDTO getBy(int n) throws Exception {
        csPaisDTO = csPaisDAO.readBy(n);
        return csPaisDTO;
    }

    public Integer getRowCount() throws Exception {
        return csPaisDAO.getMaxRow();
    }
}