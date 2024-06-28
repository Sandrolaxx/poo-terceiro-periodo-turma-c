import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javax.swing.JOptionPane;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CelcoinApp {
    private static final String BASE_URL = "https://sandbox.openfinance.celcoin.dev";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiIxSFMxbTZWSytWOUQ3SXRsU1lvbEE1dGZTeXg3cmRPZTNNSk9ob1dGQm9HNm03WXVyUWZ1ejQzMTBZZXdsb3BnZzIvSHdoaHlBSHBhbU5QSHh2YkloUVUzRHNBU2xueXVWVHU5USszWCtGMkFoVnF2c09PWUUzZnFoUUF2S0V3MDNhYm83OXpIZ0NhQXNEWC9qeURXbTkwWUNwaHR2TlF5NXE1dG9uMEMwVG1QeW9zd0hWSFFvT2N3bFhjTURsSmQ0dituN3pFc09PRnlST0JzMmd1QjltZDNydFU2UFlsbjc2Y016UkJPNWkxRTllaFF2QXNyamFQZkpFZUl0ci9kNk9weU9aWnB3anZiZHlGTTNzNk53Yk5ucUNNaE9XYlhVN3NCUHhHQVlyTC8yK25kNFkvUlBpUU9JVlRQUWg2eGI1dlJlc1h1UU9DN1liSnFYK1NwQm04NStUc2V4SXNnb2pTVDVYLzFjaUZPL2NVSEtzN3dWaE9Hb09DOHFnQldoUU00a0FRcHRrK1dnVUpzcVY5SitKbGV3aXlhQmlmZ3kxcm1SUzA1UmhocXNIeldZSlV0N05yczl3NUR2MndneGZiRnZ6N1FBMS9xMlV6UFQ2bVE4TXo5Qm5lbi9HZ1FYVE9iTEdyY0IzaUIwUWpTRGtJSFVsYVh5TUQxVmwxaS9PZFBrcy9OUjFSbFNwdTZRa1Y1ZCthQXV1UHpOV09xU3FtSytDK0c1RUdsWitRVkkwTTRIeHVNeXhLWGx0SUppYm9XSHRQQkNRelIyTUswdWJheEVRPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiMjk5NjA5NThkYjdiNGIzNGE3Y2MiLCJleHAiOjE3MTk1NDU1MTQsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.HFd7oS1WcUO8YbwRgKZeF4iAiXua40cnpJ2-LcEVYeQ";

    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Listar convênios", "Consultar boleto", "Sair"};
            int choice = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu Principal",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);

            switch (choice) {
                case 0:
                    listarConvenios();
                    break;
                case 1:
                    consultarBoleto();
                    break;
                case 2:
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }

    private static void listarConvenios() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/v5/transactions/billpayments/providers"))
                    .header("Authorization", "Bearer " + TOKEN)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
                JsonArray providers = jsonResponse.getAsJsonArray("providers");

                StringBuilder result = new StringBuilder("Convênios disponíveis:\n\n");
                for (int i = 0; i < providers.size(); i++) {
                    JsonObject provider = providers.get(i).getAsJsonObject();
                    result.append(provider.get("name").getAsString()).append("\n");
                }

                JOptionPane.showMessageDialog(null, result.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao listar convênios: " + response.statusCode());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar convênios: " + e.getMessage());
        }
    }

    private static void consultarBoleto() {
        String digitableLine = JOptionPane.showInputDialog("Digite a linha digitável do boleto:");
        if (digitableLine == null || digitableLine.isEmpty()) {
            return;
        }

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/v5/transactions/billpayments/check"))
                    .header("Authorization", "Bearer " + TOKEN)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString("{\"digitableLine\":\"" + digitableLine + "\"}"))
                    .build();

            HttpResponse<String> response
