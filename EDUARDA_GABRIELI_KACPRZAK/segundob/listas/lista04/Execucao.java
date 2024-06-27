package listas.lista04;

import javax.swing.JOptionPane;

public class Execucao {
    public static void main(String[] args) {
        while (true) {
            try {
                String[] options = { "Ver Boletos", " Ver Convênios" };
                int opc = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                // Boleto Teste - 23793381286008301352856000063307789840000150000
                switch (opc) {
                    case 0:
                        Boleto.getBoleto();
                        break;

                    case 1:
                        Convenio.getJsonData();
                        break;
                    case 2:
                        System.exit(0);
                        break;

                    default:
                        break;
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Algo deu errado. Contate a equipe de suporte: (45)99999-9999");
            }
        }
    }
}