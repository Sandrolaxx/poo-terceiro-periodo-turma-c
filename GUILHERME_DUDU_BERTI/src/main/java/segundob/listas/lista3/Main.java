package segundob.listas.lista3;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Atividade 01: ");
        atv1();
        System.out.println("Atividade 02: ");
        atv2();
        System.out.println("Atividade 03: ");
        atv3();
        System.out.println("Atividade 04: ");
        atv4();
        System.out.println("Atividade 05: ");
        atv5();
        System.out.println("Atividade 06: ");
        atv6();
    }

    private static void atv1() {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!");
    }

    private static void atv2() {
        String nome = JOptionPane.showInputDialog("Digite seu nome: ");
        JOptionPane.showMessageDialog(null, "Olá, " + nome + "!");
    }

    private static void atv3() {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja continuar?");
        switch (resposta) {
            case JOptionPane.YES_OPTION:
                JOptionPane.showMessageDialog(null, "Continuando...");
                break;
            case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(null, "Parando...");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Cancelando...");
                break;
        }
    }

    private static void atv4() {
        JFrame frame = new JFrame("Escolha uma Opção!");
        List<String> opcoes = List.of("Opcão 1", "Opcão 2", "Opcão 3");

        String opcao = (String) JOptionPane.showInputDialog(frame,
                "Qual opção deseja selecionar? ",
                "Sua opção",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes.toArray(),
                opcoes.toArray()[0]);
        JOptionPane.showMessageDialog(frame, "A opção selecionada é: " + opcao);
    }

    private static void atv5() {
        try {
            throw new CustomException("ERRO!");
        } catch (CustomException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void atv6() {
        JFrame frame = new JFrame("Escolha uma Opção para Calcularmos!");
        List<String> operacoes = List.of("Adição", "Subtração", "Multiplicação", "Divisão");

        String operacao = (String) JOptionPane.showInputDialog(frame,
                "Qual operação deseja realizar? ",
                "Calculadora",
                JOptionPane.QUESTION_MESSAGE,
                null,
                operacoes.toArray(),
                operacoes.toArray()[0]);

        try {
            double num1 = getDoubleNumber("Insira o primeiro número: ");
            double num2 = getDoubleNumber("Insira o segundo número: ");
            double result = switch (operacao) {
                case "Adição" -> num1 + num2;
                case "Subtração" -> num1 - num2;
                case "Multiplicação" -> num1 * num2;
                case "Divisão" -> {
                    if (num2 == 0) {
                        throw new CustomException("ERRO! Divisão por 0 não é permitida!");
                    }
                    yield num1 / num2;
                }
                default -> throw new CustomException("Erro: Operação não encontrada!");
            };
            JOptionPane.showMessageDialog(frame,
                    "O resultado é: " + result,
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (CustomException e) {
            JOptionPane.showMessageDialog(frame,
                    e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static double getDoubleNumber(String msg) throws CustomException {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(null,
                        msg,
                        "Entrada de Número",
                        JOptionPane.ERROR_MESSAGE);
                if (input == null) {
                    throw new CustomException("CANCELADO...");
                }
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        e.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
