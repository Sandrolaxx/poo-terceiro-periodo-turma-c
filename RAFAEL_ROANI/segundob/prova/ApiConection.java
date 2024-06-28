package segundobimestre.prova;


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

    public Map<String, Object> postReturnsMap(String imageUrl, String description, String ra) throws IOException {
        return JsonUtils.toMap(post(imageUrl, description, ra));
    }

    public String post(String imageUrl, String description, String ra) throws IOException {
        openConection();

        String json = "{\n" +
                "  \"imageUrl\": \"" + imageUrl + "\",\n" +
                "  \"description\": \"" + description + "\",\n" +
                "  \"ra\": \"" + ra + "\"\n" +
                "}";

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
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

        closeConection();
        return response.toString();
    }

    public Map<String, Object> post2ToMap(String imageUrl, String description, String ra) throws IOException, InterruptedException {
        return JsonUtils.toMap(post2(imageUrl, description, ra));
    }

    public String post2(String imageUrl, String description, String ra) throws IOException, InterruptedException {
        String json = "{\n" +
                "  \"imageUrl\": \"" + imageUrl + "\",\n" +
                "  \"description\": \"" + description + "\",\n" +
                "  \"ra\": \"" + ra + "\"\n" +
                "}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://poo-exam.vercel.app/api/testimonial"))
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(""))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
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
