package admtattoo;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private List<Participante> participantes = new ArrayList<>();
    private List<Comissao> comissoes = new ArrayList<>();

    private String dataAgendada;
    private String horario;
    private String funcionario;
    private String cliente;
    private String status;
    private int id;
    private int idCliente;
    private int idFuncionario;
    private int idColaborador;
    private boolean permiteColaborador = false;
    private double sinal;
    private double valor;
    private boolean respostaData;
    private boolean respostaHora;
    private boolean respostaFuncionario;
    private boolean respostaCliente;
    private boolean respostaTipoServico;
    private boolean respostaStatus;

    public Agenda() {
    }

    public Agenda(String dataAgendada, String horario, String funcionario, String cliente, String status, int id, int idCliente, int idFuncionario, int idColaborador, double sinal, double valor, boolean respostaData, boolean respostaHora, boolean respostaFuncionario, boolean respostaCliente, boolean respostaTipoServico, boolean respostaStatus) {
        this.dataAgendada = dataAgendada;
        this.horario = horario;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.status = status;
        this.id = id;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.idColaborador = idColaborador;
        this.sinal = sinal;
        this.valor = valor;
        this.respostaData = respostaData;
        this.respostaHora = respostaHora;
        this.respostaFuncionario = respostaFuncionario;
        this.respostaCliente = respostaCliente;
        this.respostaTipoServico = respostaTipoServico;
        this.respostaStatus = respostaStatus;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public List<Comissao> getComissoes() {
        return comissoes;
    }

    public void setComissoes(List<Comissao> comissoes) {
        this.comissoes = comissoes;
    }

    public void adicionarParticipante(Participante participante) {
        this.participantes.add(participante);
    }

    public void adicionarComissao(Comissao comissao) {
        this.comissoes.add(comissao);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataAgendada() {
        return dataAgendada;
    }

    public void setDataAgendada(String dataAgendada) {
        this.dataAgendada = dataAgendada;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public int getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
    }

    public boolean isPermiteColaborador() {
        return permiteColaborador;
    }

    public void setPermiteColaborador(boolean permiteColaborador) {
        this.permiteColaborador = permiteColaborador;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getSinal() {
        return sinal;
    }

    public void setSinal(double sinal) {
        this.sinal = sinal;
    }

    public boolean isRespostaData() {
        return respostaData;
    }

    public void setRespostaData(boolean respostaData) {
        this.respostaData = respostaData;
    }

    public boolean isRespostaHora() {
        return respostaHora;
    }

    public void setRespostaHora(boolean respostaHora) {
        this.respostaHora = respostaHora;
    }

    public boolean isRespostaFuncionario() {
        return respostaFuncionario;
    }

    public void setRespostaFuncionario(boolean respostaFuncionario) {
        this.respostaFuncionario = respostaFuncionario;
    }

    public boolean isRespostaCliente() {
        return respostaCliente;
    }

    public void setRespostaCliente(boolean respostaCliente) {
        this.respostaCliente = respostaCliente;
    }

    public boolean isRespostaTipoServico() {
        return respostaTipoServico;
    }

    public void setRespostaTipoServico(boolean respostaTipoServico) {
        this.respostaTipoServico = respostaTipoServico;
    }

    public boolean isRespostaStatus() {
        return respostaStatus;
    }

    public void setRespostaStatus(boolean respostaStatus) {
        this.respostaStatus = respostaStatus;
    }

}
