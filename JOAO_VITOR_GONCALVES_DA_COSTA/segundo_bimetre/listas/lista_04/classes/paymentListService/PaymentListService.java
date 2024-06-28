package listas.lista_04.classes.paymentListService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import listas.lista_04.classes.token.TokenService;

public class PaymentListService {

  private static String token;

  public static String listPaymentAgreements() {
    try {
      if (getToken() == null) {
        setToken(TokenService.getAccessToken());
      }

      URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions");

      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      connection.setRequestMethod("GET");
      connection.setRequestProperty("accept", "application/json");
      connection.setRequestProperty("authorization", "Bearer " + getToken());
      connection.setDoOutput(true);

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

  public static String getToken() {
    return token;
  }

  public static void setToken(String token) {
    PaymentListService.token = token;
  }
}
