package segundobimestre.prova;

import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ProvaTest {
    private static ApiConection apiConectionListarAlunos;
    private static ApiConection apiConectionCriarTestemunho;
    public static void main(String[] args) {
        try {
            createApiConections();
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        loop();
    }

    private static void createApiConections() throws MalformedURLException {
        URL urlListarAlunos = new URL("https://poo-exam.vercel.app/api/students");
        apiConectionListarAlunos = new ApiConection(urlListarAlunos);

        URL urlCriarTestemunho = new URL("https://poo-exam.vercel.app/api/testimonial");
        apiConectionCriarTestemunho = new ApiConection(urlCriarTestemunho);
    }

    private static void loop() {
        while (true) {
            String option = menu();
            if (option == null) return;

            switch (option) {
                case "Listar Alunos" -> listarAlunos();
                case "Criar Testimonial" -> criarTestemunho();
                case "Sair" -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Default");
            }
        }
    }

    private static String menu() {
        List<String> options = new ArrayList<>(List.of("Listar Alunos", "Criar Testimonial", "Sair"));

        return (String) JOptionPane.showInputDialog(
                null,
                "Escolha um opção",
                "Menu de Opção",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options.toArray(),
                options.toArray()[0]
        );
    }

    private static void listarAlunos() {
        try {
            String result = apiConectionListarAlunos.get();
            JOptionPane.showMessageDialog(null, result, "Lista Alunos", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void criarTestemunho() {
        try {
            String imageUrl = JOptionPane.showInputDialog("Image URL");
            String description = JOptionPane.showInputDialog("Descricao");
            String ra = JOptionPane.showInputDialog("Ra");

            apiConectionCriarTestemunho.post(imageUrl, description, ra);
            JOptionPane.showMessageDialog(null, "Tetemunho enviado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

// https://avatars.githubusercontent.com/u/106183764?v=4
// Goostei bastante da materia, a melhor até hoje, com ela consegui aprimorar muitas coisas que ja conhecia e aprender bastante coisas novas
// 11361
