package pooprova;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int opcao = JOptionPane.showOptionDialog(null,
                "Selecione uma opção:",
                "Menu",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[] { "Listar Alunos", "Criar Testemunho", "Sair"},
                JOptionPane.DEFAULT_OPTION);
                

        switch (opcao) {
            case 0:
                listarAlunos();
                break;
            case 1:
                criarTestemunho();
                break;

            case 2:
                System.exit(0);;
            default:
                JOptionPane.showMessageDialog(null, "Nenhuma opção foi selecionada!");
        }
    }

    private static void listarAlunos() {
        try {
            String message = ListarAlunos.listarAlunos();
            System.out.println(message);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo deu errado. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void criarTestemunho() {
        try {
            Testimonial.criarTestemunho();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo deu errado. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}