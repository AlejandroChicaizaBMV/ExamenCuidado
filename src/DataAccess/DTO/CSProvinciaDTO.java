package DataAccess.DTO;

public class CSProvinciaDTO {
    private Integer csNProvincia;
    private String csNombre;
    private String csEstado;
    private String csFechaCrea;
    private String csFechaModifica;

    
    public CSProvinciaDTO() {}

    
    public CSProvinciaDTO(Integer csNProvincia, String csNombre) {
        this.csNProvincia = csNProvincia;
        this.csNombre = csNombre;
    }


    public CSProvinciaDTO(String csNombre) {
        this.csNombre = csNombre;
    }


    public CSProvinciaDTO(Integer csNProvincia, String csNombre, String csEstado, String csFechaCrea,
            String csFechaModifica) {
        this.csNProvincia = csNProvincia;
        this.csNombre = csNombre;
        this.csEstado = csEstado;
        this.csFechaCrea = csFechaCrea;
        this.csFechaModifica = csFechaModifica;
    }


    public Integer getCsNProvincia() {
        return csNProvincia;
    }
    public void setCsNProvincia(Integer csNProvincia) {
        this.csNProvincia = csNProvincia;
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
        +"\n nProvincia:        "+ getCsNProvincia()
        +"\n Nombre:            "+ getCsNombre()
        +"\n Estado:            "+ getCsEstado()
        +"\n FechaCreacion:     "+ getCsFechaCrea()
        +"\n FechaModifica:     "+ getCsFechaModifica();
    }
    
}