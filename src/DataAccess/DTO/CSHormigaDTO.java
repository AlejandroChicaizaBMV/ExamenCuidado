package DataAccess.DTO;

public class CSHormigaDTO {
    private Integer nHormiga;
    private String tipoHormiga;
    private Integer sexo;
    private Integer provincia;
    private Integer genoAlimento;
    private Integer ingestaNativa;
    private String estado;
    private String fechaCrea;
    private String fechaModifica;

    // Constructores
    public CSHormigaDTO() {}

    public CSHormigaDTO(String tipoHormiga, Integer sexo, Integer provincia, Integer genoAlimento,
            Integer ingestaNativa) {
        this.tipoHormiga = tipoHormiga;
        this.sexo = sexo;
        this.provincia = provincia;
        this.genoAlimento = genoAlimento;
        this.ingestaNativa = ingestaNativa;
    }

    public CSHormigaDTO(Integer nHormiga, String tipoHormiga) {
        this.nHormiga = nHormiga;
        this.tipoHormiga = tipoHormiga;
    }

    public CSHormigaDTO(String tipoHormiga) {
        this.tipoHormiga = tipoHormiga;
    }

    public CSHormigaDTO(Integer nHormiga, String tipoHormiga, Integer sexo, Integer provincia,
                        Integer genoAlimento, Integer ingestaNativa, String estado,
                        String fechaCrea, String fechaModifica) {
        this.nHormiga = nHormiga;
        this.tipoHormiga = tipoHormiga;
        this.sexo = sexo;
        this.provincia = provincia;
        this.genoAlimento = genoAlimento;
        this.ingestaNativa = ingestaNativa;
        this.estado = estado;
        this.fechaCrea = fechaCrea;
        this.fechaModifica = fechaModifica;
    }

    // Getters y Setters
    public Integer getnHormiga() { return nHormiga; }
    public void setnHormiga(Integer nHormiga) { this.nHormiga = nHormiga; }
    public String getTipoHormiga() { return tipoHormiga; }
    public void setTipoHormiga(String tipoHormiga) { this.tipoHormiga = tipoHormiga; }
    public Integer getSexo() { return sexo; }
    public void setSexo(Integer sexo) { this.sexo = sexo; }
    public Integer getProvincia() { return provincia; }
    public void setProvincia(Integer provincia) { this.provincia = provincia; }
    public Integer getGenoAlimento() { return genoAlimento; }
    public void setGenoAlimento(Integer genoAlimento) { this.genoAlimento = genoAlimento; }
    public Integer getIngestaNativa() { return ingestaNativa; }
    public void setIngestaNativa(Integer ingestaNativa) { this.ingestaNativa = ingestaNativa; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getFechaCrea() { return fechaCrea; }
    public void setFechaCrea(String fechaCrea) { this.fechaCrea = fechaCrea; }
    public String getFechaModifica() { return fechaModifica; }
    public void setFechaModifica(String fechaModifica) { this.fechaModifica = fechaModifica; }

    @Override
    public String toString() {
        return getClass().getName()
        +"\n nHormiga:           " + getnHormiga()
        +"\n TipoHormiga:        " + getTipoHormiga()
        +"\n Sexo:               " + getSexo()
        +"\n Provincia:          " + getProvincia()
        +"\n GenoAlimento:       " + getGenoAlimento()
        +"\n IngestaNativa:      " + getIngestaNativa()
        +"\n Estado:             " + getEstado()
        +"\n FechaCreacion:      " + getFechaCrea()
        +"\n FechaModifica:      " + getFechaModifica();
    }
}