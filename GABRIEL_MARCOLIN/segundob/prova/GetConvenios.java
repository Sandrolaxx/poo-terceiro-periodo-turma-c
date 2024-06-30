package GABRIEL_MARCOLIN.segundob.prova;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetConvenios {
    public static void main(String[] args) {
        try {
            getJsonData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getJsonData() {
        try {
            URL url = new URL("https://poo-exam.vercel.app/api/students");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            //fechando a conexão
            connection.disconnect();

            return quebrandoLinhas(response.toString());
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    private static String quebrandoLinhas(String response) {

        StringBuilder builder = new StringBuilder();
        boolean entreAspas = false;

        for (char c : response.toCharArray()) {
            builder.append(c);
            if (c == '"') {
                entreAspas = !entreAspas;
            } else if (!entreAspas && c == ',' || c == '[') {
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}