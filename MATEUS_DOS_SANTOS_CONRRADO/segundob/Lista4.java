import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.net.URL;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import javax.swing.JOptionPane;
import java.io.InputStreamReader;

public class Lista4 {

  public static void main(String[] args) {

    String opcaoEscolhida = (String) JOptionPane.showInputDialog(
      null,
        "Selecione uma das opções:",
        null,
        JOptionPane.QUESTION_MESSAGE,
        null,
        new String[] { "Listar Convenios", "Consultar Boletos", "Sair" },
        "Listar Convenios");

    switch (opcaoEscolhida) {

      case "Listar Convenios":
        listagemDeConvenios();
        break;

      case "Consultar Boletos":
        consultaDeBoletos();
        break;

      case "Sair":
        System.out.println("Saindo...");
        System.exit(0);
        break;

      default:
        break;
        
    }

  }

  public static String listagemDeConvenios() {

    try {

      URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions");

      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.setRequestProperty("Authorization",
          "bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJxY1U2ZDJlbUZHcmk5QXVwaHFtSC93ZlByTDNsOHZRUVpJSGJIdEhwWDVGbWJ6ZDBtZjJjNUNMQU03Sy8vdFFWdXFMekw3NFdqVTNObXR5Ump2OUNjUUhRSWdDWFFxWVpjVkg5SjJkM0xwUnRjNEwvT3dpV1Rad1djcU5CRHcwNkFjZTFrODdPUng3amFFK3dnMEx1QkErdExvOVJFZVlYNFFBYmhmUnkrZENaMnlWQjNhbjVUNUd2dzNUdEk4TU1oUFI4MjZpVGFFTUdqOGJralVqQTJpM21CRGZlVjQyK0M4WHFnVEhZYSsxY0wra3JHVDd2WlZTY2w1RmNHL3VPSGs1MkgzRVZWR0NSSnFFcHFzampIZ1BYd2ZRT3d2Vzg0dHA1S1VCSU54WUFVSDdrL0Vpb0RTYllYa2hVWTNXZS9oTGNEcmUvMWg0SmhsMXdQYzlvcENFcUp3dDZQNUM1dlp2d3hNeFB6OUpqSlNJcXdTSjljQlBSOEEzWUJ2UGZYOWJGRU5xUk45WHJYdkdjMENZZnF6QzdrNnF1bEhKblBsaGJJQlBrRzluRVNqcXkvZnJ3Umxnem5GL1lSNzMwREFUYTF4NVdKdEZwVzJ0eHpLZUYvSWQ4QUFvbFBxQkhjd1hvZ0MzRERIZWFQcURTcEV1d2RvdEdYZ0QvZnYxVnQyMTJKSUk1aVlYaUVXemZuUWlNOFNUcEVmbjVGVXNMN1liek1oaGlaVlhSaUczNnQ2MVdlOGZKS3VHZFpRSjRuNTBtTGx4S2luNGw5dmxScEsxVWlBPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiMTYwMzY4MmIxNDBjNGY4Mzg3OWMiLCJleHAiOjE3MTk1MDEyMTIsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.d4pPS-WxCz_-6r7rMGfhBnchqVLh4P71Ive2TdtG5OY");

      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      StringBuilder response = new StringBuilder();
      String line;

      while ((line = reader.readLine()) != null) {
        response.append(line);
      }

      reader.close();
      connection.disconnect();

      System.out.println(response.toString());

      return response.toString();

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

  }

  public static String consultaDeBoletos() {

    try {

      URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");
      String linhaDigitavel = JOptionPane.showInputDialog("Informe a linha digitável do boleto para consultar: ");

      String json = "{\n" + //
          "  \"barCode\": {\n" + //
          "    \"type\": 0,\n" + //
          "    \"digitable\":" + linhaDigitavel + "\n" + //
          "  }\n" + //
          "}";

      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("POST");
      connection.setRequestProperty("Content-Type", "application/json");
      connection.setRequestProperty("Authorization",
          "bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJxY1U2ZDJlbUZHcmk5QXVwaHFtSC93ZlByTDNsOHZRUVpJSGJIdEhwWDVGbWJ6ZDBtZjJjNUNMQU03Sy8vdFFWdXFMekw3NFdqVTNObXR5Ump2OUNjUUhRSWdDWFFxWVpjVkg5SjJkM0xwUnRjNEwvT3dpV1Rad1djcU5CRHcwNkFjZTFrODdPUng3amFFK3dnMEx1QkErdExvOVJFZVlYNFFBYmhmUnkrZENaMnlWQjNhbjVUNUd2dzNUdEk4TU1oUFI4MjZpVGFFTUdqOGJralVqQTJpM21CRGZlVjQyK0M4WHFnVEhZYSsxY0wra3JHVDd2WlZTY2w1RmNHL3VPSGs1MkgzRVZWR0NSSnFFcHFzampIZ1BYd2ZRT3d2Vzg0dHA1S1VCSU54WUFVSDdrL0Vpb0RTYllYa2hVWTNXZS9oTGNEcmUvMWg0SmhsMXdQYzlvcENFcUp3dDZQNUM1dlp2d3hNeFB6OUpqSlNJcXdTSjljQlBSOEEzWUJ2UGZYOWJGRU5xUk45WHJYdkdjMENZZnF6QzdrNnF1bEhKblBsaGJJQlBrRzluRVNqcXkvZnJ3Umxnem5GL1lSNzMwREFUYTF4NVdKdEZwVzJ0eHpLZUYvSWQ4QUFvbFBxQkhjd1hvZ0MzRERIZWFQcURTcEV1d2RvdEdYZ0QvZnYxVnQyMTJKSUk1aVlYaUVXemZuUWlNOFNUcEVmbjVGVXNMN1liek1oaGlaVlhSaUczNnQ2MVdlOGZKS3VHZFpRSjRuNTBtTGx4S2luNGw5dmxScEsxVWlBPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiMTYwMzY4MmIxNDBjNGY4Mzg3OWMiLCJleHAiOjE3MTk1MDEyMTIsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.d4pPS-WxCz_-6r7rMGfhBnchqVLh4P71Ive2TdtG5OY");
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

      System.out.println(response.toString());

      return response.toString();

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

  }

}