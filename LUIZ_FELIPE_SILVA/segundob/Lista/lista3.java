package Lista;

import javax.swing.JOptionPane;

public class lista3 {
    public static void main(String[] args) {
        exibirMensagem();
    }

    public static void exibirMensagem() {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!");
    }
}



/*import javax.swing.JOptionPane;

public class lista3 {
    public static void main(String[] args) {
        saudacaoUsuario();
    }

    public static void saudacaoUsuario() {
        String nome = JOptionPane.showInputDialog("Qual é o seu nome?");
        JOptionPane.showMessageDialog(null, "Bem-vindo, " + nome + "!");
    }
}
*/
/*import javax.swing.JOptionPane;

public class lista3 {
    public static void main(String[] args) {
        perguntarContinuacao();
    }

    public static void perguntarContinuacao() {
        int resposta = JOptionPane.showConfirmDialog(null, "Você deseja continuar?");
        if (resposta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Você escolheu continuar!");
        } else if (resposta == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Você escolheu não continuar.");
        } else {
            JOptionPane.showMessageDialog(null, "Você cancelou a operação.");
        }
    }
}
    */

/*import javax.swing.JOptionPane;

public class lista3 {
    public static void main(String[] args) {
        escolherOpcao();
    }

    public static void escolherOpcao() {
        String[] opcoes = {"Opção 1", "Opção 2", "Opção 3"};
        String resposta = (String) JOptionPane.showInputDialog(
                null, 
                "Escolha uma opção:", 
                "Opções", 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                opcoes, 
                opcoes[0]);
        
        if (resposta != null) {
            JOptionPane.showMessageDialog(null, "Você escolheu: " + resposta);
        } else {
            JOptionPane.showMessageDialog(null, "Você cancelou a operação.");
        }
    }
}

/*import javax.swing.JOptionPane;

public class lista3 {
    public static void main(String[] args) {
        try {
            throw new MinhaExcecao("Ocorreu um erro personalizado.");
        } catch (MinhaExcecao e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

class MinhaExcecao extends Exception {
    public MinhaExcecao(String mensagem) {
        super(mensagem);
    }
}
    */
    

/*import javax.swing.JOptionPane;

public class lista3 {
    public static void main(String[] args) {
        try {
            calculadora();
        } catch (MinhaExcecao e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void calculadora() throws MinhaExcecao {
        String[] operacoes = {"Adição", "Subtração", "Multiplicação", "Divisão"};
        String operacao = (String) JOptionPane.showInputDialog(
                null, 
                "Escolha uma operação:", 
                "Calculadora", 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                operacoes, 
                operacoes[0]);

        if (operacao != null) {
            double num1, num2, resultado = 0;
            try {
                num1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número:"));
                num2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo número:"));

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

                JOptionPane.showMessageDialog(null, "O resultado da " + operacao + " é: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                throw new MinhaExcecao("Entrada inválida. Por favor, insira números válidos.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Você cancelou a operação.");
        }
    }
}

class MinhaExcecao extends Exception {
    public MinhaExcecao(String mensagem) {
        super(mensagem);
    }
}
*/