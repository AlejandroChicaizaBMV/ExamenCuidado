package DataAccess.DTO;

public class CSSexoDTO {
    private Integer csNSexo;
    private String csNombre;
    private String csEstado;
    private String csFechaCrea;
    private String csFechaModifica;

    
    public CSSexoDTO() {}

    
    public CSSexoDTO(Integer csNSexo, String csNombre) {
        this.csNSexo = csNSexo;
        this.csNombre = csNombre;
    }


    public CSSexoDTO(String csNombre) {
        this.csNombre = csNombre;
    }


    public CSSexoDTO(Integer csNSexo, String csNombre, String csEstado, String csFechaCrea,
            String csFechaModifica) {
        this.csNSexo = csNSexo;
        this.csNombre = csNombre;
        this.csEstado = csEstado;
        this.csFechaCrea = csFechaCrea;
        this.csFechaModifica = csFechaModifica;
    }


    public Integer getCsNSexo() {
        return csNSexo;
    }
    public void setCsNSexo(Integer csNSexo) {
        this.csNSexo = csNSexo;
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
        +"\n nSexo :            "+ getCsNSexo()
        +"\n Nombre:            "+ getCsNombre()
        +"\n Estado:            "+ getCsEstado()
        +"\n FechaCreacion:     "+ getCsFechaCrea()
        +"\n FechaModifica:     "+ getCsFechaModifica();
    }
    
}