package DataAccess.DTO;

public class CSTipoHormigaDTO {
    private Integer csNTipoHormiga;
    private String csNombre;
    private String csEstado;
    private String csFechaCrea;
    private String csFechaModifica;

    
    public CSTipoHormigaDTO() {}

    
    public CSTipoHormigaDTO(Integer csNTipoHormiga, String csNombre) {
        this.csNTipoHormiga = csNTipoHormiga;
        this.csNombre = csNombre;
    }


    public CSTipoHormigaDTO(String csNombre) {
        this.csNombre = csNombre;
    }


    public CSTipoHormigaDTO(Integer csNTipoHormiga, String csNombre, String csEstado, String csFechaCrea,
            String csFechaModifica) {
        this.csNTipoHormiga = csNTipoHormiga;
        this.csNombre = csNombre;
        this.csEstado = csEstado;
        this.csFechaCrea = csFechaCrea;
        this.csFechaModifica = csFechaModifica;
    }


    public Integer getCsNTipoHormiga() {
        return csNTipoHormiga;
    }
    public void setCsNTipoHormiga(Integer csNTipoHormiga) {
        this.csNTipoHormiga = csNTipoHormiga;
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
        +"\n nTipoHormiga :     "+ getCsNTipoHormiga()
        +"\n Nombre:            "+ getCsNombre()
        +"\n Estado:            "+ getCsEstado()
        +"\n FechaCreacion:     "+ getCsFechaCrea()
        +"\n FechaModifica:     "+ getCsFechaModifica();
    }
    
}
