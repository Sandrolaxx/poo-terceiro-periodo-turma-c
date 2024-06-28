package MARCELO_PILUSKI_POZZOBON.SegundoBI.prova;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import java.nio.charset.StandardCharsets;

public class TestemunhoPost {
      public void postRequest() {
            /* StringBuilder strListagem = new StringBuilder(); */

            try {
                  URL url = new URL("https://poo-exam.vercel.app/api/testimonial");

                  HttpURLConnection request = (HttpURLConnection) url.openConnection();

                  String imgURL = JOptionPane.showInputDialog(null, "URL da imagem:", "Amém", 1);
                  String descricao = JOptionPane.showInputDialog(null, "Descrição:", "Amém", 1);
                  String ra = JOptionPane.showInputDialog(null, "RA do Aluno:", "Amém", 1);

                  String json = "{\r\n" + //
                              "  \"imageUrl\": \""+ imgURL + "\",\r\n"
                              + //
                              "  \"description\": \"" + descricao + "\",\r\n"
                              + //
                              "  \"ra\": \"" + ra + "\"\r\n" + //
                              "}";

                  request.setRequestMethod("POST");
                  request.setRequestProperty("Content-Type", "application/json");
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

                  if (response != null) {
                        JOptionPane.showMessageDialog(null, "Sucesso apenas, mitou!");
                  }

                  reader.close();

                  request.disconnect();
            } catch (Exception e) {
                  JOptionPane.showMessageDialog(null, "Deu ruim: " + e);
            }
      }
}
