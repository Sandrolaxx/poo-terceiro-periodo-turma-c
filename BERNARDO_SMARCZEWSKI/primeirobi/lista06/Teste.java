package primeirobi.lista06;

import java.util.Date;

public class Teste {
    public static void main(String[] args) {

        Endereco enderecoLoja = new Endereco("PR", "Cascavel", "Centro", "Avenida Brasil", 10, "");
        Endereco enderecoVendedor = new Endereco("PR", "Cascavel", "Centro", "Rio de Janeiro", 15, "");
        Endereco enderecoCliente = new Endereco("PR", "Toledo", "Centro", "Avenida Brasil", 27, "");
        Endereco enderecoJoao = new Endereco("PR", "Cascavel", "Centro", "São Paulo", 31, "");
        Endereco enderecoLuiza = new Endereco("PR", "Cascavel", "Floresta", "Manaus", 20, "");

        Loja lojaEx = new Loja("MyyPlant", "Myy Plant LTDA", "1234567890", enderecoLoja);

        Cliente cliente1 = new Cliente("Joana", 33, enderecoCliente);
        Vendedor vendedor1 = new Vendedor("Jorge", 39, enderecoVendedor, lojaEx, 2500.00);

        Cliente cliente2 = new Cliente("Joao", 40, enderecoJoao);
        Vendedor vendedor2 = new Vendedor("Luiza", 23, enderecoLuiza, lojaEx, 2700.00);
        
        lojaEx.addClientes(cliente1);
        lojaEx.addVendedores(vendedor1);
        lojaEx.addClientes(cliente2);
        lojaEx.addVendedores(vendedor2);

        System.out.println("=---=---=Loja=---=---=");
        lojaEx.apresentarse();
        lojaEx.contarClientes();
        lojaEx.contarVendedores();

        System.out.println("=---=---=Vendedor=---=---=");
        vendedor1.apresentarse();
        System.out.println("Média dos salários recebidos: " + vendedor1.calcularMedia());
        System.out.println("Bônus do vendedor: " + vendedor1.calcularBonus());
        System.out.println(" --- ");
        vendedor2.apresentarse();
        System.out.println("Média dos salários recebidos: " + vendedor2.calcularMedia());
        System.out.println("Bônus do vendedor: " + vendedor2.calcularBonus());

        System.out.println("=---=---=Clientes=---=---=");
        cliente1.apresentarse();
        cliente2.apresentarse();

        System.out.println("=---=---=Processamento de Pedido=---=---=");
        Item[] itens = {new Item(1, "Planta", "Ornamental", 50.00)};
        ProcessarPedido processarPedido = new ProcessarPedido();
        processarPedido.processar(1, new Date(), null, cliente1, vendedor1, lojaEx, itens);

    }
}
