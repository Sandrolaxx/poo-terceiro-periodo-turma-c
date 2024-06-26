package API;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetConvenios {
    public static void main(String[] args) {
        try {
            getJsonData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getJsonData() {
        try {
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization",
                    "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJ0VGZBWHFHVjBpcjRSY0dma3h3V3E3ckhlSFNBczVXN1ladmcyalNLZ3FyTWZxTUNPY2xtVE53NmxHK2FKY2dySHF5bmJHQlprMUZvZ0tpMXJaVzhOVFp1ak1Ca0M5L1czdXNqc1F1cHZ3WUJRWDdWOXJwb3lKdXlwSkdLV0k1bGVJa3ppVmNuQldTL0NKdktVYlE3UUlGUTFQNXhGWW5yeUI4RFRpbnRrZVpBb0Y2ZXM4a1hMVUFDS0NWUjA1NGRuakNUdjM1bGhjWHhSWEw0QytRblJyWEQxQVRPeVVaREQxTnYxSDV5YnNIL3dRTXdQUGJmc0JOT3V6TzRPdnpGcG1DcENnUXdTTmw3MXkyb1ZicUova0ZjZzRtOU5zNERxK2tiQmVXdGFrbXlpZGtPT2JFbnVLS2JnSmxBNGREbGZjMnpWZDNJc0NLbWhKUUZQR1ZZcXFuYUt1cE1SSklja3l2TmYyZmphSCtoV1lZR21ISENKRkdmWEYzTlVlMElEaUN4NEtWcEdzei95MUFHZWpKVlpCQyt3WERCM2lNK21WSmo5bkFIcG92RE1tVFdXc0V0cXVRNDhxVURXZXcrRU1BNnovdWFSdm9ZVTVNSEVDQmVrbUFtUDAvandqa3NDY05qc3pHVzBlR3JSOStQN2tOVTdJQXpaMkd6TUwvMFBPSzFDbjg2NlNscVJjbTUwdjg1dlpOV1hGRk5GZ0VFWS9xWnczWkU0RmNjcE1IMktJcnR1NDFvUzhoRzFnNzhKMkk2cWE1VXh4QUpBT2FIb2NtZy93PT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiYWUzYmJiYmIwMjYxNDFlY2JkYjUiLCJleHAiOjE3MTk0MzAzODAsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.sVoZSdaXNendG5T11ssZyG-WDQCccC_BX_RJvaxA8jc");
          
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            //fechando a conexão
            connection.disconnect();

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}