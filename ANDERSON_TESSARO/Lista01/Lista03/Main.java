package Lista01.Lista03;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // ATV1
        showHelloWorldMessage();

        // ATV2
        welcomeUser();

        // ATV3
        askToContinue();

        // ATV4
        showOptions();

        // ATV5 e ATV6 são chamadas na sequência lógica
        // ATV6
        try {
            calculator();
        } catch (CustomException e) {
            showErrorDialog(e.getMessage());
        }
    }

    // ATV1
    public static void showHelloWorldMessage() {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!");
    }

    // ATV2
    public static void welcomeUser() {
        String name = JOptionPane.showInputDialog("Qual é o seu nome?");
        if (name != null && !name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bem-vindo, " + name + "!");
        } else {
            JOptionPane.showMessageDialog(null, "Nome não fornecido.");
        }
    }

    // ATV3
    public static void askToContinue() {
        int response = JOptionPane.showConfirmDialog(null, "Você deseja continuar?");
        if (response == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Você escolheu continuar.");
        } else if (response == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Você escolheu não continuar.");
        } else if (response == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Você cancelou a operação.");
        }
    }

    // ATV4
    public static void showOptions() {
        String[] options = {"Opção 1", "Opção 2", "Opção 3"};
        int choice = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Opções",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (choice >= 0 && choice < options.length) {
            JOptionPane.showMessageDialog(null, "Você escolheu " + options[choice]);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma opção escolhida.");
        }
    }

    // ATV5
    public static class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }

    public static void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    // ATV6
    public static void calculator() throws CustomException {
        String[] operations = {"Adição", "Subtração", "Multiplicação", "Divisão"};
        int operation = JOptionPane.showOptionDialog(null, "Escolha uma operação:", "Calculadora",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, operations, operations[0]);

        if (operation < 0 || operation >= operations.length) {
            throw new CustomException("Operação inválida selecionada.");
        }

        try {
            String num1Str = JOptionPane.showInputDialog("Digite o primeiro número:");
            String num2Str = JOptionPane.showInputDialog("Digite o segundo número:");

            if (num1Str == null || num2Str == null) {
                throw new CustomException("Números não fornecidos.");
            }

            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double result = 0;

            switch (operation) {
                case 0:
                    result = num1 + num2;
                    break;
                case 1:
                    result = num1 - num2;
                    break;
                case 2:
                    result = num1 * num2;
                    break;
                case 3:
                    if (num2 == 0) {
                        throw new CustomException("Divisão por zero não permitida.");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new CustomException("Operação inválida.");
            }

            JOptionPane.showMessageDialog(null, "O resultado é: " + result, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            throw new CustomException("Entrada inválida. Por favor, insira números válidos.");
        }
    }
}
