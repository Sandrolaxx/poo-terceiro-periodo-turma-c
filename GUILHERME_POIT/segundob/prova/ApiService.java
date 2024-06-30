package GUILHERME_POIT.segundob.prova;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ApiService {
    private static final String BASE_URL = "https://poo-exam.vercel.app/api";

    public String getStudents() throws Exception {
        URL url = new URL(BASE_URL + "/students");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        return response.toString();
    }

    public String createTestimonial(String imageUrl, String text, String ra) throws Exception {
            URL url = new URL(BASE_URL + "/testimonial");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();


            String json = "{\n" +
                    " \"imageUrl\": \" " + imageUrl + "\",\n" +
                    " \"description\": \"" + text + "\",\n" +
                    " \"ra\": \"" + ra + "\"\n" +
                    "}";
        System.out.println(json);


            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    responseCode == HttpURLConnection.HTTP_CREATED ? connection.getInputStream() : connection.getErrorStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();


            if (responseCode != HttpURLConnection.HTTP_CREATED) {
                throw new Exception("Erro ao criar testemunho: " + response.toString());
            }

            return "Testemunho criado com sucesso!";

        }
    }