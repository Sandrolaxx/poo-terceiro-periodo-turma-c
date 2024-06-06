package segundob.atividade3;

/* ATV1
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        showMessage();
    }

    public static void showMessage() {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!");
    }
}

ATV1 */


/*ATV2

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        welcomeUser();
    }

    public static void welcomeUser() {
        String name = JOptionPane.showInputDialog(null, "Digite seu nome:");

        if (name != null && !name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bem-vindo, " + name + "!");
        } else {
            JOptionPane.showMessageDialog(null, "Nome não inserido.");
        }
    }
}

ATV2*/


/*ATV3

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        askUserToContinue();
    }

    public static void askUserToContinue() {
        int response = JOptionPane.showConfirmDialog(null, "Você deseja continuar?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Você escolheu continuar.");
        } else if (response == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Você escolheu não continuar.");
        } else {
            JOptionPane.showMessageDialog(null, "Ação cancelada.");
        }
    }
}

ATV3*/


/*ATV4

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        showOptions();
    }

    public static void showOptions() {

        String[] options = {"Opção 1", "Opção 2", "Opção 3"};

        int choice = JOptionPane.showOptionDialog(
                null, 
                "Escolha uma opção:", 
                "Escolha de Opção", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                options, 
                options[0]
        );

        switch (choice) {
            case 0:
                JOptionPane.showMessageDialog(null, "Você escolheu a Opção 1");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Você escolheu a Opção 2");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Você escolheu a Opção 3");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Nenhuma opção foi escolhida");
                break;
        }
    }
}

ATV4*/


/*ATV5

import javax.swing.JOptionPane;

public class Main {

    public static class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        try {
            throwCustomException();
        } catch (CustomException e) {
            showErrorDialog(e.getMessage());
        }
    }

    public static void throwCustomException() throws CustomException {

        throw new CustomException("Gremio maior do Br!");
    }

    public static void showErrorDialog(String errorMessage) {

        JOptionPane.showMessageDialog(null, errorMessage, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}

ATV5*/


/*ATV6

import javax.swing.JOptionPane;

public class Main {

    public static class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        boolean continueCalculating = true;
        
        while (continueCalculating) {
            try {

                String[] options = {"Adição", "Subtração", "Multiplicação", "Divisão", "Sair"};
                int choice = JOptionPane.showOptionDialog(
                        null, 
                        "Escolha uma operação:", 
                        "Calculadora", 
                        JOptionPane.DEFAULT_OPTION, 
                        JOptionPane.INFORMATION_MESSAGE, 
                        null, 
                        options, 
                        options[0]
                );

                if (choice == 4 || choice == JOptionPane.CLOSED_OPTION) {
                    continueCalculating = false;
                    continue;
                }

                double num1 = getNumber("Digite o primeiro número:");
                double num2 = getNumber("Digite o segundo número:");

                double result = performCalculation(choice, num1, num2);

                JOptionPane.showMessageDialog(null, "O resultado é: " + result, "Resultado", JOptionPane.INFORMATION_MESSAGE);

            } catch (CustomException e) {
                showErrorDialog(e.getMessage());
            }
        }
    }

    public static double getNumber(String message) throws CustomException {
        try {
            String input = JOptionPane.showInputDialog(null, message);
            if (input == null) {
                throw new CustomException("Nenhum valor foi inserido!");
            }
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new CustomException("Entrada inválida! Por favor, insira um número válido.");
        }
    }

    public static double performCalculation(int choice, double num1, double num2) throws CustomException {
        switch (choice) {
            case 0: // Adição
                return num1 + num2;
            case 1: // Subtração
                return num1 - num2;
            case 2: // Multiplicação
                return num1 * num2;
            case 3: // Divisão
                if (num2 == 0) {
                    throw new CustomException("Divisão por zero não é permitida!");
                }
                return num1 / num2;
            default:
                throw new CustomException("Operação inválida!");
        }
    }

    public static void showErrorDialog(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}

ATV6*/