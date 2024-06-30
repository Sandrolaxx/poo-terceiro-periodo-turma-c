package CLARA_LIOTTO.Lista5;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        
        Endereco endereco = new Endereco("Paraná", "Ubiratã", "Centro", 111, "Casa");
        Cliente cliente = new Cliente();
        Gerente gerente = new Gerente();
        Item item = new Item(1, "Cacto", "Planta", 5.00);
        Loja loja = new Loja("Loja A", "Razão Social A", "123456789", "São Paulo", "Centro", "Rua A");
        Pedido pedido = new Pedido(1, "Cliente A", "Vendedor A", "Loja B", new ArrayList<Item>());

        
        endereco.apresentarLogradouro();
        cliente.apresentarSe();
        gerente.apresentarSe();
        item.gerarDescricao();
        loja.apresentarSe();

        
        ProcessarPedido processador = new ProcessarPedido();
        processador.processar(pedido);

       
        System.out.println("Média dos salários do Gerente: " + gerente.calcularMedia());
        System.out.println("Bônus do Gerente: " + gerente.calcularBonus());
        
        
        ArrayList<Item> itensPedido = new ArrayList<>();
        itensPedido.add(item);
        pedido.setItens(itensPedido);
        System.out.println("Valor total do pedido: " + pedido.calcularValorTotal());
    }
}
        


