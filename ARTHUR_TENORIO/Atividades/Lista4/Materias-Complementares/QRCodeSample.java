package Atividades.Lista4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class QRCodeSample {
    public static void main(String[] args) {
        System.out.println(genQRCode(null, null));
    }
    
    public static String genQRCode(String token, Double amount) {
    try {
        @SuppressWarnings("deprecation")
        URL url = new URL("https://sandbox.openfinance.celcoin.dev/pix/v1/brcode/static");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Dados do json
        String json = "{\r\n" + //
                        "\t\"Key\": \"testepix@celcoin.com.br\",\r\n" + //
                        "\t\"amount\": 2.55,\r\n" + //
                        "\t\"merchant\": {\r\n" + //
                        "\t\t\"postalCode\": \"01201005\",\r\n" + //
                        "\t\t\"city\": \"Barueri\",\r\n" + //
                        "\t\t\"merchantCategoryCode\": 0,\r\n" + //
                        "\t\t\"name\": \"Celcoin\"\r\n" + //
                        "\t}\r\n" + //
                        "}";

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJZV3FKRDNJZG1rNldpemowOHEydEN3cllQQk11TWFVNEgraGM2R0NGZFVvenhHUEFreUlRQkJVejVlUGZVQVozdWw4UEgybXJLaTlKQ3pLVGo2TzJtV1U1M1BUQ2FYdDRKZXFYKzRwNHNTMkw4T0ZFWW9FZzNsYTlQWjRtU29yK0lFTVNSaXZCT1FzZmd1UExldXdkUTlaUEZxQTBOdUhuLzg3VFBabUJDdWpnZFc4OW9wOHVCVXdlVTVIMXVFWTFzdVIyR1hla0NMdHhhVmxMNFZiaVFoSVUxSEhuRmZzcUhqZWdJNUV1Mm1Ldkg2VXQ1SDREM1VYNktBSElJZmxxcEtvendPdGFRVUV0ZkdRMEh0SG1hL0RISDFZU0IwV3ZHaTNORXZ3MitmLzNWSStRMng5ZjY1UmZmK3ZLcTEwdUJ0V1FRSzJWRjVTZUlmaTJ5RlpmWmJoa1crOWU5eG10OEYwZVBoZFpOeERIYVBVY3h5R1VLMGtmR3hWVHlKUW90bjlFUG9OaUpXZVZKNWdYR0NZVlZxeUUxclc2ODV4U2JUbHd4YjRFOHY0TFFGbVYrRzlyQmdmaGVJTTZoZWczUzhzVno4cTE4VHhmazdrZEJnMnF3bHcrcVhMVTdKTUdrM2Z5bkYwQmlDQnlFN0FXVU5NTlRrVGNpQ0dwc2Y4YklIY1YrdVFYR2c1Rjc5WjJzZnBSQklCNGtObEJndDVnK1QrZHZwNkkxYlB3c2RteTZoMEM4ejR3V0ZsL3dzRFd2SzlXVm1SYloxaEdyUE1pSUxvdXpRPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiZjY4YjYxZWE2MjI4NDJiNTgzMjciLCJleHAiOjE3MTkxNjc3NDMsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.8PKY7_ptMu9eFCuSb9OR6Fl2pBsmgXNLZS-oyI-X_JA");
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