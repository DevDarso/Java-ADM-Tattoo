package admtattoo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FormularioRelatorioGenerator {

    public static boolean gerarArquivoTextoComDialogo(String textoCompleto) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar relatório");

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File destino = fileChooser.getSelectedFile();

            boolean sucesso = gerarArquivoTexto(textoCompleto, destino);
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo.");
            }
            return sucesso;
        }

        return false;
    }

    public static boolean gerarArquivoTexto(String textoCompleto, File destino) {
        boolean sucesso = false;

        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(destino))) {
            writer.write(textoCompleto);
            sucesso = true;

        } catch (IOException e) {
            System.err.println("Erro ao gerar o arquivo de texto: " + e.getMessage());
        }

        return sucesso;
    }
}
