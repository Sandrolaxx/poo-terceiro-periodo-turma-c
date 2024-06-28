package segundob.prova;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class CriarTestemunhoAluno {
    public static String getJsonData(String urlAluno, String raAluno, String testemunhoAluno) {
        try {
            URL url = new URL("https://poo-exam.vercel.app/api/testimonial");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            String json = "{\n" +
                    "  \"imageUrl\": \"" + urlAluno + "\",\n" +
                    "  \"description\": \"" + testemunhoAluno + "\",\n" +
                    "  \"ra\": \"" + raAluno + "\"\n" +
                    "}";

            connection.setRequestMethod("POST");
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
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

            connection.disconnect();

            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
