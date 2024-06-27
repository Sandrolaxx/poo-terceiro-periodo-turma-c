package segundoBimestre.lista_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class Main {
    private static final String LISTAR_CONVENIOS_URL = "https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions";
    private static final String CONSULTAR_BOLETO_URL = "https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize";
    private static final String AUTH_TOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJ1b1BzQ00yUHV2SjcydHVYbWpidUVUeHErYys3eENrUkxrcm5UQ1ZHVFRndEJYam0vOGVpRTF6UEUvNEI3dUhqZG9ha0hQSGpUWk5acGV2d3E3NThYZUQ2RSs4Q2hOeFZpMkVad04vTENmZEZRRFdvQklQQndmVmI4WFpYZEQ5ZjhGd1JJUkFldXdmWVgzQTNEQUk1a0MreVlHNGRHVlkxRWJmVmtjRlNkQ05BYVhYQUc5Qm43SGJXOTNhM0JiL0dKSnh4MXBoYWZZd1QyMzRld29GV1k3WkU5NXJUR1VrNWR2WkJzRTdvRVVnMFlQSHQ3YnY0Zm90Vlpmb3Z4MzBxUGVEeXNPQTRLOHFja3NSNWRrSzFyWVBCSUFBaXdYcjdQdnNrRTJtUnMzU2RDQkZqQ1ljMll1dEo2MWlRNm5ReDhnRFprSmkwdUVDRjgwU25YVTRmL3QweVlOVURrdUZFanB2MlltQzRUOGJzdU9GOFIrUlhnVUIzQ01KeHh0TWVpYnNDMGpBWlpWOVFsdFEvaG9PdWo4UTNYMERiMy91STA3SjNLNWZCYWZlR3Y0am9DUTRjZzBBaXRIbWNHZ2ZMQmE4WFU5ekZ4NkQ1dG1ucTJKNVVzK3ZVMExSbDF0b3NGR0o0RXM1VThmTER5Q3FVYlRQTHVjRkQvZmkzQUY1SFlvRnBmMFhnKzhzcnpNaUo4SUVOcVE3WEJRTFRjZUxuRG5kMGZwVGtTM0xvajRVQ0lwRjRnTmJ1ckV1elBNNURtdk1rR1hreVNCL3kvVlJFUFpyQ0pnPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiMjg0MzU4NmJjOWM3NDFkNzgyNzQiLCJleHAiOjE3MTk0OTk2MjUsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.WVpoEQW1lTqd233WBz8BvUJ_yeUpYQn3AIcJXUHoZ4k";

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Listar Convênios de Pagamento", "Consultar Boleto", "Sair"};
            int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (opcao == 0) {
                String convenios = listarConvenios();
                System.out.println(convenios);
            } else if (opcao == 1) {
                String linhaDigitavel = JOptionPane.showInputDialog("Informe a linha digitável do boleto:");
                if (linhaDigitavel != null) {
                    try {
                        String boletoInfo = consultarBoleto(linhaDigitavel);
                        JOptionPane.showMessageDialog(null, boletoInfo, "Informações do Boleto", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao consultar boleto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                break;
            }
        }
    }

    private static String listarConvenios() {
        try {
            URL url = new URL(LISTAR_CONVENIOS_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", AUTH_TOKEN);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao listar convênios.";
        }
    }

    private static String consultarBoleto(String linhaDigitavel) throws IOException {
        URL url = new URL(CONSULTAR_BOLETO_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        String json = "{\n" +
                "  \"barCode\": {\n" +
                "    \"type\": 0,\n" +
                "    \"digitable\": \"" + linhaDigitavel + "\"\n" +
                "  }\n" +
                "}";

        connection.setRequestMethod("POST");
        connection.setRequestProperty("accept", "application/json");
        connection.setRequestProperty("content-type", "application/json");
        connection.setRequestProperty("Authorization", AUTH_TOKEN);
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = json.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        connection.disconnect();

        return formatBoletoInfo(response.toString());
    }

    private static String formatBoletoInfo(String jsonResponse) {
        Pattern pattern = Pattern.compile("\"(\\w+)\":\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(jsonResponse);

        Map<String, String> jsonData = new HashMap<>();
        while (matcher.find()) {
            String key = matcher.group(1);
            String value = matcher.group(2);
            jsonData.put(key, value);
        }

        StringBuilder formattedInfo = new StringBuilder();
        formattedInfo.append("Banco: ").append(jsonData.getOrDefault("assignor", "N/A")).append("\n");
        formattedInfo.append("Data de Pagamento: ").append(jsonData.getOrDefault("payDueDate", "N/A")).append("\n");
        formattedInfo.append("Data de Vencimento: ").append(jsonData.getOrDefault("dueDate", "N/A")).append("\n");
        formattedInfo.append("Data de Liquidação: ").append(jsonData.getOrDefault("settleDate", "N/A")).append("\n");
        formattedInfo.append("Pagador: ").append(jsonData.getOrDefault("payer", "N/A")).append("\n");
        formattedInfo.append("Destinatário do documento: ").append(jsonData.getOrDefault("documentRecipient", "N/A")).append("\n");
        formattedInfo.append("Hora Final: ").append(jsonData.getOrDefault("endHour", "N/A")).append("\n");
        formattedInfo.append("Recebedor: ").append(jsonData.getOrDefault("recipient", "N/A")).append("\n");
        formattedInfo.append("Registro de Data de Vencimento: ").append(jsonData.getOrDefault("dueDateRegister", "N/A")).append("\n");
        formattedInfo.append("Hora Inicial: ").append(jsonData.getOrDefault("initeHour", "N/A")).append("\n");
        formattedInfo.append("Documento Pagador: ").append(jsonData.getOrDefault("documentPayer", "N/A")).append("\n");

        return formattedInfo.toString();
    }
}