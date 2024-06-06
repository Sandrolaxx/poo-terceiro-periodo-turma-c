package segundob.listas.lista3;

import javax.swing.*;

public class CustomException extends Exception {

    public CustomException(String errorMsg) {
        super(errorMsg);
        mensagemErro(errorMsg);
    }

    private void mensagemErro(String errorMsg) {
        JOptionPane.showMessageDialog(null,
                errorMsg,
                "Erro",
                JOptionPane.ERROR_MESSAGE);
    }
}
