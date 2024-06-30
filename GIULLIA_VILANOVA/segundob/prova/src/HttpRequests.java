package GIULLIA_VILANOVA.segundob.prova.src;

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

public class HttpRequests {
    public static String listStudentsData() throws IOException {
        try {
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

    public static String sendTestimonial(String imgUrl, String testemonial, String ra) throws IOException, InterruptedException {
        URL url = new URL("https://poo-exam.vercel.app/api/testimonial");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        String json = "{\n" + //
                "  \"imageUrl\": \"" + imgUrl + "\",\n" + //
                "  \"description\": \"" + testemonial + "\",\n" + //
                "  \"ra\": \"" + ra + "\"\n" + //
                "}";
        
        try (OutputStream os = connection.getOutputStream()){
            byte[] input = json.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);

            return connection.getResponseCode() + "";
        } catch (IOException e) {
            throw e;
        }
    }
}

