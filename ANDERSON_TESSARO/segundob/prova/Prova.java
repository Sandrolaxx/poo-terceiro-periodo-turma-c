package org.example;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class Prova {
    public static void main(String[] args) {
        while (true) {
            List<String> opcoes = List.of("Listar Alunos", "Enviar Testimonial", "Sair");
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione uma opção", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes.toArray(), opcoes.toArray()[0]);

            if (opcaoSelecionada == -1) {
                System.out.println("Saindo...");
                return;
            }

            switch (opcaoSelecionada) {
                case 0 -> listarAlunos();
                case 1 -> enviarTestimonial();
                case 2 -> {
                    return;
                }
            }
        }
    }

    private static void listarAlunos() {
        String reposta = HttpRequests.listarAlunos();
        JOptionPane.showMessageDialog(null, reposta);
    }

    private static void enviarTestimonial() {
        String url = JOptionPane.showInputDialog("Url");
        String descricao = JOptionPane.showInputDialog("descricao");
        String ra = JOptionPane.showInputDialog("ra");

        String resposta = HttpRequests.enviarTestimonial(url, descricao, ra);
        JOptionPane.showMessageDialog(null, "Testemunho Enviado");
    }
}


