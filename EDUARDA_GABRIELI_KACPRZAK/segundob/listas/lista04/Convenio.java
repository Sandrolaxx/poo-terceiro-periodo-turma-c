package listas.lista04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Convenio {
    public static void main(String[] args) {
        try {
            System.out.println(getJsonData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getJsonData() {
        try {
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization",
            "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJRbFdEK0x5SWZocEY1NFEwMGN1N2VNZ0pOUTFvK0FXMndDbXpDVGwrNVFxalRDd0dRZUh2VGs4NW5BZmRoSjVXWUlFNkJqU21hWGhoS1JGN2xmUFo4cHJNelRTd0xGQllvTFpnRmlYTCtwNG1tUzhXRlQyeVNITTVVUDhXQXZRY21YNUR0ZTI3ZzVlZnk1RE1hT0RuMXFrMW9YZzZPa2t5bTlSYlZtdjlEME1yMlZuYUt5SlRmNWZ4c2F3RzdQVzZET2tLZ1NQUFd2Y2tuL0Z1S3FaSGN1YTdqZlRjVE4yR3RTanFqRXZNL2pjSmhtRGN3ck44eWZnY3NCRlBDRXhQeFE1TW5UMUdTMW1mK3VPU2U5L1VzZ3RXTjZmd1hPSE96VHlXbklkRjNaWDFKL2ZzeG9LYTdtcEpycFg0aERxdHc1Q0EvQlBPdllKTmJjRjZETFhaNzFDVFVxcHZDUmtCSm9vRng2T0VCQXRWZTBMMVJpSG9HMzhCT1ZHTnJJOXQyNUZKNjlGL3hkanc1V3E4dHlYZ05DWmNYRUdzV3A5eUNxUndrU2RmTmZkZXY5TXRPWmFiTW1GTmhzR0J5SmtNYUlNRmVlN1RPV2RqeGRpVkpQbDd5dlN3cnl1eDlmOXZobEZnd1BySWl1ZnNVbHVacVRNNWdhV2NUUVkvWnFkZVNKQi9URnd2ZmVSNzlNMEE2L2gzblVydy80VXZ2L1NCdG5rVlVQSnZ6TVVkcTdQNE02OUJGZC9jQ3FoV0RTcHZkbUVldVpXT3h1anNvR2UwY1g1aHpBPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiZTQxMjNlODEwYWFmNDM3YmFjZDMiLCJleHAiOjE3MTkyNjk2NTcsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.5jgFKc7YeUDWKR335NcYEVfzIEd3TnuqRQleKbVMI6Q");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

             // Formata a resposta adicionando quebras de linha entre os convênios
            String formattedResponse = response.toString().replace("},", "},\n");

            // Exibindo os convênios
            JFrame frame = new JFrame("Lista de convênios");
            JOptionPane.showMessageDialog(frame, formattedResponse, "Listagem convênios", JOptionPane.INFORMATION_MESSAGE);
            return response.toString();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo deu errado. Contate a equipe de suporte: \n(45)99999-9999");
            return null;
        }
    }
    
}