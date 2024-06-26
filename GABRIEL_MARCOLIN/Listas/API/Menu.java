package API;

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

public class Menu {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Lista 4 do Professor Sandro");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel painelDeBotoes = new JPanel();
        painelDeBotoes.setLayout(new BoxLayout(painelDeBotoes, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Escolha uma opção");
        label.setHorizontalAlignment(JLabel.CENTER);

        JButton botaoListarConvenios = new JButton("Listar convênios");
        JButton botaoConsultarConta = new JButton("Consultar conta");
        JButton botaoContinuar = new JButton("Deseja continuar?");

        botaoListarConvenios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                ListarConvenios.listandoConvenios();
            }
        });

        botaoConsultarConta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                ConsultarConta.consultandoBoletos(ConsultarConta.recebendoResposta());
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
                    frame.dispose();
                }
            }
        });

        botaoListarConvenios.setAlignmentX(JButton.CENTER_ALIGNMENT);
        botaoConsultarConta.setAlignmentX(JButton.CENTER_ALIGNMENT);
        botaoContinuar.setAlignmentX(JButton.CENTER_ALIGNMENT);

        painelDeBotoes.add(Box.createRigidArea(new Dimension(10, 50)));
        painelDeBotoes.add(botaoListarConvenios);
        painelDeBotoes.add(Box.createRigidArea(new Dimension(10, 10)));
        painelDeBotoes.add(botaoConsultarConta);
        painelDeBotoes.add(Box.createRigidArea(new Dimension(10, 10)));
        painelDeBotoes.add(botaoContinuar);

        panel.add(label, BorderLayout.NORTH);
        panel.add(painelDeBotoes, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }
}