package segundobi.lista04;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Main {
    
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJuUUdieXpJOUhkT1RPNkRJM1BqWWdXMmZ1aFAxVWpVbTcvMnhpNjVNUzhERzFJb0d1SnhzQ25SRGpKUmpzcUZaM20vNTY2OXRDUEJ0SkVMY01TdXBhL0p3cEwrQWN0M3EzS2l1dGhiU2t5NDVQQlp0YWIvS0RJSlcvbUlrVlVBV1BqZG1XM1hvVkd4eml5M1ZaT0RqcjkvVk1QSXdrdk5mNDVZa0xLZmFUWlpEaVBRM0kvVUV3NGRoSVF5WEo4dks5bmRvR1ZudkZCWEhXRkVFY0hJUWQwRDkrYnAvd2poT0F5a21qdEcrN0dOKzZuUGc4SStNVXdoeldDU1hwVjRlSzJacWZ4OVdLSmlQLzlnU3NJQ0JxQ3liY3drd1FjNjlUL09LbUxPaUFJclJtcUxjaXptZlZxUFpuNVdyZ0E2TGtBcVlJVGpXVkJaSVFyNTM4TUhvbXdWK3lNSnRHZ1dFRlk2NHNhVVNuNElwK2hwZ00wZjc0eHh3VmdDSTdwU1AyNllDRHBjVnpvRVRUUTdUNWN3Y3FiYnBUYWkyUTRjM1dzeWtBS29YaURlb1pjZjN6cVBZdmVWeFFNM3RJRFpaTWwrQkZmVXdQTzJyQlNKdjcya0VUZWlVaFJVcFhMY2krRk0yMUlQMVh4Y2V3TEMyL1hXcFJHSmNvVHJ4WFV0b0VkdG8wMklSK2QyVjU1SlFBZUxvblRhU2FsTW5LY0h5UGcwSU4yU1BwUCthUWl6NG9LZzc1WXJ6dzlxVFRycnBxbitpWnJuU3I5SEgxWkg3RXNSTVRRPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiNGJjZjExYjA2MDYxNDQ1MTkzMmQiLCJleHAiOjE3MTk1MTk1MTEsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0._O4mD-jZqokv9rU8QUemvh4Uz5N4BWFEvNFByTqHZG0";

    public static void main(String[] args) {
        String[] opicoes = {"Listar Convênios", "Consultar Boleto"};
        int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha uma opção",
                "Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opicoes,
                opicoes[0]
        );

        switch (escolha) {
            case 0:
                listarConvenios();
                break;
            case 1:
                consultarBoleto();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
        }

    }

    public static void listarConvenios() {

        try {
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "Bearer " + TOKEN);

            int status = con.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder content = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                    content.append("\n");
                }
                in.close();
                con.disconnect();

                JTextArea textArea = new JTextArea(20, 40);
                textArea.setText(content.toString());
                textArea.setEditable(false);
                JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Convênios", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String errorMessage = "Erro ao listar convênios. Código de resposta: " + status;
                JOptionPane.showMessageDialog(null, errorMessage, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar convênios: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void consultarBoleto() {
        String linhaDigitavel = JOptionPane.showInputDialog("Informe a linha digitável do boleto:");
        if (linhaDigitavel != null && !linhaDigitavel.isEmpty()) {
            try {
                String urlStr = "https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize";
                URL url = new URL(urlStr);
                
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestProperty("Authorization", "Bearer " + TOKEN);
                con.setDoOutput(true);
    
                String jsonInputString = "{"
                        + "\"paymentType\": 1,"
                        + "\"amount\": 100,"
                        + "\"barCode\": {"
                        + "\"type\": 0," 
                        + "\"digitable\": \"" + linhaDigitavel + "\""
                        + "}"
                        + "}";
    
                try (OutputStream os = con.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }
    
                int status = con.getResponseCode();
                if (status == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    StringBuilder content = new StringBuilder();
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }
                    in.close();
                    con.disconnect();
    
                    JTextArea textArea = new JTextArea(20, 40);
                    textArea.setText(content.toString());
                    textArea.setEditable(false);
    
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
                    JOptionPane.showMessageDialog(null, scrollPane, "Consulta de Boleto", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao consultar boleto. Código de resposta: " + status, "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao consultar boleto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Linha digitável não informada!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}