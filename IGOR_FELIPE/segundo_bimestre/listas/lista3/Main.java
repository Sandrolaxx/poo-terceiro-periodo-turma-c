package segundo_bimestre.listas.lista3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Color;


public class Main {

    public static void helloWorld(JFrame frame){
       
        JOptionPane.showMessageDialog(frame, "Hello World!");

    }

    public static void boasVindas(JFrame frame){

        String nome = JOptionPane.showInputDialog("Digite seu nome:");

        JOptionPane.showMessageDialog(frame,"Seja bem vindo "+nome);
    };

    public static void confirmarEntrada(JFrame frame){

        int confirmar = JOptionPane.showConfirmDialog(frame, "Deseja continuar?\n1-Sim\n2-Não");
        if(confirmar == 0){
            JOptionPane.showMessageDialog(frame, "Entrando...");
        }
        if(confirmar == 1){
            JOptionPane.showMessageDialog(frame, "Saindo...");
            frame.dispose();
        }

    }

    public static void opcoes(JFrame frame){
        String[] opcoes = {"Opção 1", "Opção 2", "Opção 3"};
        String escolher = (String) JOptionPane.showInputDialog(null, "Escolha uma opção: ", "Opções:", JOptionPane.QUESTION_MESSAGE,null,opcoes,opcoes[0]);

        if (escolher != null) {
            switch (escolher) {
                case "Opção 1":
                    JOptionPane.showMessageDialog(null, "Você escolheu a Opção 1");
                    break;
                case "Opção 2":
                    JOptionPane.showMessageDialog(null, "Você escolheu a Opção 2");
                    break;
                case "Opção 3":
                    JOptionPane.showMessageDialog(null, "Você escolheu a Opção 3");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção desconhecida");
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma opção foi escolhida");
        }
    }


    public static Double digitarNumero(JFrame frame){
        try{
            String numero = JOptionPane.showInputDialog(frame,"Digite um número");
            return Double.parseDouble(numero);
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //ATIVIDADE 1 ====================

        helloWorld(frame);

        //ATIVIDADE 2 ====================

        boasVindas(frame);

        //ATIVIDADE 3 ====================

        confirmarEntrada(frame);

        //ATIVIDADE 4 ====================

        opcoes(frame);

        //ATIVIDADE 5 ====================

        //ATIVIDADE 6 ====================
        JOptionPane.showMessageDialog(frame, "Bem vindo a calculadora");
        String escolha = JOptionPane.showInputDialog(frame, "Escolha a operação que deseja fazer: \n[1]Adição\n[2]Subtração\n[3]Multiplicação\n[4]Divisão\n[0]Sair");
        
        
        switch (escolha){
            case "1":
                Double case1n1 = digitarNumero(frame);
                Double case1n2 = digitarNumero(frame);
                Double soma = case1n1 + case1n2;
                JOptionPane.showMessageDialog(frame, case1n1+" + "+case1n2+" = "+soma);
            break;
            case "2":
                Double case2n1 = digitarNumero(frame);
                Double case2n2 = digitarNumero(frame);
                Double sub = case2n1 - case2n2;
                JOptionPane.showMessageDialog(frame, case2n1+" - "+case2n2+" = "+sub);
            break;
            case "3":
                Double case3n1 = digitarNumero(frame);
                Double case3n2 = digitarNumero(frame);
                Double mult = case3n1 * case3n2;
                JOptionPane.showMessageDialog(frame, case3n1+" * "+case3n2+" = "+mult);
            
            break;
            case "4":
                Double case4n1 = digitarNumero(frame);
                Double case4n2 = digitarNumero(frame);
                Double div = case4n1 / case4n2;
                JOptionPane.showMessageDialog(frame, case4n1+" / "+case4n2+" = "+div);

            break;
            case "0":
                frame.dispose();
            break;
            default:
                JOptionPane.showMessageDialog(null, "INFORME UM NÚMERO VÁLIDO","ERRO",JOptionPane.ERROR_MESSAGE);
            break;

        }


    }
}
