package listas.lista_04.classes.painelInterativo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import listas.lista_03.MinhaExcecao;
import listas.lista_04.classes.paymentListService.PaymentListService;
import listas.lista_04.classes.ticket.BillCheck;

public class PainelInterativo {

  static JFrame frame = new JFrame("Lista 04");

  public static void start() {
    Object[] opcoes = { "1", "2", "3" };

    frame.setSize(500, 450);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    int choice;

    do {
      choice = JOptionPane.showOptionDialog(null,
          "Escolha uma opção: \n 1. Listar convênios de pagamento \n 2. Consultar um boleto \n 3. Sair",
          "Opções", JOptionPane.YES_NO_CANCEL_OPTION,
          JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

      handleUserChoice(choice);
    } while (choice != 2 && choice != -1);

    frame.dispose();
  }

  public static void handleUserChoice(int choice) {
    JTextArea textArea = new JTextArea();
    textArea.setEditable(false);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);

    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setPreferredSize(new Dimension(500, 300));

    switch (choice) {
      case 0:

        String paymentList = PaymentListService.listPaymentAgreements();
        String[] paymentListStrings = handlePaymentsList(paymentList);

        for (String value : paymentListStrings) {
          textArea.append(value + "\n");
        }

        JOptionPane.showMessageDialog(frame, scrollPane, "Opções de pagamento", JOptionPane.PLAIN_MESSAGE);

        break;
      case 1:

        String barCode = JOptionPane.showInputDialog(
            null,
            "Digite a linha digitável",
            "Código de barras",
            JOptionPane.QUESTION_MESSAGE);

        if (barCode.matches(".*[a-zA-Z].*")) {
          JOptionPane.showMessageDialog(frame, "Nâo pode letras", "ERRO", JOptionPane.ERROR_MESSAGE);
          return;
        }

        String jsonBarCode = BillCheck.checkBill(barCode);

        if (jsonBarCode == null) {
          JOptionPane.showMessageDialog(frame, "Erro ao ler o código de barras", "ERRO", JOptionPane.ERROR_MESSAGE);
          return;
        }

        Map<String, Object> formatedJsonBarCode = handleBillCheck(jsonBarCode);

        for (Map.Entry<String, Object> entry : formatedJsonBarCode.entrySet()) {
          textArea.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }

        JOptionPane.showMessageDialog(frame, scrollPane, "Boleto", JOptionPane.PLAIN_MESSAGE);

        break;
      case 2:
        JOptionPane.showMessageDialog(null, "Finalizando conexões", "Fechando", 0);
        break;
      default:
        break;
    }
  }

  public static String[] handlePaymentsList(String paymentList) {
    String patternString = "\"convenants\":\\s*\\[([^\\]]*)\\]";

    Pattern pattern = Pattern.compile(patternString);
    Matcher matcher = pattern.matcher(paymentList);

    List<String> convenantsValues = new ArrayList<>();

    if (matcher.find()) {
      String convenantsArray = matcher.group(1);

      String objectPatternString = "\\{([^}]*)\"Nomeconvenant\":\"([^\"]*)\"([^}]*)\"Tipoconvenant\":\"([^\"]*)\"([^}]*)\"statesconvenant\":\"([^\"]*)\"([^}]*)\\}";

      Pattern objectPattern = Pattern.compile(objectPatternString);
      Matcher objectMatcher = objectPattern.matcher(convenantsArray);

      while (objectMatcher.find()) {
        String nomeConvenant = objectMatcher.group(2);
        String tipoConvenant = objectMatcher.group(4);
        String statesConvenant = objectMatcher.group(6);

        String convenantValue = "Nome do convênio: " + nomeConvenant + ", tipo do convênio: " + tipoConvenant
            + ", estados do convênio: " + statesConvenant;

        convenantsValues.add(convenantValue);
      }
    }

    return convenantsValues.toArray(new String[0]);
  }

  public static Map<String, Object> handleBillCheck(String bill) {
    Map<String, Object> map = new HashMap<>();

    bill = bill.replaceAll("[{}\"]", "");

    String[] keyValuePairs = bill.split(",");
    for (String pair : keyValuePairs) {
      String[] entry = pair.split(":", 2);
      String key = entry[0].trim();
      String value = entry[1].trim();
      if (value.startsWith("\"") && value.endsWith("\"")) {
        value = value.substring(1, value.length() - 1);
      }
      Object parsedValue = parseValue(value);
      map.put(key, parsedValue);
    }
    return map;
  }

  public static Object parseValue(String value) {
    try {
      return Double.parseDouble(value);
    } catch (NumberFormatException e) {
      return value;
    }
  }
}
