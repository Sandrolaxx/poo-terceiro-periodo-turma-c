package ANA_PAULA.Segundobim.prova;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Prova {
    public static void main(String[] args) {
        List<String> opcoes = List.of("Listagem dos Alunos", "Registro de Testemunho");
        while (true) {
            int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, opcoes.toArray(), opcoes.toArray()[0]);
            if (escolha == -1) return;

            switch (escolha) {
                case 0 -> listagemalunos();
                case 1 -> registrotestemunho();
            }
        }
    }

    private static void listagemalunos() {
        URL url = null;
        try {
            url = new URL("https://poo-exam.vercel.app/api/students");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            System.out.println(response);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar os Alunos", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void registrotestemunho() {
        String json = "{Ana Paula Cruz Ferreira\n" +
                "  \"foto\": \"https://www.google.com/search?q=imagem+ngYoBoAHYBvssid=mosaic\",\n" +
                "  \"testemulho\": \"Materia legal, vários aprenizados :)\",\n" +
                "  \"ra\": \"11391\"\n" +
                "}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://poo-exam.vercel.app/api/testimonial"))
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(json))
                .build();

        try {
            String jsonReturn = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString()).body();
            System.out.println(jsonReturn);
        } catch (IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Enviar o Testemunho", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}