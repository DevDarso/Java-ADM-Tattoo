package admtattoo;

import java.time.Year;
import javax.swing.JComboBox;

public class DateComboBoxUtils {

    public static void preencherComboboxDatas(
            JComboBox<String> comboDia,
            JComboBox<String> comboMes,
            JComboBox<String> comboAno,
            Integer anoInicial,
            Integer anoFinal) {

        comboDia.removeAllItems();
        comboMes.removeAllItems();
        comboAno.removeAllItems();

        comboDia.addItem("Dia");
        comboMes.addItem("Mês");
        comboAno.addItem("Ano");

        for (int i = 1; i <= 31; i++) {
            comboDia.addItem(String.format("%02d", i));
        }

        for (int i = 1; i <= 12; i++) {
            comboMes.addItem(String.format("%02d", i));
        }

        // Define anos padrão se não forem fornecidos
        int inicio = (anoInicial != null) ? anoInicial : 1940;
        int fim = (anoFinal != null) ? anoFinal : Year.now().getValue();

        // Preenche anos
        for (int i = inicio; i <= fim; i++) {
            comboAno.addItem(String.valueOf(i));
        }
    }

// Sobrecarga do método para usar anos padrão (1940-ano atual)
    public static void preencherComboboxDatas(
            JComboBox<String> comboDia,
            JComboBox<String> comboMes,
            JComboBox<String> comboAno) {
        preencherComboboxDatas(comboDia, comboMes, comboAno, null, null);
    }
}
