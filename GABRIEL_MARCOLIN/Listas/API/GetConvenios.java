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
                    "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJDYUVJNDdkVlR1WXdhV2Noazg1ZE9lYlU4Q09SWlEvRW1aRWhYMTdKMDFyU05nQmo0Z1E0ODJlV3A4UEpsNG14OTRNTHA2TVlqdy9OVitqa0VhU0N1ZlZ5T1VzQ05kKzNDMUdIeCtOQnFHMzE3NWt3MHcvenVwZ3hYbzcwcDlFeWYwZVJxTjVaSVFuQXJCMlh4b01iZXROR0RaaDZad0xwVndwcktXS1ZXSGdlc29nMzVHZUlURWc5OHpjU0hHb25IcVlRbzJ0YzVacFFKWWJVLytlaEUxZEhSODJEMk43bTU1NWFTSWlkcUJwV3pRKzRXcUdLVkpZUDN4cEcvWkkwbElyU2p6aVdhUnliVWU3R2ZjVGdaZENYTmNoWHhDRENodWdTcFlTNkUyMVlFS1VFQWhDcWxYSUNMeWRBNmhGa2tOcHZDZmc4NVBjMFM0NVo2dzI2LzJ6eFBkb3h6SU1hVFhoRGoyVjZKZXdUTG4yWitsbnN1L3VuL3ZLdkRmd29mU3E4OWlQYTJnTnRjVlI2djNzSVR1MXAyL2VIYXdiSFl5WWxLdzBCRTVlNjVxZk9zKzV3QVA0VWhybi9Fbk1QYy9DdW8yYlRrL0pmdFYwSkszYzBWSEUxelR3N0NYU2RGNlhDdDUwOVhvRXJpd2QvMTRPVEFzM2hTZGo2MXBzV1hNODNzdmdHdVdJbGNhdkpmNzJYbFlCSTdMeGFWZXcwSUNualBCcmZLK3pKdXZuNCs1bTA5UkV1TnpJT21lZmhFdXRDd3Jjb3BjRnRaOHhTMUppVG1RPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiNDI0NzZiOWQ4OWVmNDIxZDgyYWIiLCJleHAiOjE3MTk1MTU4NjIsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.hdhuRmjfnSL684pmEoavCXjpVPfIsO0KRtLenxjxlxE");
          
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            //fechando a conexão
            connection.disconnect();

            return quebrandoLinhas(response.toString());
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    private static String quebrandoLinhas(String response) {

        StringBuilder builder = new StringBuilder();
        boolean entreAspas = false;

        for (char c : response.toCharArray()) {
            builder.append(c);
            if (c == '"') {
                entreAspas = !entreAspas;
            } else if (!entreAspas && c == ',' || c == '[') {
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}