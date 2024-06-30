package LUCAS_EDUARDO_DE_LIMA.segundobimestre.prova;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class StudentService {
    private final HttpClient client;
    private final String baseUrl;

    public StudentService(HttpClient client, String baseUrl) {
        this.client = client;
        this.baseUrl = baseUrl;
    }

    public void listStudents() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "/students"))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                Modal.showError("Erro ao buscar alunos.");
                return;
            }

            List<Map<String, String>> students = JsonUtils.parseJsonArray(response.body());

            StringBuilder studentList = new StringBuilder("Alunos:\n");
            for (Map<String, String> student : students) {
                studentList.append("RA: ")
                        .append(student.get("ra"))
                        .append(", Nome: ")
                        .append(student.get("name"))
                        .append("\n");
            }

            JOptionPane.showMessageDialog(null, studentList.toString(), "Lista de Alunos", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | InterruptedException e) {
            Modal.showError("Erro de comunicação com a API.");
        }
    }
}
