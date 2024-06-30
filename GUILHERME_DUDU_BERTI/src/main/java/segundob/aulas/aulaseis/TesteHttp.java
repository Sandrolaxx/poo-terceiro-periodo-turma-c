package segundob.aulas.aulaseis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TesteHttp {
    public static void main(String[] args) {
        try {
            System.out.println(getJsonData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getJsonData() {
        try {
            //URL alvo da request
            URL url = new URL("https://sandbox.openfinance.celcoin.dev/v5/transactions/institutions");

            //criando conexão HTTP para a URL especificada
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //config método da requisição(GET)
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiJTQUdWY3RyUXpFZW56R2pTKzltNUc3WVdjMjA4emFRMEk2Sm1wOWZJREhURi9lb2JpcXpGVTVnTHlLUGxuQUZBdnh5WlpTN0hJZ0RWWjNacHo2Z0VMSENkSDEwL01tY3NaZFI1TXpXd0R2b1hhUi9IMWtpTmJyUWUwa3dNZ0ZMUC9XZUlOVC9CendFVXp2QmtraU5sSnVrL3RYVEdtV0VuNUVxZVRrc2swUVlLcVBScDd3S1FGaDMwUXoxV0IvVS9IOERLYksyNUxxbFhaUzdSMlhVcFFPYmw4Q3UvcWNYREZ2bk5nZVZwdVNqNTFIU3k4UHdHMkRrWVN6d3JXbVhXaG00dEMwQmFwcDQ2eWJ3RGNLZTY3d1lWVTNoS1VTTGs4Zi9NVVhBb0gveThLUkhXeTJWVkJmRDIrZHI3Nm5RVytKaUFGOHJKTWgyODVHTVNZRUFyY3RTZ1lIKzVFZ3BXL3hEWWpiTnNzZ1hnTGpoZmtZVkZFVE80VmxFaDYzS0dIdHBudjlRajVDTmEwdEtUbUFnZ0Z2UkV3c0RWcXlwYUhOakd4VDE5eG9mTlA3NUxDRVYzaENQRXUwcjVuemNhRllLakxpc1M2amIvQkh0RUw3Tk9vYjBTcnc3Znp5bHF5dlYwY3lWVzVQVWhTTWtrVENFWnlyRzhkUENWNjhSQU52VFpCZ2MrNXVKN0hnNk5DUTg3M1hsTnFiSkxvY2hpditLWFRjMmpWRkx3TkZqdU5rVUdVbCtnNHJoK051aFhtWDkyNEova2MyWTg5UU9SaWQveVlRPT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiN2ZmNTdkNTZjZDQ3NDdjYjkxNDAiLCJleHAiOjE3MTkzMjkxNTUsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.z0s8bkqnOwZ4O-KHXxT8RQbWmTCbt5153HsG6GfDF94");
            connection.setDoOutput(true);

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

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}