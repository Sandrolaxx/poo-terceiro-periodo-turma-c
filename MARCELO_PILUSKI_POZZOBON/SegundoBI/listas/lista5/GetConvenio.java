package SegundoBI.listas.lista5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetConvenio {

    public StringBuilder getRequest() {
        StringBuilder string = new StringBuilder();

        try {
            PostToken token = new PostToken();
            String passwd = token.postTokenGetter();

            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions");

            HttpURLConnection request = (HttpURLConnection) url.openConnection();

            request.setRequestMethod("GET");
            request.setRequestProperty("Authorization", "Bearer " + passwd);

            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null && line.length() > 60) {
                response.append(line);
            }

            reader.close();

            string.append(response);

            request.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }

        return string;
    }
}
