package segundob.listas.lista4;

import javax.swing.*;
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
            connection.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI0MWI0NGFiOWE1NjQ0MC50ZXN0ZS5jZWxjb2luYXBpLnY1IiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6InRlc3RlIiwidGVuYW50X3VzZXIiOiI1UkJZalRsZnVHNlphazF1aWJwNTZJai9JSlI3aURQRVllU3Z2ckUvMU40QW9Edkdvc244Zm82NHovbFQ5Q0ZETUFrSDg5RDgycU9pU0NoTkc5WWZVWkI5c1VzQmFUci9PVGJlSmJmVk9WTHNYdHZVVGQ3clhwTmtnTFJGUi9FTEplbSt5aFZ6LytENSs1WjcvRzVpcE5BSVJUSzBmOWdOZkhObUpVbzJoQVFrekNPbTAxclRYM1J4UnV4ZVNBQm1zUm9aOWtDL1VLUjFDbmhOVjVnVFowREdHV1Jsd0cyWE1XWjYvb0pYa2xURlRkbFF6QUd5bkNNMWNtdHZPK1JuNHNtTCsvMVArNG5mb0ovV2x0czRkaHYwb2drUHMzTmQwQ085U1hpK0I5a3VhZUJ6ajMxcHFSKysvbnBUQmdmWWFzRmFqMUJFNkdGU25zeUlDZW1IUHNtaEtVNGlmTnZtN1gwMVhvL1FyTjhwQVVJK29oTUhjSEJmRVB5Q1F6K3IxcS9FRU0ySVpkT0FxVnlHWHBjYWVWbEdpbHFSMHcvZjZPUUJDME8vRUVYY2M2Kzljd09KREZCcUR0bFBGNnFvQVVNcU83VjdLUUk4QW9zN0F6RStaQzhERURNRVQ5UkR1d3BtSm5BTGRWNjVGamQwQU9GWVAyQi9NOGZuZWladFJjZnJicUcvRmdsSEk3eHUycDdHQ1F0UkZNR0lVMGxIMXFzQ3I2U0l6aURadjNvUmpxbU02SjdLQS92R2EwbU9WZjUyVGRtVFYwTnhsRU4yTTVaRyt3PT0iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3VzZXJkYXRhIjoiYTdkNWU4OTczMjJlNGI4NWJjZTgiLCJleHAiOjE3MTk1Mjc1NzEsImlzcyI6IkNlbGNvaW5BUEkiLCJhdWQiOiJDZWxjb2luQVBJIn0.luCMCmeMDkSF6yhUw215Ldnif1_U4P6aL4x4DAhJOD4");
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
            JOptionPane.showMessageDialog(null,
                    "Erro ao verificar os convênios.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
