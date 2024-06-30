package segundob.aulas.aulasete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpSample {
    public static void main(String[] args) {

        try {
            // URL alvo da request
            URL url = new URL("https://economia.awesomeapi.com.br/json/last/USD");

            // criando conexão HTTP para a URL especificada
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // config método da requisição(GET)
            connection.setRequestMethod("GET");

            // lendo response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            // fechando a conexão
            connection.disconnect();

            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
