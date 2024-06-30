package GABRIEL_PALUDO_FRANCESCHINI.SegundoBImestre.prova;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Prova {

        public static void main(String[] args) {

                List<String> options = List.of("Request aluno", "Testemunho");
                JFrame frame = new JFrame("Prova");
                frame.setSize(300, 250);

                String selected = (String) JOptionPane.showInputDialog(frame,
                                "Bem-vindo. Escolha a opção que desejar!",
                                "Prova",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options.toArray(),
                                "Escolha uma opção.");

                switch (selected) {

                        case "Request aluno":

                                try {

                                        JOptionPane.showMessageDialog(
                                                        frame,
                                                        GetStudents.getJsonData(),
                                                        "Alunos",
                                                        0);

                                } catch (Exception e) {
                                        e.printStackTrace();
                                }

                                break;

                        case "Testemunho":
                                String fotoUrl = JOptionPane.showInputDialog(
                                                frame,
                                                "Insira o URL da foto",
                                                "URL da foto",
                                                JOptionPane.QUESTION_MESSAGE);

                                String testemunho = JOptionPane.showInputDialog(
                                                frame,
                                                "Insira seu testemunho",
                                                "Testemunho",
                                                JOptionPane.QUESTION_MESSAGE);

                                String raAluno = JOptionPane.showInputDialog(
                                                frame,
                                                "Digite o RA do aluno",
                                                "RA",
                                                JOptionPane.QUESTION_MESSAGE);

                                RequestTestimonial.requestTestimonial(fotoUrl, testemunho, raAluno);

                                break;

                }
        }
}
