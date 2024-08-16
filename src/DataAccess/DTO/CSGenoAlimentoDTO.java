package DataAccess.DTO;

public class CSGenoAlimentoDTO {
    private Integer csNGenoAlimento;
    private String csNombre;
    private String csEstado;
    private String csFechaCrea;
    private String csFechaModifica;

    
    public CSGenoAlimentoDTO() {}

    
    public CSGenoAlimentoDTO(Integer csNGenoAlimento, String csNombre) {
        this.csNGenoAlimento = csNGenoAlimento;
        this.csNombre = csNombre;
    }


    public CSGenoAlimentoDTO(String csNombre) {
        this.csNombre = csNombre;
    }


    public CSGenoAlimentoDTO(Integer csNGenoAlimento, String csNombre, String csEstado, String csFechaCrea,
            String csFechaModifica) {
        this.csNGenoAlimento = csNGenoAlimento;
        this.csNombre = csNombre;
        this.csEstado = csEstado;
        this.csFechaCrea = csFechaCrea;
        this.csFechaModifica = csFechaModifica;
    }


    public Integer getCsNGenoAlimento() {
        return csNGenoAlimento;
    }
    public void setCsNGenoAlimento(Integer csNGenoAlimento) {
        this.csNGenoAlimento = csNGenoAlimento;
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
        +"\n nGenoAlimento :    "+ getCsNGenoAlimento()
        +"\n Nombre:            "+ getCsNombre()
        +"\n Estado:            "+ getCsEstado()
        +"\n FechaCreacion:     "+ getCsFechaCrea()
        +"\n FechaModifica:     "+ getCsFechaModifica();
    }
    
}