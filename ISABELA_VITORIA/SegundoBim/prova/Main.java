package ISABELA_VITORIA.SegundoBim.prova;

import java.util.List;

import javax.swing.JOptionPane;


public class Main {

    public static void main(String[] args) {
        List<String> lista = List.of(
                "1. Listar alunos",
                "2. Criar testemunho");

        String resposta = (String) JOptionPane.showInputDialog(null, "Escolha uma opção ",
                "Opções",
                JOptionPane.QUESTION_MESSAGE,
                null,
                lista.toArray(),
                lista.toArray()[0]);

        switch (resposta) {
            case "1. Listar alunos":
                String listaAlunosResponse = ListaAluno.getJson();
                System.out.println(listaAlunosResponse);
                break;
            case "2. Criar testemunho":
                String registraTestemunhoResponse = RegistraTestemunho.sendRequest();
                System.out.println(registraTestemunhoResponse);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção invalida", "Erro", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
}