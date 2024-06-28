package KAUE_ORLANDINI.SegundoBimestre.Lista3;

import javax.swing.JOptionPane;

public class Main {

    //ATV1
    public static void exibirMensagem(){
        JOptionPane.showMessageDialog(null, "ola mundo");
       }

    //ATV2   
    public static void usuario(){
        String nome = JOptionPane.showInputDialog("digite o seu nome");
        JOptionPane.showMessageDialog(null, "Seja bem vindo " + nome);
    }

    //ATV3
    public static void continuar(){
        int opcao = JOptionPane.showConfirmDialog(null,"deseja continuar?");
        if (opcao == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "continuando");
        
        }else if(opcao == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "encerrando");
        
        }else{
            JOptionPane.showMessageDialog(null, "escolha uma opcao");
        }
    
    }

    //ATV4
    public static String mostrarMenu() {
        String[] opcoes = {"Opção 1", "Opção 2", "cancelar"};
        int indiceSelecionado = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                null, opcoes, opcoes[0]);
    
         if (indiceSelecionado != JOptionPane.CANCEL_OPTION) {
            return opcoes[indiceSelecionado];
        } else {
            return null;
        }
    }
    
    public static void mensagem(String opcaoEscolhida) {
        if (opcaoEscolhida != null) {
            String mensagem = "Você escolheu a opção: " + opcaoEscolhida;
            JOptionPane.showMessageDialog(null, mensagem);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma opção foi selecionada.");
         }
    }

    //ATV5
    public static String errorMessage(String erro){
    
        JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
        return "erro";
    }

    //ATV6
    public static double calculadora(){
        String[] operacoes = {"soma", "subtracao", "divisao", "multilicacao"}; 
        int opcao = JOptionPane.showOptionDialog(null, "escolha uma operacao", "calculadora", 0, 0, null, operacoes, operacoes);
        String num1 = JOptionPane.showInputDialog(null, "digite o primeiro numero");
        String num2 = JOptionPane.showInputDialog(null, "digite o segundo numero");

        double num1String = 0;
        double num2String = 0;
        try{
            num1String = Double.parseDouble(num1);
            num2String = Double.parseDouble(num2);}
        catch (Exception e){
            errorMessage("Caractere digitado não numérico!");
        }

        double resultado = 0;
        
        switch (opcao) {
            case 0:
                resultado = num1String + num2String;
                JOptionPane.showMessageDialog(null,"resultado: " + resultado,"RESULTADO", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 1:
                resultado = num1String - num2String;
                JOptionPane.showMessageDialog(null,"resultado: " + resultado,"RESULTADO", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                if (num2String == 0 || num1String == 0) {
                    errorMessage("Não é possível realizar a operação!");
                    break;
                }
                JOptionPane.showMessageDialog(null,"resultado: " + resultado,"RESULTADO", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 3:
                resultado = num1String * num2String;
                JOptionPane.showMessageDialog(null,"resultado: " + resultado,"RESULTADO", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                break;
        }
       
        return 0;
    }
    public static void main(String[] args) {
        exibirMensagem();
        usuario();
        continuar();
        String opcaoEscolhida = mostrarMenu();
        mensagem(opcaoEscolhida);
        calculadora();
    } 
  }