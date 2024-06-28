package ERIKA_SARTORELLI.segundob.prova;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Provis {
    public static void main(String[] args) {
        List<String> opcoes = List.of("Listar Alunos", "Enviar Testimonial");
        while (true) {
            int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, opcoes.toArray(), opcoes.toArray()[0]);
            if (opcao == -1) return;

            switch (opcao) {
                case 0 -> listarAlunos();
                case 1 -> enviarTestimonial();
            }
        }
    }

    @SuppressWarnings("deprecation")
    private static void listarAlunos() {
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

    private static void enviarTestimonial() {
        String json = "{\n" +
                "  \"imageUrl\": \"https://i.pinimg.com/564x/33/d9/28/33d9289a7c943a660e1b2b6dcf2e4b3f.jpg\",\n" +
                "  \"description\": \"Materia Foda, adorei passar raiva com java aprendi mintas coisas  e um  Professor muito gente boa. experiencia incrivel pra quem gosta ou seja lele da cuca,  Até pq pra programar vc precisa de beleza e paciência, SE FUNCIONAR BLZ SE NÃO PACIENCIA\",\n" +
                "  \"ra\": \"11270\"\n" +
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
            JOptionPane.showMessageDialog(null, "Erro ao Enviar o Testimonial", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

