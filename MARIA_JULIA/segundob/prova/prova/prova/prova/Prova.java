package MARIA_JULIA.segundob.prova.prova.prova.prova;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javax.swing.JOptionPane;

public class Prova {
    public static void main(String[] args) {
        // PEDINDO AO USUARIO QUAL OPCAO ELE QUER
        String[] opcoes = {"Listagem de alunos", "Criar registro de testemunho", "SAIR"};
        int escolhaUsuriario = JOptionPane.showOptionDialog(null, "Escolha a ação que deseja realizar:", "PROVA ATIVIDADE",
        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        // CHAMANDO A FUNCAO CORRETA COM BASE NA RESPOSTA
        if (escolhaUsuriario != -1) {
            if (opcoes[escolhaUsuriario].equals("Listagem de alunos")){ 

                String items = listarEstudantes();
                System.out.println(items);
                JOptionPane.showMessageDialog(null, items);

            } else if (opcoes[escolhaUsuriario].equals("Criar registro de testemunho")) {

                String imageUrl = JOptionPane.showInputDialog("URL da imagem: ");
                String description = JOptionPane.showInputDialog("Descrição: ");
                String ra = JOptionPane.showInputDialog("RA: ");

                Aluno aluno1 = new Aluno();
                aluno1.setImageUrl(imageUrl);
                aluno1.setDescription(description);
                aluno1.setRa(ra);

                String resultadoDaInsercao = criarTestemunho(aluno1);
                JOptionPane.showMessageDialog(null, resultadoDaInsercao);
    

            } else {
                JOptionPane.showMessageDialog(null, "aplicacao encerrada");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Você não escolheu nenhuma função", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String listarEstudantes() {
        try {
            URL url = new URL("https://poo-exam.vercel.app/api/students");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            
            int codeResponse = connection.getResponseCode();

            if (codeResponse == HttpURLConnection.HTTP_OK){
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
    
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
    
                reader.close();
    
                connection.disconnect();
    
                    
            
                Pattern pattern = Pattern.compile("\"(\\w+)\":\"([^\"]+)\"");
                Matcher matcher = pattern.matcher(response.toString());

                List<Map<String, Object>> lista = new ArrayList<>();

                while (matcher.find()) {
                    Map<String, Object> jsonData = new HashMap<>();
                    String key = matcher.group(1);
                    String value = matcher.group(2);
                    jsonData.put(key, value);
                    lista.add(jsonData);
                }

                // eu tenteiiiii
                StringBuilder sb = new StringBuilder();

                for (Map<String, Object> map : lista) {
                    
                    if (map.get("name") != null) {
                        sb.append("\nNome do aluno: " + map.get("name"));

                    }
                    if (map.get("ra") != null) {
                        sb.append("\nRA do aluno: " + map.get("ra"));

                    }
                    
                }

                
                
                return  sb.toString();
            }
            else if (codeResponse == HttpURLConnection.HTTP_BAD_REQUEST){
                connection.disconnect();

                return "Erro 400: verifique dados digitados";
            } else if (codeResponse == HttpURLConnection.HTTP_UNAUTHORIZED){
                connection.disconnect();

                return "Erro 401: credenciais nao autorizadas";
            }
            else if (codeResponse == HttpURLConnection.HTTP_UNAUTHORIZED){
                connection.disconnect();

                return "Erro 404:verifique dados digitados";
            } else {
                String code =Integer.toString(codeResponse);
                connection.disconnect();

                return "Erro "+ code;
            }

          
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public static String criarTestemunho(Aluno aluno) {
        try {
            URL url = new URL("https://poo-exam.vercel.app/api/testimonial");

            HttpURLConnection connection2 = (HttpURLConnection) url.openConnection();

            String json = "{\r\n  \"imageUrl\": \""+aluno.getImageUrl()+"\",\r\n  \"description\": \""+aluno.getDescription()+"\",\r\n  \"ra\": \""+aluno.getRa()+"\"\r\n}";

            System.out.println(json);

            connection2.setRequestMethod("POST");
            connection2.setRequestProperty("Content-Type", "application/json");
            connection2.setRequestProperty("Accept", "application/json");
            connection2.setDoOutput(true);

            try (OutputStream os = connection2.getOutputStream()) {
                byte[] input = json.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection2.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            connection2.disconnect();

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
