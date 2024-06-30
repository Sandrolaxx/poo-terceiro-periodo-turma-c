package EDUARDA_GABRIELI_KACPRZAK.segundob.prova;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ListarAlunos {
    public static String listarAlunos() {
        try {
            URL url = new URL("https://poo-exam.vercel.app/api/students");
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

            String message = response.toString();
            System.out.println(message);

            JFrame frame = new JFrame("Lista de Alunos");
            JOptionPane.showMessageDialog(frame, message, "Listagem de Alunos", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }

        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo deu errado. Tente novamente. :(");
            return null;
        }
    }

}