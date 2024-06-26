package RICARDO_DINIZ_SILVA.prova;

import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Cliente[] clientes = new Cliente[10]; 
            Evento[] eventos = new Evento[10]; 
    
          
            while (true) {
                System.out.println("\nSelecione uma opção:");
                System.out.println("1. Cadastrar novo cliente");
                System.out.println("2. Listar todos os clientes");
                System.out.println("3. Cadastrar novo evento");
                System.out.println("4. Listar todos os eventos");
                System.out.println("5. Comprar ingresso para evento");
                System.out.println("6. Sair");
    
                int opcao = scanner.nextInt();
    
                switch (opcao) {
                    case 1:
                        cadastrarCliente(scanner, clientes);
                        break;
                    case 2:
                        listarClientes(clientes);
                        break;
                    case 3:
                        cadastrarEvento(scanner, eventos);
                        break;
                    case 4:
                        listarEventos(eventos);
                        break;
                    case 5:
                        comprarIngresso(scanner, clientes, eventos);
                        break;
                    case 6:
                        System.out.println("Encerrando o programa...");
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        }
    
        // Método para cadastrar um novo cliente
        public static void cadastrarCliente(Scanner scanner, Cliente[] clientes) {
            scanner.nextLine(); // Limpar o buffer do scanner
            System.out.println("Digite o nome do cliente:");
            String nome = scanner.nextLine();
            System.out.println("Digite o endereço do cliente:");
            String endereco = scanner.nextLine();
            System.out.println("Digite o telefone do cliente:");
            String telefone = scanner.nextLine();
    
            // Encontrar a primeira posição vazia no array de clientes
            int posicao = -1;
            for (int i = 0; i < clientes.length; i++) {
                if (clientes[i] == null) {
                    posicao = i;
                    break;
                }
            }
    
            
            if (posicao != -1) {
                Cliente cliente = new Cliente(nome, endereco, telefone);
                clientes[posicao] = cliente;
                System.out.println("Cliente cadastrado com sucesso!");
            } else {
                System.out.println("Não há espaço disponível para cadastrar mais clientes.");
            }
        }
    
        
        public static void listarClientes(Cliente[] clientes) {
            System.out.println("\nClientes cadastrados:");
            for (Cliente cliente : clientes) {
                if (cliente != null) {
                    System.out.println(cliente);
                }
            }
        }
    
        
        public static void cadastrarEvento(Scanner scanner, Evento[] eventos) {
            scanner.nextLine(); 
            System.out.println("Digite o nome do evento:");
            String nome = scanner.nextLine();
            System.out.println("Digite o local do evento:");
            String local = scanner.nextLine();
            System.out.println("Digite a data do evento:");
            String data = scanner.nextLine();
            System.out.println("Digite a quantidade de ingressos disponíveis para o evento:");
            int ingressosDisponiveis = scanner.nextInt();
    
            
            int posicao = -1;
            for (int i = 0; i < eventos.length; i++) {
                if (eventos[i] == null) {
                    posicao = i;
                    break;
                }
            }
    
            
            if (posicao != -1) {
                Evento evento = new Evento(nome, local, data, ingressosDisponiveis);
                eventos[posicao] = evento;
                System.out.println("Evento cadastrado com sucesso!");
            } else {
                System.out.println("Não há espaço disponível para cadastrar mais eventos.");
            }
        }
    
       
        public static void listarEventos(Evento[] eventos) {
            System.out.println("\nEventos cadastrados:");
            for (Evento evento : eventos) {
                if (evento != null) {
                    System.out.println(evento);
                }
            }
        }
    
        
        public static void comprarIngresso(Scanner scanner, Cliente[] clientes, Evento[] eventos) {
            scanner.nextLine(); 
            System.out.println("Digite o nome do evento para o qual deseja comprar ingresso:");
            String nomeEvento = scanner.nextLine();
    
            
            Evento eventoEncontrado = null;
            for (Evento evento : eventos) {
                if (evento != null && evento.getNome().equalsIgnoreCase(nomeEvento)) {
                    eventoEncontrado = evento;
                    break;
                }
            }
    
            if (eventoEncontrado != null) {
                
                if (eventoEncontrado.getIngressosDisponiveis() > 0) {
                    System.out.println("Digite o nome do cliente:");
                    String nomeCliente = scanner.nextLine();
                   
                    Cliente clienteEncontrado = null;
                    for (Cliente cliente : clientes) {
                        if (cliente != null && cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                            clienteEncontrado = cliente;
                            break;
                        }
                    }
                    if (clienteEncontrado != null) {
                       
                        eventoEncontrado.venderIngresso(clienteEncontrado);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                } else {
                    System.out.println("Não há ingressos disponíveis para este evento.");
                }
            } else {
                System.out.println("Evento não encontrado.");
            }
        }
    }
