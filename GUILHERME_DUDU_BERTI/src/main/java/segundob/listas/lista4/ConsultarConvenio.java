package segundob.listas.lista4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsultarConvenio {
    public static String getJsonData() {
        try {
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJyRlh3cUJBZHd3dzN3UFJEMHNCbWRtdTdBTmJnei9FV2xNcU1KMis1SnJIaTJFc213azZZS3N0V09lSklaNndFV2RQTTlndHJFb1V3ek1rTGZLVFZ5dldCTExFcEN6TVlIMFc1V04xZE5VZkx4QW1XaERrYWp0NEZiSi9JT24wTWFLcFl1S0xueWpqRzBxd2x1NmRUMFQ1cUZwd1BHQjlUclNsYjFEMFczbjZHaStRSnlWdGhTL1JUa21mV3NHREZXakpwOFZpNlFuOVc3eFhiQjlxYU9COGZaa3BkeGJmR0E2MDRhTWJZT3dOQVAzTVlxYVpRekRQdlNXRHIwQWEwRHpobWpuWEFjZUhnN016MGFDUW9VL2IyZEwwYm1wK0k0VW1yZloxM3VwU3FsU0R1azYzZlJlazRHVUozdlZpeEFuRlprL1AvMmlxQ3VzVFpkbDJ3UEVQN0x1eHJmMHpQcVp6NkRGbHlONXZrU0ZYckg3ZVFWQWRmcHllM3lBQ09wcHFDT3JFb1h1bG9jSG5QN3hIZ3JIWG9PUTJmTFprcjFNM0NlQTVnbkdVSERyQ05iR3IvNmw0NVE3RmFLazEwV3lkNjJqaGlOaXpVajRTeFZEalljMG4vL2pjaHBBbkdZSm1NcFVmQlFXMDBOSXRSZ2kyNC9wdjRDcHNaSW5ES01EaHVhUVo1Q1hOZ1JsQWlRdU9RaHYyUzZJRWlsbFQvckk2NzdwR3hLQlRQRHMyVG9uZDFkWGZBdTRvWktVSjF3bXpHa0ZDdzlRTXk3QVRnSVp0MHRBPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiMzRjOTEzODY5ODFlNGEzNWFjY2IiLCJleHAiOjE3MTk0ODI1OTQsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.sxaAkJJDOB4W-4pMyTSulIv-6Q1hZxQ0DWfNVBhmmSw");
            connection.setDoOutput(true);

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
        }
        return null;
    }
}
