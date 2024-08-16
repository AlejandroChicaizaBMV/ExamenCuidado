package DataAccess.DTO;

public class CSIngestaNativaDTO {
    private Integer csNIngestaNativa;
    private String csNombre;
    private String csEstado;
    private String csFechaCrea;
    private String csFechaModifica;

    
    public CSIngestaNativaDTO() {}

    
    public CSIngestaNativaDTO(Integer csNIngestaNativa, String csNombre) {
        this.csNIngestaNativa = csNIngestaNativa;
        this.csNombre = csNombre;
    }


    public CSIngestaNativaDTO(String csNombre) {
        this.csNombre = csNombre;
    }


    public CSIngestaNativaDTO(Integer csNIngestaNativa, String csNombre, String csEstado, String csFechaCrea,
            String csFechaModifica) {
        this.csNIngestaNativa = csNIngestaNativa;
        this.csNombre = csNombre;
        this.csEstado = csEstado;
        this.csFechaCrea = csFechaCrea;
        this.csFechaModifica = csFechaModifica;
    }


    public Integer getCsNIngestaNativa() {
        return csNIngestaNativa;
    }
    public void setCsNIngestaNativa(Integer csNIngestaNativa) {
        this.csNIngestaNativa = csNIngestaNativa;
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
        +"\n nIngestaNativa :    "+ getCsNIngestaNativa()
        +"\n Nombre:            "+ getCsNombre()
        +"\n Estado:            "+ getCsEstado()
        +"\n FechaCreacion:     "+ getCsFechaCrea()
        +"\n FechaModifica:     "+ getCsFechaModifica();
    }
    
}