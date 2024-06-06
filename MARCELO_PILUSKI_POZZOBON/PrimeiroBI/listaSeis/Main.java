package listaSeis;

import java.util.Scanner;

import listaSeis.src.*;

public class Main {
    public static void main(String[] args) {
        Scanner option = new Scanner(System.in);
        int optionMenu = 0;

        // Declarando Loja
        Loja prisma = new Loja();
        prisma.id = 1; // Na próxima versão vou implementar lógica para o ID.
        prisma.nome = "Prisma Softwares LTDA";
        prisma.razaoSocial = "Loja do Marcelolinho";
        prisma.cnpj = "0098060800120";
        prisma.endereco.cidade = "Cascavel";
        prisma.endereco.bairro = "Centro";
        prisma.endereco.rua = "Rua Presidente Bernardes";
        // Declarando Vendedor
        Vendedor marcelo = new Vendedor();
        marcelo.id = 1;
        marcelo.nome = "Marcelo Programador";
        marcelo.idade = 18;
        marcelo.nomeLoja = "Prisma Softwares LTDA";
        marcelo.endereco.cidade = "Cascavel";
        marcelo.endereco.rua = "Francisco Beltrão";
        marcelo.endereco.bairro = "Centro";
        marcelo.salarioBase = 1530;
        marcelo.salarioRecebido = new int[] { 1530, 1234, 543 };     
        /* marcelo.salarioRecebido[0] = 1530;
        marcelo.salarioRecebido[1] = 1234;
        marcelo.salarioRecebido[2] = 5432; */
        // Declarando Cliente
        Cliente kaue = new Cliente();
        kaue.id = 1;
        kaue.nome = "Kauê Orlandini";
        kaue.idade = 18;
        kaue.endereco.cidade = "Cascavel";
        kaue.endereco.bairro = "Maria Luiza";
        // Cria Gerente
        Gerente sandro = new Gerente();
        sandro.id = 1;
        sandro.nome = "Sandro";
        sandro.idade = 25;
        sandro.nomeLoja = "Prisma Softwares LTDA";
        sandro.endereco.bairro = "Centro";
        sandro.endereco.cidade = "Cascavel";
        sandro.endereco.rua = "Av. Brasil";
        sandro.salarioBase = 17550;
        sandro.salarioRecebido = new int[] { 17550, 16000, 17001 };
        /* sandro.salarioRecebido[0] = 17550;
        sandro.salarioRecebido[1] = 16000;
        sandro.salarioRecebido[2] = 17001; */
        // Cria Item
        Item apostila = new Item();
        apostila.id = 1;
        apostila.nome = "Apostila";
        apostila.tipo = "Estudos";
        apostila.valor = 10;

        // Cria Pedido
        Pedido pedido = new Pedido();
        pedido.dataCriacao = pedido.data.getTime();
        pedido.dataPagamento = pedido.data.getTime(); // Como é pra teste coloquei a data atual.
        // Alimenta ProcessaPedido
        ProcessaPedido processo = new ProcessaPedido();
        processo.valorPago = 15;

        exibirMenu(option, optionMenu, prisma, marcelo, kaue, sandro, pedido, processo);
    }

    public static void exibirMenu(Scanner opcao, int varOpcao, Loja varLoja, Vendedor varVendedor, Cliente varCliente,
            Gerente varGerente, Pedido varPedido, ProcessaPedido varProcessaPedido) {
        do {
            System.out.println(
                    "[1] - Dados empresa \n[2] - Dados Vendedor \n[3] - Dados Cliente \n[4] - Dados Gerente \n[5] - Criar Pedido \n[6] - Sair");
            varOpcao = opcao.nextInt();

            switch (varOpcao) {
                case 1:
                    varLoja.apresentarse();
                    varLoja.addClientes(varCliente.id);
                    varLoja.contarClientes();
                    varLoja.addVendedores(varVendedor.id);
                    varLoja.contarVendedores();
                    break;

                case 2:
                    varVendedor.apresentarse();

                    varVendedor.calcularMedia();
                    varVendedor.calcularBonus();
                    break;

                case 3:
                    varCliente.apresentarse();
                    break;

                case 4:
                    varGerente.apresentarse();
                    varGerente.calcularMedia();
                    varGerente.calcularBonus();
                    break;

                case 5:
                    varPedido.calcularValorTotal();
                    varPedido.gerarDescricaoVenda();
                    varProcessaPedido.processar();
                    break;
                    
                case 6:
                    System.out.println("Calculadora encerrada!");
                    break;

                default:
                    System.out.println("Erro de digitação, escolha uma das opções novamente.");
                    break;
            }
        } while (varOpcao != 6);
    }
}