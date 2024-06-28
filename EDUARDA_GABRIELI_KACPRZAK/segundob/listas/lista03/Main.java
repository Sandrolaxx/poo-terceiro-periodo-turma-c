package listas.lista03;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        helloWorld();
        welcomeToYou();
        messageConfirm();
        gamesChoices();
        calculator();
    }

    // ATV1
    public static void helloWorld() {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!");
    }

    // ATV2
    public static void welcomeToYou() {
        String name = JOptionPane.showInputDialog("Digite seu nome:");

        if (name.isEmpty()) {
            System.out.println("Inválido.");
            return;
        }
        String mensagem = "Olá, " + name + "!";
        JOptionPane.showMessageDialog(null, mensagem);
    }

     // ATV3
        public static boolean messageConfirm() {
            int resposta = JOptionPane.showConfirmDialog(null, 
            "Deseja continuar?", "Decisão..",
            JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Bora continuar");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Puts..");
                return false;
            }
        }

    // ATV4
    public static void gamesChoices() {
        String[] jogos = { "The Last of Us", "Red Dead Redemption 2", "God of War", "Horizon Zero Dawn", "Alan Wake" };

        Object jogoSelecionado = JOptionPane.showInputDialog(null,
                "Escolha seu jogo favorito:",
                "Jogos",
                JOptionPane.QUESTION_MESSAGE,
                null,
                jogos,
                jogos[0]);

        String jogoEscolhido = jogoSelecionado.toString();
        switch (jogoEscolhido) {
            case "The Last of Us":
                JOptionPane.showMessageDialog(null,
                "The Last of Us é um jogo muito massa de aventura e sobrevivência em um mundo pós-apocalíptico.");
                break;
            case "Red Dead Redemption 2":
                JOptionPane.showMessageDialog(null,
                "Red Dead Redemption 2 é um jogo de faroeste em mundo aberto com uma história épica.");
                break;
            case "God of War":
                JOptionPane.showMessageDialog(null,
                "God of War é um jogo de ação e aventura com batalhas contra deuses nórdicos.");
                break;
            case "Horizon Zero Dawn":
                JOptionPane.showMessageDialog(null,
                "Horizon Zero Dawn é um jogo de RPG de ação em um mundo aberto com dinossauros robôs.");
                break;
            case "Alan Wake":
                JOptionPane.showMessageDialog(null,
                "Alan Wake é um jogo de terror psicológico com muita ação.");
                break;
            default:
                JOptionPane.showMessageDialog(null,
                "O jogo selecionado não possui uma mensagem específica.");
        }
    }

    // ATV5
    public static class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
            JOptionPane.showMessageDialog(null, 
            message, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ATV6
    public static void calculator() {
        try {
            String[] options = { "Soma", "Subtração", "Multiplicação", "Divisão" };
            int choice = JOptionPane.showOptionDialog(null, 
            "Selecione uma operação", "Calculadora",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == JOptionPane.CLOSED_OPTION) {
                throw new CustomException("Selecione uma operação.");
            }

            String num1Str = JOptionPane.showInputDialog("Digite um número:");
            String num2Str = JOptionPane.showInputDialog("Digite outro número:");

            if (num1Str == null || num2Str == null) {
                throw new CustomException("Para calcular, os números não podem ser nulos");
            }

            double num1;
            double num2;
            try {
                num1 = Double.parseDouble(num1Str);
                num2 = Double.parseDouble(num2Str);
            } catch (NumberFormatException e) {
                throw new CustomException("Entrada inválida, tente novamente");
            }

            double result;
            switch (choice) {
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
                        throw new CustomException("Erro: Divisão por zero não dá.");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new CustomException("Operação inválida");
            }

            JOptionPane.showMessageDialog(null, 
            "Resultado: " + result, ":)",
            JOptionPane.INFORMATION_MESSAGE);

        } catch (CustomException e) {
        
        }
    }
}
