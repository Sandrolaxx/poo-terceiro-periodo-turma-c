package SegundoBimestre.ATV3;

import java.util.List;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Atividade 1:");
        atv1();
        System.out.println("\nAtividade 2:");
        atv2();
        System.out.println("\nAtividade 3:");
        atv3();
        System.out.println("\nAtividade 4:");
        atv4();
        System.out.println("\nAtividade 6:");
        atv6();
    }

    // ATV1
    public static void atv1() {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!");
    }

    // ATV2
    public static void atv2() {
        String nome = JOptionPane.showInputDialog("olá, qual é seu nome?");
        JOptionPane.showMessageDialog(null, "seja bem vindo, " + nome);
    }

    // ATV3
    public static void atv3() {
        int continuar = JOptionPane.showConfirmDialog(null, "deseja continuar?", "confirmar",
                JOptionPane.YES_NO_OPTION);
        if (continuar == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "você clicou em continuar");
        } else {
            JOptionPane.showMessageDialog(null, "você clicou em não continuar");
        }
    }

    // ATV4
    public static void atv4() {
        String[] opcoes = { "opção 1", "opção 2", "opção 3" };
        int escolha = JOptionPane.showOptionDialog(null, "escolha uma das opções:", "opções",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        if (escolha >= 0 && escolha < opcoes.length) {
            JOptionPane.showMessageDialog(null, "você escolheu: " + opcoes[escolha]);
        } else {
            JOptionPane.showMessageDialog(null, "você não escolheu nenhuma opção");
        }
    }

    // ATV5
    public static void atv5(String erro) throws Excecao {
        throw new Excecao(erro);
    }

    // ATV6
    public static void atv6() {
        List<String> operacoes = List.of("somar", "subtrair", "multiplicar", "dividir");
        int operacao = JOptionPane.showOptionDialog(null, "escolha uma operação:", "calculadora",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, operacoes.toArray(),
                operacoes.toArray()[0]);

        if (operacao >= 0 && operacao < operacoes.toArray().length) {

            String input1 = JOptionPane.showInputDialog("insira o primeiro número:");
            String input2 = JOptionPane.showInputDialog("insira o segundo número:");

            Double num1 = Double.parseDouble(input1);
            Double num2 = Double.parseDouble(input2);
            Double resultado = 0d;

            switch (operacao) {
                case 0:
                    resultado = num1 + num2;
                    break;
                case 1:
                    resultado = num1 - num2;
                    break;
                case 2:
                    resultado = num1 * num2;
                    break;
                case 3: 
                    if (num2.equals(0d)) {
                        throw new Excecao("não é possível dividir um número por zero");
                    }
                    resultado = num1 / num2;
                    break;
            }
            JOptionPane.showMessageDialog(null, "o resultado é: " + resultado, "resultado",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}