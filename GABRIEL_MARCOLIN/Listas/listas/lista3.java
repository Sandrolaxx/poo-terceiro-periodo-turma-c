package listas;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lista3 {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Lista 3 do Professor Sandro");

        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel painelDeBotoes = new JPanel();
        painelDeBotoes.setLayout(new BoxLayout(painelDeBotoes, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Escolha uma opção");
        label.setHorizontalAlignment(JLabel.CENTER);

        JButton botaoHello = new JButton("Exibir mensagem");
        JButton botaoNome = new JButton("Digitar nome");
        JButton botaoCalculadora = new JButton("Calculadora");
        JButton botaoContinuar = new JButton("Deseja continuar?");

        botaoHello.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(frame, "Olá, Mundo!");
            }
        });

        botaoNome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String nome = JOptionPane.showInputDialog(frame, "Digite seu nome:");
                if (nome != null) {
                    JOptionPane.showMessageDialog(frame, "Olá, " + nome + "!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Nenhum nome inserido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        botaoContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                int resposta = JOptionPane.showConfirmDialog(frame, "Você deseja continuar?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(frame, "Continuando!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Encerrando programa...");
                    frame.dispose(); // Fecha a janela
                }
            }
        });

        botaoCalculadora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String[] options = { "Soma", "Subtração", "Multiplicação", "Divisão" };
                int escolha = JOptionPane.showOptionDialog(frame, "Escolha uma operação", "Calculadora",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                if (escolha == JOptionPane.CLOSED_OPTION)
                    return;

                String resposta1 = JOptionPane.showInputDialog(frame, "Digite o primeiro número:");
                String resposta2 = JOptionPane.showInputDialog(frame, "Digite o segundo número:");

                if (resposta1 == null || resposta2 == null) {
                    JOptionPane.showMessageDialog(frame, "Erro, por favor digite dois números.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double num1 = Double.parseDouble(resposta1);
                double num2 = Double.parseDouble(resposta2);
                double resultado = 0;

                switch (escolha) {
                    case 0:
                        resultado = num1 + num2;
                        break;
                    case 1:
                        resultado = num1 - num2;
                        break;
                    case 2:
                        resultado = num1 * num2;
                        break;
                    case 3:
                        if (num2 == 0) {
                            JOptionPane.showMessageDialog(frame, "Não existe divisão por zero!!!", "Erro",
                                    JOptionPane.ERROR_MESSAGE);

                        } else {
                            resultado = num1 / num2;
                        }
                        break;
                }
                JOptionPane.showMessageDialog(frame, "O resultado é: " + resultado, "Resultado",
                        JOptionPane.INFORMATION_MESSAGE);

            }
        });

        botaoHello.setAlignmentX(JButton.CENTER_ALIGNMENT);
        botaoNome.setAlignmentX(JButton.CENTER_ALIGNMENT);
        botaoContinuar.setAlignmentX(JButton.CENTER_ALIGNMENT);
        botaoCalculadora.setAlignmentX(JButton.CENTER_ALIGNMENT);

        painelDeBotoes.add(Box.createRigidArea(new Dimension(10, 50)));
        painelDeBotoes.add(botaoHello);
        painelDeBotoes.add(Box.createRigidArea(new Dimension(10, 10)));
        painelDeBotoes.add(botaoNome);
        painelDeBotoes.add(Box.createRigidArea(new Dimension(10, 10)));
        painelDeBotoes.add(botaoCalculadora);
        painelDeBotoes.add(Box.createRigidArea(new Dimension(10, 10)));
        painelDeBotoes.add(botaoContinuar);

        panel.add(label, BorderLayout.NORTH);
        panel.add(painelDeBotoes, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }
}