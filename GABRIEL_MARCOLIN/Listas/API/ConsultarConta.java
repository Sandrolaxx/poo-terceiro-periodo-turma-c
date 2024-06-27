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

    // Método que recebe resposta do usuário
    public static String recebendoResposta() {
        String linhaDigitavel = JOptionPane.showInputDialog(
                null,
                "Informe a linha digitável do boleto:",
                "Consultando boleto",
                JOptionPane.QUESTION_MESSAGE);

        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, consultandoBoletos(linhaDigitavel), "Consulta de Boleto",
                JOptionPane.INFORMATION_MESSAGE);

        return linhaDigitavel;
    }

    // Método utilizado para quebrar linhas
    private static String quebrandoLinhas(String response) {

        StringBuilder builder = new StringBuilder();
        boolean entreAspas = false;

        for (char c : response.toCharArray()) {
            builder.append(c);
            if (c == '"') {
                entreAspas = !entreAspas;
            } else if (!entreAspas && c == ',' || c=='[') {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    // Método para consultar o boleto com o código forneceido pelo cliente
    public static String consultandoBoletos(String linhaDigitavel) {
        try {
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Dados do JSON
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
                    "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJqaytQSy9CY1JYU3ZiWW85ZkJGbFpUM01KUmcwQkhtQXJmRGxpWTlncklWZ21yU0FVd0ppd0VaNk0zWDAwTlZHdTJXSEpQR0NOVWdzS3QwN0lhZ2w4V05NNUpjeUs2NklZckd3SWcxN1pvd2wvZVkvUjFvRHFFbVpScnlLdXlhc0dSNFExcmM2dzVxWUU5aDB3Rkt1cVNjaDd1M1pvMG1jekdXY1V1aHRPaUdOK3VGLzVDZG5GVFFzOGxZZkJEd1FNZTByUng0SFZIZ3BYamJJUm9pUXRXVW5ZRlRFK1ROL2lPTGkzdTJZdUNZaXF0VmkwQzBITm5QbGFEeUNBRUE4SktnTk00L2hIdUZGblJDVHYrNjdCSUFEQnlTb0xINE05a0dBSmR6TVkxdGR2U1hXVXBkOE1QVEZJdm95ODhqWE1NeW8xN2lwS1F3TG1yMjRIdW15SFNnTmdVRlRQWDBTOXY2MG4yVHlvamJWZ25ySzZOWjVEY1l3VXJQOWVPRW40Zjl3Z2pWa3JmZVNyR3VKUXBmWWdTdGVDN2NaTEUwcDZWemRnZ0hreTZZb0c0NU40dm1hbWlYbHZlOHpmcGRUUXBybVRQMmg2Rkg4akp3SzRsc3lHOVhxV2pIVEFBaVNrQnlqT242ZDhjZjV5VnVsYVY0TkFmcXlNWE1NV0VHWllXcGhLaEtGeTFxYXExS3JNZ0RRYXRTQmJSdlBhUTZkNk1xMElvRHFsRStlcUY0VVE4YzR6TS8zZHlwd0lKMTcrQnBaYjV2c0xhcHNva2liVWhpMFpRPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiNTQ4NTcwMzkwNjQ0NDM5NjgwYzciLCJleHAiOjE3MTk1MTY0OTIsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.5qpn0EkrP_zLhkSgRujfLXd2TV7cJ1fKY-xkqJB9r-A");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();

            // Bloco validando resposta da requisição
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    // Formatando a resposta para quebrar a linha após vírgulas
                    return quebrandoLinhas(response.toString());
                }

                // Bloco para validação dos erros
            } else if (responseCode == HttpURLConnection.HTTP_BAD_REQUEST) {
                return "Erro 400: Solicitação inválida. Verifique a linha digitável e tente novamente.";
            } else if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                return "Erro 401: Não autorizado. Verifique suas credenciais.";
            } else if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
                return "Erro 404: Recurso não encontrado. Verifique a linha digitável e tente novamente.";
            } else {
                return "Erro " + responseCode + ": Ocorreu um erro desconhecido.";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Erro: Não foi possível consultar o boleto. Por favor, tente novamente mais tarde.";
        }
    }
}