package KAUE_ORLANDINI.PrimeiroBimestre.Lista2;

import java.util.Date;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        Vendedor marcelo = new Vendedor("Marcelo", 18.0, "regiao do lago", "Cascavel", "Bom Jesus", "Prisma", 1000.00, new double [] {1000, 1000, 1200}, 00.00 );
     

        Cliente goncalves = new Cliente("goncalves", 18.0, "Cascavel", "country", "Vincente Machado");


        Loja pvcartes = new Loja("PVCartes", "pvcartes", "77.637.684/0001-01", "Cascavel", "consolata", "Francisco Alves", "Parana", "nao há", 2861.00, new double[] {1,1,1}, new double[] {1,1,1,1,1}, 00.0, 00.0);


        Gerente mega = new Gerente(new double[] {1200, 1620, 1200}, "mega", 19.00, "prisma", "asa norte", "Brasilia", "avenida das torres", 1200.00, 00.0);


        Pedido primeiroPedido = new Pedido(new double[] {1}, "a1", "primeiro pedido",null,12.50 ,null,new Date(), new Date(), new Date(), "gufens", "prisma", "marecelo");

        

        @SuppressWarnings("deprecation")
        Pedido novoPpedido = new Pedido(new double[] {1}, "a2", "novo pedido", null,null , null,new Date(), new Date(), new Date(124,26,05), null, null, null);

        Item garrafa = new Item(new String[] {"garrafa" ,"livro" ,null},"aa", "garrafa", "garrafas", 12.50);


        ProcessaPedido pedidoA = new ProcessaPedido(null, null, "garrafa",null , 12.50,new String[] {"garrafa" ,"livro" ,null},new Date(), new Date(), new Date(), "mega", "prisma", "mega", new Date());

       

        Item cadastrarItem = new Item(new String[] {"garrafa" ,"livro" ,null},null, null, null, null);

            Scanner scanner = new Scanner(System.in);
    
            while (true) {
                exibirMenu();
    
            int opcao = scanner.nextInt();
    
            switch (opcao) {
                case 1:
                marcelo.apresentarse();
                    break;
                case 2:
                marcelo.calcularBonus();
                    break;
                case 3:
                marcelo.calcularMedia();
                    break;
                case 4:
                goncalves.apresentarse();
                    break;
                case 5:
                pvcartes.apresentarse();
                    break;
                case 6:
                pvcartes.contarClientes();
                    break;
                case 7:
                pvcartes.contarVendedores();
                    break;
                case 8:
                pvcartes.apresentarLogradouro();
                    break;
                case 9:
                mega.apresentarse();
                    break;
                case 10:
                mega.calcularBonus();
                    break;
                case 11:
                mega.calcularMedia();
                    break;
                case 12:
                primeiroPedido.calcularValorTotal();
                    break;
                case 13:
                primeiroPedido.gerarDescricaoVenda();
                    break;
                case 14:
                garrafa.gerarDescricao();
                    break;
                case 15:
                pedidoA.processar();
                    break;
                case 16:
                novoPpedido.criarPedido();
                    break;
                case 17:
                    cadastrarItem.cadastrarItem();
                    break;         
                case 18:
                    cadastrarItem.listarItens();
                    break;         
                case 19:
                    System.out.println("software encerrado");
                    return;         
                default:
                    System.out.println("opcao invalida");
                        
            }
        }
          
    }
    
    public static void exibirMenu(){
        System.out.println("[1]: apresentarse vendedor");
        System.out.println("[2]: calcular bonus vendedor");
        System.out.println("[3]: calcular media vendedor");
        System.out.println("[4]: apresentarse cliente");
        System.out.println("[5]: apresentarse loja");
        System.out.println("[6]: contar cliente loja");
        System.out.println("[7]: contar vendedore loja");
        System.out.println("[8]: apresentar logradouro loja");
        System.out.println("[9]: apresentarse gerente");
        System.out.println("[10]: calcular bonus gerente");
        System.out.println("[11]: calcular media gerente");
        System.out.println("[12]: calcular valor total pedido");
        System.out.println("[13]: gerar descricao de venda pedido");
        System.out.println("[14]: gerar descricao item");
        System.out.println("[15]: processar pedido");
        System.out.println("[16]: criar pedido");
        System.out.println("[17]: cadastrar item");
        System.out.println("[18]: listar itens");
        System.out.println("[19]:sair");
    }  
}