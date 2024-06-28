import javax.swing.JOptionPane;

public class main2 {

    public static void main(String[] args) {
        // ATV1
        mostrarMensagem();

        // ATV2
        exibirMensagemBoasVindas();

        // ATV3
        perguntarContinuar();

        // ATV4
        apresentarOpcoes();

        // ATV5 e ATV6
        // Teste da exceção personalizada pode ser feito na ATV6
        calculadora();
    }

    // ATV1
    public static void mostrarMensagem() {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!");
    }

    // ATV2
    public static void exibirMensagemBoasVindas() {
        String nome = JOptionPane.showInputDialog("Qual é o seu nome?");
        JOptionPane.showMessageDialog(null, "Bem-vindo, " + nome + "!");
    }

    // ATV3
    public static void perguntarContinuar() {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja continuar?");
        if (resposta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Você escolheu continuar.");
        } else {
            JOptionPane.showMessageDialog(null, "Você escolheu não continuar.");
        }
    }

    // ATV4
    public static void apresentarOpcoes() {
        String[] opcoes = {"Opção 1", "Opção 2", "Opção 3"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Opções",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        if (escolha == 0) {
            JOptionPane.showMessageDialog(null, "Você escolheu Opção 1");
        } else if (escolha == 1) {
            JOptionPane.showMessageDialog(null, "Você escolheu Opção 2");
        } else if (escolha == 2) {
            JOptionPane.showMessageDialog(null, "Você escolheu Opção 3");
        }
    }

    // ATV5
    public static class MinhaExcecaoPersonalizada extends Exception {
        public MinhaExcecaoPersonalizada(String mensagem) {
            super(mensagem);
        }

        public void mostrarDialogoErro() {
            JOptionPane.showMessageDialog(null, getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ATV6
    public static void calculadora() {
        String[] operacoes = {"Adição", "Subtração", "Multiplicação", "Divisão"};
        int operacao = JOptionPane.showOptionDialog(null, "Escolha uma operação:", "Calculadora",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, operacoes, operacoes[0]);

        if (operacao != JOptionPane.CLOSED_OPTION) {
            String num1Str = JOptionPane.showInputDialog("Digite o primeiro número:");
            String num2Str = JOptionPane.showInputDialog("Digite o segundo número:");

            try {
                double num1 = Double.parseDouble(num1Str);
                double num2 = Double.parseDouble(num2Str);
                double resultado = 0;

                switch (operacao) {
                    case 0: // Adição
                        resultado = num1 + num2;
                        break;
                    case 1: // Subtração
                        resultado = num1 - num2;
                        break;
                    case 2: // Multiplicação
                        resultado = num1 * num2;
                        break;
                    case 3: // Divisão
                        if (num2 == 0) {
                            throw new MinhaExcecaoPersonalizada("Divisão por zero não é permitida.");
                        }
                        resultado = num1 / num2;
                        break;
                }
                JOptionPane.showMessageDialog(null, "O resultado é: " + resultado, "Resultado",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, digite números válidos.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            } catch (MinhaExcecaoPersonalizada e) {
                e.mostrarDialogoErro();
            }
        }
    }
}
