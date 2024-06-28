package listas.lista_04.classes.ticket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import listas.lista_04.classes.token.TokenService;

public class BillCheck {

  private static String token;

  public static String checkBill(String barCode) {
    try {
      if (getToken() == null) {
        setToken(TokenService.getAccessToken());
      }

      URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");

      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      connection.setRequestMethod("POST");
      connection.setRequestProperty("accept", "application/json");
      connection.setRequestProperty("content-type", "application/json");
      connection.setRequestProperty("authorization", "Bearer " + getToken());
      connection.setDoOutput(true);

      String body = "{\"barCode\":{\"digitable\":\"" + barCode + "\"}}";

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
        response.append(line);
      }

      reader.close();

      connection.disconnect();
      return response.toString();
    } catch (Exception e) {
      return null;
    }
  }

  public static void setToken(String token) {
    BillCheck.token = token;
  }

  public static String getToken() {
    return BillCheck.token;
  }

}
