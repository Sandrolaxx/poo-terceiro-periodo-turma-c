package ATV7.src;

import java.util.Scanner;

public class ProcessaPedido {
    public void processar(Pedido pedido) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione o item desejado:");
        for (int i = 0; i < pedido.getLoja().getItens().size(); i++) {
            Item item = pedido.getLoja().getItens().get(i);
            System.out.println("[" + (i + 1) + "] - " + item.getNome() + " - R$" + item.getValor());
        }
        int escolhaItem = scanner.nextInt();
        Item itemEscolhido = pedido.getLoja().getItens().get(escolhaItem - 1);
        
        pedido.getItens().add(itemEscolhido);

        System.out.println("Pedido processado com sucesso!");
        scanner.close();
    }
}
