import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {
  public static void main(String[] args) {
    JPanel panel = new JPanel();

    // Atividade 01
    showMessage(panel, "Olá, Mundo!");

    // Atividade 02
    String nome = JOptionPane.showInputDialog(panel, "Digite seu nome: ");
    if (nome.isEmpty()) {
      showErrorMessage(panel, "Nome inválido!", "ERRO: Nome inválido");
      return;
    }
    showMessage(panel, "Olá, " + nome + "!");

    // Atividade 03
    Integer resposta = JOptionPane.showConfirmDialog(panel, nome + ", Deseja continuar?");
    if (resposta == 0) {
      showMessage(panel, "Continuando...");
    } else {
      showMessage(panel, "Saindo...");
      return;
    }

    // Atividade 04
    List<String> jogos = new ArrayList<String>(List.of(
      "Elden Ring",
      "Red Dead Redemption 2",
      "Days Gone",
      "Minecraft",
      "League of Legends"
    ));

    String jogoFavorito = (String) JOptionPane.showInputDialog(
      panel,
      "Qual seu jogo favorito?",
      "Jogos",
      JOptionPane.QUESTION_MESSAGE,
      null,
      jogos.toArray(),
      jogos.toArray()[0]
    );
    showMessage(panel, nome + ", Seu jogo favorito é " + jogoFavorito);

    // Atividade 05
    if (jogoFavorito == "League of Legends") {
      showErrorMessage(panel, "Você não pode gostar de League of Legends!", "ERRO: Jogo inválido");
    }

    // Atividade 06
    List<String> operacoes = new ArrayList<String>(List.of(
      "Soma",
      "Subtração",
      "Multiplicação",
      "Divisão"
    ));

    String operacao = (String) JOptionPane.showInputDialog(
      panel,
      "Qual operação deseja realizar?",
      "Operações",
      JOptionPane.QUESTION_MESSAGE,
      null,
      operacoes.toArray(),
      operacoes.toArray()[0]
    );

    Integer num1 = Integer.parseInt(JOptionPane.showInputDialog(panel, "Digite o primeiro número: "));
    Integer num2 = Integer.parseInt(JOptionPane.showInputDialog(panel, "Digite o segundo número: "));
    Integer resultado = 0;

    switch (operacao) {
      case "Soma":
        resultado = num1 + num2;
        break;
      case "Subtração":
        resultado = num1 - num2;
        break;
      case "Multiplicação":
        resultado = num1 * num2;
        break;
      case "Divisão":
        if (num1 == 0 || num2 == 0) {
          showErrorMessage(panel, "Não é possível dividir por 0!", "ERRO: Divisão por 0");
          return;
        } else {
          resultado = num1 / num2;
        }
        break;
      default:
        showErrorMessage(panel, "Escolha uma operação válida", "ERRO: Operação inválida");
        break;
    }

    showMessage(panel, "O resultado é: " + resultado);
  }

  // Métodos auxiliares
  public static void showErrorMessage(JPanel panel, String message, String title) {
    JOptionPane.showMessageDialog(
      panel,
      message,
      title,
      JOptionPane.ERROR_MESSAGE
    );
  }

  public static void showMessage(JPanel panel, String message) {
    JOptionPane.showMessageDialog(
      panel,
      message
    );
  }
}