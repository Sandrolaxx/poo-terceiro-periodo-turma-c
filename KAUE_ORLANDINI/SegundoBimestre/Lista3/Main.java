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
    
    public static void Mensagem(String opcaoEscolhida) {
        if (opcaoEscolhida != null) {
            String mensagem = "Você escolheu a opção: " + opcaoEscolhida;
            JOptionPane.showMessageDialog(null, mensagem);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma opção foi selecionada.");
         }
    }


    
    
    
    

    public static void main(String[] args) {
        exibirMensagem();
        usuario();
        continuar();
        String opcaoEscolhida = mostrarMenu();
        Mensagem(opcaoEscolhida);

       
            
        
    } 
  }
