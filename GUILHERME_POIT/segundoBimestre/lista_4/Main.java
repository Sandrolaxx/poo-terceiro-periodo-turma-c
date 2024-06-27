package segundoBimestre.lista_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;

public class App {
    private static final String LISTAR_CONVENIOS_URL = "https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions";
    private static final String CONSULTAR_BOLETO_URL = "https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize";
    private static final String AUTH_TOKEN = ("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJWd012VVliZ1RyUFdCN0NZK3ZjY2FpclFlejRvTzhJb09wRE5PaUNYMDhjV28xdXRKeXJOdEdUZ2NYZWNLMVkzd0pubDlBKzFMazBWSCtaZ1JycVFleU5PSnhCR0l1TmRBMFNoZFp0M2lLTUFGbjJaTks3WmFmQ2RJYW9xVVp1R2s1dXRqOXdVSktPc0ZvSVQ0U0hoWEd0Qk9rdkRFTGN5WnBsSjR4TXJzWWkvejZFWUZQa01Pd3NuaWdvYThSZDZYMThwYWM1TUtpZVJrMFpHdXBMQk1nc21UUTBwYVpxV1FEQm9MaUp3WElmVFI2NlV5NjgzREZMZjFWQjllZU9pUTBUN0FHeW8xVkdHVjBjTHQ4eVE5QzdCZnRDRmgxOXRLMnZKYW5Ldis3WmV2WHFTcUVIclN1YVVyN2tuK215am5HL2NqSGhnWkQycks2dHpvMWdXT3NKaldCZWxONSs1enpyRVpuSkU1UnEwTVpaN0Y2UnVUZnZOZldVMmR2eG5wYWhwKzZWR21HSHNqY2kvNzZvdkgwUXJVRzNKOFNaU25DbStFbjVOUGxYeU1lQTNENXI4Ymx6ZnpIc1loOUY2SFBmVC9zb2JWYzg3LzQ4YUFaVXdMTWpXbjZBQWxyenYwb3pneXhGUGRWL0gxN09vZ1Y4Q1FzRktaaEV3VXAxazdEOVpWUGRMV09NTGxtRzJsNFcrWUhBUzRVSWlyNi9ocys5QjE3d2ZQUmtXRjNBSnJscmVqNU5LK1VGWnQyMzdrdy9XRXlibWgydExKeU53Q1A2K2JRPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiMzIzNzUxNTdjODBhNGQ1MmJkZjkiLCJleHAiOjE3MTkzNjI4NDcsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.hBIOQZ3z-DK6sCpoM2AWNYnHRvNmLUDOE49iqo9mruU");

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Listar Convênios de Pagamento", "Consultar Boleto", "Sair"};
            int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (opcao == 0) {
                String convenios = listarConvenios();
                System.out.println(convenios);
            } else if (opcao == 1) {
                String linhaDigitavel = JOptionPane.showInputDialog("Informe a linha digitável do boleto:");
                if (linhaDigitavel != null) {
                    String boletoInfo = consultarBoleto(linhaDigitavel);
                    JOptionPane.showMessageDialog(null, boletoInfo, "Informações do Boleto", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                break;
            }
        }
    }

    private static String listarConvenios() {
        try {
            URL url = new URL(LISTAR_CONVENIOS_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", AUTH_TOKEN);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");


            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao listar convênios.";
        }
    }

    private static String consultarBoleto(String linhaDigitavel) {
        try {
            URL url = new URL(CONSULTAR_BOLETO_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", AUTH_TOKEN);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            String jsonInputString = "{ \"linhaDigitavel\": \"" + linhaDigitavel + "\" }";
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();

            return "Erro ao consultar boleto.";
        }
    }
}
