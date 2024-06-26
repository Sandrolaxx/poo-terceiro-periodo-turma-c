package segundob.aulas.aulaquatro;

import java.util.List;

import javax.swing.JOptionPane;

public class JOptionalPaneSample {

    public static void main(String[] args) {
        List<String> professores = List.of("Rita", "Andrade", "Sandro", "Marcelo", "Elaine");

        String melhorProfessor = (String) JOptionPane.showInputDialog(
                null,
                "Informe seu nome?",
                "Selecione",
                JOptionPane.QUESTION_MESSAGE,
                null,
                professores.toArray(),
                professores.toArray()[0]);

        System.out.println(melhorProfessor);

        if (!melhorProfessor.equals("Sandro")) {
            JOptionPane.showMessageDialog(
                    null,
                    "Resposta errada!",
                    "ERRO!",
                    JOptionPane.ERROR_MESSAGE);
        }

        try {
            sampleOne();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sampleOne() throws Exception {
        String nomeAluno = JOptionPane.showInputDialog(null,
                "Informe seu nome?");

        System.out.println(nomeAluno);
        
        if (true) {
            throw new RuntimeException("Deu ruim!");
        }
    }

}
