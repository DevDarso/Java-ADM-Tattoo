package admtattoo;

public class AgendaDTO {

    private int idAgenda;
    private int idCliente;
    private int idFuncionario;
    private String data;
    private String hora;
    private String tipoServico;
    private double valor;

    public AgendaDTO() {
    }

    public AgendaDTO(int idAgenda, int idCliente, int idFuncionario, String data, String hora, String tipoServico, double valor) {
        this.idAgenda = idAgenda;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.data = data;
        this.hora = hora;
        this.tipoServico = tipoServico;
        this.valor = valor;
    }

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
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

}
