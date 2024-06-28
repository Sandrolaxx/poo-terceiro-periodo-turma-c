import javax.swing.JOptionPane;

public class Erro {

    public static void mostrarErro(String mensagem) {

        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
        
    }
}
