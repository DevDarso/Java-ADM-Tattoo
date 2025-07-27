package admtattoo;
// classe para armazenar os participantes de cada agendamento

public class Participante {

    private int idProfissional;
    private String tipoServico;
    private String papel;
    private int idAgenda;
    private double valor;
    private int porcentagem;

    public Participante() {
    }

    public Participante(int idProfissional, String tipoServico, String papel, int idAgenda, double valor, int porcentagem) {
        this.idProfissional = idProfissional;
        this.tipoServico = tipoServico;
        this.papel = papel;
        this.idAgenda = idAgenda;
        this.valor = valor;
        this.porcentagem = porcentagem;
    }

    public int getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
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

    public int getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(int porcentagem) {
        this.porcentagem = porcentagem;
    }

}
