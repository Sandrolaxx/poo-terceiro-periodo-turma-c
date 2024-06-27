package segundob.listas.lista42;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String[] opcoes = {"Listar Convênios", "Consultar Boleto"};
        int escolhaUsuarip = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Escolha Usuário!!!",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        if (escolhaUsuarip != -1) {
            if (opcoes[escolhaUsuarip].equals("Listar Convênios")){ 
                // como sao muitos cortei em 4, descomente par ver todos
        
                int tamanho = listarConvenios().length();
                
                // Calculando o tamanho de cada parte
                int tamanhoParte = tamanho / 4;
                
                // Cortando a string em 4 partes iguais
                String parte1 = listarConvenios().substring(0, tamanhoParte);                
               // String parte2 = listarConvenios().substring(tamanhoParte, 2 * tamanhoParte); 
                //String parte3 = listarConvenios().substring(2 * tamanhoParte, 3 * tamanhoParte);
                //String parte4 = listarConvenios().substring(3 * tamanhoParte);                
                
                JOptionPane.showMessageDialog(null, parte1);
                //JOptionPane.showMessageDialog(null,parte2 );
                //JOptionPane.showMessageDialog(null,parte3 );
                //JOptionPane.showMessageDialog(null,parte4 );


            } else {
                String digitavel = JOptionPane.showInputDialog("Insira a linha digitavel");
                JOptionPane.showMessageDialog(null, consultarBoleto(digitavel));


            }
        } else {
            JOptionPane.showMessageDialog(null, "Você não escolheu nenhuma opção.");
        }
        
    }
    public static String listarConvenios() {
        try {  
            // tem que ter try catch
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions");
            //criando conexão HTTP para a URL especificada
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //config método da requisição(GET)
            connection.setRequestMethod("GET");
            connection.setRequestProperty("authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJDUWM3cjIvcGQ1cVBHTElCbjdZak5lWGx0bTJCWDk5VCtLZlJsdWF6MDVKQjBVcnYvV3BMeUxmTjRqMGZmYkIrbWJGblordVpKRVk3M0kwUE9CUUJNQjhQdGtRbjNkK2ZOTWJNcXZ3UGFwNjZkUnhsekdqbEZtRC9ycFRSYzVSYlBNN2x4dnk5eXB3V1hhdm4rK3ZWT0lFTXFoWXh6VmxjaWR3UENaNCtjNlZFU05JbXNoTXhBRUg1OEVIZW9CcnhDaUNCZ29BMXczOHBmdVVLZTVCa2tFK1ZTVUNrc3VpMDA0QmU3d1JHM2tYYW1kZmNvRHEzVnY0NG9WVTVFV3h5SWVGRzRlTW55ekJFMmFleWw4ZTJOMEM4THlqK1ViblVqQmI4Qlo5d2o3cGRWaHNYUWxob0RzTWFkTGd2YUVLV0R6Um16eUJudTc5by9qMEplK2IxQms5V2ZJZjVsYkRtMnNkcmNJMEU2Q3AzUVlOK2NNZC9EUXlSMEIxTEh2bU15M2R2L1pCYmo4dVYrVGR0aGVEandTSFRsaFQ5c3N3c1hkZHNPMUhJd1Z3SGJvVUZWZEMwOVRhUEwvdTJUZjN5Z1hOclR0eGp1K3BSY21LanVMVXp4YllvSTVXOFUxUGxhY1NCcm16OUp3bHhvY2JNRG5mckc3dzJocFpzNmwranhRQ2VFOWszVklPRWxUenRqSDJ5Z1BnVDRTSjNkczdHMHdUdjY5Lyt1bnZtek4reldwZGQ2OEIzUElCdVR5Q01NUjl6blgyWDFGdmw2M0VUR2FJQWxRPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiZDIyZTBmYTVmMTljNDY0NWI4MzUiLCJleHAiOjE3MTkxNjk2MDksImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.ATrzNhRNm5nsSdT9lGrycoWefFHtJpo2kVSRn1hY3RE");

            //lendo response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            //fechando a conexão
            connection.disconnect();

            
            // Extrair os dados do JSON usando expressões regulares
            Pattern pattern = Pattern.compile("\"(\\w+)\":\"([^\"]+)\"");
            Matcher matcher = pattern.matcher(response.toString());

            // Mapa que irá armazenar a chave:valor do json
            List<Map<String, Object>> lista = new ArrayList<>();

            while (matcher.find()) {
                Map<String, Object> jsonData = new HashMap<>();
                String key = matcher.group(1);
                String value = matcher.group(2);
                jsonData.put(key, value);
                lista.add(jsonData);
            }
            // Exibindo os dados da moeda
            StringBuilder sb = new StringBuilder();
            sb.append("Convênios ---");

            for (Map<String, Object> map : lista) {
                //System.out.println(map);
                
                if (map.get("Nomeconvenant") != null) {
                    sb.append("\n---");
                    sb.append("\nNome do convênio: " + map.get("Nomeconvenant"));

                }
                if (map.get("Tipoconvenant") != null) {
                    sb.append("\nTipo do convênio: " + map.get("Tipoconvenant"));

                }
                if (map.get("statesconvenant") != null) {
                    sb.append("\nUF do convênio: " + map.get("statesconvenant"));
                    sb.append("\n---");

                }
                
            }

            
            
            return  sb.toString();
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
        
        
    }

    public static String consultarBoleto(String Digitable) {
        try {  
            // tem que ter try catch
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");
            //criando conexão HTTP para a URL especificada
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();


            String json = "{\r\n  \"barCode\": {\r\n    \"type\": 0,\r\n    \"digitable\": \""+Digitable+"\"\r\n  }\r\n}";

            //config método da requisição(POST)
            connection.setRequestMethod("POST");
            connection.setRequestProperty("content-type","application/json");
            connection.setRequestProperty("authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJOTE5kaDJZdTRvckNiOHJYZGp3V2c0UGplbGtGdHN2cVdiazZ5Wms2cFdHclhSZ2lxQnFWM29Ld2QrSWlRY1d5ZkNkbEpmWEdrY3Z1cXFuYkFMUVFlNnZSaUVGVmtqaWpKTXRhNW8wK1A3Q0sycGV5cmVFa3o2d3BCSEp0YnduWjlNQlpYTjBvZ0llRHhnMXN0RnJ2YXBWeUd1OGdFd2ZDZUFvcGxjQlg5bytlRG5XNDl4UlIwNlMvbCtQaGRKaDNNejVLcGIvclhKZW9ZaGpHZjNLWlhKUURtbTRxQS9vcG1TR3JsUjRjOENaaTQwaVhoMExSNTVsNkFBRFp2dUlWNUVITmNsdFNNUUkvU3MrYXFwM0dDUDVqbWpHZCtyYjV4ZDVOQ3dueCt5YU02ZXYwcWlBMmJ5ZVM3WnB3b0VwMGdocUJlbXJlOTZRM09VbkJsMEZ0ZklTKzN4dHFxc0c5WVpBenAyOWdmTkM5REpYRStjRXRaU3g4dmlnd1hXcE9Wa1BWN0YwUytuM3M4MDFBOW9pd1VyLzhwY0F6OUFBUkpidFFRUWY3R3F4U1NOMlBQcGphU0IxWXZ6dUIzTGEzdVVIZ3RPTTA1MWwwNFJpb3ZDeTdQUmcvRjUzeENaWXRvUU0zV2kwOHlNY3VEWXNEZC9yTDFXcjJXZjhVODM3MXhESGdyaElzR0NrYlBXOUtBVVVTTkUyaFpIYm5YWjZJc2xLazZOYi9vU2xBM2lGR2tTR1NBTUU3RWJEVzJFK0VqS3NXUjN5bXBjTXNDRW9SbWhRVzFnPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiYTYxNDQ1MGYzZDM3NDRlNzk3YWUiLCJleHAiOjE3MTkxNzIyMTgsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.OgJpiVDEGmBAQA85UP46qed9kwlBYFCYucz3CRDl4XE");
            connection.setDoOutput(true); // mandar coisas pelo json

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            //lendo response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            //fechando a conexão
            connection.disconnect();

            
           // Extrair os dados do JSON usando expressões regulares
            Pattern pattern = Pattern.compile("\"(\\w+)\":\\s*(\"(?:[^\"\\\\]|\\\\.)*\"|\\d+)");
            Matcher matcher = pattern.matcher(response.toString());

            // Mapa que irá armazenar a chave:valor do json
            Map<String, Object> jsonData = new HashMap<>();

            while (matcher.find()) {
                String key = matcher.group(1);
                String value = matcher.group(2);

                jsonData.put(key, value);
            }

            // Exibindo os dados da moeda
            StringBuilder sb = new StringBuilder();
            //Formatar moeda

            sb.append("Dados do boleto");
            sb.append("\nAssignor: " + jsonData.get("assignor"));
            sb.append("\nsettleDate: " + jsonData.get("settleDate"));
            sb.append("\ndueDater: " + jsonData.get("dueDate"));
            sb.append("\nendHour: " + jsonData.get("endHour"));
            sb.append("\niniteHour: " + jsonData.get("initeHour"));
            sb.append("\nextSettle: " + jsonData.get("nextSettle"));
            sb.append("\ndigitable: " + jsonData.get("digitable"));
            sb.append("\ntransactionId: " + jsonData.get("transactionId"));
            sb.append("\ntype: " + jsonData.get("type"));
            sb.append("\nvalue: " + jsonData.get("value"));
            sb.append("\nmaxValue: " + jsonData.get("maxValue"));
            sb.append("\nminValue: " + jsonData.get("minValue"));
            sb.append("\nerrorCode: " + jsonData.get("errorCode"));

            
            return  sb.toString();
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
        
    
    }
}
