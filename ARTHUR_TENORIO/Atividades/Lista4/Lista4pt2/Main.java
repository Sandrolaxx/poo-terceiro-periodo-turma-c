package Lista4.Lista4pt2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main {
    public static void main(String[] args) {
        while (true) {
            String[] options = {"Listar convênios de pagamento", "Consultar boleto", "Sair"};
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
                // Opção de listar convênios de pagamento
                listarConvenios();
            } else if (choice == 1) {
                // Opção de consulta de boleto
                consultarBoleto();
            } else if (choice == 2 || choice == JOptionPane.CLOSED_OPTION) {
                // Sair ou fechar o dialogo
                break;
            }
        }
    }

    private static void listarConvenios() {
        String convenios = getJsonData();
        if (convenios != null) {
            showScrollableMessage(formatMessage(convenios), "Lista de Convênios");
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao listar os convênios.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private static void consultarBoleto() {
        String linhaDigitavel = JOptionPane.showInputDialog(
                null,
                "Informe a linha digitável do boleto:",
                "Consulta de Boleto",
                JOptionPane.QUESTION_MESSAGE
        );

        if (linhaDigitavel != null && !linhaDigitavel.isEmpty()) {
            String response = genQRCode(linhaDigitavel);
            if (response != null) {
                showScrollableMessage(formatMessage(response), "Resultado da Consulta");
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Erro ao consultar o boleto.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Linha digitável não informada.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private static String getJsonData() {
        try {
            @SuppressWarnings("deprecation")
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJZM1Z3NjlqQjBmLy9JSUhnS05SL0wzb1czMDVRRFduaWdiWkFmU2lQVy9NcE9tUC9IZCtnT2VxbWtvT0hqZ093bURhaTlZVUc0YVVhWXVCNHhPbG5CMFFFRC9Ya2Y5WUZNSWJvSkJidW0vdnpxVnMvdUhyYy84OFNzcU1ydVRWZmJjL0pSMXk2Vm1GL2p2WmdyYTMzRi9JbmNZU3dDS2JRRVg0YnNwVkhNYmxNUllxUVdhOUFNSTJTUDFGd2YzUEpMUjlCSTQwWEJhemoraEh1K2l6cEl2T2JzYzl0SjZvZ05HNlBlcVExNnFnZ2s2dGg2a0kvaDdYT2hNZGFidVJyL3QvU2FqSjJPVS9ZTVJMNDMwOVIvcWxzemxNRTBsUmwrRjl2RU1mS1d2Y0k0RjdCMEZYZmIyNE1OcFBxaFpOb0c1cytxNU43V1phTGNhOWp2WnRxcDloSHQzVHM4dkhub1A5c3BTZDZveEpyaHY2N3c5QytmNnRMaGE4NFM5TEprQkVJejBqbGxaNFEySVZYUWkyZXJOWGZpU0E5a0FzR1c2aS9tOWZCaXhIUEVMbEh5TUJJRHhjZE1qZS9GWmdWZklNckhSN1J3OGJtMk1veFF1UGRBS1pGa0xIdkVCdk1TNjdvOWYwZ3FPa0FSSWN5SmZsWVo5OXlBd3pyK2xScE1ySFd1Z25jSUVFeUoxb1Fla0NUQ2tTNXBZMjM5ZXlvY1FYS2RVQ29aeUoyT0ZQa1MxcHdnZWNUdjZkTm9OT3l5cUl6eGZScmxyWWwxRVBjd3RITG1BPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiMWE1YzEwNmE4YjM2NGVmYWFhMTMiLCJleHAiOjE3MTkxODMwODgsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.kYr94ph_dmOl24AOwbH6n0nuwDp9Vqi8vpY5wVOKO-8");

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

    private static String genQRCode(String linhaDigitavel) {
        try {
            @SuppressWarnings("deprecation")
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            String json = "{\r\n" +
                    "  \"barCode\": {\r\n" +
                    "    \"type\": 0,\r\n" +
                    "    \"digitable\": \"" + linhaDigitavel + "\"\r\n" +
                    "  }\r\n" +
                    "}";

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJZM1Z3NjlqQjBmLy9JSUhnS05SL0wzb1czMDVRRFduaWdiWkFmU2lQVy9NcE9tUC9IZCtnT2VxbWtvT0hqZ093bURhaTlZVUc0YVVhWXVCNHhPbG5CMFFFRC9Ya2Y5WUZNSWJvSkJidW0vdnpxVnMvdUhyYy84OFNzcU1ydVRWZmJjL0pSMXk2Vm1GL2p2WmdyYTMzRi9JbmNZU3dDS2JRRVg0YnNwVkhNYmxNUllxUVdhOUFNSTJTUDFGd2YzUEpMUjlCSTQwWEJhemoraEh1K2l6cEl2T2JzYzl0SjZvZ05HNlBlcVExNnFnZ2s2dGg2a0kvaDdYT2hNZGFidVJyL3QvU2FqSjJPVS9ZTVJMNDMwOVIvcWxzemxNRTBsUmwrRjl2RU1mS1d2Y0k0RjdCMEZYZmIyNE1OcFBxaFpOb0c1cytxNU43V1phTGNhOWp2WnRxcDloSHQzVHM4dkhub1A5c3BTZDZveEpyaHY2N3c5QytmNnRMaGE4NFM5TEprQkVJejBqbGxaNFEySVZYUWkyZXJOWGZpU0E5a0FzR1c2aS9tOWZCaXhIUEVMbEh5TUJJRHhjZE1qZS9GWmdWZklNckhSN1J3OGJtMk1veFF1UGRBS1pGa0xIdkVCdk1TNjdvOWYwZ3FPa0FSSWN5SmZsWVo5OXlBd3pyK2xScE1ySFd1Z25jSUVFeUoxb1Fla0NUQ2tTNXBZMjM5ZXlvY1FYS2RVQ29aeUoyT0ZQa1MxcHdnZWNUdjZkTm9OT3l5cUl6eGZScmxyWWwxRVBjd3RITG1BPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiMWE1YzEwNmE4YjM2NGVmYWFhMTMiLCJleHAiOjE3MTkxODMwODgsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.kYr94ph_dmOl24AOwbH6n0nuwDp9Vqi8vpY5wVOKO-8");
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

    private static String formatMessage(String message) {
        StringBuilder formatted = new StringBuilder();
        int lineLength = 40;
        int start = 0;
        while (start < message.length()) {
            int end = Math.min(start + lineLength, message.length());
            formatted.append(message, start, end).append("\n");
            start = end;
        }
        return formatted.toString();
    }

    private static void showScrollableMessage(String message, String title) {
        JTextArea textArea = new JTextArea(message);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(500, 500));

        JOptionPane.showMessageDialog(
                null,
                scrollPane,
                title,
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
