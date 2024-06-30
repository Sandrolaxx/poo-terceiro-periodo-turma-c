package JOAO_VITOR_GONCALVES_DA_COSTA.segundo_bimetre.prova.classes.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.swing.JOptionPane;

public class Http {
  private static String baseUrl = "https://poo-exam.vercel.app/api/";

  public static String getStudents() {
    try {
      URL url = new URL(getBaseUrl().concat("students"));

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
      e.printStackTrace();
      JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro ao listar alunos",
          JOptionPane.ERROR_MESSAGE);
      return null;
    }
  }

  public static String postTestimonial(String imageUrl, String description, String ra) {
    try {
      URL url = new URL(getBaseUrl().concat("testimonial"));

      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      connection.setRequestMethod("POST");
      connection.setRequestProperty("Content-Type", "application/json");
      connection.setDoOutput(true);

      String requestJson = "{\"imageUrl\":\"" + imageUrl + "\",\"description\":\"" + description + "\",\"ra\":\"" + ra
          + "\"}";

      try (OutputStream os = connection.getOutputStream()) {
        byte[] input = requestJson.getBytes(StandardCharsets.UTF_8);
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
      JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro ao listar alunos",
          JOptionPane.ERROR_MESSAGE);
      return null;
    }
  }

  public static String getBaseUrl() {
    return baseUrl;
  }
}
