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
                    "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiIwVS93WDNsWGZWN2psRHZabXN1WnJNRmdYdDRjbDBicmhGVFBqU0N4dHh5aEtrTzNCWDhmdHVlRFNTRFVwKzQ4V0c5d3ZSdzJSeWtCc2JCbDArbkVQbjBJejJ6T0hJY05NVGVIcVlpMFpHUzROWG9SNll2cTd3MjNPQWJubEVzVytKRUUrS3VkaFV5SWZuZElHQzhCUEVVc2dSKytrSy9WYjROdktRSGhqMS9GWjZFRU53QUc3UG1mRVRLK25rTlZNK1BHZVVmeHk5MHpTRWI2Q2hqcVZWU3VGbTJ6R3o1OFE0YStpRE5IK1JxWXRuV01nYlVJSWFhdVZpSmhUbVpOK0JuUS9vNW5FTjUvZHl1ZnBXcGE3VDJKTE9UaEtkZXNxYnRkM3E1alY3RVlTd1lLK0swOTNGQVdJbHZNc3ZxZlBxSVpMekVLNWhROWcxSm5lY2F1RXFJaWJIbG9xWk5Pc1FUODRRanZQZ05paU05L3dVYzV6dTMxQzhkRHlxRmJsMGVzcDByN1pLWGRhV2JhQ0JTQXNrZjlUeFlIMGRSZUdHbSs0RC91WEU2OEFOWHdKVUVnVG1rdTgwUlNNV1ZoUXR3VWFpcWxVcE94YnI3akpFa1ptU3MvS1BkNzcvYTZUZmdVS3FjUGZiQ3FKWldwRGtBUVNnai9ra1ltU2J1REo1bmNpeit3dzNoWENUVkhmMnRDdnJrMS9TNm5HcEZjQ0JKdG16aU9IT25ldU94Y1VyMEhseUJhbTJFT3JYWHlVRnBpTWwyY09FVzJvOWlodldXWWJRPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiZDM2MTU5YjRiYjg1NDRiYWIzMjIiLCJleHAiOjE3MTk1MTI5NzUsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.OOkamsctXv3ZkCaxXeJp_hT1Pqj6yfTp4d_AX6LP27A");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();

            //Bloco validando resposta da requisição
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    return response.toString();
                }

            //Bloco de validação da resposta de erros
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