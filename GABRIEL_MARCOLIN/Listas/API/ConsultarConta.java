package API;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConsultarConta {

    public static String recebendoResposta() {
        String linhaDigitavel = JOptionPane.showInputDialog(
                null,
                "Informe a linha digitável do boleto:",
                "Consultando boleto",
                JOptionPane.QUESTION_MESSAGE);

        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, consultandoBoletos(linhaDigitavel), "Lista de convênios",
                JOptionPane.INFORMATION_MESSAGE);

        return linhaDigitavel;
    };

    public static String consultandoBoletos(String linhaDigitavel) {

        try {
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Dados do json
            String json = "{\r\n" +
                    "  \"barCode\": {\r\n" +
                    "    \"type\": 0,\r\n" +
                    "    \"digitable\": \"" + linhaDigitavel + "\"\r\n" +
                    "  }\r\n" +
                    "}";

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization",
                    "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJvOFpLbW94SnhWWnJUeHhNVmhGWFV6MkI1L0huQ1JlVk1QaVFXRmU2bk5icjl5TG0rZkVLYWRINktEa3Z5dEtCVGxyYlhoSkVmM3Vsd2dGTzFPZnJCRHRmaWowMVd3S1dxb2hPSTBMNm8raWJaSTNZdWVjQThXditpYUFIQTc3YjVVK2E4aUo5ZktPUTBzT253YXc0TEFKZWE1K0IyalNJdU1yUSt3V0o3Q21lMVY5Q0lJcWUzd21GZEhrc0dCTVpUdGRLemtKRmtXOEJpdDRpdnozVE9rV05QZVhNMUk2T3hXaGlYb1VCK2cwYU96SkNrZ2xyMDBTUUgraDJ1ZUVsbitaZTlvT01DZmF0MzdTT0pYNWtXSElva2R3dlpuelB5K0tzUWdRUGNZc0lKZlZnVWh5cTRjMlJoRkNiWFhPMy9PaDlmV2NCUzIxNDc3K0xkQmE3ajlWN0I2ZTkybVJOMys3VGQ0WW1Nb3Q1N1krOXRnM1dPbU5tUHlRMkVjZW92QnFEUWx2dzdGMGJVTGRTNWRsOTZqN0NML3dtbldZZjlmdHJ3MHdRM1NpL25YQjJMY3BXd2tXNFlqRVFqNjMrYXMvZTFOeENscUZlamN2OEJsenAzU2RydzBFeDdtOEdISkNXZkg3bjcxaFNSUHR5RlNNMjM0M0h1STF2emRFS0dJNitpU1Y5UnVUR2ptdVphKzR5VnZTK0ZLU1ArajJmTEpmT1BPcmdiWlM4VXVydkMvR3lNZGtzLzZHb1lIMXo2UG5ZZUc4Si9jS2hvMlFUQ0RubnpBPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiOWI0MWUwNDZhYzU4NGExNGIyNjEiLCJleHAiOjE3MTk0Mjg3MjQsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.7QMXP2PWtGP7n1ravBlJiIs6NPDwNkxuzg6mf4nDKVM");
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

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

}