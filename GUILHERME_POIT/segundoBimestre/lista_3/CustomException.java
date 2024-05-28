package segundoBimestre.lista_3;

import javax.swing.JOptionPane;

// Definição da exceção personalizada
public class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
        // Exibe o diálogo de erro
        JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
