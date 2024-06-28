import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    //ATV01
    JOptionPane.showMessageDialog(null, "Olá, Mundo!");

    //ATV02
    String nome = JOptionPane.showInputDialog(null, "digite seu primeiro nome");      
    JOptionPane.showMessageDialog(null, "bem-vindo " + nome + "." );

    //ATV03
    int escolha = JOptionPane.showConfirmDialog(null, "qual sua escolha?");
    switch (escolha) {
      case JOptionPane.YES_OPTION:
        JOptionPane.showMessageDialog(null, "Você escolheu continuar");
        break;
      case JOptionPane.NO_OPTION:
        JOptionPane.showMessageDialog(null, "Você escolheu não continuar");
        break;
      default:
        JOptionPane.showMessageDialog(null, "Você escolheu cancelar");
        break;
    }

    //ATV04
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    
    JPanel painel = new JPanel();

    List<String> carros = new ArrayList<String>();
    carros.add("Golf");
    carros.add("Jetta");
    carros.add("Lancer");
    carros.add("Civic");
    carros.add("Corolla");

    String carroEscolhido = (String) JOptionPane.showInputDialog(
      painel,
      "Escolha uma opção",
      "Carros",
      JOptionPane.QUESTION_MESSAGE,
      null,
      carros.toArray(),
      carros.toArray()[0]
    );
    JOptionPane.showMessageDialog(painel, "Você escolheu o: " + carroEscolhido);

    //ATV05
    if (carroEscolhido == "Corolla") {
      JOptionPane.showMessageDialog(painel, "não pode carro de veio", "Escolheu um carro de veio", JOptionPane.ERROR_MESSAGE);
    }

    frame.add(painel);
    frame.setVisible(true);

    //ATV06
    List<String> escolhaOperacao = new ArrayList<String>();
    escolhaOperacao.add("somar");
    escolhaOperacao.add("subtrair");
    escolhaOperacao.add("multiplicar");
    escolhaOperacao.add("dividir");

    String operacao = (String) JOptionPane.showInputDialog(
      painel,
      "Escolha uma operação para escolher",
      "Calculadora",
      JOptionPane.QUESTION_MESSAGE,
      null,
      escolhaOperacao.toArray(),
      escolhaOperacao.toArray()[0]
    );

    int primeiro = Integer.parseInt(JOptionPane.showInputDialog(painel, "Digite o primeiro número: "));
    int segundo = Integer.parseInt(JOptionPane.showInputDialog(painel, "Digite o segundo número: "));

    int resposta = 0;

    switch (operacao) {
      case "somar":
        resposta = primeiro + segundo;
        break;
      case "subtrair":
        resposta = primeiro - segundo;
        break;
      case "multiplicar":
        resposta = primeiro * segundo;
        break;
      case "dividir":
        if (segundo == 0 || primeiro == 0) {
          JOptionPane.showMessageDialog(painel, "não tem como dividir por 0");
          return;
        }
        resposta = primeiro / segundo;
        break;
    }
    JOptionPane.showMessageDialog(painel, "resposta: " + resposta);
  }
}