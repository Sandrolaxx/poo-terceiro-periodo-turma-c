package SegundoB.Lista_3;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // ATV1
        exibirMensagemOlaMundo();
        
        // ATV2
        exibirMensagemBoasVindas();
        
        // ATV3
        perguntarContinuar();
        
        // ATV4
        exibirOpcaoEscolhida();
        
        // ATV5 é usada na ATV6

        // ATV6
        calculadora();
    }

    // ATV1
    public static void exibirMensagemOlaMundo() {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!");
    }

    // ATV2
    public static void exibirMensagemBoasVindas() {
        String nome = JOptionPane.showInputDialog("Qual é o seu nome?");
        JOptionPane.showMessageDialog(null, "Bem-vindo, " + nome + "!");
    }

    // ATV3
    public static void perguntarContinuar() {
        int resposta = JOptionPane.showConfirmDialog(null, "Você deseja continuar?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Você escolheu continuar.");
        } else {
            JOptionPane.showMessageDialog(null, "Você escolheu não continuar.");
        }
    }

    // ATV4
    public static void exibirOpcaoEscolhida() {
        String[] opcoes = {"Opção 1", "Opção 2", "Opção 3"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Opções",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        if (escolha >= 0 && escolha < opcoes.length) {
            JOptionPane.showMessageDialog(null, "Você escolheu: " + opcoes[escolha]);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma opção foi escolhida.");
        }
    }

    // ATV5 - Exceção personalizada
    static class MinhaExcecao extends Exception {
        public MinhaExcecao(String mensagem) {
            super(mensagem);
        }

        public void exibirErro() {
            JOptionPane.showMessageDialog(null, getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ATV6
    public static void calculadora() {
        String[] operacoes = {"Soma", "Subtração", "Multiplicação", "Divisão"};
        int operacao = JOptionPane.showOptionDialog(null, "Escolha uma operação", "Calculadora",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, operacoes, operacoes[0]);

        if (operacao >= 0 && operacao < operacoes.length) {
            try {
                double num1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número:"));
                double num2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo número:"));
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
                            throw new MinhaExcecao("Erro: Divisão por zero.");
                        }
                        resultado = num1 / num2;
                        break;
                    default:
                        throw new MinhaExcecao("Operação inválida.");
                }

                JOptionPane.showMessageDialog(null, "O resultado é: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);

            } catch (MinhaExcecao e) {
                e.exibirErro();
            } catch (NumberFormatException e) {
                new MinhaExcecao("Erro: Entrada inválida.").exibirErro();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma operação foi escolhida.");
        }
    }
}