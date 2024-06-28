package MATEUS_DOS_SANTOS_CONRRADO.segundob.prova;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        String opcaoEscolhida = (String) JOptionPane.showInputDialog(
            null,
            "Selecione uma das opções:",
            null,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[] { "Listar Alunos", "Criar Registro de Testemunho", "Sair" },
            "Listar Alunos");

        switch (opcaoEscolhida) {
            case "Listar Alunos":
                listagemDeAlunos();
                break;

            case "Criar Registro de Testemunho":
                criarRegistroDeTestemunho();
                break;

            case "Sair":
                System.out.println("Saindo...");
                System.exit(0);
                break;

            default:
                break;
        }
    }

    public static void listagemDeAlunos() {
        try {
            URL url = new URL("https://poo-exam.vercel.app/api/students");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            JOptionPane.showMessageDialog(null, response.toString(), "Lista de Alunos", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void criarRegistroDeTestemunho() {
        try {
            URL url = new URL("https://poo-exam.vercel.app/api/testimonial");
            String imageUrl = JOptionPane.showInputDialog("Informe a URL da imagem:");
            String ra = JOptionPane.showInputDialog("Informe o RA do aluno:");
            String description = JOptionPane.showInputDialog("Informe a descrição do testemunho:");

            
            System.out.println("Image URL: " + imageUrl);
            System.out.println("RA: " + ra);
            System.out.println("Description: " + description);

            
            String json = String.format(
                "{\"imageUrl\":\"%s\", \"ra\":\"%s\", \"description\":\"%s\"}",
                imageUrl.replace("\"", "\\\""),
                ra.replace("\"", "\\\""),
                description.replace("\"", "\\\"")
            );
            System.out.println("JSON Enviado: " + json);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader reader;
            if (responseCode >= 200 && responseCode < 300) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            if (responseCode >= 200 && responseCode < 300) {
                JOptionPane.showMessageDialog(null, "Testemunho criado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro: " + response.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
