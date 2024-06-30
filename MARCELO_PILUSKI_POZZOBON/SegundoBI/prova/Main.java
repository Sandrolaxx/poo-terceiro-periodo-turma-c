package MARCELO_PILUSKI_POZZOBON.SegundoBI.prova;

import java.util.List;
import javax.swing.JOptionPane;

public class Main {
      public static void main(String[] args) {
            JOptionPane.showMessageDialog(null, "Iniciando Software!", "Requests", 1);
            perguntas();
      }

      public static void perguntas() {
            List<String> options = List.of("Listagem de Alunos", "Criar Testemunho", "Sair");
            String operation = (String) JOptionPane.showInputDialog(null, "Escolha uma opção de Request", null, 3, null,
                        options.toArray(), options.toArray()[0]);

            switch (operation) {
                  case "Listagem de Alunos":
                        ListagemRequest requestListagem = new ListagemRequest();
                        StringBuilder strResponse = new StringBuilder();
                        strResponse = requestListagem.getListagem();
                        JOptionPane.showMessageDialog(null, strResponse, "Amém", 1);
                        break;

                  case "Criar Testemunho":
                        TestemunhoPost requestTestemunho = new TestemunhoPost();
                        requestTestemunho.postRequest();
                        break;

                  case "Sair":
                        JOptionPane.showMessageDialog(null, "Saindo da aplicação");
                        break;

                  default:
                        System.out.println("Fez o impossível, parabéns!");
                        break;
            }
      }
}