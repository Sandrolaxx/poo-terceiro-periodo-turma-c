package listas.lista_03;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

  public static void main(String[] args) {
    // atv1();
    // atv2();
    // atv3();
    // atv4();
    // atv5("Troca o óleo");
    atv6();
  }

  // Atv1 - Crie um método em Java que exiba uma mensagem simples "Olá, Mundo!"
  // usando JOptionPane.

  public static void atv1() {
    JOptionPane.showMessageDialog(null, "Olá, mundo!", "Olá, mundo!", 0);
  }

  // Atv2 - Crie um método que solicite ao usuário seu nome e exiba uma mensagem
  // de boas-vindas.

  public static void atv2() {
    String nome_do_usuario = JOptionPane.showInputDialog(
        null,
        "Digite seu nome",
        "Entrada de nome",
        JOptionPane.QUESTION_MESSAGE);

    JOptionPane.showMessageDialog(null, "Bem vindo(a) ".concat(nome_do_usuario), "Salve", 0);
  }

  // Atv3 - Crie um método que pergunte(showConfirmDialog) ao usuário se ele
  // deseja continuar e exiba uma mensagem conforme a resposta.

  public static void atv3() {
    Integer si_no = JOptionPane.showConfirmDialog(
        null,
        "Deseja continuar e ver a mensagem secreta?",
        "Confirm",
        JOptionPane.YES_NO_OPTION);

    if (si_no == 0) {
      JOptionPane.showMessageDialog(null, "Sai daí curioso", "Curioso", 0);
    }
  }

  // Atv4 - Crie um método que apresente uma lista de opções ao usuário e exiba
  // uma mensagem segundo a opção escolhida. Exemplos de lista("Opção 1", "Opção
  // 2", "Opção 3").

  public static void atv4() {
    Object[] opcoes = { "Opção 1", "Opção 2", "Opção 3" };

    int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Opções", JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

    switch (escolha) {
      case 0:
        JOptionPane.showMessageDialog(null, "Celta 2015", "carro", 0);
        break;
      case 1:
        JOptionPane.showMessageDialog(null, "prisma 2014", "carro", 0);
        break;
      case 2:
        JOptionPane.showMessageDialog(null, "Cg 150", "moto", 0);
        break;
      default:
        JOptionPane.showMessageDialog(null, "Opcão inválida", "Ruim", 0);
        break;
    }

  }

  // Atv5 - Crie uma exceção personalizada que apresente um dialog(ERROR_MESSAGE)
  // com a mensagem do erro que ocorreu.

  public static void atv5(String mensagem) throws MinhaExcecao {
    throw new MinhaExcecao(mensagem);
  }

  // Atv6 - Crie uma calculadora utilizando JOptionPane, apresente as quatro
  // opções matemáticas ao usuário, após selecionada a opção e avançar, requisite
  // os dois números para realizar o cálculo, apresente o resultado em um
  // dialog(INFORMATION_MESSAGE) e em caso de erro lance sua exceção personalizada
  // da atividade 5.

  public static void atv6() {
    try {
      String num_01 = JOptionPane.showInputDialog(
          null,
          "Digite um número",
          "Num 1",
          JOptionPane.QUESTION_MESSAGE);

      if (!num_01.matches(".*[0-9].*")) {
        throw new MinhaExcecao("Não pode letra né mano");
      }

      String num_02 = JOptionPane.showInputDialog(
          null,
          "Digite um número",
          "Num 2",
          JOptionPane.QUESTION_MESSAGE);

      if (!num_02.matches(".*[0-9].*")) {
        throw new MinhaExcecao("Não pode letra né mano");
      }

      Object[] opcoes = { "/", "+", "-", "*", "%" };

      int escolha = JOptionPane.showOptionDialog(null,
          "Escolha uma opção (calculo será realizado como 1º número escolhido 'operação' 2º número escolhido)",
          "Calculadora dos guri", JOptionPane.YES_NO_CANCEL_OPTION,
          JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

      handleOperation(escolha, num_01, num_02);
    } catch (Exception e) {
      if (e.getMessage() != null)
        atv6();
    }
  }

  public static int tranformToInt(String num) {
    int novoNumero = Integer.parseInt(num);
    return novoNumero;
  }

  public static void handleOperation(int escolha, String num_01, String num_02) {
    try {
      double double_01 = tranformToDouble(num_01);
      double double_02 = tranformToDouble(num_02);

      switch (escolha) {
        case 0:
          JOptionPane.showMessageDialog(null,
              "Divisão entre ".concat(num_01).concat(" e ").concat(num_02 + ": \n") + (double_01 / double_02),
              "Divisão",
              JOptionPane.INFORMATION_MESSAGE);
          break;
        case 1:
          JOptionPane.showMessageDialog(null,
              "Soma entre ".concat(num_01).concat(" e ").concat(num_02 + ": \n") + (double_01 + double_02), "Soma",
              JOptionPane.INFORMATION_MESSAGE);
          break;
        case 2:
          JOptionPane.showMessageDialog(null,
              "Subtração entre ".concat(num_01).concat(" e ").concat(num_02 + ": \n") + (double_01 - double_02),
              "Subtração", JOptionPane.INFORMATION_MESSAGE);
          break;
        case 3:
          JOptionPane.showMessageDialog(null,
              "Multiplicação entre ".concat(num_01).concat(" e ").concat(num_02 + ": \n") + (double_01 * double_02),
              "Multiplicação", JOptionPane.INFORMATION_MESSAGE);
          break;
        case 4:
          JOptionPane.showMessageDialog(null,
              "Resto da divisão entre ".concat(num_01).concat(" e ").concat(num_02 + ": \n") + (double_01 % double_02),
              "Resto da divisão", JOptionPane.INFORMATION_MESSAGE);
          break;
        default:
          throw new MinhaExcecao("Operação nao encontrada");
      }
      // "/", "+", "-", "*", "%"
    } catch (Exception e) {
      System.out.println(e.getMessage());
      if (e.getMessage() != null)
        atv6();
    }

  }

  public static double tranformToDouble(String num) {
    double novoNumero = Double.parseDouble(num);
    return novoNumero;
  }
}
