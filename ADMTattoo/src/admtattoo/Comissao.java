package admtattoo;

public class Comissao {

    private Participante participante;
    private Agenda agenda;
    private Informacao informacao;

    private int idProfissional;
    private int idAgenda;
    private double valor;
    private double valorColaborador; // usado na classe que valida comissão
    private double valorCalculado;
    private int porcentagem;
    private int porcentoColaborador;
    private double total;
    private String tipoServico;

    public Comissao() {
    }

    // Uni a classe agenda com a classe informação
    public Comissao(Agenda agenda, Informacao informacao) {
        this.agenda = agenda;
        this.informacao = informacao;
    }

    public Comissao(Agenda agenda, Informacao informacao, int idProfissional, int idAgenda, double valor, double valorColaborador, double valorCalculado, int porcentagem, int porcentoColaborador, double total, String tipoServico, Participante participante) {
        this.agenda = agenda;
        this.informacao = informacao;
        this.idProfissional = idProfissional;
        this.idAgenda = idAgenda;
        this.valor = valor;
        this.valorColaborador = valorColaborador;
        this.valorCalculado = valorCalculado;
        this.porcentagem = porcentagem;
        this.porcentoColaborador = porcentoColaborador;
        this.total = total;
        this.tipoServico = tipoServico;
        this.participante = participante;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Informacao getInformacao() {
        return informacao;
    }

    public void setInformacao(Informacao informacao) {
        this.informacao = informacao;
    }

    public int getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorColaborador() {
        return valorColaborador;
    }

    public void setValorColaborador(double valorColaborador) {
        this.valorColaborador = valorColaborador;
    }

    public void setValorCalculado(double valorCalculado) {
        this.valorCalculado = valorCalculado;
    }

    public int getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(int porcentagem) {
        this.porcentagem = porcentagem;
    }

    public int getPorcentoColaborador() {
        return porcentoColaborador;
    }

    public void setPorcentoColaborador(int porcentoColaborador) {
        this.porcentoColaborador = porcentoColaborador;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public double getValorCalculado() {
        if (valor == 0 || porcentagem == 0) {
            return 0;
        }
        double calculado = (valor * porcentagem) / 100.0;
        System.out.println("[DEBUG] Calculando comissão: (" + valor + " * " + porcentagem + ")/100 = " + calculado);
        return calculado;
    }
}
