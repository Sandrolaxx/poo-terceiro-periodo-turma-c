package SegundoBI.listas.lista3;

/* import java.awt.List; */
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Janela Principal");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // Atividade 1
        JButton atividade1 = new JButton("Atividade 1");
        atividade1.setSize(15,3);
        atividade1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                atv01(frame);
            }
        });

        // Atividade 2
        JButton atividade2 = new JButton("Atividade 2");
        atividade2.setSize(15,3);
        atividade2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atv02(frame);
            }
        });

        // Atividade 3
        JButton atividade3 = new JButton("Atividade 3");
        atividade3.setSize(15,3);
        atividade3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atv03(frame);
            }
        });

        // Atividade 4
        JButton atividade4 = new JButton("Atividade 4");
        atividade4.setSize(15,3);
        atividade4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atv04(frame);
            }
        });

        // Atividade 5 na atividade 6

        // Atividade 6
        JButton atividade6 = new JButton("Atividade 6");
        /* atividade6.setSize(15,3); */
        atividade6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atv06(frame);
            }
        });
        
        panel.add(atividade1);
        panel.add(atividade2);
        panel.add(atividade3);
        panel.add(atividade4);
        panel.add(atividade6);
        frame.add(panel);

        frame.setVisible(true);
    }

    public static void atv01(JFrame frame) {
        JOptionPane.showMessageDialog(frame,"Hello World");
    }

    public static void atv02(JFrame frame) {
        String nome = JOptionPane.showInputDialog("Qual é seu nome amigo(a)?");
        try {
            JOptionPane.showMessageDialog(frame,"Seja bem vindo(a) " + nome);
        } catch (Exception e){
            JOptionPane.showMessageDialog(frame, "Erro de exceção. Reinicie o sistema!");
        }
    }

    public static void atv03(JFrame frame) {
        int opcao = JOptionPane.showConfirmDialog(frame, "Deseja continuar?");
        if (opcao != 0) {
            System.exit(0);
        }
    }

    public static void atv04(JFrame frame) {
        List<String> jogos = List.of("Elden Ring", "League of Legends", "Valorant");
        String opcao = (String) JOptionPane.showInputDialog(frame, "Qual jogo deseja Jogar?", "Lista de jogos", JOptionPane.QUESTION_MESSAGE, null,jogos.toArray(), jogos.toArray()[0]);
        if (opcao != "LOL") {
            JOptionPane.showMessageDialog(frame, "Ótima escolha, abrindo " + opcao + "...");
        } else {
            JOptionPane.showMessageDialog(frame, "Péssima escolha! Infelizmente abrindo " + opcao + "...");
        }

    }

    public void atv05(Object numero) throws Atv05 {
        if (!(numero instanceof Number)) {
            throw new Atv05("Errado!!! Escreva um número");
        }
        // Continuação da execução do algoritmo...
    }

    public static void atv06(JFrame frame) {
        List<String> operators = List.of("+", "-", "*", "/");
        String operation = (String) JOptionPane.showInputDialog(frame, "Qual operação?", "Calculadora do Marcelo em JAVA", JOptionPane.INFORMATION_MESSAGE, null, operators.toArray(), operators.toArray()[0]);
        String primeiroNumeroString = JOptionPane.showInputDialog(frame, "Digite o primeiro número:");
        String segundoNumeroString = JOptionPane.showInputDialog(frame, "Digite o segundo número:");
        
        try {
            int primeiroNumero = Integer.parseInt(primeiroNumeroString);
            int segundoNumero = Integer.parseInt(segundoNumeroString);

            switch (operation) {
                case "+":
                    JOptionPane.showMessageDialog(frame, "Resultado: " + (primeiroNumero + segundoNumero), "Resultado da Operação",JOptionPane.INFORMATION_MESSAGE, null);
                    break;
                case "-":
                    JOptionPane.showMessageDialog(frame, "Resultado: " + (primeiroNumero - segundoNumero), "Resultado da Operação",JOptionPane.INFORMATION_MESSAGE, null);
                    break;
                case "*":
                    JOptionPane.showMessageDialog(frame, "Resultado: " + (primeiroNumero * segundoNumero), "Resultado da Operação",JOptionPane.INFORMATION_MESSAGE, null);
                    break;
                case "/":
                    JOptionPane.showMessageDialog(frame, "Resultado: " + (primeiroNumero / segundoNumero), "Resultado da Operação",JOptionPane.INFORMATION_MESSAGE, null);
                    break;
            }
        }catch (Atv05 e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Digite um número, por favor!!!!!!!", JOptionPane.ERROR_MESSAGE);
        }

    }
}