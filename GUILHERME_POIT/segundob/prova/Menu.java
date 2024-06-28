package GUILHERME_POIT.segundob.prova;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private ApiService apiService;

    public Menu() {
        apiService = new ApiService();

        setTitle("Menu");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel label = new JLabel("Escolha uma opção:");
        label.setBounds(10, 20, 200, 25);
        panel.add(label);

        JButton listButton = new JButton("Listagem dos alunos");
        listButton.setBounds(10, 50, 200, 25);
        panel.add(listButton);

        JButton createButton = new JButton("Criar registro de testemunho");
        createButton.setBounds(10, 80, 200, 25);
        panel.add(createButton);

        JButton exitButton = new JButton("Sair");
        exitButton.setBounds(10, 110, 200, 25);
        panel.add(exitButton);

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listStudents();
            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTestimonial();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void listStudents() {
        try {
            String response = apiService.getStudents();
            JOptionPane.showMessageDialog(this, response, "Listagem dos Alunos", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            showErrorModal(e.getMessage());
        }
    }

    private void createTestimonial() {
        JTextField photoUrlField = new JTextField();
        JTextField raField = new JTextField();
        JTextField textField = new JTextField();

        Object[] message = {
                "URL da Foto:", photoUrlField,
                "RA do Aluno:", raField,
                "Texto do Testemunho:", textField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Criar Testemunho", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String imageUrl = photoUrlField.getText();
            String ra = raField.getText();
            String text = textField.getText();

            try {
                String response = apiService.createTestimonial(imageUrl, ra, text);
                JOptionPane.showMessageDialog(this, response, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                showErrorModal(e.getMessage());
            }
        }
    }

    private void showErrorModal(String message) {
        JOptionPane.showMessageDialog(this, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
