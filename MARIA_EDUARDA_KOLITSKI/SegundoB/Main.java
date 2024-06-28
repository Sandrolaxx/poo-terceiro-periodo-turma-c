package SegundoB.Lista_4;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJvaHorbnRXMG1vb1ZCbjV1Q1ZCMHVTSmhyNWVCaWpkcTUwbFg0NjI4Ty9mS1RHR0tnU1FvQzcrK1QxK1pyWXYrR21RN1pzMnUvZTd3c0o0RTFIWmtnR3dmbUtHU0ZPK1NBcENlSGoxRTgxU0s2U0NPQjNwYVhkUVNleUNZVDlpeVN4S0RucnNjVzRGZjhESjFhdnZUeURyaVFPYjgxL1lHdWV5MFBwWVA0ZG8rWkpTQXZ6WnpnTXJsY1dQZGdTS1ZRQ0NVSWpXeEtWRUF0TzRoMlNadTVndHpCR082ekpsdWxyVzh3ZTdYMVplV3NwKzRVNFZZUzZWdDJ2VjlRcXVDakJXMmxaY2pGRXZkUGFoUmNjalNqNEtNSkhuNFVBQUN2ZzNKcWRyanVXaEZQWkZZa0UzMXRwMHZzQklKTlZGdjhod3plUGZhN3R2WXdxSzNlNVdvejd3UlVncVYzQUxZOC80cU1vOXErU2JURE1kTGsySUtLQVB1SlJZRUZDWWNFMG1PdkJER2Y0R0tRemVsYVpOYzlUU0RiajlJMzM1TUlDZVNMZmhFZkVnT044dURQaHIxWGN6V3IzK3lOamxCY3RoL3Y2c3E1b3RvMVBIMkRhdFp1WnVuNVdFZ2FWdHlHNS9pdkRDS3lQeDUyMGxWT1NhYUtWUkxKSW4rTlVJVEIzcnVoTEQ0Z05oenZMSEh5TXU0RUhGdlFjTUdPQVBlcUk2UGtTc01uN0Q3OUdnYXlydm9HVWUwVDdkS3NmT2ZyZWFRaGN6cUZpckdSY082K0czQ1NnPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiNWNjYWNkOTg0ODVhNDhmODgyYTMiLCJleHAiOjE3MTk0ODM0ODYsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.YCbTH9H_xbs9KN_032HQ8SK1vL0BsXx03lEcljUi3o8";

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Listar Convênios", "Consultar Boleto", "Sair"};
            int choice = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    listarConvenios();
                    break;
                case 1:
                    consultarBoleto();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    private static void listarConvenios() {
        try {
            URL url = new URL("https://developers.celcoin.com.br/reference/obtenha-a-lista-de-conv%C3%AAnios");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + TOKEN);
            conn.setRequestProperty("Content-Type", "application/json");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                JOptionPane.showMessageDialog(null, content.toString(), "Lista de Convênios", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao listar convênios. Código: " + responseCode, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private static void consultarBoleto() {
        String linhaDigitavel = JOptionPane.showInputDialog("Informe a linha digitável do boleto:");
        if (linhaDigitavel != null && !linhaDigitavel.trim().isEmpty()) {
            try {
                URL url = new URL("https://developers.celcoin.com.br/reference/pagamento-de-contas-2");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Authorization", "Bearer " + TOKEN);
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setDoOutput(true);

                String jsonInputString = "{\"linhaDigitavel\": \"" + linhaDigitavel + "\"}";

                try (OutputStream os = conn.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }

                int responseCode = conn.getResponseCode();
                if (responseCode == 200) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String inputLine;
                    StringBuilder content = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }
                    in.close();
                    JOptionPane.showMessageDialog(null, content.toString(), "Consulta de Boleto", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                    String inputLine;
                    StringBuilder errorContent = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        errorContent.append(inputLine);
                    }
                    in.close();
                    JOptionPane.showMessageDialog(null, "Erro ao consultar boleto. Código: " + responseCode + "\nErro: " + errorContent.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Linha digitável não pode ser vazia", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
