package segundoBimestre.lista_3;

import javax.swing.JOptionPane;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //ATIV 01

        JOptionPane.showMessageDialog(null, "Olá, Mundo!");

        //ATIV 02

        String name = JOptionPane.showInputDialog(null,"Digite seu nome" );

        JOptionPane.showMessageDialog(null, "Bem vindo " + name + "!");

        //ATIV 03

        int option = JOptionPane.showConfirmDialog(null, "Você deseja continuar?", "Confirmação", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Você escolheu continuar.");
            } else if (option == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Você escolheu não continuar.");
            }


        List<String> frutas = List.of("Morango", "Uva", "Melancia");

        String melhorFruta = (String) JOptionPane.showInputDialog(
                null,
                "Qual sua fruta preferida?",
                "Selecione",
                JOptionPane.QUESTION_MESSAGE,
                null,
                frutas.toArray(),
                frutas.toArray()[0]);

        System.out.println(melhorFruta);

        if (!melhorFruta.equals("Melancia")) {
            JOptionPane.showMessageDialog(
                    null,
                    "Resposta errada!",
                    "ERRO!",
                    JOptionPane.ERROR_MESSAGE);
        } try {
            runCalculator();
        } catch (CustomException e) {

        }
    }


    public static void runCalculator() throws CustomException {

        String[] options = {"Adição", "Subtração", "Multiplicação", "Divisão"};


        int operation = JOptionPane.showOptionDialog(
                null,
                "Escolha uma operação:",
                "Calculadora",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (operation < 0 || operation >= options.length) {
            throw new CustomException("Nenhuma operação válida foi selecionada.");
        }

        try {

            String input1 = JOptionPane.showInputDialog("Digite o primeiro número:");
            if (input1 == null || input1.trim().isEmpty()) {
                throw new CustomException("Erro: Nenhum número foi fornecido.");
            }
            double num1 = Double.parseDouble(input1.trim());


            String input2 = JOptionPane.showInputDialog("Digite o segundo número:");
            if (input2 == null || input2.trim().isEmpty()) {
                throw new CustomException("Erro: Nenhum número foi fornecido.");
            }
            double num2 = Double.parseDouble(input2.trim());


            double result;
            switch (operation) {
                case 0: // Adição
                    result = num1 + num2;
                    break;
                case 1: // Subtração
                    result = num1 - num2;
                    break;
                case 2: // Multiplicação
                    result = num1 * num2;
                    break;
                case 3: // Divisão
                    if (num2 == 0) {
                        throw new CustomException("Erro: Divisão por zero.");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new CustomException("Operação desconhecida.");
            }


            JOptionPane.showMessageDialog(null, "O resultado é: " + result, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            throw new CustomException("Erro: Entrada inválida. Por favor, insira números válidos.");
        }
    }
}