package BERNARDO_SMARCZEWSKI.segundobi.prova;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Main {
    
    public static void main(String[] args) {
        exibirMenu();
    }

    private static void exibirMenu() {
        String[] opcoes = {"Listar Alunos", "Criar Testemunho", "Sair"};

        while (true) {
            int escolha = JOptionPane.showOptionDialog(null, "Selecione uma opção:", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0:
                    listarAlunos();
                    break;
                case 1:
                    criarTestemunho();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Saindo");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    break;
            }
        }
    }

    private static void listarAlunos() {

        try {
            URL url = new URL("https://poo-exam.vercel.app/api/students");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJzREJoQ2NsNkNJdFJJS2FMUGRtVW5ENFAxN3l0dmpWNnhURURnVU9tSXgyK2EySGpEZHhqQzFNOEhLVThFTG1Udmwxa2VmMFp3Z2tENTZKaWU0WUtPc3RtS1FZRDdPK3dPRk42TlZSb2U1M2NqVkZySkVkYUpYVUcxOGQyd1BwSjdtSmF1VlJNZk1UanRCV0NiN2gwc3lOV2dUdGpDRi9CNms4aThBYlZsbzBPZ1FDY1J1dWtFSTlnOEtJTmdETTh3dzBkTWprM25BSlR3ZHZ5UTkxY2dZY0hlYjJ4bjl5bE4rcW1sTHNGV01rTWIxSjIxM1pBL1U5T1EzMjVmeStqSXB0MFhyZWF5T0xmZ0lXdCthaDdJL2o3SzdqR0VQRHJ2L0lhQUxpL1BsRENhSWZLQzZ3RWtvbjB1UzFRS0w0UFNEMkUvL09lR1FibUNHQW5sQlRMak5lNWFZdHlkeHFBM2R6TURzTVJiZEZBVDUralo0MnliMmZCNVRsUTNaRkdhUTBiYU1zOG5FMzYraWl6UExRdkEzdEFzeW1RaUhiVmxLMlBsOFpLY2JwdWZvT0hQUzJMd045dHhQaEdSMlJQaGVXV3F4TmVnT2xNZlNmNGJHcFRtSkV5OW90SytsRWNlTHhqdEhlSmEyQUpuU3NtNkFLOXJ1RmxQRUx1QStHeG9NQnpsbFJQUG5wc2RJMXJqUUYvbEdtSFpMNjN1SlgyQVZCUnE0aGY1OEFHbEZhVlRCczk0TG5yKzJBd3J4eG5WeDJoVUo0S1ZqT2dXRG5GZTFGQjdRPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiYjY2YjA4ZGVjMTljNDVjOTg3M2IiLCJleHAiOjE3MTk1Mzc0MTksImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.T3lVTtTDcZZI0Gli966WwBOwqzqFG_MvWXy8QpUuUUk");

            int status = con.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder content = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                    content.append("\n");
                }
                in.close();
                con.disconnect();

                JTextArea textArea = new JTextArea(10, 40);
                textArea.setText(content.toString());
                textArea.setEditable(false);
                JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Alunos", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Erro.mostrarErro("Erro ao listar alunos. Código de resposta: " + status);
            }
        } catch (Exception e) {
            Erro.mostrarErro("Erro ao listar alunos.");
        }

    }

    private static void criarTestemunho() {
        JTextField campoUrlFoto = new JTextField();
        JTextField campoRA = new JTextField();
        JTextField campoTestemunho = new JTextField();
        
        Object[] message = {
            "URL da Foto:", campoUrlFoto,
            "RA do Aluno:", campoRA,
            "Testemunho:", campoTestemunho
        };
    
        int option = JOptionPane.showConfirmDialog(null, message, "Criar Testemunho", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String urlFoto = campoUrlFoto.getText();
            String ra = campoRA.getText();
            String texto = campoTestemunho.getText();
            enviarTestemunho(urlFoto, ra, texto); 
        }
    }

    private static void enviarTestemunho(String urlFoto, String ra, String texto) {
        try {
            URL url = new URL("https://poo-exam.vercel.app/api/testimonial");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJzREJoQ2NsNkNJdFJJS2FMUGRtVW5ENFAxN3l0dmpWNnhURURnVU9tSXgyK2EySGpEZHhqQzFNOEhLVThFTG1Udmwxa2VmMFp3Z2tENTZKaWU0WUtPc3RtS1FZRDdPK3dPRk42TlZSb2U1M2NqVkZySkVkYUpYVUcxOGQyd1BwSjdtSmF1VlJNZk1UanRCV0NiN2gwc3lOV2dUdGpDRi9CNms4aThBYlZsbzBPZ1FDY1J1dWtFSTlnOEtJTmdETTh3dzBkTWprM25BSlR3ZHZ5UTkxY2dZY0hlYjJ4bjl5bE4rcW1sTHNGV01rTWIxSjIxM1pBL1U5T1EzMjVmeStqSXB0MFhyZWF5T0xmZ0lXdCthaDdJL2o3SzdqR0VQRHJ2L0lhQUxpL1BsRENhSWZLQzZ3RWtvbjB1UzFRS0w0UFNEMkUvL09lR1FibUNHQW5sQlRMak5lNWFZdHlkeHFBM2R6TURzTVJiZEZBVDUralo0MnliMmZCNVRsUTNaRkdhUTBiYU1zOG5FMzYraWl6UExRdkEzdEFzeW1RaUhiVmxLMlBsOFpLY2JwdWZvT0hQUzJMd045dHhQaEdSMlJQaGVXV3F4TmVnT2xNZlNmNGJHcFRtSkV5OW90SytsRWNlTHhqdEhlSmEyQUpuU3NtNkFLOXJ1RmxQRUx1QStHeG9NQnpsbFJQUG5wc2RJMXJqUUYvbEdtSFpMNjN1SlgyQVZCUnE0aGY1OEFHbEZhVlRCczk0TG5yKzJBd3J4eG5WeDJoVUo0S1ZqT2dXRG5GZTFGQjdRPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiYjY2YjA4ZGVjMTljNDVjOTg3M2IiLCJleHAiOjE3MTk1Mzc0MTksImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.T3lVTtTDcZZI0Gli966WwBOwqzqFG_MvWXy8QpUuUUk");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
    
            String json = String.format("{\"imageUrl\":\"%s\",\"description\":\"%s\",\"ra\":\"%s\"}", urlFoto, texto, ra);
            System.out.println(json);
    
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
    
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                JOptionPane.showMessageDialog(null, "Testemunho criado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Erro.mostrarErro("Erro ao criar testemunho: " + conn.getResponseMessage());
            }
    
        } catch (Exception e) {
            Erro.mostrarErro("Erro na criação: " + e.getMessage());
        }
    }
}