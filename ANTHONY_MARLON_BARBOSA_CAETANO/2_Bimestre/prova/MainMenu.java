import java.io.IOException;

import javax.swing.*;

public class MainMenu {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Menu Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        frame.add(panel);

        JButton listarAlunosButton = new JButton("Listar Alunos");
        JButton criarTestemunhoButton = new JButton("Criar Testemunho");
        JButton sairButton = new JButton("Sair");

        panel.add(listarAlunosButton);
        panel.add(criarTestemunhoButton);
        panel.add(sairButton);

        listarAlunosButton.addActionListener(e -> {
            try {
                String alunos = APIManager.listarAlunos();
                JOptionPane.showMessageDialog(null, "Alunos:\n" + alunos, "Lista de Alunos", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                ErrorModal.showError("Erro ao listar alunos: " + ex.getMessage());
            }
        });

        criarTestemunhoButton.addActionListener(e -> {
            String urlFoto = JOptionPane.showInputDialog("Informe a URL da foto:");
            String ra = JOptionPane.showInputDialog("Informe o RA do aluno:");
            String texto = JOptionPane.showInputDialog("Informe o texto do testemunho:");

            try {
                String response = APIManager.criarTestemunho(urlFoto, ra, texto);
                JOptionPane.showMessageDialog(null, response, "Testemunho Criado com Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                ErrorModal.showError("Erro ao criar testemunho: " + ex.getMessage());
            }
        });

        sairButton.addActionListener(e -> {
            System.exit(0);
        });

        frame.pack();
        frame.setVisible(true);
    }
}