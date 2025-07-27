package admtattoo;

import java.awt.Color;
import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.text.MaskFormatter;

public class DateUtils {

    // Validação principal usando Java Time
    public static boolean validarDataComJavaTime(int dia, int mes, int ano) {
        try {
            LocalDate.of(ano, mes, dia);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    // Validação genérica (sem interface gráfica)
    public static boolean validarData(int dia, int mes, int ano) {
        if (mes < 1 || mes > 12) {
            return false;
        }
        if (ano < 1) {
            return false;
        }

        int maxDias = diasNoMes(mes, ano);
        return dia >= 1 && dia <= maxDias;
    }

    public static boolean validarDataComUI(Object diaItem, Object mesItem, Object anoItem, JLabel labelErro) {
        try {
            if (diaItem == null || mesItem == null || anoItem == null) {
                ocultarErro(labelErro);
                return false;
            }

            String diaStr = diaItem.toString().trim();
            String mesStr = mesItem.toString().trim();
            String anoStr = anoItem.toString().trim();

            if (diaStr.isEmpty() || mesStr.isEmpty() || anoStr.isEmpty()) {
                mostrarErro(labelErro, "Data incompleta");
                return false;
            }

            int dia = Integer.parseInt(diaStr);
            int mes = Integer.parseInt(mesStr);
            int ano = Integer.parseInt(anoStr);

            if (!validarDataComJavaTime(dia, mes, ano)) {
                mostrarErro(labelErro, "Data inválida");
                return false;
            }

            // Cria as datas para comparação
            LocalDate dataSelecionada = LocalDate.of(ano, mes, dia);
            LocalDate dataAtual = LocalDate.now();

            if (dataSelecionada.isBefore(dataAtual)) {
                mostrarErro(labelErro, "Data retroativa");
                return false;
            }

            ocultarErro(labelErro);
            return true;

        } catch (NumberFormatException | DateTimeException e) {
            mostrarErro(labelErro, "Data inválida");
            return false;
        }
    }

    // Métodos auxiliares para UI
    private static void mostrarErro(JLabel label, String msg) {
        if (label != null) {
            label.setVisible(true);
            label.setForeground(Color.RED);
            label.setText(msg);
        }
    }

    private static void ocultarErro(JLabel label) {
        if (label != null) {
            label.setVisible(false);
        }
    }

    // Lógica auxiliar para dias no mês (se quiser manter a versão manual)
    private static int diasNoMes(int mes, int ano) {
        switch (mes) {
            case 2:
                return ehBissexto(ano) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    private static boolean ehBissexto(int ano) {
        return (ano % 400 == 0) || (ano % 100 != 0 && ano % 4 == 0);
    }

    // Exceção personalizada
    public static class DateException extends Exception {

        public DateException(String message) {
            super(message);
        }
    }

    // lançar exceção se a data for inválida
    public static void validarDataOuExcecao(int dia, int mes, int ano) throws DateException {
        if (!validarDataComJavaTime(dia, mes, ano)) {
            throw new DateException("Data inválida: " + dia + "/" + mes + "/" + ano);
        }
    }
    // Retorna true se a data for hoje ou no futuro

    public static boolean isHojeOuFuturo(int dia, int mes, int ano) {
        try {
            LocalDate data = LocalDate.of(ano, mes, dia);
            return !data.isBefore(LocalDate.now());
        } catch (DateTimeException e) {
            return false;
        }
    }

// Retorna data formatada em yyyy-MM-dd
    public static String formatarParaSql(int dia, int mes, int ano) {
        try {
            LocalDate data = LocalDate.of(ano, mes, dia);
            return data.toString(); // formato ISO padrão: yyyy-MM-dd
        } catch (DateTimeException e) {
            return null;
        }
    }

    public static String formatarStringParaSQL(String dataStr) {
        if (dataStr == null || dataStr.trim().isEmpty() || dataStr.equals("__/__/____")) {
            return null;
        }

        // Tenta formatar do tipo dd/MM/yyyy para yyyy-MM-dd
        try {
            DateTimeFormatter entradaFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataStr, entradaFormatada);
            return data.toString(); // yyyy-MM-dd
        } catch (DateTimeParseException e) {
            // Tenta se já estiver no formato yyyy-MM-dd
            try {
                LocalDate data = LocalDate.parse(dataStr); // ISO 8601
                return data.toString();
            } catch (DateTimeParseException ex) {
                System.err.println("Erro ao converter data: " + dataStr);
                return null;
            }
        }
    }
// aceita um dia mínimo - quem chama decide se é 1 ou hoje

    public static List<String> getDiasValidos(int ano, int mes, int diaMinimo) {
        List<String> dias = new ArrayList<>();
        try {
            int diasNoMes = YearMonth.of(ano, mes).lengthOfMonth();
            for (int d = diaMinimo; d <= diasNoMes; d++) {
                dias.add(String.format("%02d", d));
            }
        } catch (DateTimeException e) {
            // retorna lista vazia
        }
        return dias;
    }
    // Cria o campo JFormattedTextField com máscara dd/MM/yyyy

    public static JFormattedTextField criarCampoData() {
        try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.setPlaceholderCharacter('_');
            return new JFormattedTextField(dateMask);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Valida se a data no campo é válida (ex: não aceita 32/02/2025)
    public static boolean isDataValida(String data) {
        if (data.contains("_") || data.length() < 10) {
            return false; // incompleto
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse(data, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // método para regra de data inválida em ListaAgenda
    public static boolean validarDataFiltro(Object diaItem, Object mesItem, Object anoItem, JLabel labelErro) {
        try {
            // Se algum dos combos estiver com o valor padrão ("Dia", "Mês", "Ano"), não mostra erro
            if ("Dia".equals(diaItem) || "Mês".equals(mesItem) || "Ano".equals(anoItem)) {
                ocultarErro(labelErro);
                return true;
            }

            String diaStr = diaItem.toString().trim();
            String mesStr = mesItem.toString().trim();
            String anoStr = anoItem.toString().trim();

            // Verifica se algum campo está vazio (não deveria acontecer, mas é uma proteção)
            if (diaStr.isEmpty() || mesStr.isEmpty() || anoStr.isEmpty()) {
                ocultarErro(labelErro);
                return false;
            }

            int dia = Integer.parseInt(diaStr);
            int mes = Integer.parseInt(mesStr);
            int ano = Integer.parseInt(anoStr);

            // Valida apenas se a data existe (ignora se é retroativa)
            if (!validarDataComJavaTime(dia, mes, ano)) {
                mostrarErro(labelErro, "Data inválida");
                return false;
            }

            ocultarErro(labelErro);
            return true;

        } catch (NumberFormatException | DateTimeException e) {
            mostrarErro(labelErro, "Data inválida");
            return false;
        }
    }

}
