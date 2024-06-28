package LUCAS_EDUARDO_DE_LIMA.segundobimestre.prova;

import javax.swing.*;

public class Modal {
    public static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void showSuccess(String message) {
        JOptionPane.showMessageDialog(null, message, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
}
