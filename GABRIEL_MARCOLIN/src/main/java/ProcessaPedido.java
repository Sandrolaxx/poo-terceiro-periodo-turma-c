import java.util.Date;
import java.util.Scanner;

public class ProcessaPedido {

    private Scanner scanner;
    private Pedido pedido;
    private Item[] itensExistentes;
    private int numItens;

    public ProcessaPedido() {
        this.scanner = new Scanner(System.in);
        this.pedido = new Pedido();
        this.itensExistentes = new Item[100];
        this.numItens = 0;
    }

    public void confirmarPagamento() {
        Date dataAtual = new Date();

        if (dataAtual.getTime() < pedido.getDataVencimentoReserva().getTime()) {
            System.out.println("A data de vencimento de sua reserva ainda não expirou.");
        } else {
            System.out.println("A data de vencimento de sua reserva expirou.");
        }
    }

    public Item criarItem() {
        System.out.print("ID do Item: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome do Item: ");
        String nome = scanner.nextLine();

        System.out.print("Valor do Item: ");
        double valor = scanner.nextDouble();

        Item novoItem = new Item(id, nome, valor);
        itensExistentes[numItens] = novoItem;
        numItens++;

        return novoItem;
    }

    public void listarItensExistentes() {
        System.out.println("Itens Existentes:");
        for (int i = 0; i < numItens; i++) {
            Item item = itensExistentes[i];
            System.out.println("ID: " + item.getId() + ", Nome: " + item.getNome() + ", Valor: " + item.getValor());
        }
    }

    public Pedido criarPedido() {

        Pedido pedido = new Pedido();

        System.out.print("ID do Cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = new Cliente();
        pedido.setCliente(cliente);

        boolean continuarAdicionando = true;
        while (continuarAdicionando) {

            System.out.print("ID do item que deseja adicionar ao pedido (Digite 0 para enc): ");
            int idItem = scanner.nextInt();
            scanner.nextLine();

            if (idItem == 0) {
                continuarAdicionando = false; 
            } else {
                Item itemSelecionado = null;
                for (Item item : itensExistentes) {
                    if (item != null && item.getId() == idItem) {
                        itemSelecionado = item;
                        break;
                    }
                }
            }
        }
        return pedido;
    }
}

