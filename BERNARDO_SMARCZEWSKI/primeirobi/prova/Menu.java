package primeirobi.prova;

import java.util.Scanner;
import java.util.Date;

public class Menu {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        int opcao;
        Cliente[] clientes = new Cliente[100];
        int nClientes = 0;
        Evento[] eventos = new Evento[100];
        int nEventos = 0;

        do {

            System.out.println(" -=- MENU -=- ");
            System.out.println(" [1] Cadastrar Cliente ");
            System.out.println(" [2] Criar Evento ");
            System.out.println(" [3] Listar Clientes ");
            System.out.println(" [4] Listar Eventos ");
            System.out.println(" [5] Comprar Ingresso ");
            System.out.println(" [6] Utilizar Ingresso ");
            System.out.println(" [0] Sair ");
            System.out.print(" Insira a opção escolhida aqui: ");

            opcao = scanner.nextInt();
            
                switch (opcao) {
                    case 1:
                        System.out.print(" Insira o nome do cliente: ");
                        String nome = scanner.next();
                        System.out.print(" Insira o Cpf do cliente: ");
                        String cpf = scanner.next();

                        clientes[nClientes] = new Cliente(nome, cpf);
                        nClientes++;
                        break;

                    case 2:
                        System.out.print(" Insira o tipo do evento: ");
                        String tipo = scanner.next();
                        System.out.print(" Inisira daqui quantos dias acontecera o evento: ");
                        int dias = scanner.nextInt();

                        Date dataAtual = new Date();
                        long diasEmMs = dias * 24 * 60 * 60 * 1000;
                        long dataEmMs = dataAtual.getTime();
                        Date data = new Date(dataEmMs + diasEmMs);

                        eventos[nEventos] = new Evento(tipo, data);
                        System.out.println(" Evento do tipo " + eventos[nEventos].getTipo() + " agendado para " + eventos[ nEventos].getDataEvento());
                        nEventos++;
                        break;

                    case 3: 
                        System.out.println(" -> Clientes Cadastrados: ");
                        for (int i = 0; i < nEventos; i++) {
                            System.out.println(" [" + i + "] Nome: " + clientes[i].getNome());
                            System.out.println("     Cpf: " + clientes[i].getCpf());
                        }
                        break;

                    case 4:
                        System.out.println(" -> Eventos Marcados: ");
                        for (int i = 0; i < nEventos; i++) {
                            System.out.println(" [" + i + "] Tipo do evento: " + eventos[i].getTipo() + " - Data: " + eventos[i].getDataEvento());
                        }
                        break;

                    case 5:
                        System.out.print(" Insira o numero do comprador: ");
                        int comprador = scanner.nextInt();
                        System.out.print(" Insira o numero de qual evento deseja ir: ");
                        int evento = scanner.nextInt();
                        clientes[comprador].setIngresso(new Ingresso(eventos[evento]));
                        break;

                    case 6:
                        System.out.print(" Insira o numero de qual evento esta indo: ");
                        int show = scanner.nextInt();
                        System.out.print(" Insira o numero de quem deseja usar o ingresso: ");
                        int usuario = scanner.nextInt();

                        clientes[usuario].verificarIngresso(usuario, eventos[show]);
                        break;

                    case 0:
                        break;

                    default:
                        System.out.println(" Insira uma opção valida.");
                        break;
                }

        } while (opcao != 0);

        scanner.close();
    }

}