package admtattoo;

import java.awt.Component;
import javax.swing.JOptionPane;

public class InfoAdicionalMetodo {

    public static boolean salvarInfoAdicional(Comissao c, Component parentComponent) {
        try {
            double valorColab = c.getValorColaborador();
            double valorPrincipal = c.getValor();

            if (c.getPorcentagem() == 0 && valorPrincipal != 0.0) {
                int resposta = JOptionPane.showConfirmDialog(parentComponent,
                        "Comissão não informada,selecione:\n"
                        + "(Yes) para aplicar 100%\n"
                        + "(No) para aplicar 0%\n"
                        + "(Cancel) para retornar.",
                        "Confirmação de Comissão", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if (resposta == JOptionPane.YES_OPTION) {
                    c.setPorcentagem(100);
                    return true;
                }
                if (resposta == JOptionPane.NO_OPTION) {
                    c.setPorcentagem(0);
                    return true;
                } else {
                    return false;
                }
            }

            if (c.getPorcentoColaborador() == 0 && valorColab != 0.0) {
                int resposta = JOptionPane.showConfirmDialog(parentComponent,
                        "Comissão não informada,selecione:\n"
                        + "(Yes) para aplicar 100%\n"
                        + "(No) para aplicar 0%\n"
                        + "(Cancel) para retornar.",
                        "Confirmação de Comissão", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if (resposta == JOptionPane.YES_OPTION) {
                    c.setPorcentagem(100);
                    return true;
                }
                if (resposta == JOptionPane.NO_OPTION) {
                    c.setPorcentagem(0);
                    return true;
                } else {
                    return false;
                }
            }

            if (ComissaoDAO.inserirComissao(c)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(parentComponent, "Erro ao salvar comissões", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(parentComponent,
                    "Erro inesperado ao processar as informações adicionais." + e.getMessage(),
                    "Erro interno", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
