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
            String[] options = {"Listar alunos", "Criar registro de testemunho", "Sair"};
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
                // Opção de listar alunos
                listarAlunos();
            } else if (choice == 1) {
                // Opção de criar registro de testemunho
                criarRegistroTestemunho();
            } else if (choice == 2 || choice == JOptionPane.CLOSED_OPTION) {
                // Sair ou fechar o diálogo
                break;
            }
        }
    }

    private static void listarAlunos() {
        String alunos = getJsonData();
        if (alunos != null) {
            showScrollableMessage(formatMessage(alunos), "Lista de Alunos");
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao listar os alunos. Verifique sua conexão ou tente novamente mais tarde.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private static void criarRegistroTestemunho() {
        String fotoUrl = JOptionPane.showInputDialog(
                null,
                "Informe a URL da foto:",
                "Criar Registro de Testemunho",
                JOptionPane.QUESTION_MESSAGE
        );

        if (fotoUrl != null && !fotoUrl.isEmpty()) {
            String texto = JOptionPane.showInputDialog(
                    null,
                    "Informe o TEXTO do aluno:",
                    "Criar Registro de Testemunho",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (texto != null && !texto.isEmpty()) {
                String ra = JOptionPane.showInputDialog(
                        null,
                        "Digite o RA do aluno:",
                        "Criar Registro de Testemunho",
                        JOptionPane.QUESTION_MESSAGE
                );

                if (ra != null && !ra.isEmpty()) {
                    String response = criarTestemunho(fotoUrl, ra, texto);
                    if (response != null) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Testemunho criado com sucesso!",
                                "Sucesso",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    } else {
                        JOptionPane.showMessageDialog(
                                null,
                                "Erro ao criar o testemunho. Verifique os dados fornecidos.",
                                "Erro",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "RA do aluno não informado. Por favor, digite o RA do aluno.",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Texto do testemunho não informado. Por favor, informe o texto do aluno.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "URL da foto não informada. Por favor, forneça a URL da foto.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private static String getJsonData() {
        try {
            URL url = new URL("https://poo-exam.vercel.app/api/students");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

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

    private static String criarTestemunho(String fotoUrl, String ra, String texto) {
        try {
            URL url = new URL("https://poo-exam.vercel.app/api/testimonial");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            String json = "{\r\n" +
                    "  \"imageUrl\": \"" + fotoUrl + "\",\r\n" +
                    "  \"description\": \"" + texto + "\",\r\n" +
                    "  \"ra\": \"" + ra + "\"\r\n" +
                    "}";

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
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
