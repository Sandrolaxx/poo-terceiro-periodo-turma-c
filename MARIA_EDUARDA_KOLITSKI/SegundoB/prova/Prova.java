package MARIA_EDUARDA_KOLITSKI.SegundoB.prova;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class Prova {
    public static void main(String[] args) {
        while (true) {
            List<String> opcoes = List.of("Listar Alunos", "Enviar Testimonial", "Sair");
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione uma opção", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes.toArray(), opcoes.toArray()[0]);

            if (opcaoSelecionada == -1 || opcaoSelecionada == 2) {
                System.out.println("Saindo...");
                return;
            }

            switch (opcaoSelecionada) {
                case 0:
                    listarAlunos();
                    break;
                case 1:
                    enviarTestimonial();
                    break;
            }
        }
    }

    private static void listarAlunos() {
        try {
            String resposta = Site.listarAlunos();
            JOptionPane.showMessageDialog(null, resposta, "Lista de Alunos", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os Alunos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void enviarTestimonial() {
        String imageUrl = JOptionPane.showInputDialog("Informe a URL da imagem:");
        String ra = JOptionPane.showInputDialog("Informe o RA do aluno:");
        String description = JOptionPane.showInputDialog("Informe o texto do testemunho:");

        try {
            String resposta = Site.enviarTestimonial(imageUrl, description, ra);
            JOptionPane.showMessageDialog(null, "Testemunho enviado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Erro ao enviar o Testimonial: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}