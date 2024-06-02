package listas.lista_03;

import javax.swing.JOptionPane;

public class MinhaExcecao extends Exception {
  public MinhaExcecao(String mensagem) {
    super(mensagem);
    // Exibe a mensagem de erro em um dialogo
    JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
  }
}