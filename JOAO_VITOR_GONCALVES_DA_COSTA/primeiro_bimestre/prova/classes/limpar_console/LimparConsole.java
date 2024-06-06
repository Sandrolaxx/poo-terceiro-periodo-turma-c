package prova.classes.limpar_console;

import java.io.IOException;

public class LimparConsole {
  public static void limparConsole() {
    try {
      if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Windows
      else
        new ProcessBuilder("clear").inheritIO().start().waitFor(); // Linux
    } catch (IOException | InterruptedException ex) {
      ex.printStackTrace();
    }
  }
}
