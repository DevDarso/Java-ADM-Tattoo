package admtattoo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TextoFormulario {

    public static String gerarTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty()) {
            return "";
        }
        String linhaTitulo = titulo;
        return centralizar(linhaTitulo, 75) + "\n";
    }

    public static String gerarCabecalho(Cadastro cliente) {
        if (cliente == null) {
            return "";
        }

        return "\nDados pessoais do cliente:\nNome: " + cliente.getNome() + ", nascido(a) em " + cliente.getNascimento()
                + "\nportador(a) do CPF: " + cliente.getCpf()
                + "\nresidente e domiciliado(a) na rua " + cliente.getRua()
                + "\nN° " + cliente.getNumero()
                + ", Bairro " + cliente.getBairro()
                + ", Cidade " + cliente.getCidade() + ".\n";
    }

    public static String gerarCabecalhoResponsavel(Cadastro cliente) {
        if (cliente == null) {
            return "";
        }

        return "Dados pessoais do responsável:\nNome: " + cliente.getNome() + ", nascido(a) em " + cliente.getNascimento()
                + "\nportador(a) do CPF: " + cliente.getCpf()
                + "\nresidente e domiciliado(a) na rua " + cliente.getRua()
                + "\nN° " + cliente.getNumero()
                + ", Bairro " + cliente.getBairro()
                + ", Cidade " + cliente.getCidade() + ".";
    }

    public static String gerarRodape(String cidade, String empresa) {
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (cidade == null || cidade.isEmpty()) {
            cidade = "[Cidade]";
        }
        if (empresa == null || empresa.isEmpty()) {
            empresa = "[Nome da Empresa]";
        }

        String linhaEmpresa = "Empresa responsável: " + empresa;
        String linhaCidadeData = cidade + " - Data: " + data;

        return "\n"
                + centralizar(linhaEmpresa, 75) + "\n"
                + centralizar(linhaCidadeData, 75) + "\n";
    }

    private static String centralizar(String texto, int largura) {
        if (texto == null || texto.isEmpty()) {
            return " ".repeat(largura); // Retorna apenas espaços se não houver texto
        }

        // Remove possíveis espaços extras no texto original
        texto = texto.trim();

        // Calcula os espaços necessários de cada lado
        int espacosTotais = largura - texto.length();
        if (espacosTotais <= 0) {
            return texto; // Retorna o texto original se for maior que a largura
        }

        int espacosEsquerda = espacosTotais / 2;
        int espacosDireita = espacosTotais - espacosEsquerda;

        return " ".repeat(espacosEsquerda) + texto + " ".repeat(espacosDireita);
    }
}
