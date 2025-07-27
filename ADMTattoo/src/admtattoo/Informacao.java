package admtattoo;

public class Informacao {

    private int id;
    private int idAgenda;
    private int idColaborador;
    private int sessao;
    private int porcento;
    private int porcentoColaborador;
    private double valorColaborador;
    private String duracao;
    private String nota;
    private double valorCalculado;
    private String nomeCliente;
    private String nomeFuncionario;
    private double valor;
    private String tipoServico;
    private String tipoFuncionario;
    private String observacao;
    private String data;
    private String hora;

    public Informacao() {
    }

    public Informacao(int id, int idAgenda, int idColaborador, int sessao, int porcento, int porcentoColaborador,
            double valorColaborador, String duracao, String nota, double valorCalculado,
            String nomeCliente, String nomeFuncionario, double valor, String tipoServico,
            String tipoFuncionario, String observacao, String data, String hora) {
        this.id = id;
        this.idAgenda = idAgenda;
        this.idColaborador = idColaborador;
        this.sessao = sessao;
        this.porcento = porcento;
        this.porcentoColaborador = porcentoColaborador;
        this.valorColaborador = valorColaborador;
        this.duracao = duracao;
        this.nota = nota;
        this.valorCalculado = valorCalculado;
        this.nomeCliente = nomeCliente;
        this.nomeFuncionario = nomeFuncionario;
        this.valor = valor;
        this.tipoServico = tipoServico;
        this.tipoFuncionario = tipoFuncionario;
        this.observacao = observacao;
        this.data = data;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public int getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
    }

    public int getSessao() {
        return sessao;
    }

    public void setSessao(int sessao) {
        this.sessao = sessao;
    }

    public int getPorcento() {
        return porcento;
    }

    public void setPorcento(int porcento) {
        this.porcento = porcento;
    }

    public int getPorcentoColaborador() {
        return porcentoColaborador;
    }

    public void setPorcentoColaborador(int porcentoColaborador) {
        this.porcentoColaborador = porcentoColaborador;
    }

    public double getValorColaborador() {
        return valorColaborador;
    }

    public void setValorColaborador(double valorColaborador) {
        this.valorColaborador = valorColaborador;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public double getValorCalculado() {
        return valorCalculado;
    }

    public void setValorCalculado(double valorCalculado) {
        this.valorCalculado = valorCalculado;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(String tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
