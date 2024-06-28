package lista05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class HttpRequest {

  private static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJEWFg2NmNuTkllMXNIdWIyaTRwd0I5TTh5WlpPTlVabUxMYkV2aEExMXdhdWZ0YVIyRmpFR2pFTG9idTN2WjlUalk2ZjdVdjJLNVkrckpYd1NsOUdTWmVwWWFXamZQNmF3NGhSanFmY2Juc1NjS085U05MRmpyTVNDekRDL21QeVlBazZMSjQ1MTVKNWVOUnVSKys1cjgzQW1aQysrckZ5OEc3b3I4WDIwUTU3OHRPeDY2eXNkZzVQRjFhWlVwc3AwQWdzL09mQlVyN3oxWXk2WklqUUZKVlJpNGNUZURqT2JWK1hsaTlEZGRHRzc2T1k4VUVZYVY4V0JjKzVXYVRQNGhjNTcyNmU4K01YVlo0Smhlb2w3WU1NUnR5ZnZRUDlpL2RtZVlxU011SGtxVitoZFJRWWVjcUk5ckQ4R1JzeDkxelFJOXlHUzVsN2x4SjY1M1YvWXdsTWdaRHN2dnlMdDBITkdpcytXVVdFNDgrMjU2L1YwaGtBcm1sRVE1NnlXeEFRQkdQK2VRQUJpRHptMytwcXJ6L0g5b2RDaU9FM0pMUksxSmxuTXZaSXI1YkhicW9KRGFpMWlRQXlQQTRaRXprRWp1K0tvMUtHTTZ6dlFZQWcrdTF5cTg0a1JsczFRcnk4ZlM1TUk5eEg1dm9GY0QrOGVOcDNHbFBwaVRIVDFmZzgxQzg2alZ3SC9Ud0lYeDJBbGVCWDhqNmdoOXEvcEZyYkxiYm5WQUpnK0Fhbm9namt0R2VZeHVmUlVIUzdvbkJxRkQ0ZWF1djBOVnR3dkxiNDhRPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiNWVkNmQ3NTQxZTM1NGJiNzg1ODciLCJleHAiOjE3MTkwMDEwNzUsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.ss9lg7s_G4-M9yOS9FedVUeTq7VIRuEGEUkB1gRvh6M";

  public static void main(String[] args) {
    List<String> options = new ArrayList<>(List.of(
      "1. Listar convênios",
      "2. Consulta de boletos"
    ));

    String response = (String) JOptionPane.showInputDialog(
      null, 
      "Escolha uma opção",
      "Opções",
      JOptionPane.QUESTION_MESSAGE,
      null,
      options.toArray(),
      options.toArray()[0]
    );

    switch (response) {
      case "1. Listar convênios":
        System.out.println(listagemDeConvenios());
        break;
      case "2. Consulta de boletos":
        System.out.println(consultaDeBoletos());
        break;
      default:
        JOptionPane.showMessageDialog(null, "Opção inválida!", "ERRO", JOptionPane.ERROR_MESSAGE);
        break;
    }
  }

  public static String listagemDeConvenios() {
    try {

      URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions");

      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      connection.setRequestMethod("GET");
      connection.setRequestProperty("Authorization", "bearer " + token);

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

  public static String consultaDeBoletos() {
    try {
      
      String linhaDigitavel = JOptionPane.showInputDialog("Digite a linha digitável do boleto");

      URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");

      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      String json = "{\n" + //
                "  \"barCode\": {\n" + //
                "    \"type\": 0,\n" + //
                "    \"digitable\":" + linhaDigitavel + "\n" + //
                "  }\n" + //
                "}";
      
      connection.setRequestMethod("POST");
      connection.setRequestProperty("Content-Type", "application/json");
      connection.setRequestProperty("Authorization", "bearer " + token);
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
