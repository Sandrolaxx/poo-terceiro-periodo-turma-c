package segundob.listas.lista4;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String[] opcoes = {"Consultar Convênio", "Consultar Boleto", "Sair"};
        while (true) {
            String selecionar = (String) JOptionPane.showInputDialog(null, "Selecione a opção desejada: ",
                    "Menu", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
            switch (selecionar) {
                case "Consultar Convênio" -> consultarConvenio();
                case "Consultar Boleto" -> consultarBoleto();
                case "Sair" -> {
                    return;
                }
                default -> JOptionPane.showMessageDialog(null, "Nenhuma Opção selecionada", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private static void consultarConvenio() {
        System.out.println(ConsultarConvenio.getJsonData());
    }

    private static void consultarBoleto() throws IOException, InterruptedException {
        String linhaDigitavel = (String) JOptionPane.showInputDialog(
                null,
                "Informe a Linha Digitavel",
                "Inserir",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null);
        ConsultarBoleto.getJsonData(linhaDigitavel);

    }
}
