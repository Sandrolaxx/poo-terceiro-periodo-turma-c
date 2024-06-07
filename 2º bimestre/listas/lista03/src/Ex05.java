import javax.swing.JOptionPane;

public class Ex05 {

    public static void main(String[] args) {
        try {
            int resultado = dividir(10, 0);
            System.out.println("Resultado: " + resultado);
        } catch (MinhaExcecaoPersonalizada e) {
            e.mostrarDialogoErro();
        }
    }

    private static int dividir(int dividendo, int divisor) throws MinhaExcecaoPersonalizada {
        if (divisor == 0) {
            throw new MinhaExcecaoPersonalizada("Não é possível dividir por zero!");
        }
        return dividendo / divisor;
    }
}

class MinhaExcecaoPersonalizada extends Exception {

    private String mensagemErro;

    public MinhaExcecaoPersonalizada(String mensagemErro) {
        super(mensagemErro);
        this.mensagemErro = mensagemErro;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public void mostrarDialogoErro() {
        JOptionPane.showMessageDialog(null, mensagemErro, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
