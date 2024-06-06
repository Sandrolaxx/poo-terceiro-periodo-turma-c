package segundob.aulas.aulaum.revisaoprova;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {

        Cliente[] listaClientes = new Cliente[100];
        Integer indiceCliente = 1;
        Evento[] listaEvento = new Evento[100];
        Integer indiceEvento = 1;
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            printMenu();

            Integer opcao = input.nextInt();

            switch (opcao) {
                case 1:

                    Cliente novoCliente = new Cliente();

                    System.out.println("Qual é nome do cliente?");
                    input.nextLine();
                    novoCliente.setNome(input.nextLine());

                    System.out.println("Qual é a idade do cliente?");
                    novoCliente.setIdade(input.nextInt());

                    novoCliente.setId(indiceCliente);

                    listaClientes[indiceCliente] = novoCliente;
                    indiceCliente++;

                    break;
                case 2:

                    Evento novoEvento = new Evento();

                    System.out.println("Qual é a descrição?");
                    input.nextLine();
                    novoEvento.setDescricao(input.nextLine());

                    System.out.println("Quantidade limite pessoas?");
                    novoEvento.setMaxClientes(input.nextInt());

                    System.out.println("Qual valor diário ingresso?");
                    novoEvento.setVlrDiarioIngresso(input.nextDouble());

                    input.nextLine();// limpa buffer

                    System.out.println("Qual a data inicial?(dd/MM/yyyy)");
                    novoEvento.setDataInicio(formater.parse(input.nextLine()));

                    novoEvento.setId(indiceCliente);

                    listaEvento[indiceCliente] = novoEvento;
                    indiceCliente++;

                    break;
                case 3:
                    for (int i = 0; i < listaEvento.length; i++) {
                        if (listaEvento[i] != null) {
                            System.out.println("Nome do evento: " + listaEvento[i].getDescricao());
                            System.out.println("ID do evento: " + listaEvento[i].getId());
                        }
                    }
                    break;
                case 6:
                    return;
                default:
                    break;
            }
        }

    }

    public static void printMenu() {
        System.out.println("[1] CADASTRO CLIENTE");
        System.out.println("[2] CADASTRO EVENTO");
        System.out.println("[3] LISTAGEM EVENTO");
        System.out.println("[4] COMPRAR INGRESSO");
        System.out.println("[5] UTILIZAR INGRESSO");
        System.out.println("[6] SAIR");
    }

}
