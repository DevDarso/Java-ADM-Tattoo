package admtattoo;

public class FormResponsa {

    private int id;
    private int idCliente;
    private String titulo;
    private String cabecalho;
    private String cabecalhoResponsa;
    private String questionario;
    private String cidade;
    private String empresa;
    private String rodape;

    public FormResponsa() {
    }

    public FormResponsa(int id, int idCliente, String titulo, String cabecalho, String cabecalhoResponsa, String questionario, String cidade, String empresa, String rodape) {
        this.id = id;
        this.idCliente = idCliente;
        this.titulo = titulo;
        this.cabecalho = cabecalho;
        this.cabecalhoResponsa = cabecalhoResponsa;
        this.questionario = questionario;
        this.cidade = cidade;
        this.empresa = empresa;
        this.rodape = rodape;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(String cabecalho) {
        this.cabecalho = cabecalho;
    }

    public String getCabecalhoResponsa() {
        return cabecalhoResponsa;
    }

    public void setCabecalhoResponsa(String cabecalhoResponsa) {
        this.cabecalhoResponsa = cabecalhoResponsa;
    }

    public String getQuestionario() {
        return questionario;
    }

    public void setQuestionario(String questionario) {
        this.questionario = questionario;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getRodape() {
        return rodape;
    }

    public void setRodape(String rodape) {
        this.rodape = rodape;
    }

    public String gerarTextoCompleto() {
        return titulo + "\n" + cabecalho + "\n" + questionario + "\n" + rodape;
    }

    public String gerarTextoCompletoResponsa() {
        return titulo + "\n" + cabecalho + "\n" + cabecalhoResponsa + "\n" + questionario + "\n" + rodape;
    }
}
