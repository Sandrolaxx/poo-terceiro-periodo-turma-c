package Segundobim;
import javax.swing.JOptionPane;

public class Exlistatres {
    public static void main(String[] args) {
        //ATV 1
        JOptionPane.showMessageDialog(null, "Olá, Mundo!");
        
        //ATV 2
        String nome = JOptionPane.showInputDialog("Qual seu nome ?");
        JOptionPane.showMessageDialog(null, "Bem-vindo(a), " + nome + "!");

        //ATV 3
        int continuacao = JOptionPane.showConfirmDialog(null, "Dejesa continuar?");
        if(continuacao == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Vamos continuar..");
        }
        else{
            JOptionPane.showMessageDialog(null, "Até mais!");
            System.exit(0);
        }

        //ATV 4
        String[] opcoes = { "Opção 1", "Opção 2", "Opção 3" };
        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Opções",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
        switch (escolha) {
            case 0:
                JOptionPane.showMessageDialog(null, "Você escolheu Opção 1.");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Você escolheu Opção 2.");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Você escolheu Opção 3.");
                break;
        }

        // ATV5
        try {
            throw new Excecao("Exceção personalizada!");
        } catch (Excecao e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        // ATV6
        try {
            String operacao = JOptionPane.showInputDialog("Escolha a operação (+, -, *, /):");
            double num1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número:"));
            double num2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo número:"));
            double resultado = calcular(operacao, num1, num2);
            JOptionPane.showMessageDialog(null, "Resultado: " + resultado, "Calculadora",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Inválido", "Calculadora",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Excecao e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    static class Excecao extends Exception {
        public Excecao(String mensagem) {
            super(mensagem);
        }
    }

    static double calcular(String operacao, double num1, double num2) throws Excecao {
        switch (operacao) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new Excecao("Erro: Divisão por zero.");
                }
            default:
                throw new Excecao("Erro: Operação inválida.");
        }
    }
}