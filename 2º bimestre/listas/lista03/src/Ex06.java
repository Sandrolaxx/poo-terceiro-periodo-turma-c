import javax.swing.JOptionPane;

public class Ex06 {

    public static void main(String[] args) {
        try {
            int opcao = mostrarMenuOpcoes();
            double num1 = pedirNumero("Primeiro número: ");
            double num2 = pedirNumero("Segundo número: ");
            double resultado = calcular(opcao, num1, num2);
            mostrarResultado(resultado);
        } catch (MinhaExcecaoPersonalizada e) {
            e.mostrarDialogoErro();
        }
    }

    private static int mostrarMenuOpcoes() {
        String[] opções = {"+", "-", "*", "/"};
        int opcaoSelecionada = JOptionPane.showOptionDialog(null,
                "Selecione a operação:", "Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, opções, opções[0]);
        if (opcaoSelecionada == JOptionPane.CANCEL_OPTION) {
            System.exit(0);
        }
        return opcaoSelecionada;
    }

    private static double pedirNumero(String mensagem) throws MinhaExcecaoPersonalizada {
        String input = JOptionPane.showInputDialog(null, mensagem);
        if (input == null) {
            System.exit(0);
        }
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new MinhaExcecaoPersonalizada("Entrada inválida: número esperado.");
        }
    }

    private static double calcular(int opcao, double num1, double num2) throws MinhaExcecaoPersonalizada {
        switch (opcao) {
            case 0: return num1 + num2;
            case 1: return num1 - num2;
            case 2: return num1 * num2;
            case 3:
                if (num2 == 0) {
                    throw new MinhaExcecaoPersonalizada("Não é possível dividir por zero.");
                }
                return num1 / num2;
            default: throw new MinhaExcecaoPersonalizada("Opção inválida.");
        }
    }

    private static void mostrarResultado(double resultado) {
        JOptionPane.showMessageDialog(null, "Resultado: " + resultado,
                "Cálculo", JOptionPane.INFORMATION_MESSAGE);
    }
}

