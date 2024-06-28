package lista06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class HttpRequestExample {

    public static void main(String[] args) {
        String jsonResponse = HttpRequestExample.getJsonData();

        try {

            Pattern pattern = Pattern.compile("\"(\\w+)\":\"([^\"]+)\"");
            Matcher matcher = pattern.matcher(jsonResponse);


            Map<String, Object> jsonData = new HashMap<>();

            while (matcher.find()) {
                String key = matcher.group(1);
                String value = matcher.group(2);

                jsonData.put(key, value);
            }

            StringBuilder sb = new StringBuilder();

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

    public static String getJsonData() {
        String urlString = "https://api.exemplo.com/dados"; 
        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}
