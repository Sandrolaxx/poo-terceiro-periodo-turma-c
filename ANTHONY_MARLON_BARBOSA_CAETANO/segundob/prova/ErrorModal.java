package ANTHONY_MARLON_BARBOSA_CAETANO.segundob.prova;

import javax.swing.*;

public class ErrorModal {
    public static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}

