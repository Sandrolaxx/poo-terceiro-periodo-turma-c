package Lista4;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvênioBoletoApp {

    private static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJ5Qk44QkE3WEdTTFg3bVhHRVpzbkwwOTlhdk8xaDhrZzRaa3IyNzQ5eFNyTTZoQVNLZjlJTzBsNFhaNmxJR1lxRjREN1VGaVI3RVRJNVhianB5ZmJqNXU5dEpBVWFpQnRHN2NhVDh5Z0ZWaFM0a3dvamJ0bXo1bEV4SGVQOVM2Q2JBZ3dScWErdWY4QTJOOWxFZWtMa0Z4ZC84VUxzR1JTRmxUMVpZUVZidzR3ckc4QWhnZVUvblZiUml6SkcveGlGcy84K0FjUHF1aExNVmhsSDJpZm1rV3hDREtoZDRRakx6ZTBjTm9vdW9mYjlXTHcvRXVvUnVTRFl2dXNTSk9aR1Izc1BoYmFOYm9GNEZsak84WUhtbVNRbEk0K0FCOHUrdDYzdGp2S2ZTcVpSVHowREhBZFlPK1RFUWRZNUFUN3VyZmdhOWJ5OXI2b0JZUkFSc1dZUnJTUXJleUJHRG1DM25vMTN4eFBkbVZYQ2ZGS2VNcGpoSUpmQ0J5SnBKMkgySVQxUUV4QzhraUhvWmh5WFNVekFub1RwMjY0OElqMVlBVnBMemxPcDUwYUtsOE1PcGNqeUVyWTByeDlwZGVYSVFaWktuaW1rVWtGaVFXN3RMUDl2VkI3UTdNSEpHTTBRSWpIK3lvMU16S0VmU3VBTjk4cFhsSnI5S3JRL1FhKzNMbUpybHl2VGV0TkNuMmhnNmVoVlNaZWtud1Vldlg2S1BKVU5lMWxwYWV1K1dUamtxRUlCR0tFSk8zTEhiNmVCUW4waWh0YzI4cmtXd1YyQ0tGZDZRPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiNzkzNjFkZWE1ZTcxNGJmMGE0ZTgiLCJleHAiOjE3MTk0NDcyMDcsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.ZStKI0GMVQ0mlcAs2wA9xFqq39c-tTvBvrl--jK-uIY";

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Listar Convênios", "Consultar Boleto", "Sair"};
            int choice = JOptionPane.showOptionDialog(null,
                    "Selecione uma opção",
                    "Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]);

            switch (choice) {
                case 0:
                    System.out.println(listarConvenios());
                    break;
                case 1:
                System.out.println(consultarBoleto());
                    break;
                case 2:
                    System.exit(0);
            }
        }
    }

    public static String listarConvenios() {
        try {
            
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions");

            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "bearer " + token);
            
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


    public static String consultarBoleto() {
        try {

            String linhaDigitavel= JOptionPane.showInputDialog("Digite linha digitaveldo do boleto");

            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            String json = "{\n" +
                        " \"barCode\": {\n"  + //
                        "   \"type\": 0,\n " + //
                        "    \"digitable\":" + linhaDigitavel + "\n" + //
                    "  }\n " + //
                    "}";
                    connection.setRequestMethod("POST");  
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.setRequestProperty("Authorization", "bearer " + token);
                    connection.setDoOutput(true);

                    try (OutputStream os = connection.getOutputStream()){
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

