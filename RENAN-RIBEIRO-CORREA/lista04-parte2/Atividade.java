import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.io.OutputStream;
import java.net.URL;
import javax.swing.JOptionPane;

public class Atividade {
  private static URL url;
  private static String tokenDeAcesso = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJqb20rRHplNS81MnB1aW94dG4wT3JkR2t3ZTBWKzZyNHlibWs2TnoyZjFKdHJ6TmtkaXZtR2pPQXFaNmcreUNLc0d3NDRZZm02bWdpUmptUkRPNm9jUDdOZldYbEY2MlBWcUh3MmhSMUZUZ0hHb2s5YU1XdUYwb1ZaTUV1WGIxbE95bm5SaElVcWtSVTdIQkNzV0VQVnk2M0plR1VFM1FBdU1DWHFDOXptTkl5SmU1ZmgzYUoxQUhKUC9KYjA4L1RNNGhMNGh2bEF6c0h1TGhPa2pEWkdxMUlRY0VCL1NvUklXTGQ4SHMzVEU4a2V0elJRVDBFMXJRWFhaK29TU2ZIREFwYzRpVVBSaW04YTJxSFNHU2tVNHowZ21HOFhTcWYxdW81OVozaU54RENpWFNNcmcwaGNpbE12eWhMOFZ0MFFmL0ljaHIyVTJmNGlBais1RGVJeUxJRUc0bzFtNHhQTDdGS1M5N2xETzV5RVhwRW9tQ3prQjRGK0RkRnVRMGV1Y3BtSy9CeU4zTUJvSi9wSm95SEtrd3RmdXJPNFZrYVhDb3RQRGJKR0tFd2RNWnhoQ1VDTC84THM2L2MxT3hNb0hTMEdRNGY0NFZjbUNlUTNkQ1U0YXNlajE2SkFqUFQwdjRwMU5XcVlpREVCTEFSN0N5UUNDdzBQNjUrVE9VNWo1Nm5na3RpeXQwYVJmbkh2VS81UTBKaktZdXU3ZmNvVkp1MmZpQ1ZWMGJYaFlHNzliN3VoSllkRGZzME94bmxpSUNiUzZFZ2J3VVZnclIxWENxQUl3PT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiYjkyNTQwOTBkMGYwNDA2M2IxMTYiLCJleHAiOjE3MTk0MjMzNjgsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.DHi_eb9TOAeFUxh3kmWFPJvrE7b5e-6feqpu8AoR-mg";
  public static void main(String[] args) {


    String[] opcoes = { "listar convenios", "consultar boletos" };


    String escolhaOpcao = (String) JOptionPane.showInputDialog(null,
        "escolha uma opção:",
        null,
        JOptionPane.QUESTION_MESSAGE,
        null,
        opcoes,
        opcoes[0]);
    

    switch (escolhaOpcao) {
      case "listar convenios":
        try {
          url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions");
          HttpURLConnection connection = (HttpURLConnection) url.openConnection();
          connection.setRequestMethod("GET");
          connection.setRequestProperty("Authorization", "bearer " + tokenDeAcesso);

          BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
          StringBuilder res1 = new StringBuilder();
          String line;

          while ((line = reader.readLine()) != null) {
            res1.append(line);
          }

          reader.close();
          connection.disconnect();
          System.out.println(res1.toString());
        } catch (Exception e) {
          e.printStackTrace();
        }
        break;

      case "consultar boletos":
        try {
          url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");

          String linhaDigitavelBoleto = JOptionPane.showInputDialog("Escreva a linha digitável do boleto");
          HttpURLConnection connection = (HttpURLConnection) url.openConnection();

          String json = "{\n" + //
              "  \"barCode\": {\n" + //
              "    \"type\": 0,\n" + //
              "    \"digitable\":" + linhaDigitavelBoleto + "\n" + //
              "  }\n" + //
              "}";

          connection.setRequestMethod("POST");
          connection.setRequestProperty("Content-Type", "application/json");
          connection.setRequestProperty("Authorization", "bearer " + tokenDeAcesso);
          connection.setDoOutput(true);

          try (OutputStream os = connection.getOutputStream()) {
            byte[] input = json.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
          }

          BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
          StringBuilder res2 = new StringBuilder();
          String line;

          while ((line = reader.readLine()) != null) {
            res2.append(line);
          }

          reader.close();
          connection.disconnect();
          System.out.println(res2.toString());
        } catch (Exception e) {
          e.printStackTrace();
        }
        break;
    }
  }
}