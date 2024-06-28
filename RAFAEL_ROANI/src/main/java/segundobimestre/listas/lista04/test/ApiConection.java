package segundobimestre.listas.lista04.test;

import segundobimestre.listas.lista04.utils.JsonUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ApiConection {
    private HttpURLConnection connection;
    private URL url;

    public ApiConection(URL url) {
        this.url = url;
    }

    public Map<String, Object> getReturnsMap() throws IOException {
        return JsonUtils.toMap(get());
    }

    public String get() throws IOException {
        openConection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);
        setKey();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();

        closeConection();

        return response.toString();
    }

    public Map<String, Object> postReturnsMap(String jsonBody) throws IOException {
        return JsonUtils.toMap(post(jsonBody));
    }

    public String post(String jsonBody) throws IOException {
        openConection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonBody.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();

        closeConection();
        return response.toString();
    }

    public Map<String, Object> post2ToMap(String linhaDigitavel) throws IOException, InterruptedException {
        return JsonUtils.toMap(post2(linhaDigitavel));
    }

    public String post2(String linhaDigitavel) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize"))
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .header("Authorization", getKey())
                .method("POST", HttpRequest.BodyPublishers.ofString("{\"barCode\":{\"type\":0,\"digitable\":\"" + linhaDigitavel + "\"}}"))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private void setKey() {
        connection.setRequestProperty("Authorization", getKey());
    }

    private String getKey() {
        return "bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJLZUpSeWNVS3Vka3lhZUYvVzIxT0REb1BSeTg2N0FGVUc5LzBDbHl2eEswejJwYVNocFZWQnhuRWFadnFkY09heGFEZEt1bDZhbTVrd2ZyTHRCb1B2ZTF2QTlWUkYzRnVyUmNHQ0tib3ZORGY1WjZUaUhlZHVSN2pCTm1QT2VsRVN1RGNvaUxIL2pmZFVrdG1nNzcrbmlOTGZSMEQ0VWVVaG9RTm5PNG1EZXczVzV0UEtmZFJzditUclRqNWhuYmJjTUg0N1Y5RHEyRlVmVlIranF2NXFoUGZ4M2p0aEJ6blV0T3RlRmY4TVlQUDdZYkVqbG9qNm56NCtrZXdNZ2JtRHZJdUpScFdoVEFxTEJRK1pLcVJuZ0krL25zaHBFQlkvZCtyaTBIWUs2cDBOY2hVT1VRcURNN1FxZURyRDMwSFlzdW9jazJjME1JNEZqR3ozMWhpam80VGNMTm91WlhHUjJpK2NKNzBjZFkrMHE4Z3lQL1J4V3RiMldyQWRCaVkzaFcwb0Nwc29NT2tveW1Ja0swS1grVHZPeEZheHZjZGRtek5MNmhWUnAvc0hVQjdRMWVMcVNrcXp1SlVMaDR3dUlwUmdja1JiQXpiSW9tSGZ0ZTRKQUkwTWdsQ1lqNlZrNERFSG5xazVnaU1OSzRrOWRGM0poTmRlbHh1eEd1M0kxUDd3ZHhORkRFYmJhUWdvQ2ZReTRsckMzcVNaMzJFZDNlelpEYjYrbXFhS05BOE5ENWplWkxXNndyZnp0UzJ2RlFsMFpFT2hLWFZROFZPVk1HZGRRPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiYjc3NDIzZTkzOTY5NGY1Zjk5MmQiLCJleHAiOjE3MTk0OTg4MzUsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.aV28VQaEtLCeAxLJjuo9S_rff1eYtFCRFp2N9x_hQGM";
    }

    private void openConection() {
        try {
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            System.out.println("Erro ao conectar com a API!");
        }
    }

    private void closeConection() {
        connection.disconnect();
    }
}
