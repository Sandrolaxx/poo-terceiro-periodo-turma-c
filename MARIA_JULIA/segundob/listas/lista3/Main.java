package segundob.listas.lista3;

import javax.swing.JOptionPane;

public class Main {
    // Atv1 - Crie um método em Java que exiba uma mensagem simples "Olá, Mundo!" usando JOptionPane.
    public static void mostraMensagem() {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!");
    }


    // Atv2 - Crie um método que solicite ao usuário seu nome e exiba uma mensagem de boas-vindas.
    public static void mostraNomeMensagem() {
        String nome = JOptionPane.showInputDialog("Qual é o seu nome?");
        JOptionPane.showMessageDialog(null, "Bem-vindo, " + nome + "!");
    }


    // Atv3 - Crie um método que pergunte(showConfirmDialog) ao usuário se ele deseja continuar e exiba uma mensagem conforme a resposta.
    public static void perguntaUsuario() {
        int resposta = JOptionPane.showConfirmDialog(null, "Voce deseja continuar comprando?");
        if (resposta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Voce desejou comprar! consumista");
        } else if (resposta == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Voce nao desejou comprar! algo contra?");
        } else {
            JOptionPane.showMessageDialog(null, "nao sei oq vc clicou !!!");
        }
    }


    // Atv4 - Crie um método que apresente uma lista de opções ao usuário e exiba uma mensagem segundo a opção escolhida. Exemplos de lista("Opção 1", "Opção 2", "Opção 3").
    public static void mostraOpcoes() {
        String[] opcoes = {"Opção 1", "Opção 2", "Opção 3"};
        int escolhaUsuarip = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Escolha Usuário!!!",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        if (escolhaUsuarip != -1) {
            JOptionPane.showMessageDialog(null, "Você escolheu " + opcoes[escolhaUsuarip]);
        } else {
            JOptionPane.showMessageDialog(null, "Você não escolheu nenhuma opção.");
        }
    }

    //     Atv5 - Crie uma exceção personalizada que apresente um dialog(ERROR_MESSAGE) com a mensagem do erro que ocorreu.
    static class excecao extends Exception {
        public excecao(String message) {
            super(message);
        }

        public void mostraErro() {
            JOptionPane.showMessageDialog(null, getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Atv6 - Crie uma calculadora utilizando JOptionPane, apresente as quatro opções matemáticas ao usuário, após selecionada a opção e avançar, requisite os dois números para realizar o cálculo, apresente o resultado em um dialog(INFORMATION_MESSAGE) e em caso de erro lance sua exceção personalizada da atividade 5.
    public static void calculadora() {
        try {
            String[] operacoes = {"+", "-", "x", "/"};
            int operacao = JOptionPane.showOptionDialog(null, "Escolha uma operação:", "Calculadora",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, operacoes, operacoes[0]);

            if (operacao == -1) {
                throw new excecao("Nenhuma operação foi selecionada.");
            }

            String numUsuario1 = JOptionPane.showInputDialog("Digite o primeiro número:");
            String numUsuario2 = JOptionPane.showInputDialog("Digite o segundo número:");

            if (numUsuario1 == null || numUsuario2 == null) {
                throw new excecao("Entrada de número foi cancelada.");
            }

            double num1, num2;
            try {
                num1 = Double.parseDouble(numUsuario1);
                num2 = Double.parseDouble(numUsuario2);
            } catch (NumberFormatException e) {
                throw new excecao("Entrada inválida de número.");
            }

            double result;
            switch (operacao) {
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
                        throw new excecao("Divisão por zero não é permitida.");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new excecao("Operação desconhecida.");
            }

            JOptionPane.showMessageDialog(null, "O resultado é: " + result, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (excecao e) {
            e.mostraErro();
        }
    }

    public static void main(String[] args) {
        mostraMensagem();     // ATV1
        mostraNomeMensagem();    // ATV2
        perguntaUsuario();      // ATV3
        mostraOpcoes();        // ATV4
        calculadora();         // ATV6
    }

    
}
