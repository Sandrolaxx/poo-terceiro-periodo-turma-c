package MARCELO_PILUSKI_POZZOBON.SegundoBI.prova;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;

public class ListagemRequest {
      public StringBuilder getListagem() {
            StringBuilder strListagem = new StringBuilder();
            
            try {
                  URL url = new URL("https://poo-exam.vercel.app/api/students");

                  HttpURLConnection request = (HttpURLConnection) url.openConnection();

                  request.setRequestMethod("GET");

                  BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
                  String line;

                  while ((line = reader.readLine()) != null) {
                        strListagem.append(line);
                  }
                  System.out.println(strListagem);
                  reader.close();

                  request.disconnect();
            } catch (Exception e) {
                  JOptionPane.showMessageDialog(null, "Deu ruim: " + e);
            }

            return strListagem;
      }
}
