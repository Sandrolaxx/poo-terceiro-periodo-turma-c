package listas.lista04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;

public class Boleto {
        public static void getBoleto(){
            try{
                String linhaDigitavel = JOptionPane.showInputDialog(null, "Insira a linha digitavel do boleto");
  
                URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                String str = "{\r\n" +
                        "  \"barCode\": {\r\n" +
                        "    \"type\": 0,\r\n" +
                        "    \"digitable\": " +
                        "\"" + linhaDigitavel + "\"\r\n" +
                        "  }\r\n" +
                        "}";
            
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Authorization",  "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJzZ2VoZWV5b250Rnd1QUo3UmNpdFUzUGhFV0kyWnFjczZDVEZyclkrN0l0aTVIUGc0UU1oQVJVZUVOL1A3ZjBkYlRxeW5aM1oyK0JFa2FVOTJXRVhnVkJ3OXlzWENhbDJicW1KWVFYOFp3SGlrMitld0RzMlBWdmUzb0RSRVhNRVZPZ2FneXF4bzI4T0hoYkhJcGFac1owQjc1eXZXU0NsOUczdnp3bE5LNWh0WjNFK1Z2ZkgyVW91VXIwQU5XaXE1YVovRytOWEwxMzYrMXNaaU5GWkVnV2lYOGlKTlg5alh2RW5XcUdZdm1hRExWNmpOSjBDcy96Z25YSHppbklzNUFJbEZ6cGhxMGNMVDJtVS9oUzgvZ1ovQ2xyazdUdnJZTW1KaVpMeTJOanlGZTcxUENNVDBUZWRpWE1scENwcnRaaXQ4cktlUU1Yd2gvMFRTNzZ6OHlTUnUwWTh5aWtEZDlhdWRTVXNJUCt1UkRJd3FzZTRjcXVhVmIwSjMvNjBPWGhmSTdHUk1TV0pybk1oV0U5YkVmc2NBMmU3cndiV3J6dDJZdTdQQVRrcjN4bUo3ZXVxa0dDRUlGSWJtbzk3T1dWVGtQZXNPY0kwd3NrSk90Zk9RYWhtbkNaTmFjTTZyRzFBMm5tL2NXK1plWDJvNzJMb3BZR215Z0dUNFg1aG5Sb08vMkwzQ0U1dFBubmlIbXFKWHlxalhBZ1k0OUw0RWhDWWZWN1dLUDQ2MkFjS1BKNnFsWGgrd1VTdTNTYTFLZEM0a05KSXU4TmRLZmNaYm8xbXZBPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiZDkyZjRkYzM1N2ZiNGYyNDg2YzkiLCJleHAiOjE3MTkyNTQ5MjEsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.FGjUl60wpfzppAXP2LuXFxx0DH0wjnjBiSiNJ9rCnU4");
                
                // setar dados json? colocar true
                connection.setDoOutput(true);
    
                // enviar requisição
                try (OutputStream os = connection.getOutputStream()){
                    byte[] input = str.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }
               
                // lendo a resposta do servidor.
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
    
                while ((line = reader.readLine()) != null){
                    response.append(line);
                }
    
                reader.close();
                connection.disconnect();
    

                String respostaArrumada = response.toString().replace("\",\"", "\",\n\"");
                JOptionPane.showMessageDialog(null, respostaArrumada);
    
            } 
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "Algo deu errado.");
            }
        }
    
    }
