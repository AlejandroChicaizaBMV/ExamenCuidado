package BussinesLogic;

import java.util.List;

import DataAccess.CSAlimentoDAO;
import DataAccess.DTO.CSAlimentoDTO;

public class CSAlimentoBL {
    private CSAlimentoDTO csAlimentoDTO;
    private CSAlimentoDAO csAlimentoDAO = new CSAlimentoDAO();
    
    public boolean add (CSAlimentoDTO csAlimentoDTO) throws Exception{
        return csAlimentoDAO.create(csAlimentoDTO);
    }

    public List<CSAlimentoDTO> getAll() throws Exception{
        List<CSAlimentoDTO> csLst = csAlimentoDAO.readAll();
        return csLst;
    }

    public boolean update(CSAlimentoDTO csAlimentoDTO) throws Exception{
        return csAlimentoDAO.update(csAlimentoDTO);
    }

    public boolean delete(int n) throws Exception{
        return csAlimentoDAO.delete(n);
    }

    public CSAlimentoDTO getBy(int n) throws Exception{
        csAlimentoDTO = csAlimentoDAO.readBy(n);
        return csAlimentoDTO;
    }

    public Integer getRowCount() throws Exception{
        return csAlimentoDAO.getMaxRow();
    }
}