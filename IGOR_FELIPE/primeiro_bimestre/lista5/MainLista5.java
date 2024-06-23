package primeiro_bimestre.lista5;
import java.util.ArrayList;
import java.util.Scanner;

public class MainLista5 {

    public static ProcessaPedido criarPedido(Loja loja, ArrayList<Item> itens){
        Scanner read = new Scanner(System.in);

        System.out.println("Digite a data de compra: ");
        String dataCompra = read.nextLine();

        System.out.println("Digite a data de pagamento: ");
        String dataPagamento = read.nextLine();

        Boolean continuarCliente = true;
        Cliente clienteObject = null;
        while(continuarCliente == true){
            System.out.println("Digite o nome do cliente: ");
            int idCliente = read.nextInt();

            clienteObject = verificarCliente(idCliente, loja);
            if(clienteObject == null){
                continuarCliente = true;
                System.out.println("ERRO, Cliente não cadastrado, tente novamente");
            }else{
                continuarCliente = false;
            };
        }

        Boolean continuarVendedor = true;
        Vendedor vendedorObject = null;
        while(continuarVendedor == true){
            System.out.println("Digite o nome do vendedor: ");
            int idVendedor = read.nextInt();

            vendedorObject = verificarVendedor(idVendedor, loja);
            if(vendedorObject == null){
                continuarVendedor = true;
                System.out.println("ERRO, Vendedor não cadastrado, tente novamente");
            }else{
                continuarVendedor = false;
            };
        }

        Boolean continuarItem = true;
        Item itemObject = null;
        while(continuarItem == true){
            System.out.println("Digite o id do produto: ");
            int idItem = read.nextInt();

            itemObject = verificarItem(idItem, loja, itens);
            if(itemObject == null){
                continuarItem = true;
                System.out.println("ERRO, Vendedor não cadastrado, tente novamente");
            }else{
                continuarItem = false;
            };
        }

        ProcessaPedido processaPedido = new ProcessaPedido(1,dataCompra,dataPagamento,clienteObject,vendedorObject,loja,itemObject);
    
        read.close();
        return processaPedido;
    }

    public static Vendedor verificarVendedor(int id,Loja loja){
        for(int i = 0;i < loja.vendedores.size();i++){
            Vendedor vendedor = loja.vendedores.get(i);
            if(id == vendedor.id){
                Vendedor vendedorObject = loja.vendedores.get(i);
                return vendedorObject;
            }
        }
        return null;
    }

    public static Cliente verificarCliente(int id, Loja loja){
        for(int i = 0;i < loja.clientes.size();i++){
            Cliente cliente = loja.clientes.get(i);
            if(id == cliente.id){
                Cliente clienteObject = loja.clientes.get(i);
                return clienteObject;
            }
        }
        return null;
    }

    public static Item verificarItem(int id, Loja loja, ArrayList<Item> itens){
        for(int i = 0;i < itens.size();i++){
            Item item = itens.get(i);
            if(id == item.id){
                Item itemObject = itens.get(i);
                return itemObject;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<ProcessaPedido> allProcessaPedidos = new ArrayList<>();
        ArrayList<Item> itens = new ArrayList<>();

        Loja loja1 = new Loja(1,"Infotec","Paraná","Cascavel","Centro","Rua Dom Pedro II","152","Casa","Fictício","123456789101");

        Vendedor vendedor1 = new Vendedor(1,"Igor",20,"Paraná","Cascavel","Quebec","Avenida das Torres","747","Casa",loja1,1500,1500,2000,2100);
        loja1.vendedores.add(vendedor1);

        Vendedor vendedor2 = new Vendedor(2,"Maria",19,"Paraná","Cascavel","Centro","Avenida Brasil","157","Ap 152",loja1,1700,2000,1750,2300);
        loja1.vendedores.add(vendedor2);

        Gerente gerente1 = new Gerente(1,"Cleber",35,"Paraná","Cascavel","Brasmadeira","Rua da Abobrinha","235","Casa Azul",loja1,5200,6000,7200,6500);
        gerente1.apresentarse();
        
        vendedor1.apresentarse();
        System.out.println(vendedor1.apresentarLogradouro());

        System.out.println(loja1.apresentarse());

        vendedor1.calcularBonus();
        vendedor1.calcularMedia();

        vendedor2.apresentarse();
        vendedor2.calcularBonus();
        vendedor2.calcularMedia();
        
        Cliente cliente1 = new Cliente(1,"Sarah",17,"Paraná","Cascavel","Centro","Avenida Brasil","584","Casa",loja1);
        loja1.clientes.add(cliente1);

        Item item1 = new Item(1,"Cacto","Planta",20);
        itens.add(item1);

        item1.gerarDescricao();

        ProcessaPedido processaPedido1 = criarPedido(loja1, itens);
        allProcessaPedidos.add(processaPedido1);
        Pedidos pedido1 = processaPedido1.processarPedido(processaPedido1.itens);


        cliente1.apresentarse();

        loja1.contarVendedores();
        loja1.contarClientes();
    }
}

