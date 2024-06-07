import javax.swing.JOptionPane;

public class Ex03 {

    public static void main(String[] args) {
        boolean continuar = confirmarContinuacao();
        exibirMensagemResultado(continuar);
    }

    private static boolean confirmarContinuacao() {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Confirmação", JOptionPane.YES_NO_OPTION);
        return resposta == JOptionPane.YES_OPTION;
    }

    private static void exibirMensagemResultado(boolean continuar) {
        String mensagem;
        if (continuar) {
            mensagem = "Você escolheu continuar!";
        } else {
            mensagem = "Você escolheu não continuar.";
        }
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
