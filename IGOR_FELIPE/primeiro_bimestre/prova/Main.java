package primeiro_bimestre.prova;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("BEM VINDO");
        Scanner read = new Scanner(System.in);
        ArrayList<Evento> allEventos = new ArrayList<>();
        ArrayList<Cliente> allClientes = new ArrayList<>();
        ArrayList<Ingresso> allIngressos = new ArrayList<>();

        Evento eventoTeste = new Evento("Show Ana Castella","05/20/2024",allEventos);
        allEventos.add(eventoTeste);
        
        Cliente clienteTeste = new Cliente("Igor",20,"12345678910","45999113972",allClientes);
        allClientes.add(clienteTeste);

        Ingresso ingressoTeste = new Ingresso(clienteTeste,eventoTeste,1,allIngressos);
        allIngressos.add(ingressoTeste);

        boolean continuarSistema = true;
        int escolha = 0;
        while(continuarSistema == true){

            System.out.println("Escolha a opção desejada");
            System.out.println("[1] - Cadastrar evento");
            System.out.println("[2] - Cadastrar cliente");
            System.out.println("[3] - Listar eventos");
            System.out.println("[4] - Listar clientes");
            System.out.println("[5] - Comprar ingressos");
            System.out.println("[6] - Utilizar ingresso");

            escolha = read.nextInt();

            Scanner readCases = new Scanner(System.in);
            switch(escolha){
                case 1:
                    System.out.println("Digite o nome do evento: ");
                    String caseNomeEvento = readCases.nextLine();

                    System.out.println("Digite a data do evento: ");
                    String caseDataEvento = readCases.nextLine();

                    Evento caseEvento = new Evento(caseNomeEvento,caseDataEvento,allEventos);
                    allEventos.add(caseEvento);
                    System.out.println("Evento registrado com sucesso");
                break;
                case 2:
                    System.out.println("Digite o nome do cliente: ");
                    String caseNome = readCases.nextLine();

                    System.out.println("Digite a idade do cliente ");
                    Integer caseIdade = readCases.nextInt();

                    System.out.println("Digite o cpf do cliente");
                    String caseCpf = readCases.nextLine();

                    System.out.println("Digite o telefone do cliente ");
                    String caseTelefone = readCases.nextLine();

                    Cliente caseCliente = new Cliente(caseNome,caseIdade,caseCpf,caseTelefone,allClientes);
                    allClientes.add(caseCliente);
                    System.out.println("Cliente registrado com sucesso");
                break;
                case 3:
                    for(int i = 0;i<allEventos.size();i++){
                        System.out.println("------EVENTOS ATIVOS------");
                        allEventos.get(i).listarEventos();
                    }
                break;
                case 4:
                    for(int i = 0;i<allClientes.size();i++){
                        System.out.println("------CLIENTES ATIVOS------");
                        allClientes.get(i).listarClientes();
                    }
                break;
                case 5:
                    boolean testeIdEvento = true;
                    Evento idEvento = null;
                    while(testeIdEvento == true){
                        System.out.println("Digite o ID do evento");
                        Integer caseIdEvento = readCases.nextInt();
                        if(caseIdEvento>allEventos.size()){
                            System.out.println("Evento não registrado, tente novamente");
                        }else{
                            idEvento = allEventos.get(caseIdEvento-1);
                            testeIdEvento = false;
                        }
                    }

                    Cliente idCliente = null;
                    boolean testeIdCliente = true;
                    while(testeIdCliente == true){
                        System.out.println("Digite o ID do cliente");
                        Integer caseIdCliente = readCases.nextInt();
                        if(caseIdCliente>allClientes.size()){
                            System.out.println("Cliente não registrado, tente novamente");
                        }else{
                            idCliente = allClientes.get(caseIdCliente-1);
                            testeIdCliente = false;
                        }
                    }

                    Integer caseTipoIngresso = 0;
                    boolean testeTipoIngresso = true;
                    while(testeTipoIngresso == true){
                        System.out.println("Digite o tipo de ingresso do cliente");
                        System.out.println("1 - Básico - R$100,00");
                        System.out.println("2 - VIP - R$200,00");
                        System.out.println("3 - Backstage - R$500,00");
                        caseTipoIngresso = readCases.nextInt();
                        if(caseTipoIngresso<1 || caseTipoIngresso>3){
                            System.out.println("ERRO, tipo de ingresso indisponível, tente novamente");
                        }else{
                            testeTipoIngresso = false;
                        }
                    }

                    Ingresso ingresso = new Ingresso(idCliente,idEvento,caseTipoIngresso,allIngressos);
                    allIngressos.add(ingresso);
                    System.out.println("Ingresso comprado com sucesso!");
                    System.out.println("ID DO INGRESSO:"+ingresso.getId());
                break;
                case 6: 
                    Integer idIngresso;
                    boolean testarIdIngresso = true;
                    while(testarIdIngresso == true){
                        System.out.println("Digite o ID do seu ingresso");
                        idIngresso = readCases.nextInt();
                        if(idIngresso>allIngressos.size()){
                            System.out.println("Ingresso indisponível");
                        }else{
                            testarIdIngresso = false;
                            Ingresso ingressoCase = allIngressos.get(idIngresso-1);
                            ingressoCase.utilizarIngresso();
                        }
                    }
                break;
                case 0:
                    read.close();
                    readCases.close();
                    continuarSistema = false;
                break;
                default:
                    System.out.println("OPÇÃO INDISPONÍVEL, TENTE NOVAMENTE");
                break;
            }
        }
    }
}
