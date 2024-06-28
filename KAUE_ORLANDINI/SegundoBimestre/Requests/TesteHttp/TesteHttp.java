package KAUE_ORLANDINI.SegundoBimestre.Requests.TesteHttp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JOptionPane;

public class TesteHttp {
    public static void main(String[] args) {
        try {
            System.out.println(getJsonData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getJsonData() {
        try {
            //URL alvo da request
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions");

            //criando conexão HTTP para a URL especificada
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //config método da requisição(GET)
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization",
                    "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiI0a21pNm92citqYkQzb1hmRFBmeFJTS1p2NGwvY3N3VDlsM2NCb0QxUERDanRXaG9XZ2NNbGYzUitUQ3dTMk51dFp6QzFlV2p3alF5VzNXdmlLSUtkcXpwckUvNW96eU1zbUhtRnVaNjRLSk0xNXdtdHl6RGpiVEovSVhqam1uclJBbnZpZUZjTUdEMytBTjh1bWdTTmozcWswM3BPZVhKUUJBc3pLR1R6dk5Qb1pvYmdQUlJmclRjYzF4cHB5QkVVMWtoQ0ZsR3gxdG9iaWwwL1ZCeCt5dFZMNEpEOTJtdEZUdzBmWFNmT0ZOdGRRSzVQdzBraEpOSy9pOTdRWWlZMW1tek8zTlFJZE5KcktKR05FeVBaaDZNSVYxNDV6NExGK1RSYmNxVlRJdm1qNHE4VHVHY1ZMNkVIV1pPS1FESnJMemE5cjQwVEI0RlNNSTBjdkZkeGhWT0RnQ1JKQTJMRFVaMXp1SDRTUkVUdVd0bVpuRTJCanNWY1ExdEpYVHZrU20zRFNkRTZtb0FMZlhyUlFzaHdPRTZaTTVWMG5yMkExRWRBVXlxcHhlbDFTQkFkYnc4dC9PQ0NuVEM1QUp6M0VWTXFKcDB1Y2Z2WnkyVCtZR3NOYTFHdXFUM0loNk5ObVk0QTFibmRsV0tYNWNlZnYwN1JPRW5tZGEwM1BWb2tNOGcvYXJRNlM5SjJ3R293VWpLcnhic2xRS3UyM1J2amZnUnpkZXVqd3JYUGprRXlUQUdHaFB5bmVpU2dSZEs2SnNvM1cvcHdiQUxWNFc0NzVjL2t3PT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiZjAyNjY1Y2FlOTFmNDRlN2I1MzMiLCJleHAiOjE3MTk1MTU1MDcsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.bQW7rqC0bvegITTpGtaspcUymI1zxrZZco6CXXM28Tw");
            
            //lendo response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            //fechando a conexão
            connection.disconnect();

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}