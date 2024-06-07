
import javax.swing.JOptionPane;

// ATV1
public class atvTres {
    public static void main(String[] args) {
        // Atv1
        olaMundo();

        // Atv2
        boasVindas();

        // Atv3
        desejaContinuar();

        // Atv4
        apresentarOpcoes();

        // Atv e Atv6
        try {
            calculadora();
        } catch (CustomException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Atv1
    public static void olaMundo() {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!");
    }

    // Atv2
    public static void boasVindas() {
        String nome = JOptionPane.showInputDialog("Qual é o seu nome?");
        JOptionPane.showMessageDialog(null, "Bem-vindo, " + nome + "!");
    }

    // Atv3
    public static void desejaContinuar() {
        int resposta = JOptionPane.showConfirmDialog(null, "Você deseja continuar?");
        if (resposta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Você escolheu continuar.");
        } else if (resposta == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Você escolheu não continuar.");
        } else {
            JOptionPane.showMessageDialog(null, "Você cancelou a operação.");
        }
    }

    // Atv4
    public static void apresentarOpcoes() {
        String[] opcoes = {"Opção 1", "Opção 2", "Opção 3"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Opções",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        if (escolha != JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(null, "Você escolheu " + opcoes[escolha]);
        }
    }

    // Atv5 - Custom Exception
    static class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }

    // Atv6
    public static void calculadora() throws CustomException {
        String[] operacoes = {"Adição", "Subtração", "Multiplicação", "Divisão"};
        int operacao = JOptionPane.showOptionDialog(null, "Escolha uma operação:", "Calculadora",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, operacoes, operacoes[0]);
        
        if (operacao == JOptionPane.CLOSED_OPTION) {
            throw new CustomException("Nenhuma operação foi selecionada.");
        }

        try {
            String input1 = JOptionPane.showInputDialog("Digite o primeiro número:");
            String input2 = JOptionPane.showInputDialog("Digite o segundo número:");
            double num1 = Double.parseDouble(input1);
            double num2 = Double.parseDouble(input2);
            double resultado = 0;

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
                    if (num2 == 0) {
                        throw new CustomException("Divisão por zero não é permitida.");
                    }
                    resultado = num1 / num2;
                    break;
                default:
                    throw new CustomException("Operação desconhecida.");
            }

            JOptionPane.showMessageDialog(null, "O resultado é: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            throw new CustomException("Entrada inválida, por favor insira números válidos.");
        }
    }
}
