package segundob.aulas.aulaseis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class QRCodeSample {
    public static void main(String[] args) {
        System.out.println(genQRCode(null, 20d));

    }

    public static String genQRCode(String token, Double amount) {
        try {
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/pix/v1/brcode/static");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Dados do json
            String json = "{\n" +
                    "  \"key\": \"testepix@celcoin.com.br\",\n" +
                    "  \"amount\": 2.55,\n" +
                    "  \"merchant\": {\n" +
                    "    \"postalCode\": \"01201005\",\n" +
                    "    \"city\": \"Barueri\",\n" +
                    "    \"merchantCategoryCode\": 0,\n" +
                    "    \"name\": \"Celcoin\"\n" +
                    "\t}\n" +
                    "}";

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJNaTlCa003bG5aTFVBZXRMV0IxQTN2ME1kSHE1SWx2ekFhRWo0TUY3eWIzNGpJanc3WTRqOVNiSWtpalBTaExwZE9qYzl3WUEvTnZXeHVaZVBJWXkwdjRNU243aThZbWFNOWlZQWV2TDVNVVl6TkNwWTNBOGgwOW5xTGRPeGdMbElvRGlSMXlWeGpUNTFPQXVEYzRrczBYdlAzQzdoTW5DT3JVTnJxOVR6Mzk1OE1mbGs1WUVQNzlwNERNakhGWWp5MUxMUXpuTzVrM2JrdUJrQUl1di81ZzRJSkJ6bUd4T1V0YStrN3ZEdkIxKzlic3NpSTV5Q3ZzeXl5SG9oQzdhbDNybU9MSEtkZkVZT2ZCZUZzckwybWh5TkcvUFRMOExkbldDZTEwc3MrZ3FzZDhUTzJUTHQ4MUhneGFGN2t0T2hERnRYM2djbkFwdEg0RnBQb3FjU2MvSWlJaHdEb3kzaWs1SGh0bEZuWTJmM2VjYjNTdHhXNGdGVm1vaTRqNXA1NmY2NzQvUHhwenBCeTY0cVcwNjFrQVhSS05RdG8vYndXTy9Hc0FBd1Y1UTIwejlDT29ubzZNQ3RJZ2Yvdy9RVXBHNGdwWFc3YXozd1k4WHhHRG5lbmdLWHRNQ2YxUXh5OTJIWmJ1U0R5NHFTSUFEWkthS09Pam1JM2tOY05QY2xaWVRSYWRWaDR3UkR0Ty95cHJITWc1SFVVVmpXTjBuU3F6UEMyVjhGVThpNjF6TTMzK3RiUlZyby9WUEwyUXFzQVdtS25PcUllQitOK2pZVWlXWWFnPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiMWUzZmMzZjI2NWZhNDI5MmI5MmQiLCJleHAiOjE3MTg5MzE1ODAsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.inxQokW2nUCpohPvPtbmF8bGf6v8GnH4yYMgaJHdev4");
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

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
