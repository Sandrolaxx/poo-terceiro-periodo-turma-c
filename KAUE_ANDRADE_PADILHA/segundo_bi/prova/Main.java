package KAUE_ANDRADE_PADILHA.segundo_bi.prova;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {
  public static void main(String[] args) {
    List<String> options = new ArrayList<>(List.of(
      "1 - Listagem de alunos",
      "2 - Criar registro de testemunho",
      "3 - Sair"
    ));

    String userResponse = (String) JOptionPane.showInputDialog(
      null,
      "Escolha uma opção",
      "Opções",
      JOptionPane.QUESTION_MESSAGE,
      null,
      options.toArray(),
      options.toArray()[0]
    );

    switch (userResponse) {
      case "1 - Listagem de alunos":
        String listagemResponse = ListagemAlunos.getJsonData();
        JOptionPane.showMessageDialog(null, listagemResponse, "Listagem de alunos", JOptionPane.INFORMATION_MESSAGE);
        break;
      case "2 - Criar registro de testemunho":
          CriarTestemunho.sendRequest();
          break;
      case "3 - Sair":
        System.exit(0);
        break;
      default:
        JOptionPane.showMessageDialog(null, "Opção inválida!", "ERRO", JOptionPane.ERROR_MESSAGE);
        break;
    }
  }
}