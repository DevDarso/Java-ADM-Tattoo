package admtattoo;

public class ComissaoDTO {

    private int idAgenda;
    private int idFuncionario;
    private String tipoServico;
    private String data;
    private String hora;
    private double valor;
    private int porcento;
    private double valorCalculado;

    public ComissaoDTO() {
    }

    public ComissaoDTO(int idAgenda, int idFuncionario, String tipoServico, String data, String hora, double valor, int porcento, double valorCalculado) {
        this.idAgenda = idAgenda;
        this.idFuncionario = idFuncionario;
        this.tipoServico = tipoServico;
        this.data = data;
        this.hora = hora;
        this.valor = valor;
        this.porcento = porcento;
        this.valorCalculado = valorCalculado;
    }

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
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

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPorcento() {
        return porcento;
    }

    public void setPorcento(int porcento) {
        this.porcento = porcento;
    }

    public double getValorCalculado() {
        return valorCalculado;
    }

    public void setValorCalculado(double valorCalculado) {
        this.valorCalculado = valorCalculado;
    }

}
