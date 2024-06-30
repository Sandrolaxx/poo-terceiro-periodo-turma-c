package CLARA_LIOTTO.segundob.prova;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

public class ListagemTestemunho {
    public static void main(String[] args) {
        while (true) {
            List <String> options = List.of("Listar Alunos", "Enviar Testemunho"); 
            int selectOption = JOptionPane.showOptionDialog(null, "Selecione uma opção", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options.toArray(), options.toArray()[0]);

            if (selectOption == -1) {
                System.out.println("Saindo");
                return;
            }
            switch (selectOption) {
                case 0 -> listarAlunos();
                case 1 -> enviarTestemunho();
                
            }

        }
    }

    public static void listarAlunos(){
        try{
            String reposta = TestHttp.listarAlunos();
            System.out.println(reposta);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro em listar alunos", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    private static void enviarTestemunho() {
        try {
            String resposta = TestHttp.enviarTestemunho();
        } catch (IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Erro em enviar testemunho", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
