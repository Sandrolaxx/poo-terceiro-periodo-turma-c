package segundob.listas.lista4;

import javax.swing.*;
import java.awt.*;
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

public class ConsultarBoleto {
    public static String getJsonData(String linhaDigitavel) {
        try {
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");

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
            connection.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiI1UkJZalRsZnVHNlphazF1aWJwNTZJai9JSlI3aURQRVllU3Z2ckUvMU40QW9Edkdvc244Zm82NHovbFQ5Q0ZETUFrSDg5RDgycU9pU0NoTkc5WWZVWkI5c1VzQmFUci9PVGJlSmJmVk9WTHNYdHZVVGQ3clhwTmtnTFJGUi9FTEplbSt5aFZ6LytENSs1WjcvRzVpcE5BSVJUSzBmOWdOZkhObUpVbzJoQVFrekNPbTAxclRYM1J4UnV4ZVNBQm1zUm9aOWtDL1VLUjFDbmhOVjVnVFowREdHV1Jsd0cyWE1XWjYvb0pYa2xURlRkbFF6QUd5bkNNMWNtdHZPK1JuNHNtTCsvMVArNG5mb0ovV2x0czRkaHYwb2drUHMzTmQwQ085U1hpK0I5a3VhZUJ6ajMxcHFSKysvbnBUQmdmWWFzRmFqMUJFNkdGU25zeUlDZW1IUHNtaEtVNGlmTnZtN1gwMVhvL1FyTjhwQVVJK29oTUhjSEJmRVB5Q1F6K3IxcS9FRU0ySVpkT0FxVnlHWHBjYWVWbEdpbHFSMHcvZjZPUUJDME8vRUVYY2M2Kzljd09KREZCcUR0bFBGNnFvQVVNcU83VjdLUUk4QW9zN0F6RStaQzhERURNRVQ5UkR1d3BtSm5BTGRWNjVGamQwQU9GWVAyQi9NOGZuZWladFJjZnJicUcvRmdsSEk3eHUycDdHQ1F0UkZNR0lVMGxIMXFzQ3I2U0l6aURadjNvUmpxbU02SjdLQS92R2EwbU9WZjUyVGRtVFYwTnhsRU4yTTVaRyt3PT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiYTdkNWU4OTczMjJlNGI4NWJjZTgiLCJleHAiOjE3MTk1Mjc1NzEsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.luCMCmeMDkSF6yhUw215Ldnif1_U4P6aL4x4DAhJOD4");
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

            Pattern pattern = Pattern.compile("\"(\\w+)\":\"([^\"]+)\"");
            Matcher matcher = pattern.matcher(response.toString());

            Map<String, Object> jsonData = new HashMap<>();

            while (matcher.find()) {
                String key = matcher.group(1);
                String value = matcher.group(2);

                jsonData.put(key, value);
            }
            System.out.println(jsonData);

            showDataPanel(jsonData);

            return response.toString();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao consultar o boleto, verifique a linha digitavel", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
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

