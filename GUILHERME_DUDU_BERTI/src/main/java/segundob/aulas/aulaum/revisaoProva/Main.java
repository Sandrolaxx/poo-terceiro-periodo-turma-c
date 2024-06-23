package segundob.aulas.aulaum.revisaoProva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        Cliente[] listaClientes = new Cliente[100];
        Integer indiceCliente = 1;

        Evento[] listaEventos = new Evento[100];
        Integer indiceEvento = 1;

        Cliente clienteEncontrado = null;
        Evento eventoEncontrado = null;
        Integer idCrescenteIngresso = 1;

        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            printMenu();
            Integer opcao = input.nextInt();

            switch (opcao) {
                case 1:

                    Cliente novoCliente = new Cliente();

                    System.out.println("Qual o seu nome: ");
                    novoCliente.setNome(input.next());
                    System.out.println("Qual a sua idade: ");
                    novoCliente.setIdade(input.nextInt());
                    novoCliente.setId(indiceCliente);
                    listaClientes[indiceCliente++] = novoCliente;

                    System.out.println("Cliente cadastrado com sucesso...");

                    break;
                case 2:

                    Evento eventoNovo = new Evento();

                    System.out.println("Qual é a descrição? : ");
                    eventoNovo.setDescricao(input.next());

                    System.out.println("Qual a quantidade limite de pessoas? : ");
                    eventoNovo.setClienteMax(input.nextInt());

                    System.out.println("Qual o valor diário ingresso?");
                    eventoNovo.setValorDiarioIngresso(input.nextDouble());

                    input.nextLine(); // limpa buffer

                    System.out.println("Qual a data inicial? (dd/MM/yyyy)");
                    eventoNovo.setDataInicio(formater.parse(input.nextLine()));

                    eventoNovo.setId(indiceEvento);
                    listaEventos[indiceEvento++] = eventoNovo;

                    System.out.println("Evento cadastrado com sucesso...");

                    break;
                case 3:

                    for (int i = 0; i < listaEventos.length; i++) {

                        if (listaEventos[i] != null) {
                            System.out.println("nome do evento: " + listaEventos[i].getDescricao());
                        }

                    }

                    break;
                case 4:
                    System.out.println("Insira o ID do cliente");
                    int idCliente = input.nextInt();
                    for (int i = 0; i < listaClientes.length; i++) {
                        if (listaClientes[i] != null && listaClientes[i].getId() == idCliente) {
                            clienteEncontrado = listaClientes[i];
                            System.out.println("Cliente encontrado: " + listaClientes[i]);
                            break;
                        }
                    }
                    System.out.println("Insira o ID do evento");
                    int idEvento = input.nextInt();
                    for (int i = 0; i < listaEventos.length; i++) {
                        if (listaEventos[i] != null && listaEventos[i].getId() == idEvento) {
                            eventoEncontrado = listaEventos[i];
                            System.out.println("Evento encontrado" + listaEventos[i]);
                            break;
                        }
                    }

                    Ingresso ingressoNovo = new Ingresso();
                    ingressoNovo.setId(idCrescenteIngresso++);
                    ingressoNovo.setCliente(clienteEncontrado);
                    ingressoNovo.setEvento(eventoEncontrado);
                    ingressoNovo.setDescricao(eventoEncontrado.getDescricao());
                    System.out.println("Gostaria do ingresso para quantos dias? ");
                    ingressoNovo.setQtndDiasParticipacao(input.nextInt());
                    System.out.println("Qual será a data de utilização do ingresso? (dd/MM/yyyy)");
                    ingressoNovo.setDataUtilizacao(formater.parse(input.nextLine()));
                    ingressoNovo.setValorTotal(
                            eventoEncontrado.getValorDiarioIngresso() * ingressoNovo.getQtndDiasParticipacao());
                    System.out.println("Ingresso comprado com sucesso...");
                    break;
                case 5:

                    break;
                case 6:
                    return;

                default:
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Cadastrar Evento");
        System.out.println("3 - Listar Evento");
        System.out.println("4 - Comprar Ingresso");
        System.out.println("5 - Utilizar Ingresso");
        System.out.println("6 - Sair");
    }

}
