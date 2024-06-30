package segundo_bimestre.aulas.aulasete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class QrCodeSample {
    
        public static String genQRCode(String token, Double amount) {
        try {
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/pix/v1/brcode/static");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Dados do json
            String json = "{\r\n" + //
                                "  \"key\": \"testepix@celcoin.com.br\",\r\n" + //
                                "  \"amount\":"+amount+",\r\n" + //
                                "  \"transactionIdentification\": \"testqrcodestaticcelcoin\",\r\n" + //
                                "  \"merchant\": {\r\n" + //
                                "    \"postalCode\": \"01201005\",\r\n" + //
                                "    \"city\": \"Barueri\",\r\n" + //
                                "    \"merchantCategoryCode\": 0,\r\n" + //
                                "    \"name\": \"Celcoin\"\r\n" + //
                                "  }\r\n" + //
                                "}";

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJHaml5K0ZmOFZDUjdxV3NSNm5FSWtqK3BveU5KUFZwazA2NEJLd1UzMFBSN3EwSmU2K0FQWldsVEE2blZGeU5lMFVjZzRCMnRVYzYyWFFlemNXb1IyRlB2U1RocHh1MzdXck1ka3ZGM3N3OUM2V0tDVkhjaEdmZXFIS014VVdiUW9TRVlGS1JZemxlL3JCWXhCcVFJQ04ra3NYcXFkQUpONjlPL2lEZFcwUDdobmFERm94VVJzVDJRZHpMeHdJbWNGSkJPT2pHY2R0M0FnaUk1a0llam5FNmdtSkI1b1RSUDE4cVI1cHZBbDlkUlhuS2x4Z05PWGIrY2JDV3RQekN3OUF4L2JjUTNkOVhhTmI2L2tQQjVkYms3bm5UdVRpNUVqS3VHa0RzaThJc3Nld2Jvem9Zd3cyMnJDYnZEcFdZV2xrT05xdy9SK0tMbVMrRE54OFVsN3FiWTJQQ3NYWGxmeVNkM1BiL3Zaa2NSNGYxZmRDelc0UldvWllIK2M5NFhHS1hCV01ENkJKNFVSQitJdTNuQzl2aGxvdVExTmxmT3NBK01wR1pmL0daNEpSYXBuK0pNeU5zUlZCaCs5S3gvM3FSMG80a3h6UDZ4SG9iajBQdUZjVU1qWTdpcEE2QUJRZTF6V1QySW9kNWFMdWkrOEVwdC9GRVhvbkVocXllTlQzL2IwUVB6TzdIUlA0NHF2c0l5MlpteDZNOVNEcSt6MVNIZ2V4ajRsVmhsNzlqSUVSbmpHTVNKdkh6NEk0Z2pXZ3dJZWl1eGQwMlZ3U1hRZmw1MCt3PT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiNzA5ODkxMzFiOGM1NDkxNGExMmQiLCJleHAiOjE3MTk1MTYzOTksImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.E33GmzZoGOhUS7AuLaUF4st1NzrGvXq9c2urDl1llYQ");
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

    public static void main(String[] args) {
        System.out.println(genQRCode(null,null));
    }
}
