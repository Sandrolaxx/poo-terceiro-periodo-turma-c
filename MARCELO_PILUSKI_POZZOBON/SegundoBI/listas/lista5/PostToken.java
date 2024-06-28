package SegundoBI.listas.lista5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostToken {
    public String postTokenGetter() {
        String password = "";
        try {
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/token");

            HttpURLConnection request = (HttpURLConnection) url.openConnection();

            String encodedHeader = "client_id="
                    + URLEncoder.encode("41b44ab9a56440.teste.celcoinapi.v5", StandardCharsets.UTF_8.name())
                    + "&grant_type=" + URLEncoder.encode("client_credentials", StandardCharsets.UTF_8.name())
                    + "&client_secret="
                    + URLEncoder.encode("e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3",
                            StandardCharsets.UTF_8.name());

            request.setRequestMethod("POST");
            request.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            request.setRequestProperty("Content-Length", Integer.toString(encodedHeader.length()));
            request.setDoOutput(true);

            try (OutputStream os = request.getOutputStream()) {
                byte[] input = encodedHeader.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            Pattern pattern = Pattern.compile("\"access_token\":\"([^\"]+)\"");
            Matcher matcher = pattern.matcher(response);

            if (matcher.find()) {
                password = matcher.group(1);
            } else {
                System.out.println("Não achou o token");
            }

            reader.close();

            request.disconnect();
            /* System.out.println(response); */
        } catch (Exception e) {
            System.out.println(e);
        }
        return password;
    }
}
