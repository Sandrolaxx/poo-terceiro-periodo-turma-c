package API;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ListarAlunos {
    public static void listandoAlunos(){
        try {

            String jsonResponse = GetConvenios.getJsonData();

            Pattern pattern = Pattern.compile("\"(\\w+)\":\"([^\"]+)\"(?:,|$)");

            Matcher matcher = pattern.matcher(jsonResponse);

            Map<String, Object> jsonData = new HashMap<>();

            while (matcher.find()) {
                String chave = matcher.group(1);
                String valor = matcher.group(2);

                jsonData.put(chave, valor);
            }
         
            StringBuilder sb = new StringBuilder();

            sb.append(jsonResponse);
          
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, sb.toString(), "Lista de alunos", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
};