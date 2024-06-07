package Lista3;

import javax.swing.JOptionPane;

public class CustomExceptionf extends RuntimeException {
    CustomExceptionf(String erro){
        JOptionPane.showMessageDialog(null,erro, "Errado", JOptionPane.ERROR_MESSAGE);
    }
}
