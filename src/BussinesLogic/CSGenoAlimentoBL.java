package BussinesLogic;

import java.util.List;

import DataAccess.CSGenoAlimentoDAO;
import DataAccess.DTO.CSGenoAlimentoDTO;

public class CSGenoAlimentoBL {
    private CSGenoAlimentoDTO csGenoAlimentoDTO;
    private CSGenoAlimentoDAO csGenoAlimentoDAO = new CSGenoAlimentoDAO();
    
    public boolean add(CSGenoAlimentoDTO csGenoAlimentoDTO) throws Exception {
        return csGenoAlimentoDAO.create(csGenoAlimentoDTO);
    }

    public  List<CSGenoAlimentoDTO> getAll() throws Exception {
        List<CSGenoAlimentoDTO> csLst = csGenoAlimentoDAO.readAll();
        return csLst;
    }

    public boolean update(CSGenoAlimentoDTO csGenoAlimentoDTO) throws Exception {
        return csGenoAlimentoDAO.update(csGenoAlimentoDTO);
    }

    public boolean delete(int n) throws Exception {
        return csGenoAlimentoDAO.delete(n);
    }

    public CSGenoAlimentoDTO getBy(int n) throws Exception {
        csGenoAlimentoDTO = csGenoAlimentoDAO.readBy(n);
        return csGenoAlimentoDTO;
    }

    public Integer getRowCount() throws Exception {
        return csGenoAlimentoDAO.getMaxRow();
    }
}