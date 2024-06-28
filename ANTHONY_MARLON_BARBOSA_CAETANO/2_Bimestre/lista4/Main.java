package lista4;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJNVVF4Q3RneURaMk9yekQ2SzBPc05NZ1dBQzJpVE13OXRLU0RzNmJ2VFVKMnM2N0JOTmVRSDVnUEVVVjlyUkgwQnY2cEI3SVdYSUFza3NCaHFaZzgzQjNsUERxaHBwSHl2Mk9DbVNxbkpha21lQkgxdGgyUzRyMjAzUG9FVXlYTTRCUXgrOFlFM3FGUDFmdEJuaWdmWXArRGpDZ3M5TzdHTVdTUlZFem5mWVdmd01LaFJmeHUyZzBUaFREUy9heC9IbjdneUJHazFOWWNUbnJQZG9Hd2Q0akJURFg1eG94QVJsK3o5MitTdWlxNXJMTXdjTDFYZ24vcUp5Q00xRjRORGdISVBuV25JaEZsRFVXMy9aS2VSVWliYTFYczRRU0d6TmpSMmdaMGtySytCT2tiSWE4OWlsajZZT0ZVWGhoajFQa1d5Q3NKYng1WjhpcGpDNHlqNnBKZUlEQmozK05iSFM1MTVWU0VUWjFYanY5dlprMUs4NkhXdDZmTzNNT0F2OVBZTmp1dTd6MGpmeWxRZGRXSi92ZWw1d1ZRaHFKT1NpbCtYZVd5YXFLaFZvSkhFMUdDbXROZWxTdzBKQnE1UzhLZkxHYWFqWVdtbnNKNmFDNVVwMVBXSFlzWGQrc0RzelFLTlBjQUpiUlNtakMvM0x5dGZhbGhzdUhmOWFwL2Nwa1hZSmZjajB2V2tyN2prbXZUWkdFUDlVUkxDQko3V1pQR21pUUkwY3krSFBmQWw0dnZpWk90Q25maUp4dVJBRmlTWDBMMlozS3EzZ1ZUcys1RWx3PT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiNjRiZjkxNGQ2ZTRiNGYxMDk3ZDMiLCJleHAiOjE3MTk1MDgzODEsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.suLnREtXkK4xKCszq5hgUOUpqD-34JAOlsqm4sCX_iE";

    public static void main(String[] args) {
        while (true) {
            List<String> opcoes = List.of("Listar convênios de pagamento", "Consulta de boleto");
            int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes.toArray(), opcoes.toArray()[0]);

            if (opcao < 0) return;

            switch (opcao) {
                case 0 -> listarConvenios();
                case 1 -> consultarBoleto();
            }
        }
    }

    private static void listarConvenios() {
        try {
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", token);
            connection.setDoOutput(true);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            System.out.println(response);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao listar os convenios ", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void consultarBoleto() {
        String codigo = JOptionPane.showInputDialog("Qual a linha digitavel do boleto: ");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize"))
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .header("Authorization", token)
                .method("POST", HttpRequest.BodyPublishers.ofString("{\"barCode\":{\"type\":0,\"digitable\":\"" + codigo + "\"}}"))
                .build();
        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao consultar o boleto, verifique se a liha digitavel esta correta ", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        String responseJson = response.body();

        Map<String, Object> jsonData = converteMap(responseJson);

        StringBuilder message = new StringBuilder();

        message.append("Cedente: ").append(jsonData.get("assignor")).append("\n");
        message.append("Data de Vencimento do Pagamento: ").append(jsonData.get("payDueDate")).append("\n");
        message.append("Data de Vencimento: ").append(jsonData.get("dueDate")).append("\n");
        message.append("Próximo Liquidação: ").append(jsonData.get("nextSettle")).append("\n");
        message.append("Data de Liquidação: ").append(jsonData.get("settleDate")).append("\n");
        message.append("Pagador: ").append(jsonData.get("payer")).append("\n");
        message.append("Documento do Pagador: ").append(jsonData.get("documentPayer")).append("\n");
        message.append("Beneficiário: ").append(jsonData.get("recipient")).append("\n");
        message.append("Documento do Beneficiário: ").append(jsonData.get("documentRecipient")).append("\n");
        message.append("Hora de Término: ").append(jsonData.get("endHour")).append("\n");
        message.append("Código de Barras: ").append(jsonData.get("digitable")).append("\n");

        JOptionPane.showMessageDialog(null, message.toString(), "Dados do Boleto", JOptionPane.INFORMATION_MESSAGE);
    }

    private static Map<String, Object> converteMap(String json) {
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
