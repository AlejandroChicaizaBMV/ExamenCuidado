package DataAccess.DTO;

public class CSRegionDTO {
    private Integer csNRegion;
    private String csNombre;
    private String csEstado;
    private String csFechaCrea;
    private String csFechaModifica;

    
    public CSRegionDTO() {}

    
    public CSRegionDTO(Integer csNRegion, String csNombre) {
        this.csNRegion = csNRegion;
        this.csNombre = csNombre;
    }


    public CSRegionDTO(String csNombre) {
        this.csNombre = csNombre;
    }


    public CSRegionDTO(Integer csNRegion, String csNombre, String csEstado, String csFechaCrea,
            String csFechaModifica) {
        this.csNRegion = csNRegion;
        this.csNombre = csNombre;
        this.csEstado = csEstado;
        this.csFechaCrea = csFechaCrea;
        this.csFechaModifica = csFechaModifica;
    }


    public Integer getCsNRegion() {
        return csNRegion;
    }
    public void setCsNRegion(Integer csNRegion) {
        this.csNRegion = csNRegion;
    }
    public String getCsNombre() {
        return csNombre;
    }
    public void setCsNombre(String csNombre) {
        this.csNombre = csNombre;
    }
    public String getCsEstado() {
        return csEstado;
    }
    public void setCsEstado(String csEstado) {
        this.csEstado = csEstado;
    }
    public String getCsFechaCrea() {
        return csFechaCrea;
    }
    public void setCsFechaCrea(String csFechaCrea) {
        this.csFechaCrea = csFechaCrea;
    }
    public String getCsFechaModifica() {
        return csFechaModifica;
    }
    public void setCsFechaModifica(String csFechaModifica) {
        this.csFechaModifica = csFechaModifica;
    }

    @Override
    public String toString(){
        return getClass().getName()
        +"\n nRegion:          "+ getCsNRegion()
        +"\n Nombre:           "+ getCsNombre()
        +"\n Estado:           "+ getCsEstado()
        +"\n FechaCreacion:    "+ getCsFechaCrea()
        +"\n FechaModifica:    "+ getCsFechaModifica();
    }
    
}