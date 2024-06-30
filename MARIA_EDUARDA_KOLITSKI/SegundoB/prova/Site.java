package MARIA_EDUARDA_KOLITSKI.SegundoB.prova;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Site {

    private static final String BASE_URL = "https://poo-exam.vercel.app/api";

    public static String listarAlunos() throws IOException {
        try {
            URL url = new URL(BASE_URL + "/students");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            return response.toString();
        } catch (IOException e) {
            throw new IOException("Erro ao listar os alunos", e);
        }
    }

    public static String enviarTestimonial(String imageUrl, String description, String ra) throws IOException, InterruptedException {
        String json = "{\n" +
                "  \"imageUrl\": \"" + imageUrl + "\",\n" +
                "  \"description\": \"" + description + "\",\n" +
                "  \"ra\": \"" + ra + "\"\n" +
                "}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/testimonial"))
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(json))
                .build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new IOException("Erro ao enviar testimonial", e);
        }
    }
}
