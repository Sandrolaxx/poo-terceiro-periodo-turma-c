package LUCAS_EDUARDO_DE_LIMA.segundobimestre.prova;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class TestimonialService {
    private final HttpClient client;
    private final String baseUrl;

    public TestimonialService(HttpClient client, String baseUrl) {
        this.client = client;
        this.baseUrl = baseUrl;
    }

    public void createTestimonial(String photoUrl, String studentRa, String testimonialText) {
        try {
            Map<String, String> testimonial = new HashMap<>();
            testimonial.put("photoUrl", photoUrl);
            testimonial.put("studentRa", studentRa);
            testimonial.put("testimonialText", testimonialText);

            String requestBody = JsonUtils.toJsonString(testimonial);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "/testimonial"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 201) {
                Modal.showError("Erro ao criar testemunho. Código de status: " + response.statusCode() + ". Resposta: " + response.body());
                return;
            }

            Modal.showSuccess("Testemunho criado com sucesso.");
        } catch (IOException | InterruptedException e) {
            Modal.showError("Erro de comunicação com a API.");
        }
    }
}
