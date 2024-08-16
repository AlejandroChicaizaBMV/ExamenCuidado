package BussinesLogic;

import java.util.List;

import DataAccess.CSRegionDAO;
import DataAccess.DTO.CSRegionDTO;

public class CSRegionBL {
    private CSRegionDTO csRegionDTO;
    private CSRegionDAO csRegionDAO = new CSRegionDAO();
    
    public boolean add(CSRegionDTO csRegionDTO) throws Exception {
        return csRegionDAO.create(csRegionDTO);
    }

    public List<CSRegionDTO> getAll() throws Exception {
        List<CSRegionDTO> csLst = csRegionDAO.readAll();
        return csLst;
    }

    public boolean update(CSRegionDTO csRegionDTO) throws Exception {
        return csRegionDAO.update(csRegionDTO);
    }

    public boolean delete(int n) throws Exception {
        return csRegionDAO.delete(n);
    }

    public CSRegionDTO getBy(int n) throws Exception {
        csRegionDTO = csRegionDAO.readBy(n);
        return csRegionDTO;
    }

    public Integer getRowCount() throws Exception {
        return csRegionDAO.getMaxRow();
    }
}