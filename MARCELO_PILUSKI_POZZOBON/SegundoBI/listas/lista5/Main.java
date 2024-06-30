package SegundoBI.listas.lista5;

import java.util.List;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Iniciando Software!", "Requests", 1);
        List<String> options = List.of("Convênio", "Dados dos Boletos", "Sair");
        String operation = (String) JOptionPane.showInputDialog(null, "Escolha uma opção de Request", null, 3, null,
                options.toArray(), options.toArray()[0]);

        switch (operation) {
            case "Convênio":
                GetConvenio convenio = new GetConvenio();
                StringBuilder string = new StringBuilder();
                string = convenio.getRequest();
                JOptionPane.showMessageDialog(null, string, null, 1);
                break;

            case "Dados dos Boletos":
                PostDadosConta conta = new PostDadosConta();
                string = conta.postRequest();
                JOptionPane.showMessageDialog(null, string, null, 1);
                break;

            case "Sair":
                JOptionPane.showMessageDialog(null, "Obrigado pelas aulas Sandro!", "Agradecimento", 1);
                break;

            default:
                System.out.println("Fez o impossível, parabéns!");
                break;
        }

    }
}