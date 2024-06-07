import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        // Chamando os métodos das atividades
        atv1();
        atv2();
        atv3();
        atv4();
        try {
            atv6();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ATV1 - Método para exibir "Olá, Mundo!"
    private static void atv1() {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!", "Boas-Vindas", JOptionPane.INFORMATION_MESSAGE);
    }

    // ATV2 - Método para solicitar o nome do usuário e exibir uma mensagem de boas-vindas
    private static void atv2() {
        String nome = JOptionPane.showInputDialog("Digite seu nome:");
        JOptionPane.showMessageDialog(null, "Bem-vindo(a), " + nome + "!", "Mensagem de Boas-Vindas", JOptionPane.INFORMATION_MESSAGE);
    }

    // ATV3 - Método para perguntar ao usuário se ele deseja continuar
    private static void atv3() {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Pergunta", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Você escolheu continuar.", "Resposta", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Você escolheu não continuar.", "Resposta", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // ATV4 - Método para apresentar uma lista de opções ao usuário
    private static void atv4() {
        Object[] opcoes = {"Opção 1", "Opção 2", "Opção 3"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Opções",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        JOptionPane.showMessageDialog(null, "Você escolheu: " + opcoes[escolha], "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }

    // ATV5 - Exceção personalizada
    static class CalculadoraException extends Exception {
        public CalculadoraException(String message) {
            super(message);
        }
    }

    // ATV6 - Método para criar uma calculadora com JOptionPane
    private static void atv6() throws CalculadoraException {
        Object[] operacoes = {"Adição", "Subtração", "Multiplicação", "Divisão"};
        int operacaoEscolhida = JOptionPane.showOptionDialog(null, "Escolha uma operação:",
                "Calculadora", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, operacoes, operacoes[0]);

        double num1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número:"));
        double num2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo número:"));

        switch (operacaoEscolhida) {
            case 0:
                JOptionPane.showMessageDialog(null, "Resultado: " + (num1 + num2), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Resultado: " + (num1 - num2), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Resultado: " + (num1 * num2), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 3:
                if (num2 == 0) throw new CalculadoraException("Divisão por zero não permitida.");
                JOptionPane.showMessageDialog(null, "Resultado: " + (num1 / num2), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                throw new CalculadoraException("Operação inválida.");
        }
    }
}
