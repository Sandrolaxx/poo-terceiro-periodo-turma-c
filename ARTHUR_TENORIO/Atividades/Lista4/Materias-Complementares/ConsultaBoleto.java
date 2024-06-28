package Atividades.Lista4;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ConsultaBoleto {
    public static void main(String[] args) {
        // Solicitar ao usuário a linha digitável do boleto
        String linhaDigitavel = JOptionPane.showInputDialog(
                null,
                "Informe a linha digitável do boleto:",
                "Consulta de Boleto",
                JOptionPane.QUESTION_MESSAGE
        );

        if (linhaDigitavel != null && !linhaDigitavel.isEmpty()) {
            String response = genQRCode(linhaDigitavel);
            JOptionPane.showMessageDialog(
                    null,
                    response != null ? response : "Erro ao consultar o boleto.",
                    "Resultado da Consulta",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Linha digitável não informada.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static String genQRCode(String linhaDigitavel) {
        try {
            @SuppressWarnings("deprecation")
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Dados do json
            String json = "{\r\n" + //
                    "  \"barCode\": {\r\n" + //
                    "    \"type\": 0,\r\n" + //
                    "    \"digitable\": \"" + linhaDigitavel + "\"\r\n" + //
                    "  }\r\n" + //
                    "}";

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJIQ0NiZkFJWVNGUmdoZStFY0VMN05NNFkvYzQ3YkNTb0N6ckE3bDd0eXZGdUpTK2dzNFRXSnFBamFpbk8zOG5LNVNpZWFpRnUwdzdNWTBnMDdIR0tZWk44eTl1a2JmazlBdXEvQnYwbWp5N2ZMMFozN1B5VlJiTUJUZ2IrcHVvbHhUM0IxUnM2RTRLMytvQ3E3S2lidGZBNkRXakRYK05NV25VUk13QmhXaXc4THJxS1FrU0s0RmxINUs3QjZWQWdCaDNwL01DdnFnZE1pd1Ewb2VKN0VNQmxja0dLRHRJeE1adlJHUXFkUzRXTnl1V2hpRE9DMG9nRE00Tzl3cjV6ZUdlejUvTVFzUWd4VVZXK0FMdHUvOU1uQVZTb05yNXUvRDU0ckRvdEZyZXIvL0l3Z3FTSWxvNzByZmUxZGh1a2hLaVBJdWJrTVdBVXJVTkJTVjhWQ2RCbDVJUlpkZDJwTnRobWhlbFZiUUl1dWhRNVV2Z1ovdlREbnBPWmJwaEN5cFNLcW9IYXFxZGFmU0tjemNWMkloa21DaXJFRng4bVJWZ1NvY3VjbHkxbEY4cGF1aS9QMklha0VUQ21HMGlZditUTUtxV0drSlMyOG83SzgvVkxMQjZaQzhtbFlXWkNTc09TeTVETE1kVXVYWVpHYmllYmxNWWk0cXMxZVRudi9vMWVMYXNDS0t5T01JamI4T1hJeTZBaEVaOWhqaHlMOE1YVHZkQWU0REEvUjQxVFBEZTdJZjJLMFBEOXVrazd0d0Y5UWZ4TWtCQ0lzWmNMNlhPQ1V3PT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiNDBmNWEwZTcxOWJjNDgyNDljMDgiLCJleHAiOjE3MTkxNzQwNDQsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.utl08UlDct7PaK3omYGXGH8WcV1K-oGwDefeqQdeebc");
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
