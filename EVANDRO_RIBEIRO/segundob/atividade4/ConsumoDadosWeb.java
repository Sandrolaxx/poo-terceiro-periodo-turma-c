package segundob.atividade4;
import javax.swing.JOptionPane;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class ConsumoDadosWeb {
    private static final String CONVENIOS_URL = "https://developers.celcoin.com.br/reference/obtenha-a-lista-de-conv%C3%AAnios";
    private static final String BOLETOS_URL = "https://developers.celcoin.com.br/reference/pagamento-de-contas-2";

    public static void main(String[] args) {
        String[] options = {"Listar Convênios", "Consultar Boletos"};
        int choice = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        
        if (choice == 0) {
            listarConvenios();
        } else if (choice == 1) {
            consultarBoletos();
        }
    }

    private static void listarConvenios() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(CONVENIOS_URL))
                    .header("Authorization", "")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            JOptionPane.showMessageDialog(null, responseBody, "Convênios", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao listar convênios", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void consultarBoletos() {
        String linhaDigitavel = JOptionPane.showInputDialog("Informe a linha digitável do boleto:");
        if (linhaDigitavel != null && !linhaDigitavel.isEmpty()) {
            try {
                String url = BOLETOS_URL + "?linhaDigitavel=" + linhaDigitavel;
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI(url))
                        .header("Authorization", "")
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String responseBody = response.body();
                JOptionPane.showMessageDialog(null, responseBody, "Boleto", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao consultar boleto", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Linha digitável inválida", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

