package segundo_bimestre.listas.lista4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Atividade");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        Boolean continuar = true;
        String[] opcoes = {"Listar convênios","Consulta de boleto"};
        String escolher = (String) JOptionPane.showInputDialog(null, "Escolha uma opção","OPÇÕES:", JOptionPane.QUESTION_MESSAGE,null, opcoes, opcoes[0]);
    
        String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJWdkVTcDJzaDJ6VUhuSXNUYlBqVnY0MWVUR21zSThuNmZNSzF0bzgvZmFzYkRpNVpYazhYeGdNZmQvUkFjRlpiaDA4NzJ1KytVRHJBTHBFV3QycGlkZ2xOa3YrTWVxWkQ1ek5FUXNSSk93MTVIWjk1ZFZaVzJ3aVBJZVh3N3FibFNDVy8wV21PakRDQjl4WTRETkRHY3VJQnlESEFCQ29pM29kcDlhL1pGZ2J1K2NzQy9WdU9YUlJYWllzZDk4enhqazRqanMvblpKTllNUnp4TFlIVXVOMzFCZHZVeUhOcmZ0dDZucUd2Vy9XU0hYd0owZ21zZmNnSkNJN3h1UVJNaTBiS251aW12RG05K3hlZUpRdDUxVTI1S21oNjZrS0V4N3dPTVJXSzVrNlo2TXZWaE52aGM1OHBDaHlzdWdsSjRzMjZtODc2dTVZU0QvcmtVY0svcGZyWGlIWk04YWxTWitzYVFVYmtCSjZNci9lbXJ5aXN6cTdta0dBVGxkU2VSdGVnU1JlcW5IK09HTmk4UWNpT0djaGhVTFl6aHVEdjFqanMveUNrVnlGTzJYWC9QdXB3SHdDUFdNbUlwanB3MW5iTW1BdEg2anBTTGxPU0ZOWFA4a1hUb0ZMODB1YkZvZE4zNGY5cGRXdEJQMjIyc3dBanNCQ05oT21PQzU2aGVkSUFhZ01IVnphWGRHN3QyR05CanFtU3VzbUxCeG9UYis1ZWpDTmdCbnVsREZUSTIxa2tPdC94azlIZW5YRWdjUFRqbTdFeFcya0dVWnVXVit5Y2RRPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiNDJmZDZiNTgyODhjNDUwZDg4YmQiLCJleHAiOjE3MTk1MjE2ODIsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.SArBrbpo1WJ8uxLaXSYjjeh2upNxL0sWzudXwHQqCbU";

        switch(escolher){
            case "Listar convênios":

                try {
                    URL urlConvenios = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions?Type=NACIONAL");

                    HttpURLConnection connection = (HttpURLConnection) urlConvenios.openConnection();
    

                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Authorization", token);

                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                
                    while((line = reader.readLine()) != null){
                        response.append(line);
                    }

                    reader.close();
                    connection.disconnect();

                    Pattern pattern = Pattern.compile("\"Nomeconvenant\":\"([^\"]+)\"");
                    Matcher matcher = pattern.matcher(response.toString());
                    
                    StringBuilder nomes = new StringBuilder();

                    while (matcher.find()){
                        String nome = matcher.group(1);

                        nomes.append(nome).append("\n");
                    }

                    JOptionPane.showMessageDialog(frame, nomes.toString(), "Lista de Convênios", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            break;
            case "Consulta de boleto":

                try {

                    String infoUsuario = JOptionPane.showInputDialog("Digite o boleto:");

                    URL urlBoletos = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");

                    String json = "{\r\n" +
                                "  \"barCode\": {\r\n" +
                                "    \"type\": 0,\r\n" +
                                "    \"digitable\": \"" + infoUsuario + "\"\r\n" +
                                "  }\r\n" +
                                "}";

                    HttpURLConnection connection = (HttpURLConnection) urlBoletos.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Authorization", token);
                    connection.setRequestProperty("Content-Type", "application/json; utf-8");
                    connection.setRequestProperty("Accept", "application/json");
                    connection.setDoOutput(true);

                    try (OutputStream os = connection.getOutputStream()) {
                        byte[] input = json.getBytes(StandardCharsets.UTF_8);
                        os.write(input, 0, input.length);
                    }

                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                
                    while((line = reader.readLine()) != null){
                        response.append(line);
                        response.append("\n");
                    }

                    reader.close();

                    JOptionPane.showMessageDialog(frame, response.toString(), "Boleto", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e) {
                    e.printStackTrace();
                }




            break;
        }

    }

}
