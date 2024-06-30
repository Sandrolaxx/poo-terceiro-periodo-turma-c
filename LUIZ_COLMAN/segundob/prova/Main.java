package LUIZ_COLMAN.segundob.prova;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Menu");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);

            JPanel panel = new JPanel();
            frame.add(panel);
            placeComponents(panel);

            frame.setVisible(true);
        });
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JButton listStudentsButton = new JButton("Listagem dos alunos");
        listStudentsButton.setBounds(50, 20, 200, 25);
        panel.add(listStudentsButton);

        JButton createTestimonialButton = new JButton("Criar registro de testemunho");
        createTestimonialButton.setBounds(50, 60, 200, 25);
        panel.add(createTestimonialButton);

        JButton exitButton = new JButton("Sair");
        exitButton.setBounds(50, 100, 200, 25);
        panel.add(exitButton);

        listStudentsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listStudents();
            }
        });

        createTestimonialButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createTestimonial();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private static void listStudents() {
        try {
            String response = ApiService.getStudents();
            JOptionPane.showMessageDialog(null, response, "Listagem dos Alunos", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            showErrorModal(e.getMessage());
        }
    }

    private static void createTestimonial() {
        JTextField urlField = new JTextField();
        JTextField textField = new JTextField();
        JTextField raField = new JTextField();
        Object[] message = {
            "URL da Foto:", urlField,
            "Texto do Testemunho:", textField,
            "RA do Aluno:", raField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Criar Testemunho", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String imageUrl = urlField.getText();
            String description = textField.getText();
            String ra = raField.getText();
            try {
                String response = ApiService.createTestimonial(imageUrl, description, ra);
                JOptionPane.showMessageDialog(null, response, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                showErrorModal(e.getMessage());
            }
        }
    }

    private static void showErrorModal(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}