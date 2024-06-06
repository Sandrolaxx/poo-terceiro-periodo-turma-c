package MARCELO_PILUSKI_POZZOBON.prova;

import MARCELO_PILUSKI_POZZOBON.prova.src.Cliente;
import MARCELO_PILUSKI_POZZOBON.prova.src.Evento;
import MARCELO_PILUSKI_POZZOBON.prova.src.Ingresso;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int option = 0;
        Scanner optionScanner = new Scanner(System.in);

        Cliente cliente = new Cliente();
        Evento evento = new Evento();
        Ingresso ingresso = new Ingresso();

        /* Scanner clienteScanner = new Scanner(System.in);
        Scanner eventoScanner = new Scanner(System.in);
        Scanner ingressoScanner = new Scanner(System.in); */

        exibirMenu(optionScanner, option, cliente, evento, ingresso);
    }

    public static void exibirMenu(Scanner opcao, int varOpcao, Cliente varCliente, Evento varEvento, Ingresso varIngresso) {
        do {
            System.out.println(
                "[1] - Cadastrar Cliente \n[2] - Cadastrar Evento \n[3] - Listar Eventos \n[4] - Comprar Ingresso \n[5] - Utilizar Ingresso \n[6] - Sair"
            );
            varOpcao = opcao.nextInt();

            switch (varOpcao) {
                case 1:
                    varCliente.cadastrarCliente();
                    break;
                
                case 2:
                    varEvento.cadastrarEvento();
                    break;

                case 3:
                    varEvento.listarEventos();
                    break;

                case 4:
                    varIngresso.comprarIngresso();
                    break;

                case 5:
                    varCliente.utilizarIngresso();
                    break;

                case 6:
                    System.out.println("Encerrando sistema...");    
                    break;
                
                default:
                    System.out.println("Por favor digite uma opção válida!!!!!!!");
                    break;

            }
        } while (varOpcao != 5);
    }
}