package Listaseis;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        
        Cliente cliente = new Cliente();
        cliente.nome = "Ana";
        cliente.idade = 18;
        cliente.cidade = "Cascavel";
        cliente.bairro = "Centro";
        cliente.rua = "Rua Jacarandá";

        Vendedor vendedor = new Vendedor();
        vendedor.nome = "Carlos";
        vendedor.idade = 30;
        vendedor.loja = "Loja da Dona Gabrielinha1";
        vendedor.cidade = "Cascavel";
        vendedor.bairro = "Parque Verde";
        vendedor.rua = "Jatobá";
        vendedor.salarioBase = 2000.0;
        vendedor.salarioRecebido = new float[]{2000, 2200, 2300};

        Gerente gerente = new Gerente();
        gerente.nome = "Mariana";
        gerente.idade = 35;
        gerente.loja = "Loja Central";
        gerente.cidade = "Cascavel";
        gerente.bairro = "Centro";
        gerente.rua = "Rua das Petúnias";
        gerente.salarioBase = 3000.0;
        gerente.salarioRecebido = new float[]{3000, 3200, 3300}; 

        Item[] itens = {
            new Item(1, "Camisa", "Vestuário", 50.0),
            new Item(2, "Calça", "Vestuário", 80.0)
        };
        
        System.out.println("Informações do Cliente:");
        cliente.apresentarse();
        System.out.println();

        System.out.println("Informações do Vendedor:");
        vendedor.apresentarse();
        System.out.println();

        System.out.println("Informações do Gerente:");
        gerente.apresentarse();
        System.out.println();

        Endereco endereco = new Endereco();
        endereco.estado = "PR";
        endereco.cidade = "Cascavel";
        endereco.bairro = "Guarujá";
        endereco.numero = 123;
        endereco.complemento = "Apto 101";
        System.out.println("Endereço:");
        endereco.apresentarLogradouro();
        System.out.println();

        System.out.println("Informações dos Itens:");
        for (Item item : itens) {
            item.gerarDescricao();
            System.out.println();
        }
        System.out.println();

        ProcessaPedido processador = new ProcessaPedido();
        Date dataCriacao = new Date();
        Date dataVencimentoReserva = new Date(System.currentTimeMillis() + 3 * 24 * 60 * 60 * 1000);
        System.out.println("Processando pedido...");
        processador.processar(1, dataCriacao, null, dataVencimentoReserva, cliente, vendedor, "Minha Loja", itens);
    }
}
