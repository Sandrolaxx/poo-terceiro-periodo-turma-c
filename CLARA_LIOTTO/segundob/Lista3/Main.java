package Lista3;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String[] args) {
        
        // Atv 1
        JFrame frame = new JFrame("Comprimentar");

        JOptionPane.showMessageDialog(frame, "Olá mundo!", "Comprimentar", JOptionPane.INFORMATION_MESSAGE);

        // Atv 2
        String nome = JOptionPane.showInputDialog(null,"Escreva seu nome: ", "escreva seu nome ", JOptionPane.QUESTION_MESSAGE);

        JOptionPane.showMessageDialog(null, "Ola, " + nome + "seja bem vindo!", "Boas Vindas", JOptionPane.INFORMATION_MESSAGE);

        // Atv 3
        String resposta = JOptionPane.showInputDialog(frame, nome + "Deseja prosseguir? " + "1- Sim" + "2- Não", JOptionPane.QUESTION_MESSAGE);

        switch (resposta) {
            case "1":
                JOptionPane.showMessageDialog(frame, "Continuando");
                
                break;
        
            case "2":
                JOptionPane.showMessageDialog(frame, "Fechando");

                break;

            default:
                JOptionPane.showMessageDialog(frame, "Opção inválida");

                break;
        }

        // Atv 4
        List<String> lista = List.of("Channel", "Prada", "Dolce Gabana", "Versace", "Saint Laurent", "Gucci");

        String marcas = (String) JOptionPane.showInputDialog(frame, "Escolha a marca da sua roupa: ", "A marca escolhida foi: ", JOptionPane.QUESTION_MESSAGE, null, lista.toArray(), lista.toArray()[0]);

        JOptionPane.showMessageDialog(frame, "Essa é a marca da sua roupa: " + marcas);

        // Atv 5
        if (marcas.equals("Gucci")) {
            throw new CustomExceptionf("Essa marca é ruim!"); 
        }

        // Atv 6 
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

                JOptionPane.showMessageDialog(frame, "resultado = " + resultado);

                break;
            case "subtração":
                resultado = numero1 - numero2;
                JOptionPane.showMessageDialog(frame, "resultado = " + resultado);

            case "multiplicação":
                resultado = numero1 * numero2;
                JOptionPane.showMessageDialog(frame, "resultado = " + resultado);
                break;

            case "divisão":
                if (numero1 == 0 || numero2 == 0) {
                    JOptionPane.showMessageDialog(frame, "Não é possivel dividir por zero!", "Errado", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    resultado = numero1 / numero2;
                    JOptionPane.showMessageDialog(frame, "resultado = " + resultado);
                }
                break;
            default:
              
                break;
        }
    }

}
