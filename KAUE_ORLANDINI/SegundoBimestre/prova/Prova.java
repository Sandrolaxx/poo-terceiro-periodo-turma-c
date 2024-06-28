package KAUE_ORLANDINI.SegundoBimestre.prova;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.swing.JOptionPane;

public class Prova {
    
    public static String listarAlunos() {

        try {
            
            URL url = new URL("https://poo-exam.vercel.app/api/students");

            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                JOptionPane.showMessageDialog(null, line,null , 1);
            }

            reader.close();
            
            connection.disconnect();

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    public static String criarTestemunho() {

            try {
                URL url = new URL("https://poo-exam.vercel.app/api/testimonial");
    
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                
                String imageURL = JOptionPane.showInputDialog("insira a url da foto: ");
                String descricao = JOptionPane.showInputDialog("insira a mensagem: ");
                String ra = JOptionPane.showInputDialog("insira o RA: ");
                
                
                String json = "{\r\n" +
                    "  \"imageUrl\": \"" + imageURL+ "\",\r\n" +
                    "  \"description\": " +
                    "\"" +descricao+"\",\r\n" +
                    "  \"ra\": \""+ra+"\"" +
                    "\r\n" +
                    "}";
    
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Accept", "application/json");
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
                    JOptionPane.showMessageDialog(null, line,null , 1);
                }
    
                reader.close();
    
                connection.disconnect();
    
                return response.toString();
            } catch (Exception e) {
                e.printStackTrace();
    
                return null;
            }
        }

    public static String mostrarMenu(){
        String[] opcoes = {"listar alunos", "Criar testemunho", "Encerrar"};
        int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                null, opcoes, opcoes[0]);
        
                switch (opcao) {
                    case 0:
                    System.out.println(listarAlunos());
                        break;
                    case 1:
                    System.out.println(criarTestemunho());
                        break;
                    case 2:
                    break;
                    default:
                        break;
                }
        
        return null;
    }

    public static void main(String[] args) {
        mostrarMenu();
    }
}