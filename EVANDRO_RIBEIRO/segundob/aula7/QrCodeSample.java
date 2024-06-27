package segundob.aula7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class QrCodeSample {
    
    public static void main(String[] args) {                                          //colocar o codigo fora do metodo main -> dar ctrl + space no "URL" -> mudar json
            System.out.println(genQRCode(null, null));
    }

    public static String genQRCode(String token, Double amount) {           //nessa linha deixar como string
        try {
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/pix/v1/brcode/static");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Dados do json
            String json = "{\r\n" + 
                            "  \"key\": \"testepix@celcoin.com.br\",\r\n" + //
                            "  \"amount\": 10.55,\r\n" + //
                            "  \"transactionIdentification\": \"testqrcodestaticcelcoin\",\r\n" + //
                            "  \"merchant\": {\r\n" + //
                            "    \"postalCode\": \"01201005\",\r\n" + //
                            "    \"city\": \"Barueri\",\r\n" + //
                            "    \"merchantCategoryCode\": 0,\r\n" + //
                            "    \"name\": \"Celcoin\"\r\n" + //
                            "  },\r\n" + //
                            "  \"tags\": [\r\n" + //
                            "    \"string\"\r\n" + //
                            "  ],\r\n" + //
                            "  \"additionalInformation\": \"Referente ao custo de...\",\r\n" + //
                            "  \"withdrawal\": false\r\n" + //
                            "}";

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");                   //pode tirar o accept se quiser
            connection.setRequestProperty("Authorization", "bearer 00020126730014br.gov.bcb.pix0123testepix@celcoin.com.br0224Referente ao custo de...520400005303986540510.555802BR5907Celcoin6007Barueri61080120100562270523testqrcodestaticcelcoin6304DB0B");                         //parte para usar o token
            connection.setDoOutput(true);                                                   // permitido colocar dados... "true"

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));    
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            connection.disconnect();

            return (response.toString());          //deixar pra return string
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    
}
