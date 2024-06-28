package requisicoes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TokenSample {
  public static void main(String[] args) {
    try {
      getToken();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static String getToken() {
    try {
      // URL alvo da request
      URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/token");

      // criando conexão HTTP para a URL especificada
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      // Dados do formulário
      String urlParameters = "client_id="
          + URLEncoder.encode("41b44ab9a56440.teste.celcoinapi.v5", StandardCharsets.UTF_8.name())
          + "&grant_type=" + URLEncoder.encode("client_credentials", StandardCharsets.UTF_8.name())
          + "&client_secret=" + URLEncoder.encode("e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3",
              StandardCharsets.UTF_8.name());

      // Configurar método e propriedades da conexão
      connection.setRequestMethod("POST");
      connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      connection.setRequestProperty("Content-Length", Integer.toString(urlParameters.length()));
      connection.setDoOutput(true);

      try (OutputStream os = connection.getOutputStream()) {
        byte[] input = urlParameters.getBytes(StandardCharsets.UTF_8);
        os.write(input, 0, input.length);
      }

      // lendo response
      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      StringBuilder response = new StringBuilder();
      String line;

      while ((line = reader.readLine()) != null) {
        response.append(line);
      }

      reader.close();

      // fechando a conexão
      connection.disconnect();

      return response.toString();
    } catch (Exception e) {
      e.printStackTrace();

      return null;
    }
  }
}