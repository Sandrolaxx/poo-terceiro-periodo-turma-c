package RENAN_RIBEIRO_CORREA.segundob.prova;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        while (true) {
            List<String> opcoes = List.of("Listar Alunos", "Enviar Testimonial", "Sair");
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione uma opção", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes.toArray(), opcoes.toArray()[0]);

            if (opcaoSelecionada == -1) {
                System.out.println("Saindo...");
                return;
            }

            switch (opcaoSelecionada) {
                case 0 -> listarAlunos();
                case 1 -> enviarTestimonial();
                case 2 -> {
                    return;
                }
            }
        }
    }

    private static void listarAlunos() {
        try {
            URL url = new URL("https://poo-exam.vercel.app/api/students");

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

            JOptionPane.showMessageDialog(null, response.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void enviarTestimonial() {
        String url = JOptionPane.showInputDialog("Url");
        String descricao = JOptionPane.showInputDialog("Descricao");
        String ra = JOptionPane.showInputDialog("Ra");

        String json = "{\n" +
                "  \"imageUrl\": \"" + url + "\",\n" +
                "  \"description\": \"" + descricao + "\",\n" +
                "  \"ra\": \"" + ra + "\"\n" +
                "}";

        URL urlApi;
        try {
            urlApi = new URL("https://poo-exam.vercel.app/api/students");


            HttpURLConnection connection = (HttpURLConnection) urlApi.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
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

            JOptionPane.showMessageDialog(null, "Testimonial Enviado");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}