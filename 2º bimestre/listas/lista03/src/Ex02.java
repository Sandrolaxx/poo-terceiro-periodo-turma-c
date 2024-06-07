import javax.swing.JOptionPane;

public class Ex02 {

    public static void main(String[] args) {
        String nome = solicitarNome();
        exibirMensagemBoasVindas(nome);
    }

    private static String solicitarNome() {
        return JOptionPane.showInputDialog(null, "Qual é o seu nome?");
    }

    private static void exibirMensagemBoasVindas(String nome) {
        JOptionPane.showMessageDialog(null, "Seja bem-vindo(a), " + nome + "!");
    }
}
