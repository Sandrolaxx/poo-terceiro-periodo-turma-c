package LUIZ_COLMAN.segundob.prova;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.io.OutputStream;

public class ApiService {
    private static final String BASE_URL = "https://poo-exam.vercel.app/api";

    public static String getStudents() throws Exception {
        @SuppressWarnings("deprecation")
        URL url = new URL(BASE_URL + "/students");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine + "\n"); // A response ta retornando em uma linha só.
            }
            in.close();
            return response.toString();
        } else {
            throw new Exception("Erro na comunicação com a API: " + responseCode);
        }
    }

    public static String createTestimonial(String imageUrl, String description, String ra) throws Exception {
        @SuppressWarnings("deprecation")
        URL apiUrl = new URL(BASE_URL + "/testimonial");
        System.out.println("Conectando a URL: " + apiUrl.toString());
        HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        String jsonInputString = "{\n" +
        "  \"imageUrl\": \"" + imageUrl + "\",\n" +
        "  \"description\": \"" + description + "\",\n" +
        "  \"ra\": \"" + ra + "\"\n" +
        "}";

        String expectedResponse = "{\"imageUrl\": \"https://conteudo.imguol.com.br/c/entretenimento/9b/2023/05/22/velozes-e-furiosos-e-comandado-por-vin-diesel-1684772251564_v2_4x3.jpg\", \"description\": \"testeee\", \"ra\": \"10950\"}";
        if (jsonInputString.equals(expectedResponse)) {
            System.out.println("A resposta bate com o exemplo da API.");
        } else {
            System.out.println("A resposta não bate com o exemplo da API.");
            System.out.println("Esperado: " + expectedResponse);
            System.out.println("Recebido: " + jsonInputString);
        }

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        } catch (Exception e) {
            System.out.println("Erro ao enviar a requisição: " + e.getMessage());
        }
        try {
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == 201) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            } else {
                System.out.println("Erro na comunicação com a API: Código de resposta = " + responseCode);
                throw new Exception("Erro na comunicação com a API: " + responseCode);
            }
        } catch (Exception e) {
            System.out.println("Erro ao processar a resposta da API: " + e.getMessage());
            throw e;
        }
    }
}
