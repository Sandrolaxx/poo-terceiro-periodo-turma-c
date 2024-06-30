package segundob.aulas.aulasoito;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class HttpRequestExample {
    public static void main(String[] args) {
        String jsonResponse = TesteHttp.getJsonData();

        try {
            // Extrair os dados do JSON usando expressões regulares
            Pattern pattern = Pattern.compile("\"(\\w+)\":\"([^\"]+)\"");
            Matcher matcher = pattern.matcher(jsonResponse);

            // Mapa que irá armazenar a chave:valor do json
            Map<String, Object> jsonData = new HashMap<>();

            while (matcher.find()) {
                String key = matcher.group(1);
                String value = matcher.group(2);

                jsonData.put(key, value);
            }

            // Exibindo os dados da moeda
            StringBuilder sb = new StringBuilder();
            //Formatar moeda
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
            Double amount = Double.parseDouble(jsonData.get("bid").toString());

            sb.append("Dados da moeda:");
            sb.append("\nCódigo: " + jsonData.get("code"));
            sb.append("\nNome: " + jsonData.get("name"));
            sb.append("\nValor: " + currencyFormat.format(amount));

            JFrame frame = new JFrame("Cotação atual USD");
            JOptionPane.showMessageDialog(frame, sb.toString(), "Cotação atual USD", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
