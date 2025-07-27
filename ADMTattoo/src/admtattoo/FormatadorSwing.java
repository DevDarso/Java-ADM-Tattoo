package admtattoo;

import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class FormatadorSwing {

    private FormatadorSwing() {
    } // evita instanciamento

    public static void aplicarTelefone(JTextField campo) {
        campo.getDocument().addDocumentListener(new FormatadorTelefone(campo));
    }

    public static void aplicarCPF(JTextField campo) {
        campo.getDocument().addDocumentListener(new FormatadorCPF(campo));
    }

    public static void aplicarCNPJ(JTextField campo) {
        campo.getDocument().addDocumentListener(new FormatadorCNPJ(campo));
    }

    public static void aplicarCEP(JTextField campo) {
        campo.getDocument().addDocumentListener(new FormatadorCEP(campo));
    }

    public static void aplicarData(JTextField campo) {
        campo.getDocument().addDocumentListener(new FormatadorData(campo));
    }

    // Classes internas
    private static class FormatadorTelefone implements DocumentListener {

        private final JTextField campo;
        private boolean atualizando = false;

        FormatadorTelefone(JTextField campo) {
            this.campo = campo;
        }

        private void formatar() {
            if (atualizando) {
                return;
            }

            atualizando = true;
            SwingUtilities.invokeLater(() -> {
                try {
                    String textoOriginal = campo.getText();
                    String texto = textoOriginal.replaceAll("[^0-9]", "");
                    if (texto.length() > 11) {
                        texto = texto.substring(0, 11);
                    }

                    StringBuilder sb = new StringBuilder();
                    int len = texto.length();

                    if (len > 0) {
                        sb.append("(");
                        sb.append(texto.substring(0, Math.min(2, len)));
                        if (len >= 2) {
                            sb.append(")");
                        }
                    }

                    if (len > 2 && len <= 6) {
                        sb.append(texto.substring(2));
                    } else if (len > 6) {
                        sb.append(texto.substring(2, 7)).append("-").append(texto.substring(7));
                    }

                    String formatado = sb.toString();

                    if (!formatado.equals(textoOriginal)) {
                        int caret = campo.getCaretPosition();
                        campo.setText(formatado);
                        campo.setCaretPosition(Math.min(caret + 1, campo.getText().length()));
                    }
                } finally {
                    atualizando = false;
                }
            });
        }

        public void insertUpdate(DocumentEvent e) {
            formatar();
        }

        public void removeUpdate(DocumentEvent e) {
            formatar();
        }

        public void changedUpdate(DocumentEvent e) {
            formatar();
        }
    }

    private static class FormatadorCPF implements DocumentListener {

        private final JTextField campo;
        private boolean atualizando = false;

        FormatadorCPF(JTextField campo) {
            this.campo = campo;
        }

        private void formatar() {
            if (atualizando) {
                return;
            }

            atualizando = true;
            SwingUtilities.invokeLater(() -> {
                try {
                    String textoOriginal = campo.getText();
                    String texto = textoOriginal.replaceAll("[^0-9]", "");
                    if (texto.length() > 11) {
                        texto = texto.substring(0, 11);
                    }

                    StringBuilder sb = new StringBuilder();
                    int len = texto.length();
                    if (len > 0) {
                        sb.append(texto.substring(0, Math.min(3, len)));
                    }
                    if (len > 3) {
                        sb.append(".").append(texto.substring(3, Math.min(6, len)));
                    }
                    if (len > 6) {
                        sb.append(".").append(texto.substring(6, Math.min(9, len)));
                    }
                    if (len > 9) {
                        sb.append("-").append(texto.substring(9));
                    }

                    String formatado = sb.toString();

                    if (!formatado.equals(textoOriginal)) {
                        int caret = campo.getCaretPosition();
                        campo.setText(formatado);
                        campo.setCaretPosition(Math.min(caret + 1, campo.getText().length()));
                    }
                } finally {
                    atualizando = false;
                }
            });
        }

        public void insertUpdate(DocumentEvent e) {
            formatar();
        }

        public void removeUpdate(DocumentEvent e) {
            formatar();
        }

        public void changedUpdate(DocumentEvent e) {
            formatar();
        }
    }

    private static class FormatadorCNPJ implements DocumentListener {

        private final JTextField campo;
        private boolean atualizando = false;

        FormatadorCNPJ(JTextField campo) {
            this.campo = campo;
        }

        private void formatar() {
            if (atualizando) {
                return;
            }

            atualizando = true;
            SwingUtilities.invokeLater(() -> {
                try {
                    String textoOriginal = campo.getText();
                    String texto = textoOriginal.replaceAll("[^0-9]", "");
                    if (texto.length() > 14) {
                        texto = texto.substring(0, 14);
                    }

                    StringBuilder sb = new StringBuilder();
                    int len = texto.length();
                    if (len > 0) {
                        sb.append(texto.substring(0, Math.min(2, len)));
                    }
                    if (len > 2) {
                        sb.append(".").append(texto.substring(2, Math.min(5, len)));
                    }
                    if (len > 5) {
                        sb.append(".").append(texto.substring(5, Math.min(8, len)));
                    }
                    if (len > 8) {
                        sb.append("/").append(texto.substring(8, Math.min(12, len)));
                    }
                    if (len > 12) {
                        sb.append("-").append(texto.substring(12));
                    }

                    String formatado = sb.toString();

                    if (!formatado.equals(textoOriginal)) {
                        int caret = campo.getCaretPosition();
                        campo.setText(formatado);
                        campo.setCaretPosition(Math.min(caret + 1, campo.getText().length()));
                    }
                } finally {
                    atualizando = false;
                }
            });
        }

        public void insertUpdate(DocumentEvent e) {
            formatar();
        }

        public void removeUpdate(DocumentEvent e) {
            formatar();
        }

        public void changedUpdate(DocumentEvent e) {
            formatar();
        }
    }

    private static class FormatadorCEP implements DocumentListener {

        private final JTextField campo;
        private boolean atualizando = false;

        FormatadorCEP(JTextField campo) {
            this.campo = campo;
        }

        private void formatar() {
            if (atualizando) {
                return;
            }
            atualizando = true;

            String texto = campo.getText().replaceAll("[^0-9]", "");
            if (texto.length() > 8) {
                texto = texto.substring(0, 8);
            }

            StringBuilder sb = new StringBuilder();
            if (texto.length() >= 5) {
                sb.append(texto.substring(0, 5)).append("-").append(texto.substring(5));
            } else {
                sb.append(texto);
            }

            String resultado = sb.toString();
            SwingUtilities.invokeLater(() -> {
                campo.setText(resultado);
                atualizando = false;
            });
        }

        public void insertUpdate(DocumentEvent e) {
            formatar();
        }

        public void removeUpdate(DocumentEvent e) {
            formatar();
        }

        public void changedUpdate(DocumentEvent e) {
            formatar();
        }
    }

    private static class FormatadorData implements DocumentListener {

        private final JTextField campo;
        private boolean atualizando = false;

        FormatadorData(JTextField campo) {
            this.campo = campo;
        }

        private void formatar() {
            if (atualizando) {
                return;
            }

            atualizando = true;
            SwingUtilities.invokeLater(() -> {
                try {
                    String textoOriginal = campo.getText();
                    String texto = textoOriginal.replaceAll("[^0-9]", "");
                    if (texto.length() > 8) {
                        texto = texto.substring(0, 8);
                    }

                    StringBuilder sb = new StringBuilder();
                    int len = texto.length();
                    if (len > 0) {
                        sb.append(texto.substring(0, Math.min(2, len)));
                    }
                    if (len > 2) {
                        sb.append("/").append(texto.substring(2, Math.min(4, len)));
                    }
                    if (len > 4) {
                        sb.append("/").append(texto.substring(4, Math.min(8, len)));
                    }

                    String formatado = sb.toString();

                    if (!formatado.equals(textoOriginal)) {
                        int caret = campo.getCaretPosition();
                        campo.setText(formatado);
                        campo.setCaretPosition(Math.min(caret + 1, campo.getText().length()));
                    }
                } finally {
                    atualizando = false;
                }
            });
        }

        public void insertUpdate(DocumentEvent e) {
            formatar();
        }

        public void removeUpdate(DocumentEvent e) {
            formatar();
        }

        public void changedUpdate(DocumentEvent e) {
            formatar();
        }
    }

}
