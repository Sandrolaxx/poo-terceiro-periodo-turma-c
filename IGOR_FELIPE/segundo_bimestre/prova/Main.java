package IGOR_FELIPE.segundo_bimestre.prova;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Prova");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] opcoes = {"Listar alunos","Criar registro"};
        String escolher = (String) JOptionPane.showInputDialog(frame, "Escolha uma opção", "Prova", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        switch (escolher) {
            case "Listar alunos":

                try {
                    URL url = new URL("https://poo-exam.vercel.app/api/students");

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");

                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;

                    while((line = reader.readLine()) != null){
                        response.append(line);
                    }

                    JOptionPane.showMessageDialog(frame, response.toString(), "Lista de alunos", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            break;
            case "Criar registro":
                try {
                    URL url = new URL("https://poo-exam.vercel.app/api/testimonial");

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.setRequestProperty("Accept", "application/json");
                    connection.setDoOutput(true);

                    String imagem = JOptionPane.showInputDialog("Digite o link da imagem: ");
                    String descricao = JOptionPane.showInputDialog("Digite a descrição: ");
                    String ra = JOptionPane.showInputDialog("Digite o seu ra: ");

                    String json = "{"
                        + "\"imageUrl\": \"" + imagem + "\","
                        + "\"description\": \"" + descricao + "\","
                        + "\"ra\": \"" + ra + "\""
                        + "}";

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


                } catch (Exception e) {
                    e.getMessage();

                    
                }
            break;
            default:
                break;
        }



    }
}
