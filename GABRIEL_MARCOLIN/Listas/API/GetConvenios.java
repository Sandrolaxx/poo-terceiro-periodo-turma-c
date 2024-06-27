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
                    "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiIwVS93WDNsWGZWN2psRHZabXN1WnJNRmdYdDRjbDBicmhGVFBqU0N4dHh5aEtrTzNCWDhmdHVlRFNTRFVwKzQ4V0c5d3ZSdzJSeWtCc2JCbDArbkVQbjBJejJ6T0hJY05NVGVIcVlpMFpHUzROWG9SNll2cTd3MjNPQWJubEVzVytKRUUrS3VkaFV5SWZuZElHQzhCUEVVc2dSKytrSy9WYjROdktRSGhqMS9GWjZFRU53QUc3UG1mRVRLK25rTlZNK1BHZVVmeHk5MHpTRWI2Q2hqcVZWU3VGbTJ6R3o1OFE0YStpRE5IK1JxWXRuV01nYlVJSWFhdVZpSmhUbVpOK0JuUS9vNW5FTjUvZHl1ZnBXcGE3VDJKTE9UaEtkZXNxYnRkM3E1alY3RVlTd1lLK0swOTNGQVdJbHZNc3ZxZlBxSVpMekVLNWhROWcxSm5lY2F1RXFJaWJIbG9xWk5Pc1FUODRRanZQZ05paU05L3dVYzV6dTMxQzhkRHlxRmJsMGVzcDByN1pLWGRhV2JhQ0JTQXNrZjlUeFlIMGRSZUdHbSs0RC91WEU2OEFOWHdKVUVnVG1rdTgwUlNNV1ZoUXR3VWFpcWxVcE94YnI3akpFa1ptU3MvS1BkNzcvYTZUZmdVS3FjUGZiQ3FKWldwRGtBUVNnai9ra1ltU2J1REo1bmNpeit3dzNoWENUVkhmMnRDdnJrMS9TNm5HcEZjQ0JKdG16aU9IT25ldU94Y1VyMEhseUJhbTJFT3JYWHlVRnBpTWwyY09FVzJvOWlodldXWWJRPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiZDM2MTU5YjRiYjg1NDRiYWIzMjIiLCJleHAiOjE3MTk1MTI5NzUsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.OOkamsctXv3ZkCaxXeJp_hT1Pqj6yfTp4d_AX6LP27A");
          
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