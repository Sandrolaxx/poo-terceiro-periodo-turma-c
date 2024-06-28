package SegundoBim.Lista4sgBim;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        List<String> lista = List.of(
                "1. Listar Convênios",
                "2. Consulta de boletos");

        String resposta = (String) JOptionPane.showInputDialog(null, "Escolha uma opção ",
                "Opções",
                JOptionPane.QUESTION_MESSAGE,
                null,
                lista.toArray(),
                lista.toArray()[0]);

        switch (resposta) {
            case "1. Listar Convênios":
                listaConvenios();
                break;
            case "2. Consulta de boletos":
                consultaDeBoletos();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção invalida", "Erro", JOptionPane.ERROR_MESSAGE);

                break;
        }

    }

    public static String listaConvenios() {
        try {
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization",
                    "bearer  eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJSU3hkeXZlWHhtT0hRaStoKzVSM0h2MVBqa0N3dGs3dDcrZ3Rrd2w1M1lUTHRSZHNabnQxaHZlQnV3R29zRll5MVFTMWpOVjVKcEZkYkFWcUx2TnFRckdkN3ZaK3JZRkxNNWNlaE5jdVNPNnVUdmp5ZnkzUHZlNkRjR0ZSUERoZ3B0eDlYVVVudFRueFA3bzZDc1ZhdDVuVWVtb0haNmM5Q0RwbDN0WGJFeE1iazR0UXRpTmpHQ1o5VFdvYXpIazI4WUFwSHRLNzZhWmt1aEJjelFMb0I0TFVubnd3K1p6ZHJMZWE5NzV6Q0pxcU9JVkpjVEE0Z3c0RWJDTlBqRnNNM3hwUnZoS1BuUnhBMk1ITUxGa1hPMHFTNjh6aERZb0pFc0pCRFVjNDVCUElvSXFoRGlaSndPSHdBQzkzMkQ5em5KUUNtMlpydUNFajJsdHQ2L0ptY2YwaTd0S0RlbytTbUxLMGY5dlBDaCttbGNqU3FscWVZeVhFRTkwdWVFMU9DL1lQMDdhaXlCYitPRDZSaHZqQmtUOExYQU9QRyszYVRlVUVNN29BdXJhQnh6a3NpZ0ZMTzZ1YVJZQmNheTU1Yks4dlE5M29ZVVhhaWNBbzN2K0x4b1NXcmFENlpvTEc5RDBsNWJlWmlYdFJwekh0eFVwRjBVWE9QQVBES0EyZFo2RytOVlVRRERoTlJrVURYZmttV3ZIVFE3ZitWSkFrNGc2U283bEoyRjhDOFp1T3kyMnVQU3RETkV0MlY2eXkvempRU0d5RmNFMDFjRUNiQ2dtU2NRPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiMjgzODI1M2Y5M2JhNDlmY2I2ZTEiLCJleHAiOjE3MTk0NTc3MTgsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.cZqFqmoHsRIIKUEtzhA35bF7pTRKrnNmYTg0tGVqqqE");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();
            System.out.println(response.toString());
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }

    }

    public static String consultaDeBoletos() {
        try {

            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            String linhaDigitavel = JOptionPane.showInputDialog("Digite o numero do boleto");
            String json = "{\n" + //
                    "  \"barCode\": {\n" + //
                    "    \"type\": 0,\n" + //
                    "    \"digitable\":" + linhaDigitavel + "\n" + //
                    "  }\n" + //
                    "}";

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization",
                    "bearer  eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJSU3hkeXZlWHhtT0hRaStoKzVSM0h2MVBqa0N3dGs3dDcrZ3Rrd2w1M1lUTHRSZHNabnQxaHZlQnV3R29zRll5MVFTMWpOVjVKcEZkYkFWcUx2TnFRckdkN3ZaK3JZRkxNNWNlaE5jdVNPNnVUdmp5ZnkzUHZlNkRjR0ZSUERoZ3B0eDlYVVVudFRueFA3bzZDc1ZhdDVuVWVtb0haNmM5Q0RwbDN0WGJFeE1iazR0UXRpTmpHQ1o5VFdvYXpIazI4WUFwSHRLNzZhWmt1aEJjelFMb0I0TFVubnd3K1p6ZHJMZWE5NzV6Q0pxcU9JVkpjVEE0Z3c0RWJDTlBqRnNNM3hwUnZoS1BuUnhBMk1ITUxGa1hPMHFTNjh6aERZb0pFc0pCRFVjNDVCUElvSXFoRGlaSndPSHdBQzkzMkQ5em5KUUNtMlpydUNFajJsdHQ2L0ptY2YwaTd0S0RlbytTbUxLMGY5dlBDaCttbGNqU3FscWVZeVhFRTkwdWVFMU9DL1lQMDdhaXlCYitPRDZSaHZqQmtUOExYQU9QRyszYVRlVUVNN29BdXJhQnh6a3NpZ0ZMTzZ1YVJZQmNheTU1Yks4dlE5M29ZVVhhaWNBbzN2K0x4b1NXcmFENlpvTEc5RDBsNWJlWmlYdFJwekh0eFVwRjBVWE9QQVBES0EyZFo2RytOVlVRRERoTlJrVURYZmttV3ZIVFE3ZitWSkFrNGc2U283bEoyRjhDOFp1T3kyMnVQU3RETkV0MlY2eXkvempRU0d5RmNFMDFjRUNiQ2dtU2NRPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiMjgzODI1M2Y5M2JhNDlmY2I2ZTEiLCJleHAiOjE3MTk0NTc3MTgsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.cZqFqmoHsRIIKUEtzhA35bF7pTRKrnNmYTg0tGVqqqE");
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
            System.out.println(response.toString());

            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
