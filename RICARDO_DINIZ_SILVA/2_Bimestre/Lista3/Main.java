import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setSize(300, 300);
    JPanel panel = new JPanel();

    //atividade 1
    JOptionPane.showMessageDialog(panel, "Olá, Mundo!");

    //atividade 2
    String nome = JOptionPane.showInputDialog(panel, "Qual é o seu nome? ");      
    JOptionPane.showMessageDialog(panel, "Seja bem-vindo(a) " + nome);

    //atividade 3
    Integer escolha = JOptionPane.showConfirmDialog(panel, "Você quer continuar?");
    if (escolha == JOptionPane.YES_OPTION) {
      JOptionPane.showMessageDialog(panel, "Escolheu continuar");
    } else {
      JOptionPane.showMessageDialog(panel, "Escolheu sair");
      return;
    }

    //atividade 4
    List<String> opcoes = new ArrayList<String>();
    opcoes.add("opção 1");
    opcoes.add("opção 2");
    opcoes.add("opção 3");
    opcoes.add("não escolha essa opção");

    String opcaoEscolhida = (String) JOptionPane.showInputDialog(
      panel,
      "Escolha uma opção",
      null,
      JOptionPane.QUESTION_MESSAGE,
      null,
      opcoes.toArray(),
      opcoes.toArray()[0]
    );
    JOptionPane.showMessageDialog(panel, "Opção escolhida: " + opcaoEscolhida);

    //atividade 5
    if (opcaoEscolhida == "não escolha essa opção") {
      JOptionPane.showMessageDialog(panel, "Você escolheu a opção errada", null, JOptionPane.ERROR_MESSAGE);
    }

    //atividade 6
    List<String> operacoes = new ArrayList<String>();
    operacoes.add("Soma +");
    operacoes.add("Subtração -");
    operacoes.add("Multiplicação *");
    operacoes.add("Divisão /");

    String operacao = (String) JOptionPane.showInputDialog(
      panel,
      "Escolha uma operação para escolher",
      "Calculadora",
      JOptionPane.QUESTION_MESSAGE,
      null,
      operacoes.toArray(),
      operacoes.toArray()[0]
    );

    String primeiro = JOptionPane.showInputDialog(panel, "Digite o primeiro número: ");
    String segundo = JOptionPane.showInputDialog(panel, "Digite o segundo número: ");

    if (primeiro == null || segundo == null) {
      JOptionPane.showMessageDialog(panel, "Você precisa digitar um número", null, JOptionPane.ERROR_MESSAGE);
      return;
    }

    int resultado = 0;

    int primeiroNumero = Integer.parseInt(primeiro);
    int segundoNumero = Integer.parseInt(segundo);

    if (operacao == "Divisão /" && primeiroNumero == 0 || segundoNumero == 0) {
      JOptionPane.showMessageDialog(panel, "0 não é divisivel", null, JOptionPane.ERROR_MESSAGE);
      return;
    }

    switch (operacao) {
      case "Soma +":
        resultado = primeiroNumero + segundoNumero;
        break;
      case "Subtração -":
        resultado = primeiroNumero - segundoNumero;
        break;
      case "Multiplicação *":
        resultado = primeiroNumero * segundoNumero;
        break;
      case "Divisão /":
        resultado = primeiroNumero / segundoNumero;
        break;
    }
    JOptionPane.showMessageDialog(panel, "Resultado: " + resultado);

    frame.add(panel);
  }
}