package segundob.aulas.aulaquatro;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JpanelSample {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Tela bala!");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(0);

        JPanel panel = new JPanel();

        panel.setBackground(Color.MAGENTA);

        JLabel label = new JLabel("Clique no botão");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btn = new JButton("Clique aqui!");

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Fui clicado!!!");
            }

        });

        frame.add(panel);
        frame.add(label);
        frame.add(btn);
        frame.setVisible(true);
    }

}
