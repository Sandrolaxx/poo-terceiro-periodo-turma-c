import java.nio.charset.StandardCharsets;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import javax.swing.JOptionPane;
import java.net.URL;

public class Main {
  public static void main(String[] args) {
    URL url;

    String respostaUsuario = (String) JOptionPane.showInputDialog(
        null,
        "Escolha uma opção",
        "Opções",
        JOptionPane.QUESTION_MESSAGE,
        null,
        new String[] { "1. Listar convênios", "2. Consulta de boletos" },
        "1. Listar convênios");

    switch (respostaUsuario) {

      // Atividade 1
      case "1. Listar convênios":
        try {
          url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions");

          HttpURLConnection connection = (HttpURLConnection) url.openConnection();

          connection.setRequestMethod("GET");
          connection.setRequestProperty("Authorization", "bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJQUXpDT0xjTk16UXZValphUUhYMnlYUVhtMXBxNzd3Qk8vbzZoa1gxaS90cDVWdzNCV1dCb1ZDRVJUTHZlWEo5SUtXeStMOSt4Mk1KSFlPeldRYXBValR2YWNKWkNUWnRaci9nTW1aRDkvV1crVGlYeVRpZUpYOWE4SE1aRDUxaVRtbk5yRnA1bEphQjRFK2V3aTRWbjJsQi9Wb1VTZmkvbys0anFtUWhSWGt4MC9qQUladW9kWUFCZE5hSkhNSzVBZUpkMlNpUCtYb2Z6d1lrWlFYdnQwbXJ6eXZSTXdMNXBQSjU0cExsc2tnQWlXNStoSG9WUmg1T3FYdVdJZ3pJeWJZNlpMb2VKbzFVRVRTZFRscUN3NE9oNVpTRExBYXRRNUkzNExmNi9rSjk2MlJHSjNlRCtWSmU2K29NRWFpb3NySGJGZWRnOFpTM2tLbkZxTnN0NkQxU2owZFVoUWpYQkdQSjZaRWR2YnFmdGQ2SWpwb25TL082OFRXV2xTbnlQd05kSjFvL2pGcFdDcmxHUk5hdXEwUlo0QXpkVnpsR1dyMGJBSVdmRXB4V1hpdzNJOTQ4TitQUGxHNGpHampFcDc3Z2VkVUszbkdaQTVNYVZxcFlXMUt0UnA4YUkvSHM3MUd4bWFwWkkxWnNGYWR5cVVyeEhCVHF3Zjdabll4blc0VkY0MUczVklkYUU0VWZRU1Nqci9sS0VTVVRkN2VpTXZTaDRJNDUrYXYxaCszMTh1MG1BdDhRdkRMakNLR0VQSm9TcDlRemNoZ2RmMFk1L2N1MHJ3PT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiMzM2ZDZmODY0MDU4NDg1NDkwYWQiLCJleHAiOjE3MTkyNzAzODEsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.eY7zzaxfjanUtXedkAXoFB9dVvFuhFQUR3_591IPyOo");

          BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
          StringBuilder respostaGet = new StringBuilder();
          String line;

          while ((line = reader.readLine()) != null) {
            respostaGet.append(line);
          }

          reader.close();
          connection.disconnect();
          System.out.println(respostaGet.toString());

        } catch (Exception e) {
          e.printStackTrace();
          break;
        }
        break;

      // Atividade 2
      case "2. Consulta de boletos":
        try {
          url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");

          String linhaDigitavel = JOptionPane.showInputDialog("Cole aqui a linha digitável do seu boleto");
          HttpURLConnection connection = (HttpURLConnection) url.openConnection();

          String json = "{\n" + //
              "  \"barCode\": {\n" + //
              "    \"type\": 0,\n" + //
              "    \"digitable\":" + linhaDigitavel + "\n" + //
              "  }\n" + //
              "}";

          connection.setRequestMethod("POST");
          connection.setRequestProperty("Content-Type", "application/json");
          connection.setRequestProperty("Authorization", "bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJQUXpDT0xjTk16UXZValphUUhYMnlYUVhtMXBxNzd3Qk8vbzZoa1gxaS90cDVWdzNCV1dCb1ZDRVJUTHZlWEo5SUtXeStMOSt4Mk1KSFlPeldRYXBValR2YWNKWkNUWnRaci9nTW1aRDkvV1crVGlYeVRpZUpYOWE4SE1aRDUxaVRtbk5yRnA1bEphQjRFK2V3aTRWbjJsQi9Wb1VTZmkvbys0anFtUWhSWGt4MC9qQUladW9kWUFCZE5hSkhNSzVBZUpkMlNpUCtYb2Z6d1lrWlFYdnQwbXJ6eXZSTXdMNXBQSjU0cExsc2tnQWlXNStoSG9WUmg1T3FYdVdJZ3pJeWJZNlpMb2VKbzFVRVRTZFRscUN3NE9oNVpTRExBYXRRNUkzNExmNi9rSjk2MlJHSjNlRCtWSmU2K29NRWFpb3NySGJGZWRnOFpTM2tLbkZxTnN0NkQxU2owZFVoUWpYQkdQSjZaRWR2YnFmdGQ2SWpwb25TL082OFRXV2xTbnlQd05kSjFvL2pGcFdDcmxHUk5hdXEwUlo0QXpkVnpsR1dyMGJBSVdmRXB4V1hpdzNJOTQ4TitQUGxHNGpHampFcDc3Z2VkVUszbkdaQTVNYVZxcFlXMUt0UnA4YUkvSHM3MUd4bWFwWkkxWnNGYWR5cVVyeEhCVHF3Zjdabll4blc0VkY0MUczVklkYUU0VWZRU1Nqci9sS0VTVVRkN2VpTXZTaDRJNDUrYXYxaCszMTh1MG1BdDhRdkRMakNLR0VQSm9TcDlRemNoZ2RmMFk1L2N1MHJ3PT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiMzM2ZDZmODY0MDU4NDg1NDkwYWQiLCJleHAiOjE3MTkyNzAzODEsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.eY7zzaxfjanUtXedkAXoFB9dVvFuhFQUR3_591IPyOo");
          connection.setDoOutput(true);

          try (OutputStream os = connection.getOutputStream()) {
            byte[] input = json.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
          }

          BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
          StringBuilder respostaPost = new StringBuilder();
          String line;

          while ((line = reader.readLine()) != null) {
            respostaPost.append(line);
          }

          reader.close();
          connection.disconnect();

          System.out.println(respostaPost.toString());

        } catch (Exception e) {
          e.printStackTrace();
          break;
        }
        break;

      default:
        System.out.println("Opção inválida");
        break;
    }
  }
}