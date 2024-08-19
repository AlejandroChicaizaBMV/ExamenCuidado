package DataAccess.DTO;

public class CSHormigaDTO {
    private int csNHormiga;
    private int csId_TipoHormiga;
    private String csTipoHormiga;
    private int csId_Sexo;
    private String csSexo;
    private int csId_Provincia;
    private String csProvincia;
    private int csId_GenoAlimento;
    private String csGenoAlimento;
    private int csId_IngestaNativa;
    private String csIngestaNativa;
    private String csEstado;
    private String csFechaCrea;
    private String csFechaModifica;

    
    
    public CSHormigaDTO() {
    }


    
    public CSHormigaDTO(int csNHormiga, int csId_TipoHormiga, int csId_IngestaNativa) {
        this.csNHormiga = csNHormiga;
        this.csId_TipoHormiga = csId_TipoHormiga;
        this.csId_IngestaNativa = csId_IngestaNativa;
    }



    public CSHormigaDTO(int csNHormiga, int csId_TipoHormiga) {
        this.csNHormiga = csNHormiga;
        this.csId_TipoHormiga = csId_TipoHormiga;
    }



    public CSHormigaDTO(String csTipoHormiga) {
        this.csTipoHormiga = csTipoHormiga;
    }

    public CSHormigaDTO(int csId_TipoHormiga, int csId_Sexo, int csId_Provincia, int csId_GenoAlimento,
            int csId_IngestaNativa) {
        this.csId_TipoHormiga = csId_TipoHormiga;
        this.csId_Sexo = csId_Sexo;
        this.csId_Provincia = csId_Provincia;
        this.csId_GenoAlimento = csId_GenoAlimento;
        this.csId_IngestaNativa = csId_IngestaNativa;
    }

    public CSHormigaDTO(int csNHormiga, String csTipoHormiga, String csSexo, String csProvincia, String csGenoAlimento,
            String csIngestaNativa, String csEstado, String csFechaCrea, String csFechaModifica) {
        this.csNHormiga = csNHormiga;
        this.csTipoHormiga = csTipoHormiga;
        this.csSexo = csSexo;
        this.csProvincia = csProvincia;
        this.csGenoAlimento = csGenoAlimento;
        this.csIngestaNativa = csIngestaNativa;
        this.csEstado = csEstado;
        this.csFechaCrea = csFechaCrea;
        this.csFechaModifica = csFechaModifica;
    }
    
    public int getCsNHormiga() {
        return csNHormiga;
    }
    public void setCsNHormiga(int csNHormiga) {
        this.csNHormiga = csNHormiga;
    }
    public int getCsId_TipoHormiga() {
        return csId_TipoHormiga;
    }
    public void setCsId_TipoHormiga(int csId_TipoHormiga) {
        this.csId_TipoHormiga = csId_TipoHormiga;
    }
    public String getCsTipoHormiga() {
        return csTipoHormiga;
    }
    public void setCsTipoHormiga(String csTipoHormiga) {
        this.csTipoHormiga = csTipoHormiga;
    }
    public int getCsId_Sexo() {
        return csId_Sexo;
    }
    public void setCsId_Sexo(int csId_Sexo) {
        this.csId_Sexo = csId_Sexo;
    }
    public String getCsSexo() {
        return csSexo;
    }
    public void setCsSexo(String csSexo) {
        this.csSexo = csSexo;
    }
    public int getCsId_Provincia() {
        return csId_Provincia;
    }
    public void setCsId_Provincia(int csId_Provincia) {
        this.csId_Provincia = csId_Provincia;
    }
    public String getCsProvincia() {
        return csProvincia;
    }
    public void setCsProvincia(String csProvincia) {
        this.csProvincia = csProvincia;
    }
    public int getCsId_GenoAlimento() {
        return csId_GenoAlimento;
    }
    public void setCsId_GenoAlimento(int csId_GenoAlimento) {
        this.csId_GenoAlimento = csId_GenoAlimento;
    }
    public String getCsGenoAlimento() {
        return csGenoAlimento;
    }
    public void setCsGenoAlimento(String csGenoAlimento) {
        this.csGenoAlimento = csGenoAlimento;
    }
    public int getCsId_IngestaNativa() {
        return csId_IngestaNativa;
    }
    public void setCsId_IngestaNativa(int csId_IngestaNativa) {
        this.csId_IngestaNativa = csId_IngestaNativa;
    }
    public String getCsIngestaNativa() {
        return csIngestaNativa;
    }
    public void setCsIngestaNativa(String csIngestaNativa) {
        this.csIngestaNativa = csIngestaNativa;
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

}