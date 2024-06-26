package MARIA_JULIA.prova;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;
// professore misturei console com a caixinha pq nao deu tempo de organizar pq entrei em panico no meio da  prova
// mas acredito que a fucnionalidade esta interessante
// class cliente
// classe evento
// class ingresso
public class Main {
    public static void main(String[] args){
        Random ran = new Random();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        int opcao;
        int id = ran.nextInt(1000);
        ArrayList<EventoProva> eventos = new ArrayList<>();
        EventoProva eventoShow = new EventoProva(id,"rua teste","bairro teste","cidade teste","estado teste","nome teste", 50.0);
        eventos.add(eventoShow);
        do {
            
            String opcaoString = JOptionPane.showInputDialog("Selecione uma opção:\n" + //
                                "1. Cadastrar cliente (compra do ingresso embutido)\n" + //
                                "2. Cadastrar evento\n" + //
                                "3. Listar eventos\n" + //
                                "4. Listar clientes\n" + //
                                "5. Utilizar ingresso em evento\n" + //
                                "0. Sair\ninsira o id conforme o console");
            opcao = Integer.parseInt(opcaoString);

            switch (opcao) {
                case 1:
                    boolean verificadorIngresso = true;
                    System.out.println("-----  CADASTRO DE CLIENTE -----");

                    System.out.println("----- Informações necessárias:");
                    System.out.println("- Nome");
                    String nomeUser = JOptionPane.showInputDialog("nome:");

                    System.out.println("- Idade");
                    String idade = JOptionPane.showInputDialog("Idade");
                    int idadeUser = Integer.parseInt(idade);

                    System.out.println("- Endereco");
                    String enderecoUser = JOptionPane.showInputDialog("Endereco");

                    ClienteProva cliente = new ClienteProva(nomeUser, idadeUser,enderecoUser);

                    
                    System.out.println("----- Com base nos eventos já cadastrados, escolha um para participar: (Insira o ID)");
                    String texto = "";
                    for (EventoProva evento : eventos) {
                        String idString = String.valueOf(evento.getId());
                        texto = texto +("EventoProva [id=" + idString + ", rua=" + evento.getRua() + ", bairro=" + evento.getBairro() + ", cidade=" + evento.getCidade() + ", estado="
                        + evento.getEstado() + ", nome=" + evento.getNome() + "\n"); 
                    }
                    while (verificadorIngresso){
                        String iduser = JOptionPane.showInputDialog(texto+ "\n----- Com base nos eventos já cadastrados, escolha um para participar: (Insira o ID) (impresso no console)");
                        int IngressoUsuario = Integer.parseInt(iduser);
                        if (IngressoUsuario == 0){
                            verificadorIngresso = false;
                        }
                        for (EventoProva evento : eventos) {
                            if (IngressoUsuario == evento.getId()){
                                verificadorIngresso = false;
                                int id2 = ran.nextInt(1000);
                                IngressoProva ingressoUser = new IngressoProva(evento, id2);  
                                cliente.setIngresso(ingressoUser);
                                evento.setClientes(cliente);
                            }
                        }
                        if (verificadorIngresso){
                            System.out.println("----- O id inserido nao corresponde a nenhum evento já cadastrado, digite 0 para desistir do cadastro ou insira um envento já exixtente");
                        }
                    }
                    break;
                case 2:
                    System.out.println("-----  CADASTRAR EVENTO -----");
                    System.out.println("----- Informações necessárias:");
                    System.out.println("- Nome");
                    String nomeEvento = JOptionPane.showInputDialog("nome:");

                    System.out.println("- Rua");
                    String ruaEvento = JOptionPane.showInputDialog("Rua:");


                    System.out.println("- Bairro");
                    String bairroEvento = JOptionPane.showInputDialog("Bairro:");


                    System.out.println("- cidade ");
                    String cidadeEvento = JOptionPane.showInputDialog("cidade:");


                    System.out.println("- estado ");
                    String estadoEvento = JOptionPane.showInputDialog("estado:");


                    System.out.println("- valor do ingresso ");
                    String valor = JOptionPane.showInputDialog("valor do ingresso :");
                    double valorEvento = Double.parseDouble(valor);


                    int idEvento = ran.nextInt(1000);
                    EventoProva eventoUser = new EventoProva(idEvento,ruaEvento, bairroEvento, cidadeEvento, estadoEvento,nomeEvento,valorEvento);
                    eventos.add(eventoUser);
                    break;
                case 3:
                    for (EventoProva evento : eventos) {
                        System.out.println(evento.toString());
                    }
                    break;
                case 4:
                    System.out.println("----- LISTAR CLIENTES -----");
                    for (EventoProva evento : eventos) {
                        System.out.println(evento.toString());
                    }
                    System.out.println("----- Gostaria de listar clientes de qual evento (digite o id)");
                    String idEventoString = JOptionPane.showInputDialog("----- INSIRA ID EVENTO");
                    int idEventoClientes = Integer.parseInt(idEventoString);
                    for (EventoProva evento : eventos) {
                        if (idEventoClientes == evento.getId()){
                            for (ClienteProva clienteEvento : evento.getClientes()){
                                clienteEvento.apresentarse();
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("-----  UTILIZAR INGRESSO -----");
                    System.out.println("-----  Para utilizar o ingresso você precisa selecionar o evento, e deixar seu nome, iremos conferir se na sua conta está cadastrada e se seu ingresso condiz com o evento que quer participar ");
                    boolean entrada = true;
                    System.out.println("----- para qual evento deseja entrar? ");
                    String texto2 = "";
                    for (EventoProva evento : eventos) {
                        String idString = String.valueOf(evento.getId());
                        texto2 = texto2 +("EventoProva [id=" + idString + ", rua=" + evento.getRua() + ", bairro=" + evento.getBairro() + ", cidade=" + evento.getCidade() + ", estado="
                        + evento.getEstado() + ", nome=" + evento.getNome() + "\n"); 
                    }
                    String idIngressoEntradaString = JOptionPane.showInputDialog(texto2 + "\n----- INSIRA ID EVENTO");
                    int idIngressoEntrada = Integer.parseInt(idIngressoEntradaString);
                    for (EventoProva evento : eventos) {
                        if (idIngressoEntrada == evento.getId()){
                            System.out.println("----- Seu nome, o mesmo do cadastro por favor ");
                            String nomeIngressoEntrada = JOptionPane.showInputDialog("----- INSIRA SEU NOME");
                            for (ClienteProva clientesEvento : evento.getClientes()){
                                System.out.println(nomeIngressoEntrada);
                                System.out.println(clientesEvento.getNome());
                                if (nomeIngressoEntrada.equals(clientesEvento.getNome())){
                                    entrada = false;
                                    JOptionPane.showMessageDialog(null,"Permitida a entrada" );

                                }
                            }
                            if(entrada){
                                JOptionPane.showMessageDialog(null,"perdao, evento ou nome errado!" );
                            } 

                        }
                    }

                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
        scanner.close();
        scanner2.close();
        
    }
}
