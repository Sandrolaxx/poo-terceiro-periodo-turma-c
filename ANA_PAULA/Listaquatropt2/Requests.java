package Segundobim.Listaquatropt2;
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
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Requests {
    private static String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJmb0lQS1U2ejJ2T2c1amdjdW91ZWZRU0YzWEdIWFMzSGFCc2cyR0luQ3R4NVZKT2ExN2VrUHZXSjg4WVU2MzlGTXp4U3dxT2YxOUpoQXk0NU9pNm1iWk03RmlDSGtJWVNSNW9jZm5CRVd5T1d6bHRUZ1dBYU5DZTllWGtoUlludmRCZkt2d3pnTWJid2dqaU9KZEZPZVJvQ0sxQnZIaHBKcnBHUzZtcVVzNnBFaWJhV3A5T0pCWVQ0UlQ2WlMwNndQWlB2UGdSUHpualY2aGl3WUxWR2hpdzBheTJXUEFpWEQ1L3ZjSWlMNElCNkt3d0V1RndacVluRXVhMVZEN3NLcEFsWEUyeVhqc2pTWEI0bFUwcWxDaHA1ZXN4TnFwdUtXVk5sV09pNTBMWnlTWm1sMnNLQmdYcmlod2ZCSTFtY2F6bW4xT25ybDI3NTE0MXZtQkhqc0I3bjlEMTFYM0RqOWNySUN1UjBhbmhKSXZ4Ri9kL3pJNHRnMUFNak1McHNQYVhqT0IwVXF2ZFhnMmpCc3dCU2R1bER1L1RUVmFVVTl3NFlyaXBTdU1ZZm1aNUJScFVtRldtdVVjUXJDNzA2MFZ6QWtiUWg1WHlCSmh4V2pGZVRKbkZuT2xCZ1VPeUxRYVJaV1d6TUhFMXEyVFNXYkVpN1Q0WG8rUEVueGNXNW0rSTJ6WTFNNWI0L0l3L2M3QWRvY1NSYi92aGd1NXdUUFE0aWd4d0NaQkpBY3U2bHVmeVB0MHVxMWRyTWQ2SEgzM2hmUk94V1l3MUJyYitpOTRtMkxBPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiY2E1MzA1MjMwMzg5NGI0YWFkMTkiLCJleHAiOjE3MTk1MTEyNjgsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.VvnlLAY2kia1uup1D7YwJV5hTYbNAOiI_vqXB-k2UlA";

    public static void listgemconvenios() {
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
            JOptionPane.showMessageDialog(null, "Erro para listar convenios", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void consultaboleto() {
        String linhaDigitavel = JOptionPane.showInputDialog("Informe a linha digitavel do boleto: ");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize"))
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .header("Authorization", token)
                .method("POST", HttpRequest.BodyPublishers.ofString("{\"barCode\":{\"type\":0,\"digitable\":\"" + linhaDigitavel + "\"}}"))
                .build();
        HttpResponse<String> reposta = null;

        try {
            reposta = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar o boleto, veja se a liha digitavel esta correta ", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        Map<String, Object> jsonMap = converteParaMap(reposta.body());

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
