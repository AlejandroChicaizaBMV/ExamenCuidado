package BussinesLogic;

import java.util.List;

import DataAccess.CSSexoDAO;
import DataAccess.DTO.CSSexoDTO;

public class CSSexoBL {
    private CSSexoDTO csSexoDTO;
    private CSSexoDAO csSexoDAO = new CSSexoDAO();
    
    public boolean add(CSSexoDTO csSexoDTO) throws Exception {
        return csSexoDAO.create(csSexoDTO);
    }

    public List<CSSexoDTO> getAll() throws Exception {
        List<CSSexoDTO> csLst = csSexoDAO.readAll();
        return csLst;
    }

    public boolean update(CSSexoDTO csSexoDTO) throws Exception {
        return csSexoDAO.update(csSexoDTO);
    }

    public boolean delete(int n) throws Exception {
        return csSexoDAO.delete(n);
    }

    public CSSexoDTO getBy(int n) throws Exception {
        csSexoDTO = csSexoDAO.readBy(n);
        return csSexoDTO;
    }

    public Integer getRowCount() throws Exception {
        return csSexoDAO.getMaxRow();
    }
}