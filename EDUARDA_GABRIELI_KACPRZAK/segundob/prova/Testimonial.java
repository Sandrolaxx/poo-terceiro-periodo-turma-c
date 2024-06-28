package pooprova;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Testimonial {
    public static void criarTestemunho() {
        try {

            URL url = new URL("https://poo-exam.vercel.app/api/testimonial");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String jsonInfo = "{\n" +
                    " \"imageUrl\": \"https://lh3.googleusercontent.com/a/ACg8ocK3FHqgthOVoHAy9dHaSaepq2Vr7jDM4F_46IYH6E_Eum9So_w=s288-c-no\",\n" +
                    "  \"description\": \"#quintou\",\n" +
                    "  \"ra\": \"11129\"\n" +
                    "}";

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInfo.getBytes(StandardCharsets.UTF_8);
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

            String message = response.toString().replace("},", "},\n");

            JFrame frame = new JFrame("Testemunho");
            JOptionPane.showMessageDialog(frame, message, "Testimonial", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo deu errado.");
        }
    }
}
