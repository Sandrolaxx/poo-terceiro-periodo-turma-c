/*package LUCAS_EDUARDO_DE_LIMA.listas.listacinco;

public class MyyPlantTest {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Cleverson ", 55, "Cascacity", "Cidade Vova", "Rua das aves");
        Cliente cliente2 = new Cliente("Juvenildo", 25, "Foz do Jordão", "7 de Outubro", "Rua agusta");

        Vendedor vendedor1 = new Vendedor("João", 33, "Cascacity", "Universitário", "Rua Sociologia", 1200);
        Vendedor vendedor2 = new Vendedor("Pedro", 28, "Foz do Jordão", "Esmeralda", "Rua Marcelino Ramos", 1500);

        Loja loja1 = new Loja("MyPlant", "My Plant LTDA", "10.317.425/0001-82", "Rio Bonito do Sul", "Lagoa azul", "Rua Lagoinha", new Cliente[]{
                cliente1, cliente2
        }, new Vendedor[]{
                vendedor1, vendedor2
        });

        vendedor1.setLoja(loja1);
        vendedor2.setLoja(loja1);

        vendedor1.adicionarSalarioRecebido(1200, 1300, 1500);
        vendedor2.adicionarSalarioRecebido(1250, 1350, 1550);

        cliente1.apresentarse();
        System.out.println("\n");
        cliente2.apresentarse();
        System.out.println("\n");
        vendedor1.apresentarse();
        System.out.println("Meu salário base é: " +vendedor1.calcularMedia());
        System.out.println("Meu bônus de salário foi de: " +vendedor1.calcularBonus());
        System.out.println("\n");
        vendedor2.apresentarse();
        System.out.println("Meu salário base é: " +vendedor2.calcularMedia());
        System.out.println("Meu bônus de salário foi de: " +vendedor2.calcularBonus());
        System.out.println("\n");
        loja1.apresentarse();
        System.out.println("\n");


    }
}
*/
