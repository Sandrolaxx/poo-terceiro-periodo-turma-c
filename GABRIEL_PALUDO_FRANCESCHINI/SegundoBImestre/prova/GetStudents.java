package listasfacul.prova;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class GetStudents {

    public static void main(String[] args) {

        try {
            System.out.println(getJsonData());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getJsonData() {

        try {
            URL url = new URI("https://poo-exam.vercel.app/api/students").toURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            return response.toString();

        } catch (Exception e) {
            return e.getMessage();
        }
    }

}