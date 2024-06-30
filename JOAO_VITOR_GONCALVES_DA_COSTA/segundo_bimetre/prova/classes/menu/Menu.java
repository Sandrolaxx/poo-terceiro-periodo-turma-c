package JOAO_VITOR_GONCALVES_DA_COSTA.segundo_bimetre.prova.classes.menu;

import javax.swing.JOptionPane;

import JOAO_VITOR_GONCALVES_DA_COSTA.segundo_bimetre.prova.classes.http.Http;

public class Menu {

  public static void start() {
    Object[] opcoes = { "Listar alunos", "Salvar testemunho", "Sair" };
    int choice;
    do {
      choice = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Opções", JOptionPane.YES_NO_CANCEL_OPTION,
          JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
      handleUserChoice(choice);
    } while (choice != 2 && choice != -1);
  }

  public static void handleUserChoice(int choice) {
    switch (choice) {
      case 0:
        String responseGet = Http.getStudents();
        if (responseGet == null) {
          return;
        }

        String[] itens = responseGet.replace("{\"data\":[", "").replace("{", "").replace("}", "").replace("]", "")
            .split(",");

        JOptionPane.showMessageDialog(null, itens, "Alunos", 0);
        break;
      case 1:
        // https://avatars.githubusercontent.com/u/127047416?v=4 meu ra: 11030
        String imageUrl = JOptionPane.showInputDialog(
            null,
            "URL da imagem",
            "Entrada de imagem",
            JOptionPane.QUESTION_MESSAGE);
        String description = JOptionPane.showInputDialog(
            null,
            "Descrição da mensagem",
            "Descrição",
            JOptionPane.QUESTION_MESSAGE);
        String ra = JOptionPane.showInputDialog(
            null,
            "Ra do usuário",
            "Ra",
            JOptionPane.QUESTION_MESSAGE);
        String responsePost = Http.postTestimonial(imageUrl, description, ra);
        if (responsePost == null) {
          return;
        }

        JOptionPane.showMessageDialog(null, "Sucesso pra firma", "Mensagem salva", 0);
        break;
      case 2:
        JOptionPane.showMessageDialog(null, "Finalizando aplicação", "Saindo", 0);
        break;
      case -1:
        JOptionPane.showMessageDialog(null, "Finalizando aplicação", "Saindo", 0);
        break;
      default:
        JOptionPane.showMessageDialog(null, "Opcão inválida", "Ruim", JOptionPane.WARNING_MESSAGE);
        break;
    }
  }
}
