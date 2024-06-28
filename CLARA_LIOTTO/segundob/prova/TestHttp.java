package CLARA_LIOTTO.segundob.prova;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TestHttp {




    public static String listarAlunos() throws IOException {
        try{

        URL url = new URL("https://poo-exam.vercel.app/api/students");

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
        } catch (Exception e) {
            throw e;
        }
    }

   

    public static String enviarTestemunho() throws IOException, InterruptedException {
        String json = "{\n" +
                "  \"imageUrl\": \"https://i.pinimg.com/564x/e1/7d/37/e17d376be992e5730fbc6b0ac972ff70.jpg\",\n" +
                "  \"description\": \";)\",\n" +
                "  \"ra\": \"11205\"\n" +
                "}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://poo-exam.vercel.app/api/testimonial"))
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(json))
                .build();

        try {
            return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException e) {
            throw e;
        }
    }
    
}
