package DataAccess.DTO;

public class CSPaisDTO {
    private Integer csNPais;
    private String csNombre;
    private String csEstado;
    private String csFechaCrea;
    private String csFechaModifica;

    
    public CSPaisDTO() {}

    
    public CSPaisDTO(Integer csNPais, String csNombre) {
        this.csNPais = csNPais;
        this.csNombre = csNombre;
    }


    public CSPaisDTO(String csNombre) {
        this.csNombre = csNombre;
    }


    public CSPaisDTO(Integer csNPais, String csNombre, String csEstado, String csFechaCrea,
            String csFechaModifica) {
        this.csNPais = csNPais;
        this.csNombre = csNombre;
        this.csEstado = csEstado;
        this.csFechaCrea = csFechaCrea;
        this.csFechaModifica = csFechaModifica;
    }


    public Integer getCsNPais() {
        return csNPais;
    }
    public void setCsNPais(Integer csNPais) {
        this.csNPais = csNPais;
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
        +"\n nPais :    "+ getCsNPais()
        +"\n Nombre:            "+ getCsNombre()
        +"\n Estado:            "+ getCsEstado()
        +"\n FechaCreacion:     "+ getCsFechaCrea()
        +"\n FechaModifica:     "+ getCsFechaModifica();
    }
    
}