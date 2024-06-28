package segundob.estudos;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class QrCodeSample {
    public static void main(String[] args) {
        System.out.println(genQRCode(null,null));
        
    }
    public static String genQRCode(String token, Double amount) {
        try {
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/pix/v1/brcode/static");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Dados do json
            String json = "{\n" + //
                                "  \"key\": \"testepix@celcoin.com.br\",\n" + //
                                "  \"amount\": 10.55,\n" + //
                                "  \"transactionIdentification\": \"testqrcodestaticcelcoin\",\n" + //
                                "  \"merchant\": {\n" + //
                                "    \"postalCode\": \"01201005\",\n" + //
                                "    \"city\": \"Barueri\",\n" + //
                                "    \"merchantCategoryCode\": 0,\n" + //
                                "    \"name\": \"Celcoin\"\n" + //
                                "  }\n" + //
                                "}";

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", token);
            connection.setDoOutput(true);

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

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
