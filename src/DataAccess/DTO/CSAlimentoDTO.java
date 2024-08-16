package DataAccess.DTO;

public class CSAlimentoDTO {
    private Integer nAlimento;
    private Integer ingestaNativa;
    private Integer genoAlimento;
    private String estado;
    private String fechaCrea;
    private String fechaModifica;

    // Constructores
    public CSAlimentoDTO() {}

    public CSAlimentoDTO(Integer nAlimento) {
        this.nAlimento = nAlimento;
    }


    public CSAlimentoDTO(Integer ingestaNativa, Integer genoAlimento) {
        this.ingestaNativa = ingestaNativa;
        this.genoAlimento = genoAlimento;
    }

    public CSAlimentoDTO(Integer nAlimento, Integer ingestaNativa, Integer genoAlimento,
                         String estado, String fechaCrea, String fechaModifica) {
        this.nAlimento = nAlimento;
        this.ingestaNativa = ingestaNativa;
        this.genoAlimento = genoAlimento;
        this.estado = estado;
        this.fechaCrea = fechaCrea;
        this.fechaModifica = fechaModifica;
    }

    // Getters y Setters
    public Integer getnAlimento() { return nAlimento; }
    public void setnAlimento(Integer nAlimento) { this.nAlimento = nAlimento; }
    public Integer getIngestaNativa() { return ingestaNativa; }
    public void setIngestaNativa(Integer ingestaNativa) { this.ingestaNativa = ingestaNativa; }
    public Integer getGenoAlimento() { return genoAlimento; }
    public void setGenoAlimento(Integer genoAlimento) { this.genoAlimento = genoAlimento; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getFechaCrea() { return fechaCrea; }
    public void setFechaCrea(String fechaCrea) { this.fechaCrea = fechaCrea; }
    public String getFechaModifica() { return fechaModifica; }
    public void setFechaModifica(String fechaModifica) { this.fechaModifica = fechaModifica; }

    @Override
    public String toString() {
        return getClass().getName()
        +"\n nAlimento:          " + getnAlimento()
        +"\n IngestaNativa:      " + getIngestaNativa()
        +"\n GenoAlimento:       " + getGenoAlimento()
        +"\n Estado:             " + getEstado()
        +"\n FechaCreacion:      " + getFechaCrea()
        +"\n FechaModifica:      " + getFechaModifica();
    }
}