package primeiro_bimestre.lista7;

import java.util.ArrayList;
import java.util.Scanner;

public class MainLista7{

    public static Pedidos criarPedido(ArrayList<Pedidos>allPedidos,ArrayList<Cliente> clientes,ArrayList<Item>itens){
        ArrayList<Item> itensPedido = new ArrayList<>();
        Scanner read = new Scanner(System.in);

        boolean testarIdCliente = true;
        Cliente cliente = null;
        while(testarIdCliente == true){
            System.out.println("Digite o id do cliente: ");
            int idCliente = read.nextInt();
            if(idCliente<=clientes.size()){
                cliente = clientes.get(idCliente-1);
                testarIdCliente = false;
            }else{
                System.err.println("Erro, id não registrado no sistema, tente novamente");
            }
        }

        Boolean continuarItens = true;
        while(continuarItens == true){
            Boolean testarIdItens = true;
            while(testarIdItens == true){
                System.out.println("Digite o id do produto: ");
                int idItem = read.nextInt();
                if(idItem<=itens.size()){
                    itensPedido.add(itens.get(idItem-1));
                    testarIdItens = false;
                }else{
                    System.out.println("Erro, id não registrado no sistema, tente novamente");
                }
            }
            System.out.println("Deseja continuar adicionando produtos?\n1 - Sim\n0 - Não");
            int teste = read.nextInt();
            if(teste == 0){
                continuarItens = false;
            }
        }
        
        ProcessaPedido newPedido = new ProcessaPedido();
        Pedidos pedido = newPedido.processaPedido(allPedidos,cliente, itensPedido);

        return pedido;
    }

    public static void listarItens(ArrayList<Item> itens){
        System.out.println("--PRODUTOS--");
        for(int i = 0;i<itens.size();i++){
            Item item = itens.get(i);
            System.out.println("PRODUTO 1 // Nome: "+item.getNome()+" Tipo: "+item.getTipo()+" Valor: "+item.getValor());
        }
    }

    public static Item cadastrarProduto(ArrayList<Item> itens){
        Scanner read = new Scanner(System.in);
        String nome, tipo;
        Float valor;
        System.out.println("Digite o nome do produto: ");
        nome = read.nextLine();        

        System.out.println("Digite o tipo do produto: ");
        tipo = read.nextLine();

        System.out.println("Digite o valor do produto: ");
        valor = read.nextFloat();

        Item item = new Item(itens.size(),nome,tipo,valor);

        return item;
    }
    public static void main(String[] args) {
        
        ArrayList<Item> itens = new ArrayList<>();
        ArrayList<Pedidos> allPedidos = new ArrayList<>();
        Scanner read = new Scanner(System.in);

        Loja loja = new Loja(1,"NewPlant","Plant","12345678910",new Endereco("Paraná","Cascavel","Centro","Avenida Brasil","747","Empresa Branca"));

        System.out.println("LOJA "+loja.getNomeFantasia());

        Gerente gerente1 = new Gerente(1,"Sandro",25,loja,new Endereco("Paraná","Cascavel","14 de Novembro","Avenida das Torres","747","Casa roxa"),7000f,9000f,8500f,9200f);

        Vendedor vendedor1 = new Vendedor(1,"Igor",20,new Endereco("Paraná","Cascavel","14 de Novembro","Avenida das Torres","747","Casa roxa"),loja,1500f,1700f,2800f,2200f);
        loja.setVendedores(vendedor1);

        Cliente cliente1 = new Cliente(1,"Sarah",19,loja,new Endereco("Paraná","Cascavel","14 de Novembro","Avenida das Torres","747","Casa roxa"));
        loja.setClientes(cliente1);

        Item item;
        item = new Item(1,"Cacto","Planta",20f);
        itens.add(item);

        item = new Item(2,"Orquídea","Planta",25f);
        itens.add(item);

        ProcessaPedido processaPedido = new ProcessaPedido();

        Pedidos pedido = processaPedido.processaPedido(allPedidos,cliente1,itens);
        allPedidos.add(pedido);
        
        processaPedido.confirmarPagamento(pedido);

        boolean continuarSistema = true;
        int escolha = 0;
        while(continuarSistema == true){

            System.out.println("ESCOLHA A OPÇÃO DESEJADA");
            System.out.println("1 - Criar pedido");
            System.out.println("2 - Cadastrar itens");
            System.out.println("3 - Listar itens");
            System.out.println("4 - Confirmar pagamento de algum pedido");
            System.out.println("5 - Listar pedidos");
            System.out.println("0 - Sair do sistema");
            
            escolha = read.nextInt();
            
            switch(escolha){
                case 1:
                    Pedidos pedido1 = criarPedido(allPedidos,loja.getClientes(),itens);
                    allPedidos.add(pedido1);
                    pedido1.descricaoVenda();
                break;
                case 2:
                    item = cadastrarProduto(itens);
                    itens.add(item);
                break;
                case 3:
                    listarItens(itens);
                break;
                case 4:
                    int idPedido;
                    Pedidos pedidoConfirm = null;
                    boolean testeIdPedidos = true;
                    while(testeIdPedidos == true){
                        System.out.println("Digite o id do pedido que deseja confirmar");
                        idPedido = read.nextInt();
                        if(idPedido <= allPedidos.size()){
                            pedidoConfirm = allPedidos.get(idPedido - 1);
                            testeIdPedidos = false;
                        }else{
                            System.out.println("Erro, pedido não registrado no sistema");
                        }
                    }

                    processaPedido.confirmarPagamento(pedidoConfirm);
                break;
                case 5:
                    System.out.println("---PEDIDOS---");
                    Pedidos listarPedidos = null;
                    for(int i=0;i<allPedidos.size();i++){
                        listarPedidos = allPedidos.get(i);
                        listarPedidos.descricaoVenda();
                    }
                break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    continuarSistema = false;
                    read.close();
                break;
                default:
                    System.out.println("Erro, opção nao listada");
            }
        }
    }
}