import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class ListaQuatro {

    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJJbzB6Y0tTK0J6dE91SUFkcEZEbUJ0eVlDbXlvN0NWWTdEWmhqVHpmK3RqTlNnVTluTWRLUjJQYTFXeldJcFluSXdYRHpCT3N3cHBnVHF2MkRPWEpVdE5jRm1VOEVZS216bVByWDMrQkNmdkJob2Q1UEV4dy9zaWJuMWVCaXVqaC8zcFFwZHU1UDlKMm9Nb0hvNXJNSE02Ui9wOHY0dG9yb1RnbHFYVXdVR0xyME42NlZLSVVTY2hIN3hpNmxWVnlldU55alRBTjNoVFNnZTJ6YUd5dzZtcnFHWjlkS2gyOHV5dXpSSE9oVW04VGhUUHZzdkl6akZYSVlRUHBIR2xLVUR5UDR4RmJqeVU3S3RDNnhrcTRIaXFVWHFMdDUzbk91em5XNS9LWDB1QWs4ZndPaGhteHhzWTdrcXpiTUlqTWZ1aTFiSmpjWFVSWXViTFpWOE8yRjQ0cE1nWVZGZUMwVm5qSDdkbUMvQkJ6KzlGRDlPSHdjckRYczBZZW1iVnB2cGx2eWI0RGZqelQzcVBmQjlRMmlyZFptaUMrTG5jU2RLWW9WV3JQcUVEMzFmWndlcElDSStVYi8rWXNIbU84eFdaK1NnUlRiZEZNODJ4S045SjMwSWxFdjZ2VXY4N0JTOWJzMm9oaHVjeFUxeCs2ME9vUmx3OVgzWGVoRitTSmp1a0pOcUtmMHBMTVpwV2VoMzBGakI2V29tNEZNaWNYN3RtenR1V0lnS282WnBTOVcwL0hpdWhhS1NIaGFUWmRsRTdTY0VHd09CM1RTeTNCYnloQmpnPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiMWZkMDFiMGE5NDJjNDk4OWI5YTQiLCJleHAiOjE3MTkzNjkwNDEsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.F12mHbBJvJyjZCyb5-pQIVAtPuUe5ff6Gzz5Hd6cyvo";
    
    public static void main(String[] args) {
        String[] options = {"Listar Convênios", "Consultar Boleto"};
        int choice = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                listarConvenios();
                break;
            case 1:
                consultarBoleto();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida");
        }
    }

    private static void listarConvenios() {
        String url = "https://sandbox.celcoin.com.br/v5/billpay/convenio";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + TOKEN)
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONArray convenios = new JSONArray(response.body());
            String formattedConvenios = convenios.toString(4); // Indenta o JSON para melhor leitura
            JOptionPane.showMessageDialog(null, formattedConvenios, "Convênios", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao listar convênios", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void consultarBoleto() {
        String linhaDigitavel = JOptionPane.showInputDialog("Digite a linha digitável do boleto:");
        if (linhaDigitavel == null || linhaDigitavel.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Linha digitável não informada", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String url = "https://sandbox.celcoin.com.br/v5/billpay/check";
        String json = "{\"digitableLine\": \"" + linhaDigitavel + "\"}";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + TOKEN)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject boletoInfo = new JSONObject(response.body());
            String formattedBoletoInfo = boletoInfo.toString(4); // Indenta o JSON para melhor leitura
            JOptionPane.showMessageDialog(null, formattedBoletoInfo, "Consulta de Boleto", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao consultar boleto", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
