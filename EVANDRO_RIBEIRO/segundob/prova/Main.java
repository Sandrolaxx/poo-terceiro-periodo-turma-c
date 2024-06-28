package segundob.prova;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
        String[] options = {"Listar Alunos", "Criar Registro de Testemunho", "Sair"};
        int choice = JOptionPane.showOptionDialog(frame, "Escolha uma opção", "Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        
        switch (choice) {
            case 0:
                listarAlunos();
                break;
            case 1:
                criarRegistroDeTestemunho();
                break;
            case 2:
                System.exit(0);
                break;
        }

        String jsonData = TesteHttp.getJsonData();
        if (jsonData != null) {
            JOptionPane.showMessageDialog(null, "Dados JSON obtidos com sucesso:\n" + jsonData, "Dados JSON", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao obter dados JSON", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        frame.setVisible(true);
    }

    private static void listarAlunos() {
        try {
            URL url = new URL("https://poo-exam.vercel.app/api/students");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();
            if (status == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                con.disconnect();
                JOptionPane.showMessageDialog(null, content.toString(), "Alunos", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao buscar alunos", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro na comunicação: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void criarRegistroDeTestemunho() {
        JTextField urlField = new JTextField();
        JTextField raField = new JTextField();
        JTextField textoField = new JTextField();
        Object[] message = {
                "URL da Foto:", urlField,
                "RA do Aluno:", raField,
                "Texto do Testemunho:", textoField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Criar Registro de Testemunho", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String urlFoto = urlField.getText();
            String ra = raField.getText();
            String texto = textoField.getText();

            try {
                URL url = new URL("https://poo-exam.vercel.app/api/testimonial");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type", "application/json");
                con.setDoOutput(true);

                String jsonInputString = String.format("{\"imageUrl\":\"%s\", \"ra\":\"%s\",\"description\":\"%s\"}",urlFoto,ra,texto);

                System.out.println(jsonInputString);

                try (OutputStream os = con.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }

                int status = con.getResponseCode();
                if (status == 201) {
                    JOptionPane.showMessageDialog(null, "Testemunho criado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao criar testemunho", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro na comunicação: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

            }
        }
    }
}
