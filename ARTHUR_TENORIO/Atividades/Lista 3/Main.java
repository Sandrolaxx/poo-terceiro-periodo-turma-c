import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        // Atividade 1
        OlaMundo.exibirMensagem();


        // Atividade 2
        BemVindo.solicitarNomeEExibirMensagem();


        // Atividade 3
        ContinuarPergunta.perguntarSeDesejaContinuar();


        // Atividade 4
        EscolherOpcao.apresentarOpcoesEExibirMensagem();


        // Atividade 5 e 6 são implementadas juntas na classe Calculadora
        Calculadora.calcular();
    }
}


// Atividade 1
class OlaMundo {
    public static void exibirMensagem() {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!");
    }
}


// Atividade 2
class BemVindo {
    public static void solicitarNomeEExibirMensagem() {
        String nome = JOptionPane.showInputDialog("Qual é o seu nome?");
        JOptionPane.showMessageDialog(null, "Bem-vindo, " + nome + "!");
    }
}


// Atividade 3
class ContinuarPergunta {
    public static void perguntarSeDesejaContinuar() {
        int resposta = JOptionPane.showConfirmDialog(null, "Você deseja continuar?", "Pergunta", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Você escolheu continuar!");
        } else {
            JOptionPane.showMessageDialog(null, "Você escolheu não continuar!");
        }
    }
}


// Atividade 4
class EscolherOpcao {
    public static void apresentarOpcoesEExibirMensagem() {
        String[] opcoes = {"Opção 1", "Opção 2", "Opção 3"};
        String escolha = (String) JOptionPane.showInputDialog(null, "Escolha uma opção:", "Opções", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        if (escolha != null) {
            JOptionPane.showMessageDialog(null, "Você escolheu: " + escolha);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma opção foi escolhida.");
        }
    }
}


// Atividade 5 - Exceção Personalizada
class MinhaExcecao extends Exception {
    public MinhaExcecao(String mensagem) {
        super(mensagem);
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}


// Atividade 6
class Calculadora {
    public static void calcular() {
        String[] operacoes = {"Soma", "Subtração", "Multiplicação", "Divisão"};
        String operacao = (String) JOptionPane.showInputDialog(null, "Escolha uma operação:", "Calculadora", JOptionPane.QUESTION_MESSAGE, null, operacoes, operacoes[0]);


        if (operacao != null) {
            try {
                double num1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número:"));
                double num2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo número:"));
                double resultado = 0;


                switch (operacao) {
                    case "Soma":
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
                            throw new MinhaExcecao("Erro: Divisão por zero não é permitida.");
                        }
                        resultado = num1 / num2;
                        break;
                }
                JOptionPane.showMessageDialog(null, "O resultado da " + operacao + " é: " + resultado, "Resultado", 
JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                new MinhaExcecao("Erro: Entrada inválida. Por favor, insira números válidos.");
            } catch (MinhaExcecao e) {
                // A mensagem de erro já foi exibida na exceção personalizada
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma operação foi escolhida.");
        }
    }
}
