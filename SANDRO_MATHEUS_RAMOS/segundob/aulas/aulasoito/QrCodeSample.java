package segundob.aulas.aulasoito;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class QrCodeSample {

    public static void main(String[] args) {
        System.out.println(genQRCode(null, 2d));
    }

    public static String genQRCode(String token, Double amount) {
        try {
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/pix/v1/brcode/static");

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
            connection.setRequestProperty("Authorization",
                    "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiIwVFVvRDBEY0NVc1F3MklocmNDcWNGU0FPclorUXk2NDNDSjdpT21hRFJzQTVrZTdmK3BKdzlNVFN5TXg2dEgxNi80SjRaN2I0ZTBRdzBUWkpYK1h1V3ZRYVcxM216RTF2eEE1SG1UQnlpbU5pL3Biamw4eS92cmJKRnZzRnJBNVYwOGtDRGZUN2FZZE5JaGx2amxMcFlKcWFFMUxYVmZzR2lkVVBhQ2tYVUZZd09RMExhR2dCSm5nQ2tOK1duRHJUb3Qra2NJSm4wN1cvdk5lREtVRWdvTVBYT2RCbUxPUFB6TkxrMzY3S2ZFdEY4ZFVBZWNHRGFncmxod0tKNkV0cHlWQXdQRUYydVY3TjBTemJHYmYwTys3R2ZkSVJ1VHVZNGZidnpkUmJ4MmZ1MW93TUMvNWhTdmNOWXNoSXNjMkZEd3R2TE1JcXllUzgwTkNNdms4WlVsMGhGd1p0bklCTzNzcGhGVzRCbjJmdFNpNk5NbzJkK1Bqbzh4blF5NVJPQk9tV3I0UDdQbERpQUcvQjVUbU9qLzBMbnFEMHp6d1dxV2VldUNZeDU1YzV6K21tenhpdkptY1NHaDdvWWdPUnFDNkR4TWlWbzN3V20zU3lscHJHd0g2OFIrUDExVWJNSTBCOFJiNFpLelBhNHBweDFjZGJiV1hWVUowcU02YU55ZWt2NzFBZG9ydGlnYXJaZkt6d24wdENPdUQvc2pNOHZOSjAwdmR3Z3hYVGxMbDB1Y3BNVG1IZStNTWlwYWlwelV3aFJVSUNOUHhBbUVtaG0vMVFnPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiMjQwODAwMmM5Yjc1NDhkMThkYjAiLCJleHAiOjE3MTg5MzM0NzYsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.1ZJoBvTiUk1yvZMqL_urtILqddQ3QHaM3DLH0pF7fNc");
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
