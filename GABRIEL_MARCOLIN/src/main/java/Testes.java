public class Testes {
    public static void main(String[] args) {

        Endereco endereco = new Endereco();

        endereco.setBairro("Parque Verde");
        endereco.setCidade("Cascavel");
        endereco.setComplemento("Perto da Fag");
        endereco.setEstado("Paraná");
        endereco.setNumero(297);

        Cliente cliente = new Cliente();

        cliente.setNome("Arlete Marcolin");
        cliente.setIdade(68);
        cliente.setEndereco(endereco);

        Cliente cliente2 = new Cliente();

        cliente2.setNome("Celso Marcolin");
        cliente2.setIdade(72);
        cliente2.setEndereco(endereco);

        Vendedor vendedor = new Vendedor();

        vendedor.setNome("Gabriel Marcolin");
        vendedor.setIdade(20);
        vendedor.setEndereco(endereco);
        vendedor.setLoja(new Loja());
        vendedor.setSalarioBase(1700);
        vendedor.setSalarioRecebido(new double[]{1300, 1500, 1700});

        Vendedor vendedor2 = new Vendedor();

        vendedor2.setNome("Hadalberto Solano");
        vendedor2.setIdade(43);
        vendedor2.setEndereco(endereco);
        vendedor2.setLoja(new Loja());
        vendedor2.setSalarioBase(3000);
        vendedor2.setSalarioRecebido(new double[]{3000, 4000, 5000});

        Loja loja = new Loja();

        loja.setNomeFantasia("Marcolin LTDA");
        loja.setEndereco(new Endereco());
        loja.setCnpj("312312312");
        loja.setRazaoSocial("Marcolindo");
        loja.setVendedor(new Vendedor[]{vendedor, vendedor2});
        loja.setCliente(new Cliente[]{cliente, cliente2});

//imagino que eu esteja setando endereco certo tanto em Vendedor quanto em Loja
//porém, eu puxar o endreco de venda pelo vendedor, não funcione por algum motivo
//tipo, por nao ser direto sla

        Item item = new Item();

        item.setId(1);
        item.setNome("Faca");
        item.setValor(20);

        Item item2 = new Item();

        item2.setId(2);
        item2.setNome("Garfo");
        item2.setValor(30);

        Pedido pedido = new Pedido();

        pedido.setCliente(cliente);
        pedido.setId(1);
        pedido.setItens(new Item[]{item,item2});


      ProcessaPedido processar = new ProcessaPedido();

      processar.confirmarPagamento(pedido);

    }
}
