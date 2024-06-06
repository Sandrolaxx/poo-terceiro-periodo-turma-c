import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {

  public static void main(String[] args) {

    JFrame frame = new JFrame("Lista 3 de Java POO");
    frame.setSize(400, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();

    // Atv1 - Crie um método em Java que exiba uma mensagem simples "Olá, Mundo!" usando JOptionPane.
    JOptionPane.showMessageDialog(panel, "Olá, Mundo!");

    // Atv2 - Crie um método que solicite ao usuário seu nome e exiba uma mensagem de boas-vindas.
    String nome = JOptionPane.showInputDialog(panel, "Digite seu nome", null, JOptionPane.QUESTION_MESSAGE).toString();      
    JOptionPane.showMessageDialog(panel, "Seja muito Bem-Vindo!! " + nome);

    // Atv3 - Crie um método que pergunte(showConfirmDialog) ao usuário se ele deseja continuar e exiba uma mensagem conforme a resposta.
    int escolha = JOptionPane.showConfirmDialog(panel, "Usuário, deseja continuar?");
    if (escolha == JOptionPane.YES_OPTION) {
        JOptionPane.showMessageDialog(panel, "Continuando");
      } else {
        JOptionPane.showMessageDialog(panel, "Não continuando");
      }

    // Atv4 - Crie um método que apresente uma lista de opções ao usuário e exiba uma mensagem segundo a opção escolhida. Exemplos de lista("Opção 1", "Opção 2", "Opção 3").
    String escolhaOpcao = (String) JOptionPane.showInputDialog(
      panel,
      "Escolha uma opção da lista!",
      "Escolha de Opção",
      JOptionPane.QUESTION_MESSAGE,
      null,
      new String[] { "Opção 1", "Opção 2", "Opção 3" },
      "Corolla"
    );

    JOptionPane.showMessageDialog(panel, "Escolha: " + escolhaOpcao);

    // Atv5 - Crie uma exceção personalizada que apresente um dialog(ERROR_MESSAGE) com a mensagem do erro que ocorreu.
    try {
      throw new Exception("Erro personalizado");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(panel, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
    }

    // Atv6 - Crie uma calculadora utilizando JOptionPane, apresente as quatro opções matemáticas ao usuário, após selecionada a opção e avançar, requisite os dois números para realizar o cálculo, apresente o resultado em um dialog(INFORMATION_MESSAGE) e em caso de erro lance sua exceção personalizada da atividade 5.
    String operacaoEscolhida = (String) JOptionPane.showInputDialog(
      panel,
      "Escolha uma operação para escolher",
      "Calculadora",
      JOptionPane.QUESTION_MESSAGE,
      null,
      new String[] { "Soma", "Subtração", "Multiplicação", "Divisão" },
      "Soma"
    );

    Integer n1 = Integer.parseInt(JOptionPane.showInputDialog(panel, "Digite o 1° Número:"));
    Integer n2 = Integer.parseInt(JOptionPane.showInputDialog(panel, "Digite o 2° Número:"));

    Integer calculoFinal = 0;

    switch (operacaoEscolhida) {
      case "Soma":
        calculoFinal = n1 + n2;
        break;
      case "Subtração":
        calculoFinal = n1 - n2;
        break;
      case "Multiplicação":
        calculoFinal = n1 * n2;
        break;
      case "Divisão":
        if (n2 == 0 || n1 == 0) {
          try {
            throw new Exception("Erro ao tentar dividir por 0");
          } catch (Exception e) {
            JOptionPane.showMessageDialog(panel, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
          }
        }
        calculoFinal = n1 / n2;
        break;
      default:
        break;
    }

    JOptionPane.showMessageDialog(panel, "Resultado = " + calculoFinal);
    frame.add(panel);

  }

}