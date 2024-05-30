package segundob.aulas.aulaquatro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JpanelSample {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Tela Bala");
        frame.setSize(400, 400);

        frame.setDefaultCloseOperation(0);

        JPanel panel = new JPanel();

        panel.setBackground(Color.MAGENTA);

        JLabel label = new JLabel("Clique no botão");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JButton button = new JButton();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isBtnClicado = label.getText().equals("Botão Clicado! ");

                label.setText(isBtnClicado ? "Clique aqui" : "Botão CLicado! ");
            }
        });

        frame.add(panel);
        panel.add(label);
        panel.add(button);

        frame.add(panel);

        frame.setVisible(true);
    }

}
