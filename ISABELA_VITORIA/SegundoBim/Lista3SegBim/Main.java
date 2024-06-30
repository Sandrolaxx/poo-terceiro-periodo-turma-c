package SegundoBim.Lista3SegBim;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        // Atv1 - Crie um método em Java que exiba uma mensagem simples
        // "Olá,Mundo!"usando JOptionPane.
        JFrame frame = new JFrame("Saudação");

        JOptionPane.showMessageDialog(
                frame,
                "Olá mundo !",
                "Saudação",
                JOptionPane.INFORMATION_MESSAGE);

        // Atv2 - Crie um método que solicite ao usuário seu nome e exiba uma mensagem
        // de boas-vindas.

        String nome = JOptionPane.showInputDialog(
                null,
                "Escreva seu nome: ",
                "Escreva seu nome: ",
                JOptionPane.QUESTION_MESSAGE);

        JOptionPane.showMessageDialog(
                null,
                "Bem-vindo (a), " + nome + "!",
                "Boas-vindas",
                JOptionPane.INFORMATION_MESSAGE);

        /// Atv3 - Crie um método que pergunte(showConfirmDialog) ao usuário se ele
        /// deseja continuar e exiba uma mensagem conforme a resposta.

        String resposta = JOptionPane.showInputDialog(frame,
                nome + " Deseja continuar ? " + "\n [1]Sim " + "\n [2] Não",
                JOptionPane.QUESTION_MESSAGE);

        switch (resposta) {
            case "1":
                JOptionPane.showMessageDialog(frame, "Continuando");
                break;
            case "2":

                JOptionPane.showMessageDialog(frame, "Encerrando");
                break;
            default:
                JOptionPane.showMessageDialog(frame, "Opção invalida");

                break;
        }

        // Atv4 - Crie um método que apresente uma lista de opções ao usuário e exiba
        // uma mensagem segundo a opção escolhida. Exemplos de lista("Opção 1", "Opção
        // 2", "Opção 3").

        List<String> lista = List.of("Evee", "Pikachu", "Chikorita", "Totodile", "Cindaquill", "Mr. Mime");

        String pokemon = (String) JOptionPane.showInputDialog(frame, "Escolha seu pokemon inicial: ",
                "Pokemon Escolhido foi: ",
                JOptionPane.QUESTION_MESSAGE,
                null,
                lista.toArray(),
                lista.toArray()[0]);

        JOptionPane.showMessageDialog(frame, "Esse é o seu pokemon ! : " + pokemon);

        // Atv5 - Crie uma exceção personalizada que apresente um dialog(ERROR_MESSAGE)
        // com a mensagem do erro que ocorreu.
        if (pokemon.equals("Mr. Mime")) {
            throw new CustomExceptionf("ESSE NÃO >:| ");
        }

        // Atv6 - Crie uma calculadora utilizando JOptionPane, apresente as quatro
        // opções matemáticas ao usuário, após selecionada a opção e avançar, requisite
        // os dois números para realizar o cálculo, apresente o resultado em um
        // dialog(INFORMATION_MESSAGE) e em caso de erro lance sua exceção personalizada
        // da atividade 5.
        List<String> operacao = new ArrayList<>(List.of("soma", "subtração", "multiplicação", "divisão"));

        String operacaoEscolhida = (String) JOptionPane.showInputDialog(
                frame, "Escolha a opção: ", "Opções",
                JOptionPane.QUESTION_MESSAGE,
                null,
                operacao.toArray(),
                operacao.toArray()[0]);

        String num1 = JOptionPane.showInputDialog(frame,
                "Digite primerio numero: ",
                JOptionPane.QUESTION_MESSAGE);

        String num2 = JOptionPane.showInputDialog(frame,
                "Digite segundo numero: ",
                JOptionPane.QUESTION_MESSAGE);

        int numero1 = Integer.parseInt(num1);
        int numero2 = Integer.parseInt(num2);
        Integer resultado = 0;

        switch (operacaoEscolhida) {

            case "soma":
                resultado = numero1 + numero2;

                JOptionPane.showMessageDialog(frame, "resultado: " + resultado);

                break;
            case "subtração":
                resultado = numero1 - numero2;
                JOptionPane.showMessageDialog(frame, "resultado: " + resultado);

            case "multiplicação":
                resultado = numero1 * numero2;
                JOptionPane.showMessageDialog(frame, "resultado: " + resultado);
                break;

            case "divisão":
                if (numero1 == 0 || numero2 == 0) {
                    JOptionPane.showMessageDialog(frame, "Não é possivel dividir por zero !", "ERRO", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    resultado = numero1 / numero2;
                    JOptionPane.showMessageDialog(frame, "resultado: " + resultado);
                }
                break;
            default:
              
                break;
        }

    }

    
    
}
