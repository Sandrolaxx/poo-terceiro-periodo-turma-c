package API;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Prova do Sandrolax");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painelDeBotoes = new JPanel();
        painelDeBotoes.setLayout(new BoxLayout(painelDeBotoes, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Escolha uma opção");
        label.setHorizontalAlignment(JLabel.CENTER);

        JButton botaoListarAlunos = new JButton("Listar alunos");
        JButton botaoCadastrarTestemunho = new JButton("Criar testemunho");
        JButton botaoContinuar = new JButton("Deseja continuar?");

        botaoListarAlunos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                ListarAlunos.listandoAlunos();
            }
        });

        botaoCadastrarTestemunho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                CadastrarTestemunho.postTestemunho(CadastrarTestemunho.recebendoResposta());
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

        botaoListarAlunos.setAlignmentX(JButton.CENTER_ALIGNMENT);
        botaoCadastrarTestemunho.setAlignmentX(JButton.CENTER_ALIGNMENT);
        botaoContinuar.setAlignmentX(JButton.CENTER_ALIGNMENT);

        painelDeBotoes.add(Box.createRigidArea(new Dimension(10, 50)));
        painelDeBotoes.add(botaoListarAlunos);
        painelDeBotoes.add(Box.createRigidArea(new Dimension(10, 10)));
        painelDeBotoes.add(botaoCadastrarTestemunho);
        painelDeBotoes.add(Box.createRigidArea(new Dimension(10, 10)));
        painelDeBotoes.add(botaoContinuar);

        // Cria um JScrollPane que envolve o painelDeBotoes
        JScrollPane scrollPane = new JScrollPane(painelDeBotoes);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Adiciona o rótulo e o JScrollPane ao painel principal do JFrame
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        
        frame.add(panel);
        frame.setVisible(true);
    }
}