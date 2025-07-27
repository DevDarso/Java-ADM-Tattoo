package admtattoo;

public class Servico {

    private int idServico;
    private String nomeServico;
    double valor;

    public Servico() {

    }

    public Servico(int idServico, String nomeServico, double valor) {
        this.idServico = idServico;
        this.nomeServico = nomeServico;
        this.valor = valor;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
