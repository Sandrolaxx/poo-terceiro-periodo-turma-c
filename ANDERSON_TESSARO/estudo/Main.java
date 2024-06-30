package estudo;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    // Token gerado no Insomnia
    private static final String TOKEN = "YOUR_GENERATED_TOKEN_HERE";

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Listar Convênios", "Consultar Boleto", "Sair"};
            int choice = JOptionPane.showOptionDialog(
                null, 
                "Escolha uma opção", 
                "Menu", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                options, 
                options[0]
            );

            if (choice == 0) {
                listarConvenios();
            } else if (choice == 1) {
                String linhaDigitavel = JOptionPane.showInputDialog("Digite a linha digitável do boleto:");
                if (linhaDigitavel != null && !linhaDigitavel.trim().isEmpty()) {
                    consultarBoleto(linhaDigitavel);
                }
            } else {
                System.exit(0);
            }
        }
    }

    private static void listarConvenios() {
        try {
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + TOKEN);

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JOptionPane.showMessageDialog(null, "Convênios: " + response.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao listar convênios. Código de resposta: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage());
        }
    }

    private static void consultarBoleto(String linhaDigitavel) {
        try {
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + TOKEN);
            conn.setRequestProperty("Content-Type", "application/json");

            String jsonInputString = "{\"linhaDigitavel\": \"" + linhaDigitavel + "\"}";

            conn.setDoOutput(true);
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JOptionPane.showMessageDialog(null, "Dados do Boleto: " + response.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao consultar boleto. Código de resposta: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage());
        }
    }
}
