package Lista01.Lista04;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        while (true) {
            List<String> opcoes = List.of("Listar convênios de pagamento", "Consulta de boleto");
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes.toArray(), opcoes.toArray()[0]);

            if (opcaoSelecionada < 0) {
                System.out.println("Encerrando...");
                return;
            }

            switch (opcaoSelecionada) {
                case 0 -> listarConvenios();
                case 1 -> consultarBoleto();
            }
        }
    }

    private static void listarConvenios() {
        System.out.println(HttpRequests.listarConvenios());
    }

    private static void consultarBoleto() {
        Map<String, Object> jsonMap = converteParaMap(HttpRequests.consultarBoleto());

        String mensagem = "Cedente: " + jsonMap.get("assignor") + "\n" +
                "Data de Vencimento do Pagamento: " + jsonMap.get("payDueDate") + "\n" +
                "Data de Vencimento: " + jsonMap.get("dueDate") + "\n" +
                "Próximo Liquidação: " + jsonMap.get("nextSettle") + "\n" +
                "Data de Liquidação: " + jsonMap.get("settleDate") + "\n" +
                "Pagador: " + jsonMap.get("payer") + "\n" +
                "Documento do Pagador: " + jsonMap.get("documentPayer") + "\n" +
                "Beneficiário: " + jsonMap.get("recipient") + "\n" +
                "Documento do Beneficiário: " + jsonMap.get("documentRecipient") + "\n" +
                "Hora de Término: " + jsonMap.get("endHour") + "\n" +
                "Código de Barras: " + jsonMap.get("digitable") + "\n";

        JOptionPane.showMessageDialog(null, mensagem, "Informações do Boleto", JOptionPane.INFORMATION_MESSAGE);
    }

    private static Map<String, Object> converteParaMap(String json) {
        Map<String, Object> jsonData = new HashMap<>();
        try {
            Pattern pattern = Pattern.compile("\"(\\w+)\":\"([^\"]+)\"");
            Matcher matcher = pattern.matcher(json);

            while (matcher.find()) {
                String key = matcher.group(1);
                String value = matcher.group(2);

                jsonData.put(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonData;
    }
}
