package GIULLIA_VILANOVA.segundob.prova.src;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class Prova {
    private static boolean validEntry;

    public static void main(String[] args) {

        int selectOption;
        do {
            List<String> opt = List.of("Listar dados dos alunos", "Enviar testemunho");

            selectOption = JOptionPane.showOptionDialog(null, "Selecione uma opção", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opt.toArray(), opt.toArray()[0]);

            switch (selectOption) {
                case 0:
                    listStudentsData();
                    break;
                case 1:
                    createNewTestemonial();
                    break;
            }
        } while (selectOption != 3);

        }

    private static void listStudentsData() {
        try {
            String resposta = HttpRequests.listStudentsData();
            JOptionPane.showMessageDialog(null, resposta);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os Alunos", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void createNewTestemonial() {
        String imgUrl = String.valueOf(requestData("Digite a URL da sua imagem:"));
        String testemonial = String.valueOf(requestData("Dê seu testemunho:"));
        String ra = String.valueOf(requestData("Digite seu RA:"));
        try {
           String resposta = HttpRequests.sendTestimonial(imgUrl, testemonial, ra);
        } catch (IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Enviar testemunho", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static String requestData(String mensagem) {
        String input = JOptionPane.showInputDialog(null, mensagem);
        if (input == null) {
            System.exit(0);
        }
        return input;
    }
}

