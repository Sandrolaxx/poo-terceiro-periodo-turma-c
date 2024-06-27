package segundob.listas.lista4;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
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
            connection.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiI2bWlqUkpvU2dRRDduYmdCeVRtb2JpU2JKVlhqNFZQVFZpZW1ReG1vdVFwU3JuMjgrOTlkYWhLT3kxVU5QWDh3WnJ0UHF3Qm8yclF2K0h6NmViaGNmWkRBS2ZoL0VtYW1kZk0wNXVEUFFCU2phMHFTNXo5TVhtYnlHNVY0eGpJOUxpckRZQ1ZFS2lsaTZjekxqWFlqVVpvZUpEeTBXdWxWRG5laFFjUVN2dXo5cWhHb2RyVm5FU3FRYitDTW9kQXBzQmJmNE4zVTJVR1E1MnFVZm82eDJkRVp6YUl0U1BHU09tUE5lTHpMM1hGcFJWajV4cmNoWXVzRFJmUmNNcER1RmI2eTIwZnJDZGx3STFNNW9QQ3VZbkdlMVFwVFFhcmROOHliMkV4WCtwaEx5dTR3NUtiOHVOSWlhQmxoZ1BwbFF2Rk5PWWpJRlJHa0NzbnVNZ3BNTW1EeExFUXJCUXhMUllqOFU0NjBoZmxxQkphRlQ3TWtDR1hucXFlTzNDQXp3VUNqejMzN1Q5eE9LNFJMOUZURUhOWjFCcTRDTVR6Z3Z2ZDVXT09XcmpBTi9PazNWVlJUWGp2a29qNEFHSUQzUmErZEhEYVNvOWxIMmFreWtLV0lJdWpERkNodmFvWDF0ZWxDVkZJY1NBc0FVNytMMVBwL3A1YUNuUTN3RGFRL0pJckJYL29VTU5aR3E2Z05kejZvZGFvM2dSaVJ6SUxPSmk2Wmd0dllhR1YyWlVpUTlic1dWMG93aEIrTjI1TlRXS0FuaHhmbVl3bDNlR25Md2ZwMzNBPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiYmMwZjQyZjU1NmU2NDMxYjhlZjgiLCJleHAiOjE3MTk0ODU1ODMsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.MbcPQMLenF2xolXLAjNS4tb5CarrNmTK82zBsQfe0u4");
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
        } catch (Exception e) {
            e.printStackTrace();

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

