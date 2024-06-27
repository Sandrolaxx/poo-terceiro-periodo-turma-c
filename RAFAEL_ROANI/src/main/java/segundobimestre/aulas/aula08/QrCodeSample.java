package segundobimestre.aulas.aula08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class QrCodeSample {
    public static void main(String[] args) {
        System.out.println(genQRCode( 12D));
    }

    public static String genQRCode(Double amount) {
        try {
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/pix/v1/brcode/static");
            String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJKemFvUFFQTy9JckZTTU0vMC85N0ZBRVN2WjIvUmIwV3FyYWtNS3ZEb0djOFJFblI0czREcDl2aS85blRQSkV0YU5obEltY1MxQmpIWGpERzZSYXhRSDlTUHFwdng3cW9udDNxUHpnN1BPSWJlcVRreXEyNU9YdmVGY0RGaU1BWEdneStUMzdLb083TmZYR2N0RGxNbkpFbmIxVCtQWFduaVFsVW01a0JpcWt3SWhEaTZsdHdGdmVYbnVvUEQxREQ0THlsUGhmMzNXdlpUbEZSN1BQb05KcERZOThIQ1RpTWxyT2NLMjRLZDlpK1pOQThUdk9VVFVhY2MxVmVxclloSWdvQllucWJpWEhncGpzTi9HZjY4Q2tSYTBFMjQxdXI5UlNMS2NrdkJvei95M1pPMzUweFllb1lvSmRZSVo1QXF3Q1JRUXd6R1BXMEVLY3Q0TktpUUh6NFdqa0RyYjd5YlY3ZS9xNVk5aFlnUWFFdkppb2RKRXczNUlZb2I1eG13YVJYWm9PRHNGQTVBZ3VUVlR0TmZFejNuY2svaE1vVTNKVnYwOFVtVlI5UjlFK2Fzb3pxMk5rcE1aZ0Y5SEl4TjgwRTMwNE9wc0E1UnRsRUR5eDBRU1JVQUFOTHorZE1YemIxKzNDbFZ6c3dxT3FFckpPMGpCYXdZNFJpYm56Sk5tZEIydVdiSm8wenZSR1E1S2oveS9aSDYzT3BGalo5V1ZRMDVqZldTd2hjTG1UQ1YvKzhGQ1BLQzBTckNSVXRMVFAwdlJ2ZU1FVTZxemtJT3BodG1nPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiYmU2ODVhY2VlNDQ1NDRjZDg3YzUiLCJleHAiOjE3MTkxODEzNDksImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.SqN9QkI2pHglZXZceGvZGYxlsgUm4RYq6ewpAYfpSAI";

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // Dados do json
            String json = "{\n" + //
                    "  \"key\": \"testepix@celcoin.com.br\",\n" + //
                    "  \"amount\":" + amount + ",\n" + //
                    "  \"merchant\": {\n" + //
                    "    \"postalCode\": \"01201005\",\n" + //
                    "    \"city\": \"Barueri\",\n" + //
                    "    \"merchantCategoryCode\": 0,\n" + //
                    "    \"name\": \"Celcoin\"\n" + //
                    "  }\n" + //
                    "}";

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", token);
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
