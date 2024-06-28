package segundob.prova;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String[] opcoes = {"Listar Alunos", "Criar Registro de Testemunho", "Sair"};
        String selecionar = String.valueOf(JOptionPane.showInputDialog(null, "Selecione uma opção",
                "Menu de Opções", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]));
        if (selecionar == null) {
            return;
        }
        switch (selecionar) {
            case "Listar Alunos" -> listarAlunos();
            case "Criar Registro de Testemunho" -> criarRegistroTestemunho();
            case "Sair" -> {
                return;
            }
            default -> JOptionPane.showMessageDialog(null, "Nenhuma Opção selecionada", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void listarAlunos() {
        JOptionPane.showMessageDialog(null, ListarAlunos.genAlunos(), "Alunos Listados",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static void criarRegistroTestemunho() {
        String urlAluno = String.valueOf(JOptionPane.showInputDialog(
                null,
                "Informe a URL da sua foto",
                "Inserir",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null));
        String raAluno = String.valueOf(JOptionPane.showInputDialog(
                null,
                "Informe o seu RA",
                "Inserir",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null));
        String testemunhoAluno = String.valueOf(JOptionPane.showInputDialog(
                null,
                "Informe o seu testemunho de aluno",
                "Inserir",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null));
        CriarTestemunhoAluno.getJsonData(urlAluno, raAluno, testemunhoAluno);
    }
}