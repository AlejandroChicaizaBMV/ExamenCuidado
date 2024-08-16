package BussinesLogic;

import java.util.List;

import DataAccess.CSTipoHormigaDAO;
import DataAccess.DTO.CSTipoHormigaDTO;

public class CSTipoHormigaBL {
    private CSTipoHormigaDTO csTipoHormigaDTO;
    private CSTipoHormigaDAO csTipoHormigaDAO = new CSTipoHormigaDAO();
    
    public boolean add(CSTipoHormigaDTO csTipoHormigaDTO) throws Exception {
        return csTipoHormigaDAO.create(csTipoHormigaDTO);
    }

    public List<CSTipoHormigaDTO> getAll() throws Exception {
        List<CSTipoHormigaDTO> csLst = csTipoHormigaDAO.readAll();
        return csLst;
    }

    public boolean update(CSTipoHormigaDTO csTipoHormigaDTO) throws Exception {
        return csTipoHormigaDAO.update(csTipoHormigaDTO);
    }

    public boolean delete(int n) throws Exception {
        return csTipoHormigaDAO.delete(n);
    }

    public CSTipoHormigaDTO getBy(int n) throws Exception {
        csTipoHormigaDTO = csTipoHormigaDAO.readBy(n);
        return csTipoHormigaDTO;
    }

    public Integer getRowCount() throws Exception {
        return csTipoHormigaDAO.getMaxRow();
    }
}
