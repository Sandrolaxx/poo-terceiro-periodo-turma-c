package segundobimestre.listas.lista04.test;

import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lista04Test {
    private static ApiConection apiConectionConvenio;
    private static ApiConection apiConectionBoleto;

    public static void main(String[] args) {
        try {
            createApiConections();
        } catch (MalformedURLException e) {
            System.out.println("Erro");
        }
        loop();
    }

    private static void createApiConections() throws MalformedURLException {
        URL urlConvenios = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions");
        apiConectionConvenio = new ApiConection(urlConvenios);

        URL urlBoleto = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");
        apiConectionBoleto = new ApiConection(urlBoleto);
    }

    private static void loop() {
        while (true) {
            String option = menu();
            if (option == null) return;

            switch (option) {
                case "Listar Convenios" -> listarConvenios();
                case "Consultar Boleto" -> consultarBoleto();
                default -> System.out.println("Default");
            }
        }
    }

    private static String menu() {
        List<String> options = new ArrayList<>(List.of("Listar Convenios", "Consultar Boleto"));

        return (String) JOptionPane.showInputDialog(
                null,
                "Escolha um opção",
                "Menu de Opção",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options.toArray(),
                options.toArray()[0]
        );
    }

    private static void listarConvenios() {
        try {
            String result = apiConectionConvenio.get();
            System.out.println(result);
        } catch (IOException e) {
            exibirErro("Erro ao listar os convenios");
            e.printStackTrace();
        }
    }

    private static void consultarBoleto() {
        String linhaDigitavel = obterLinhaDigitavel();
        try {
            Map<String, Object> result = apiConectionBoleto.post2ToMap(linhaDigitavel);
            JOptionPane.showMessageDialog(
                    null,
                    factoryMessage(result),
                    "Informações do Boleto",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } catch (IOException | InterruptedException e) {
            exibirErro("Erro ao consultar o boleto");
            e.printStackTrace();
        }
    }

    private static String obterLinhaDigitavel() {
        return JOptionPane.showInputDialog("Qual a linha digitavel?");
    }

    private static String factoryMessage(Map<String, Object> map) {
        StringBuilder message = new StringBuilder();

        message.append("Cedente: ").append(map.get("assignor")).append("\n");
        message.append("Data de Vencimento do Pagamento: ").append(map.get("payDueDate")).append("\n");
        message.append("Data de Vencimento: ").append(map.get("dueDate")).append("\n");
        message.append("Próximo Liquidação: ").append(map.get("nextSettle")).append("\n");
        message.append("Data de Liquidação: ").append(map.get("settleDate")).append("\n");
        message.append("Pagador: ").append(map.get("payer")).append("\n");
        message.append("Documento do Pagador: ").append(map.get("documentPayer")).append("\n");
        message.append("Beneficiário: ").append(map.get("recipient")).append("\n");
        message.append("Documento do Beneficiário: ").append(map.get("documentRecipient")).append("\n");
        message.append("Hora de Término: ").append(map.get("endHour")).append("\n");
        message.append("Código de Barras: ").append(map.get("digitable")).append("\n");

        return message.toString();
    }

    private static void exibirErro(String message) {
        JOptionPane.showMessageDialog(
                null,
                message,
                "Erro!",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
