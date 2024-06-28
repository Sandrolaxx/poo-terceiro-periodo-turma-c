import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIManager {

    private static final String BASE_URL = "https://poo-exam.vercel.app/api";

    public static String listarAlunos() throws IOException {
        URL url = new URL(BASE_URL + "/students");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {
            throw new IOException("Erro na requisição: " + responseCode);
        }
    }

    public static String criarTestemunho(String urlFoto, String ra, String texto) throws IOException {
        URL url = new URL(BASE_URL + "/testimonial");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");

        String jsonInputString = "{\"photoUrl\": \"" + urlFoto + "\", \"ra\": \"" + ra + "\", \"testimonial\": \"" + texto + "\"}";

        con.setDoOutput(true);
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {
            throw new IOException("Erro na requisição: " + responseCode);
        }
    }
}

