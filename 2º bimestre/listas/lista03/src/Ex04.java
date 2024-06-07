import javax.swing.JOptionPane;

public class Ex04 {

    public static void main(String[] args) {
        int opcaoEscolhida = mostrarMenuOpcoes();
        exibirMensagemOpcao(opcaoEscolhida);
    }

    private static int mostrarMenuOpcoes() {
        String[] opcoes = {"Opção 1", "Opção 2", "Opção 3"};

        return JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu de Opções",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
    }

    private static void exibirMensagemOpcao(int opcaoEscolhida) {
        String[] mensagens = {
                "Você escolheu a Opção 1!",
                "Você escolheu a Opção 2!",
                "Você escolheu a Opção 3!"
        };

        if (opcaoEscolhida >= 0 && opcaoEscolhida < mensagens.length) {
            JOptionPane.showMessageDialog(null, mensagens[opcaoEscolhida]);
        } else {
            JOptionPane.showMessageDialog(null, "Opção inválida.");
        }
    }
}
