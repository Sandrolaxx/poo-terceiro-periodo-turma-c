package LUCAS_EDUARDO_DE_LIMA.segundobimestre.prova;

//URL https://lh3.googleusercontent.com/a/ACg8ocJ5cXStdN7OtHeOmSLj2LYymR2r1nb6RSz9GFEbkIIzzNneWINh=s317-c-no
//RA 202311148

import javax.swing.*;
import java.net.http.HttpClient;

public class Main {
    private static final String BASE_URL = "https://poo-exam.vercel.app/api";
    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public static void main(String[] args) {
        StudentService studentService = new StudentService(CLIENT, BASE_URL);
        TestimonialService testimonialService = new TestimonialService(CLIENT, BASE_URL);

        while (true) {
            String[] options = {"Listar Alunos", "Criar Testemunho", "Sair"};
            int choice = JOptionPane.showOptionDialog(null, "Selecione uma opção", "Menu", 
                                                      JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                                                      null, options, options[0]);

            if (choice == -1) {
                System.out.println("Saindo...");
                return;
            }

            switch (choice) {
                case 0:
                    studentService.listStudents();
                    break;
                case 1:
                    String photoUrl = JOptionPane.showInputDialog("URL da Foto:");
                    String studentRa = JOptionPane.showInputDialog("RA do Aluno:");
                    String testimonialText = JOptionPane.showInputDialog("Texto do Testemunho:");
                    testimonialService.createTestimonial(photoUrl, studentRa, testimonialText);
                    break;
                case 2:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
