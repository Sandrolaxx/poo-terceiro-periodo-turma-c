package KAUE_ORLANDINI.SegundoBimestre.Lista4Pt2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;

public class Main {

    public static String listarConvenios() {

        try {
            
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions");

            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization",
                    "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJtMGQvY1JmbFdBVnVTY1pDTlIyWlJVUDhYTmxobXdaaGgrS00weDFLaFRZam5kbmFQejlkUTZvcmNSTS9uck42RG9QbVRGRHJSSGxyZXoyZEM4VDlsOUhZeGxuL0RQWHhDUXN5alNaYklYZk9QZ3dhNmQzUlFieVNNdm9YdWtNWUUwUVhhVzNkUlM5TXZwbS9zUGRxWDl3bzNZcHA5aGdFVmJPcFdKNVI4Rk92NERVN054dUl6SHp1Q0NzOHZpTGsvQkZhZjU3OGdOUENIcVphK3B4RStYaDNDZ3krbkIvUlRqTTdQRHlVVVJpY1paS1lRRGtxRGErYXZLUUhsWGF6VGJNdlNoYlFqMHNHQ09QVnlhZFdyRlQzZHF0c0JORGZNZzlkRzlQQnpJazdYTW1Sdkp4WkdOU3ZJM1RPcDBmWHo2WHlQUGRLRGxXSGdTZzQrclRidHZ1T1A3V3g0MUFyeVRuRkNKS3FPeVhGKyt3QStGbkJVSFhqM3BDMklkek1yeDBoZEpSTE80VE53RDgwL0dUd3VKWXpxM2laQ0p2dml4ODRJSFgrdTRTTmlYaFkzNkxJWkdHWEZ0MFVsbXl3ZDE0VVNMT0lDSi9FNjN5L1MzdGRrVTlOYi9sZlZ4QklZWSs3TUxPd0RjLzk4MW92ampDSmNKVExNcFRONFJ3NHRuWTdUc1Nla1QxMzlwYkw1Qis1UEtleklQeGorSEJ0RXFaYmlvOVNzSUdPVERqQ2NET3JzY2xZZFdPMjVYSG1FUXY2VFVVaTd6bkRqNUo2UGZvZ1V3PT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiNzJjNmE2Nzk0ZmIwNGNhOTg3MmEiLCJleHAiOjE3MTk1MTc3NDcsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.mwIVnEqD4qwegA7ipfqkeX9JQWN1rGGLfAONA8Ilicw");
            
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

    public static String consultarBoletos() {

        
            try {
                URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");
    
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                
                String linhaDigitavel = JOptionPane.showInputDialog("insira a linha digitavel: ");
                
                
                String json = "{\n" + //
                "  \"barCode\": {\n" + //
                "    \"type\": 0,\n" + //
                "    \"digitable\":" + linhaDigitavel + "\n" + //
                "  }\n" + //
                "}";
    
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
               
                connection.setRequestProperty("Authorization",
                        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJtMGQvY1JmbFdBVnVTY1pDTlIyWlJVUDhYTmxobXdaaGgrS00weDFLaFRZam5kbmFQejlkUTZvcmNSTS9uck42RG9QbVRGRHJSSGxyZXoyZEM4VDlsOUhZeGxuL0RQWHhDUXN5alNaYklYZk9QZ3dhNmQzUlFieVNNdm9YdWtNWUUwUVhhVzNkUlM5TXZwbS9zUGRxWDl3bzNZcHA5aGdFVmJPcFdKNVI4Rk92NERVN054dUl6SHp1Q0NzOHZpTGsvQkZhZjU3OGdOUENIcVphK3B4RStYaDNDZ3krbkIvUlRqTTdQRHlVVVJpY1paS1lRRGtxRGErYXZLUUhsWGF6VGJNdlNoYlFqMHNHQ09QVnlhZFdyRlQzZHF0c0JORGZNZzlkRzlQQnpJazdYTW1Sdkp4WkdOU3ZJM1RPcDBmWHo2WHlQUGRLRGxXSGdTZzQrclRidHZ1T1A3V3g0MUFyeVRuRkNKS3FPeVhGKyt3QStGbkJVSFhqM3BDMklkek1yeDBoZEpSTE80VE53RDgwL0dUd3VKWXpxM2laQ0p2dml4ODRJSFgrdTRTTmlYaFkzNkxJWkdHWEZ0MFVsbXl3ZDE0VVNMT0lDSi9FNjN5L1MzdGRrVTlOYi9sZlZ4QklZWSs3TUxPd0RjLzk4MW92ampDSmNKVExNcFRONFJ3NHRuWTdUc1Nla1QxMzlwYkw1Qis1UEtleklQeGorSEJ0RXFaYmlvOVNzSUdPVERqQ2NET3JzY2xZZFdPMjVYSG1FUXY2VFVVaTd6bkRqNUo2UGZvZ1V3PT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiNzJjNmE2Nzk0ZmIwNGNhOTg3MmEiLCJleHAiOjE3MTk1MTc3NDcsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.mwIVnEqD4qwegA7ipfqkeX9JQWN1rGGLfAONA8Ilicw");
                
                connection.setDoOutput(true);
    
                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = json.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }
    
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
    
                while ((line = reader.readLine()) != null) {
                    JOptionPane.showMessageDialog(null, line,null , 1);
                }
    
                reader.close();
    
                connection.disconnect();
    
                return response.toString();
            } catch (Exception e) {
                e.printStackTrace();
    
                return null;
            }
        }

    public static String mostrarMenu(){
        String[] opcoes = {"listar convenios", "Consultar boletos", "Encerrar"};
        int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                null, opcoes, opcoes[0]);
        
                switch (opcao) {
                    case 0:
                    System.out.println(listarConvenios());
                        break;
                    case 1:
                    System.out.println(consultarBoletos());
                        break;
                    case 2:
                    break;
                    default:
                        break;
                }
        
        return null;
    }

    public static void main(String[] args) {
       mostrarMenu();

     }
    }