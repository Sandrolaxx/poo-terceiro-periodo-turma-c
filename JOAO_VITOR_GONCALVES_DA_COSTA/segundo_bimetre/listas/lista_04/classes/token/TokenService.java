package listas.lista_04.classes.token;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenService {

  public static String generateToken() {
    try {
      URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/token");
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      connection.setRequestMethod("POST");
      connection.setRequestProperty("accept", "application/json");
      connection.setRequestProperty("content-type", "multipart/form-data; boundary=---011000010111000001101001");
      connection.setDoOutput(true);

      String boundary = "---011000010111000001101001";
      String body = "--" + boundary + "\r\n" +
          "Content-Disposition: form-data; name=\"client_id\"\r\n\r\n" +
          "41b44ab9a56440.teste.celcoinapi.v5\r\n" +
          "--" + boundary + "\r\n" +
          "Content-Disposition: form-data; name=\"grant_type\"\r\n\r\n" +
          "client_credentials\r\n" +
          "--" + boundary + "\r\n" +
          "Content-Disposition: form-data; name=\"client_secret\"\r\n\r\n" +
          "e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3\r\n" +
          "--" + boundary + "--";

      try (OutputStream os = connection.getOutputStream()) {
        byte[] input = body.getBytes(StandardCharsets.UTF_8);
        os.write(input, 0, input.length);
      }

      int statusCode = connection.getResponseCode();

      if (statusCode != 200) {
        try (Scanner scanner = new Scanner(connection.getErrorStream(), "UTF-8")) {
          String errorResponseBody = scanner.useDelimiter("\\A").next();
          System.out.println("Error Response: " + errorResponseBody);
        }
        System.out.println("Request failed: " + statusCode + " " + connection.getResponseMessage());
      }

      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      StringBuilder response = new StringBuilder();
      String line;

      while ((line = reader.readLine()) != null) {
        response.append(line.trim());
      }

      reader.close();
      return response.toString();
    } catch (Exception e) {
      return null;
    }
  }

  public static String getAccessToken() {
    String jsonData = TokenService.generateToken();

    Pattern pattern = Pattern.compile("\"access_token\"\\s*:\\s*\"([^\"]+)\"");
    Matcher matcher = pattern.matcher(jsonData);

    if (matcher.find()) {
      return matcher.group(1);
    } else {
      return null;
    }
  }
}
