package admtattoo;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ComissaoUtils {

    // valor = valor do funcionário e total = valor do atendimento
    public static boolean definirPorcentagem(Comissao com, JComboBox<String> comboBox, String status, double valor, double total, JFrame parent) {
        String porcento = comboBox.getSelectedItem().toString();
        if ("Agendado".equalsIgnoreCase(status) && "0".equalsIgnoreCase(porcento) && valor != 0.00) {
            int resposta = JOptionPane.showConfirmDialog(
                    parent,
                    "Tem certeza que deseja salvar com porcentagem 0% ?",
                    "Valor não declarado",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (resposta != JOptionPane.YES_OPTION) {
                return false;
            }

        }

        if (!"Agendado".equalsIgnoreCase(status) && !"0".equalsIgnoreCase(porcento) && valor == 0.00) {
            JOptionPane.showMessageDialog(parent, "Para valores zerados, a comissão é salva como 0");
            porcento = "0";
        }

        if (valor == 0.00 && total != 0.00 && !"Agendado".equalsIgnoreCase(status)) {
            int resposta = JOptionPane.showConfirmDialog(
                    parent,
                    "Tem certeza que deseja salvar com valor igual a 0 ?",
                    "Valor não declarado",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (resposta != JOptionPane.YES_OPTION) {
                return false;
            }
        }
        if ("0".equalsIgnoreCase(porcento) && !"Agendado".equalsIgnoreCase(status) && valor != 0.00 && total != 0.00) {
            int resposta = JOptionPane.showConfirmDialog(
                    parent,
                    "Comissão não informada! Deseja aplicar:\n"
                    + "YES → 100% / NO → 0%\n"
                    + "CANCEL → voltar e selecionar manualmente.",
                    "Comissão não selecionada",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (resposta == JOptionPane.YES_OPTION) {
                com.setPorcentagem(100);
                porcento = "100";
                return true;
            } else if (resposta == JOptionPane.NO_OPTION) {
                com.setPorcentagem(0);
                porcento = "0";
                return true;
            } else {
                // CANCELADO pelo usuário
                return false;
            }
        }
        try {
            com.setPorcentagem(Integer.parseInt(porcento));
            return true;
        } catch (Exception e) {
            System.err.println("Erro ao converter porcentagem: " + e.getMessage());
            return false;
        }
    }
}
