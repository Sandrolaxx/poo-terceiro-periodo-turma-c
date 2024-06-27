package segundob.listas.lista4;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsultarBoleto {
    public static String getJsonData(String linhaDigitavel) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize"))
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .header("authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJyRlh3cUJBZHd3dzN3UFJEMHNCbWRtdTdBTmJnei9FV2xNcU1KMis1SnJIaTJFc213azZZS3N0V09lSklaNndFV2RQTTlndHJFb1V3ek1rTGZLVFZ5dldCTExFcEN6TVlIMFc1V04xZE5VZkx4QW1XaERrYWp0NEZiSi9JT24wTWFLcFl1S0xueWpqRzBxd2x1NmRUMFQ1cUZwd1BHQjlUclNsYjFEMFczbjZHaStRSnlWdGhTL1JUa21mV3NHREZXakpwOFZpNlFuOVc3eFhiQjlxYU9COGZaa3BkeGJmR0E2MDRhTWJZT3dOQVAzTVlxYVpRekRQdlNXRHIwQWEwRHpobWpuWEFjZUhnN016MGFDUW9VL2IyZEwwYm1wK0k0VW1yZloxM3VwU3FsU0R1azYzZlJlazRHVUozdlZpeEFuRlprL1AvMmlxQ3VzVFpkbDJ3UEVQN0x1eHJmMHpQcVp6NkRGbHlONXZrU0ZYckg3ZVFWQWRmcHllM3lBQ09wcHFDT3JFb1h1bG9jSG5QN3hIZ3JIWG9PUTJmTFprcjFNM0NlQTVnbkdVSERyQ05iR3IvNmw0NVE3RmFLazEwV3lkNjJqaGlOaXpVajRTeFZEalljMG4vL2pjaHBBbkdZSm1NcFVmQlFXMDBOSXRSZ2kyNC9wdjRDcHNaSW5ES01EaHVhUVo1Q1hOZ1JsQWlRdU9RaHYyUzZJRWlsbFQvckk2NzdwR3hLQlRQRHMyVG9uZDFkWGZBdTRvWktVSjF3bXpHa0ZDdzlRTXk3QVRnSVp0MHRBPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiMzRjOTEzODY5ODFlNGEzNWFjY2IiLCJleHAiOjE3MTk0ODI1OTQsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.sxaAkJJDOB4W-4pMyTSulIv-6Q1hZxQ0DWfNVBhmmSw")
                .method("POST", HttpRequest.BodyPublishers.ofString("{\"barCode\":{\"type\":0,\"digitable\":\"" + linhaDigitavel + "\"}}"))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        Pattern pattern = Pattern.compile("\"(\\w+)\":\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(response.body());

        Map<String, Object> jsonData = new HashMap<>();

        while (matcher.find()) {
            String key = matcher.group(1);
            String value = matcher.group(2);

            jsonData.put(key, value);
        }
        System.out.println(jsonData);

        showDataPanel(jsonData);

        return response.body();
    }

    private static void showDataPanel(Map<String, Object> jsonData) {

        JFrame frame = new JFrame("Dados do Boleto:");
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        panel.add(new JLabel("Banco: " + jsonData.get("assignor")));
        panel.add(new JLabel("Data de Pagamento: " + jsonData.get("payDueDate")));
        panel.add(new JLabel("Data de Vencimento: " + jsonData.get("dueDate")));
        panel.add(new JLabel("Data de Liquidação: " + jsonData.get("settleDate")));
        panel.add(new JLabel("Pagador: " + jsonData.get("payer")));
        panel.add(new JLabel("Destinatário do documento: " + jsonData.get("documentRecipient")));
        panel.add(new JLabel("Hora Final: " + jsonData.get("endHour")));
        panel.add(new JLabel("Recebedor: " + jsonData.get("recipient")));
        panel.add(new JLabel("Registro de Data de Vencimento: " + jsonData.get("dueDateRegister")));
        panel.add(new JLabel("Recebedor: " + jsonData.get("recipient")));
        panel.add(new JLabel("Hora Inicial: " + jsonData.get("initeHour")));
        panel.add(new JLabel("Documento Pagador: " + jsonData.get("documentPayer")));

        frame.add(panel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);
    }
}

