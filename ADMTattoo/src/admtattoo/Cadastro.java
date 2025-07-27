package admtattoo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Cadastro {

    private String nome;
    private String cpf;
    private String cnpj;
    private String nascimento;
    private String tel;
    private String cep;
    private String rua;
    private String numero;
    private String bairro;
    private String cfal;
    private String cidade;
    private String email;
    private String status;
    private int id;

    public Cadastro() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCfal() {
        return cfal;
    }

    public void setCfal(String cfal) {
        this.cfal = cfal;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Validações 
    public boolean isFuncionario() {
        // Verifica COMO o status está armazenado no banco de dados
        return "Funcionario".equalsIgnoreCase(this.status)
                || "Funcionário".equalsIgnoreCase(this.status);
    }

    public boolean validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return false;
        }
        return nome.matches("[A-Za-zÀ-ÿ\\s]+");
    }

    public boolean validarRua(String rua) {
        if (rua == null || rua.trim().isEmpty()) {
            return false;
        }
        return rua.matches("[A-Za-zÀ-ÿ\\s]+");
    }

    public boolean validarCidade(String cidade) {
        if (cidade == null || cidade.trim().isEmpty()) {
            return false;
        }
        return cidade.matches("[A-Za-zÀ-ÿ\\s]+");
    }

    public boolean validarBairro(String bairro) {
        if (bairro == null || bairro.trim().isEmpty()) {
            return false;
        }
        return bairro.matches("[A-Za-zÀ-ÿ\\s]+");
    }

    public boolean validarData(String nascimento) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate.parse(nascimento, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public boolean validarTelefone(String tel) {
        String numeros = tel.replaceAll("[^0-9]", "");
        return numeros.length() >= 10 && numeros.length() <= 11;
    }

    public boolean validarCEP(String cep) {
        String numeros = cep.replaceAll("[^0-9]", "");
        return numeros.length() == 8;
    }

    public static boolean validarCPF(String cpf) {
        if (cpf == null) {
            return false;
        }
        String numeros = cpf.replaceAll("[^0-9]", "");
        return numeros.length() == 11;
    }

    public static boolean validarCNPJ(String cnpj) {
        if (cnpj == null) {
            return false;
        }
        String numeros = cnpj.replaceAll("[^0-9]", "");
        return numeros.length() == 14;
    }

    public boolean validarDocumentos(String cpf, String cnpj) {
        // Verifica se ambos estão nulos
        if ((cpf == null || cpf.trim().isEmpty())
                && (cnpj == null || cnpj.trim().isEmpty())) {
            return false; // Não pode salvar se os dois estiverem nulos
        }

        // Verifica se ambos estão preenchidos
        if ((cpf != null && !cpf.trim().isEmpty())
                && (cnpj != null && !cnpj.trim().isEmpty())) {
            return false; // Não pode salvar se os dois estiverem preenchidos
        }

        // Valida o documento informado (CPF ou CNPJ)
        if (cpf != null && !cpf.trim().isEmpty()) {
            return validarCPF(cpf);
        } else {
            return validarCNPJ(cnpj);
        }
    }
}
