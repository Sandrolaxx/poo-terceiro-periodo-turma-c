// package aula_04;

// import java.awt.Color;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.List;

// import javax.swing.JFrame;
// import javax.swing.JOptionPane;
// import javax.swing.JPanel;
// import javax.swing.JButton;

// public class Main {
// public static void main(String[] args) {
// JFrame frame = new JFrame("Exemplo JFrame e JPanel");
// // frame.setSize(400, 300);
// // frame.setDefaultCloseOperation(0);

// // JPanel panel = new JPanel();
// // JButton btn = new JButton("Clique!");

// // btn.addActionListener(new ActionListener() {
// // @Override
// // public void actionPerformed(ActionEvent e) {
// // System.out.println("Fui clicado!!");
// // }
// // });

// // panel.setBackground(Color.RED);

// // frame.add(panel);
// // frame.add(btn);
// // frame.setVisible(true);

// List<String> professores = List.of("Rita", "Andrade", "Sandro");

// String melhorProfessor = (String) JOptionPane.showInputDialog(
// null,
// "Seu nome",
// "Selecione",
// JOptionPane.QUESTION_MESSAGE,
// null,
// professores.toArray(),
// professores.toArray()[0]);

// System.err.println(melhorProfessor);

// if (!melhorProfessor.equals("Sandro")) {
// JOptionPane.showMessageDialog(
// null,
// "Resposta errada!",
// "ERRO!",
// JOptionPane.ERROR_MESSAGE);
// }
// }
// }
