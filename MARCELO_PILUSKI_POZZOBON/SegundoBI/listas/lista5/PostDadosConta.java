package SegundoBI.listas.lista5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.swing.JOptionPane;

public class PostDadosConta {
    public StringBuilder postRequest() {

        StringBuilder string = new StringBuilder();

        try {
            PostToken token = new PostToken();
            String passwd = token.postTokenGetter();

            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");

            HttpURLConnection request = (HttpURLConnection) url.openConnection();

            String json = "";

            String linhaDigitavel = perguntaLinhaDigitavel();

            if (linhaDigitavel != "") {
                json = "{\n" + //
                        "  \"barCode\": {\n" + //
                        "    \"type\": 0,\n" + //
                        "    \"digitable\": \"23793381286008301352856000063307789840000150000\"\n" + //
                        "  }\n" + //
                        "}";
            } else {
                json = "{\n" + //
                        "  \"barCode\": {\n" + //
                        "    \"type\": 0,\n" + //
                        "    \"digitable\": \"" + linhaDigitavel + "\"\n" + //
                        "  }\n" + //
                        "}";
            }

            request.setRequestMethod("POST");
            request.setRequestProperty("Content-Type", "application/json");
            request.setRequestProperty("Authorization", "Bearer " + passwd);
            request.setDoOutput(true);

            try (OutputStream os = request.getOutputStream()) {
                byte[] input = json.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            string.append(response);

            reader.close();

            request.disconnect();
            /* System.out.println(response); */
        } catch (Exception e) {
            System.out.println(e);
        }

        return string;

    }

    public String perguntaLinhaDigitavel() {
        String x = "";
        x = JOptionPane.showInputDialog(null, "Digite a Linha Digitável (Cancelar caso não quer digitar)", "Linha Digitável Input", 1);
        return x;
    }
}
