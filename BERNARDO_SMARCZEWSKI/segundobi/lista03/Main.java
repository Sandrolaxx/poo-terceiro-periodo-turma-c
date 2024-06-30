package segundobi.lista03;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {


        // ATV 01

        atividade1();


        // ATV 02

        atividade2();


        // ATV 03

        boolean continuar = atividade3();
        
        if (continuar == true) {

            // ATV 04

            atividade4();

            // ATV 06

            atividade6();
        
        }

    }

    public static void atividade1() {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!");
    }

    public static void atividade2() {
        String nome = JOptionPane.showInputDialog("Qual é seu nome?");
        JOptionPane.showMessageDialog(null, "Bem vindo, " + nome + "!");
    }

    public static boolean atividade3() {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja continuar?");
        if (resposta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Dando sequência...");
            return true;
        } else if (resposta == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Parando...");
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Cancelado");
            return false;
        }
    }

    public static void atividade4() {
        String[] opcoes = { "Opção 1", "Opção 2", "Opção 3" };
        String escolha = (String) JOptionPane.showInputDialog(null, "Escolha uma opção:", "Opções",
                JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        JOptionPane.showMessageDialog(null, "Você escolheu a " + escolha);
    }


    // ATV 05

    static class MinhaExcecao extends Exception {
        public MinhaExcecao(String mensagem) {
            super(mensagem);
        }
    }

    public static void lancaExcecao() throws MinhaExcecao {
        throw new MinhaExcecao("Ocorreu um erro!");
    }

    public static void atividade6() {
        String[] operacoes = { "Adição", "Subtração", "Multiplicação", "Divisão" };
        String operacao = (String) JOptionPane.showInputDialog(null, "Escolha uma operação:", "Calculadora",
                JOptionPane.QUESTION_MESSAGE, null, operacoes, operacoes[0]);

        if (operacao != null) {
            try {
                String num1Str = JOptionPane.showInputDialog("Digite o primeiro número:");
                String num2Str = JOptionPane.showInputDialog("Digite o segundo número:");

                double num1 = Double.parseDouble(num1Str);
                double num2 = Double.parseDouble(num2Str);
                double resultado = 0;

                switch (operacao) {
                    case "Adição":
                        resultado = num1 + num2;
                        break;
                    case "Subtração":
                        resultado = num1 - num2;
                        break;
                    case "Multiplicação":
                        resultado = num1 * num2;
                        break;
                    case "Divisão":
                        if (num2 == 0) {
                            throw new MinhaExcecao("Divisão por zero não é permitida.");
                        }
                        resultado = num1 / num2;
                        break;
                }

                JOptionPane.showMessageDialog(null, "Resultado: " + resultado, "Resultado",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, insira números válidos.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            } catch (MinhaExcecao e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

}