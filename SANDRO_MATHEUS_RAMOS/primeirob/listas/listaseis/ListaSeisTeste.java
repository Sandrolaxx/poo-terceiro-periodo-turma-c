package primeirob.listas.listaseis;

public class ListaSeisTeste {
    
    public static void main(String[] args) {
        
        Cliente cliente = new Cliente();

        cliente.setNome("Sandrolax");
        cliente.setIdade(23);
        cliente.setEndereco(new Endereco());

        Vendedor vendedor = new Vendedor();

        vendedor.setNome("Clebim");
        vendedor.setIdade(23);
        vendedor.setEndereco(new Endereco());

        Loja loja = new Loja();
        
        loja.setCnpj("2343243243");
        loja.setNomeFantasia("Nubank");
        loja.setRazaoSocial("NU Pagamentos S.A");

        loja.setClientes(new Cliente[] { cliente });
        loja.setVendedores(new Vendedor[] { vendedor });

        Item item1 = new Item();

        item1.setId(1);
        item1.setNome("Planta show");
        item1.setValor(25d);

        Item item2 = new Item();

        item2.setId(1);
        item2.setNome("Planta Bala");
        item2.setValor(25d);

        Item[] items = new Item[] { item1, item2 };

        ProcessaPedido processaPedido = new ProcessaPedido();

        Pedido pedido = processaPedido.processaPedido(cliente, items);
    
        processaPedido.confirmarPagamento(pedido);

        System.out.println(pedido.calcularValorTotal());
        System.out.println(pedido.getDataVencimentoReserva());
        System.out.println(pedido.getDataPagamento());
    }
    
}
