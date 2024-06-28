package ISABELA_VITORIA.SegundoBim.prova;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.swing.JOptionPane;

public class RegistraTestemunho {
  public static String sendRequest() {
    try {

      URL url = new URL("https://poo-exam.vercel.app/api/testimonial");

      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      String imageUrl = JOptionPane.showInputDialog("Informe a URL da imagem");
      String description = JOptionPane.showInputDialog("Informe a descrição");
      String ra = JOptionPane.showInputDialog("Informe o RA");

      String json = "{\r\n" + //
          "  \"imageUrl\":\"" + imageUrl + "\",\r\n" + //
          "  \"description\":\"" + description + "\",\r\n" + //
          "  \"ra\":\"" + ra + "\"\r\n" + //
          "}";

      connection.setRequestMethod("POST");
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

      return null;
  }
  }
}