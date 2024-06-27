package KAUE_ORLANDINI.SegundoBimestre.Requests.QRCodeSample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.swing.JOptionPane;

public class QRCodeSample {

    public static void main(String[] args) {
        System.out.println(genQRCode(null, 2d));
    }

    public static String genQRCode(String token, Double amount) {
        try {
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            String linhaDigitavel = JOptionPane.showInputDialog("insira a linha digitavel: ");
            
            // Dados do json
            String json = "{\n" + //
                    "  \"key\": \"testepix@celcoin.com.br\",\n" + //
                    "  \"amount\":" + amount + ",\n" + //
                    "  \"merchant\":" + linhaDigitavel + "{\n" + //
                    "    \"postalCode\": \"01201005\",\n" + //
                    "    \"city\": \"Barueri\",\n" + //
                    "    \"merchantCategoryCode\": 0,\n" + //
                    "    \"name\": \"Celcoin\"\n" + //
                    "  }\n" + //
                    "}";

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
           // TIRAR NA PROVA N PRECISA DE TOKEN
            connection.setRequestProperty("Authorization",
                    "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiI0a21pNm92citqYkQzb1hmRFBmeFJTS1p2NGwvY3N3VDlsM2NCb0QxUERDanRXaG9XZ2NNbGYzUitUQ3dTMk51dFp6QzFlV2p3alF5VzNXdmlLSUtkcXpwckUvNW96eU1zbUhtRnVaNjRLSk0xNXdtdHl6RGpiVEovSVhqam1uclJBbnZpZUZjTUdEMytBTjh1bWdTTmozcWswM3BPZVhKUUJBc3pLR1R6dk5Qb1pvYmdQUlJmclRjYzF4cHB5QkVVMWtoQ0ZsR3gxdG9iaWwwL1ZCeCt5dFZMNEpEOTJtdEZUdzBmWFNmT0ZOdGRRSzVQdzBraEpOSy9pOTdRWWlZMW1tek8zTlFJZE5KcktKR05FeVBaaDZNSVYxNDV6NExGK1RSYmNxVlRJdm1qNHE4VHVHY1ZMNkVIV1pPS1FESnJMemE5cjQwVEI0RlNNSTBjdkZkeGhWT0RnQ1JKQTJMRFVaMXp1SDRTUkVUdVd0bVpuRTJCanNWY1ExdEpYVHZrU20zRFNkRTZtb0FMZlhyUlFzaHdPRTZaTTVWMG5yMkExRWRBVXlxcHhlbDFTQkFkYnc4dC9PQ0NuVEM1QUp6M0VWTXFKcDB1Y2Z2WnkyVCtZR3NOYTFHdXFUM0loNk5ObVk0QTFibmRsV0tYNWNlZnYwN1JPRW5tZGEwM1BWb2tNOGcvYXJRNlM5SjJ3R293VWpLcnhic2xRS3UyM1J2amZnUnpkZXVqd3JYUGprRXlUQUdHaFB5bmVpU2dSZEs2SnNvM1cvcHdiQUxWNFc0NzVjL2t3PT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiZjAyNjY1Y2FlOTFmNDRlN2I1MzMiLCJleHAiOjE3MTk1MTU1MDcsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.bQW7rqC0bvegITTpGtaspcUymI1zxrZZco6CXXM28Tw");
            // TIRAR NA PROVA N PRECISA DE TOKEN
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

    private static void subString(int i, int j) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subString'");
    }

}
