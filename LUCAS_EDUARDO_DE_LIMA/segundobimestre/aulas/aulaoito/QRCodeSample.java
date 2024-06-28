package segundobimestre.aulas.aulaoito;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class QRCodeSample {
     public static void main(String[] args) {
      System.out.println(genQRCode(null, null));  
     }
       public static String genQRCode(String token, Double amount) {
        try {
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/pix/v1/brcode/static");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Dados do json
            String json = "{\r\n" + //
                                "  \"key\": \"testepix@celcoin.com.br\",\r\n" + //
                                "  \"amount\": 10.55,\r\n" + //
                                "  \"merchant\": {\r\n" + //
                                "    \"postalCode\": \"01201005\",\r\n" + //
                                "    \"city\": \"Barueri\",\r\n" + //
                                "    \"merchantCategoryCode\": 0,\r\n" + //
                                "    \"name\": \"Celcoin\"\r\n" + //
                                "  }\r\n" + //
                                "}";

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiIybjAvaTNMUzRZLzRQYWs4bDBsMUR5QVVVQnc4emVGZ0tMcEQ0Q2FoQm5UWXlOd0hSa1NDbmoreGxEcDV1K2VkTFdUVkFqNnFIZWw3VVdHTWRIVTM5UXNuLy9qZWVEVlB2VEV4MHVxZ2RSQlJKdUlNcnRpZXl0YkNvbXFxTEFnelB6eFNiMUQ1R2gyNktOTEl5WDZXNVh6YjZEdks2bmRTUXJsejBUQlExU2JRcGhLYVFweEZaaGRPcnVxVTlQZXpQZ2lpcm9XaDlFc2o0Zk1sYVlFbmVZYk8xNnR4dWtBVVBnM01vVlFWdUY0OVhnWVFtYVR3dGpMcE5CbG1kV2FYZVE1RGJmaTBSNXhlQWI4Y1MvRE5UODhDc3BzQlFGUlN2Uk9weUNEbU5yeGtlM2dzYUhoSkFXcWpWMzRJaUlCSHlDQlBscHNLaHZiOUJOdm5FRks4WDBCakRibjFnMzAxQTU4a2haRlF0SlNIMERGMGJleEZSNEpPeTlwTHJtVE5vWThveUdvaXYwbHJiMUgxQm9GYWJZR0JudnNkMHFzbUhBSXU4YmR2eHlKZjdwYmhRTC9FaUU5bmRpUW80clhWVk9jaTQ4ZXJ6MDZ6ZDVRQXQ4aktuVWZOeWd5c05yeGxsejk2RTk1K3gwK2p4Y0V1V0lTc3dRV0lLNG10QWtvcGV0dUdZZVdMYlFQVWZKSjNRMVlkc2FudnU0SXZKaHVtMVdwbnhpaEFEK3FSdzd6Q3N4a3hOZlBRV3prRy9NNytMVWJNeitJTVpIT0g2REx6YWkrc0V3PT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiMGU4NTFmOTQ4MTVlNGY2MTkwNDEiLCJleHAiOjE3MTg5MzE3NDksImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.d1oQRRXXz8BB3Xox58oVENYVQTUCQRqDQmBRJuudKOw");
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
