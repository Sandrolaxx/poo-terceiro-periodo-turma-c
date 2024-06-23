package requisicoes;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.util.Base64;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class QRCodeSample {
    public static void main(String[] args) {
        try {
            Map<String, Object> tokenJson = JsonUtils.srtToMap(TokenSample.getToken());
            String token = "Bearer " + tokenJson.get("access_token").toString();

            Double amount = Double.parseDouble(JOptionPane.showInputDialog("Valor do pix?"));

            Map<String, Object> qrCodeData = genQRCode(token, amount);
            String emv = splitString(qrCodeData.get("emvqrcps").toString(), 60);

            String msg = "Pix Copia e Cola\n".concat(emv).concat("\n\nValor\n").concat(formatCurrency(amount));

            Image image = getBase64Image(token, qrCodeData.get("transactionId").toString());
            Icon icon = new ImageIcon(image);

            JOptionPane.showMessageDialog(
                    null,
                    msg,
                    "QR Code PIX🤑",
                    JOptionPane.PLAIN_MESSAGE,
                    icon);
        } catch (Exception e) {
          
            e.printStackTrace();
        }
    }

    public static Map<String, Object> genQRCode(String token, Double amount) {
        try {
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/pix/v1/brcode/static");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Dados do json
            String json = "{\n" + //
                    "  \"key\": \"testepix@celcoin.com.br\",\n" + //
                    "  \"amount\": " + amount.toString() + ",\n" + //
                    "  \"merchant\": {\n" + //
                    "    \"postalCode\": \"858402\",\n" + //
                    "    \"city\": \"cascaland\",\n" + //
                    "    \"merchantCategoryCode\": \"5000\",\n" + //
                    "    \"name\": \"TestBullet\"\n" + //
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

            return JsonUtils.srtToMap(response.toString());
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    public static Image getBase64Image(String token, String transactionId) {
        try {
            String path = "https://sandbox.openfinance.celcoin.dev/pix/v1/brcode/static/";
            URL url = new URL(path + transactionId + "/base64");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", token);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            connection.disconnect();

            // Pegando retorno Base64 e gerando bytes da imagem a ser criaada
            String base64 = JsonUtils.srtToMap(response.toString()).get("base64image").toString();
            byte[] data = Base64.getDecoder().decode(decodeUtfToPlain(base64));

            // Criando arquivo para adicionar no Icon do JOptionPane
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(data));

            return resize(img, 140, 140);
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    private static BufferedImage resize(BufferedImage img, int newW, int newH) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
        Graphics2D g = dimg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();

        return dimg;
    }

    private static String decodeUtfToPlain(String input) {
        Pattern pattern = Pattern.compile("\\\\u[0-9a-fA-F]{4}");
        Matcher matcher = pattern.matcher(input);

        StringBuilder decodedString = new StringBuilder();

        while (matcher.find()) {
            String unicodeSequence = matcher.group();
            char unicodeChar = (char) Integer.parseInt(unicodeSequence.substring(2), 16);

            matcher.appendReplacement(decodedString, Character.toString(unicodeChar));
        }

        matcher.appendTail(decodedString);

        return decodedString.toString();
    }

    private static String formatCurrency(Double value) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

        return currencyFormat.format(value);
    }

    private static String splitString(String text, int wordsPerLine) {
        final StringBuilder newText = new StringBuilder();

        long wordCount = 1;

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            if (wordCount++ > wordsPerLine) {
                newText.append(character);
                newText.append("\n");

                wordCount = 1;

                continue;
            }

            newText.append(character);
        }

        return newText.toString();
    }
}
