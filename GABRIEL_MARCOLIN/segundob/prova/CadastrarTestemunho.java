package GABRIEL_MARCOLIN.segundob.prova;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CadastrarTestemunho {

    // Método que recebe resposta do usuário
    public static String recebendoResposta() {
        String ra = JOptionPane.showInputDialog(
                null,
                "Informe o RA do aluno:",
                "Informando RA",
                JOptionPane.QUESTION_MESSAGE);

        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, postTestemunho(ra), "Criando testemunho",
                JOptionPane.INFORMATION_MESSAGE);

        return ra;
    }

    // Método utilizado para quebrar linhas
    private static String quebrandoLinhas(String response) {

        StringBuilder builder = new StringBuilder();
        boolean entreAspas = false;

        for (char c : response.toCharArray()) {
            builder.append(c);
            if (c == '"') {
                entreAspas = !entreAspas;
            } else if (!entreAspas && c == ',' || c == '[') {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    // Método para consultar o boleto com o código forneceido pelo cliente
    public static String postTestemunho(String ra) {
        try {
            URL url = new URL("https://poo-exam.vercel.app/api/testimonial");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Dados do JSON
            String json = "{\r\n  \"imageUrl\": \"https://br.web.img3.acsta.net/c_310_420/pictures/16/05/17/17/28/208580.jpg\",\r\n  \"description\": \"quero chorar\",\r\n  \"ra\": \"" + ra + "\"\r\n}";

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();

            // Bloco validando resposta da requisição
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    // Formatando a resposta para quebrar a linha após vírgulas
                    return quebrandoLinhas(response.toString());
                }

                // Bloco para validação dos erros
            } else if (responseCode == HttpURLConnection.HTTP_BAD_REQUEST) {
                return "Erro 400: Solicitação inválida. Verifique a linha digitável e tente novamente.";
            } else if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                return "Erro 401: Não autorizado. Verifique suas credenciais.";
            } else if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
                return "Erro 404: Recurso não encontrado. Verifique a linha digitável e tente novamente.";
            } else {
                return "Erro " + responseCode + ": Ocorreu um erro desconhecido.";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Erro: Não foi possível criar o testemunho. Por favor, tente novamente mais tarde.";
        }
    }
}