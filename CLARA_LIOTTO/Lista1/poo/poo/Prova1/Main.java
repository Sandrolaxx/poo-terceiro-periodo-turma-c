package poo.Prova1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args, List<Evento> clientes) {
    Scanner scanner = new Scanner(System.in);
    List<Evento> eventos = new ArrayList<>();
    

        boolean continuar = true;
        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar evento");
            System.out.println("3 - Listar eventos");
            System.out.println("4 - Comprar ingresso");
            System.out.println("5 - Sair");
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                System.out.println("Digite o nome do cliente:");
                String nomeCliente = scanner.next();
                System.out.println("Digite o email do cliente:");
                String emailCliente = scanner.next();
                Cliente novoCliente = new Cliente(nomeCliente, emailCliente);
                Cliente.add(novoCliente);
                System.out.println("Cliente cadastrado com sucesso!");
                break;
                case 2:
                    System.out.println("Digite o nome do evento:");
                    String nomeEvento = scanner.next();
                    System.out.println("Digite a data do evento:");
                    String dataEvento = scanner.next();
                    System.out.println("Digite o preço do ingresso:");
                    double precoIngresso = scanner.nextDouble();
                    System.out.println("Digite a quantidade de ingressos disponíveis:");
                    int quantidadeIngressos = scanner.nextInt();
                    Evento novoEvento = new Evento(nomeEvento, dataEvento, precoIngresso, quantidadeIngressos);
                    eventos.add(novoEvento);
                    System.out.println("Evento cadastrado com sucesso!");
                    break;
                case 3:
                    System.out.println("Lista de eventos:");
                    for (int i = 0; i < eventos.size(); i++) {
                        Evento evento = eventos.get(i);
                        System.out.println((i + 1) + " - " + evento.getNome() + " - " + evento.getData() + " - Preço: " + evento.getPrecoIngresso() + " - Ingressos disponíveis: " + evento.getQuantidadeIngressosDisponiveis());
                    }
                    break;
                case 4:
                    System.out.println("Digite o número do evento que deseja comprar ingresso:");
                    int numeroEvento = scanner.nextInt();
                    if (numeroEvento >= 1 && numeroEvento <= eventos.size()) {
                        Evento eventoSelecionado = eventos.get(numeroEvento - 1);
                        if (eventoSelecionado.temIngressosDisponiveis()) {
                            @SuppressWarnings("unused")
                            int ingresso = eventoSelecionado.comprarIngresso();
                            System.out.println("Ingresso comprado com sucesso para o evento " + eventoSelecionado.getNome());
                        } else {
                            System.out.println("Desculpe, ingressos esgotados para o evento " + eventoSelecionado.getNome());
                        }
                    } else {
                        System.out.println("Número de evento inválido!");
                    }
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}