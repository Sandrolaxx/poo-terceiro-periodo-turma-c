package loja_myy_Plant;
// sla e o main
public class Main {
    public static void main(String[] args) {
        // vendedor
        Vendedor vendedor1 = new Vendedor("Carlos", 28, "Myy Plant", "São Paulo", "Centro", "Rua A", 2500.0);
        vendedor1.salarionaConta.add(2600.0);
        vendedor1.salarionaConta.add(2550.0);
        vendedor1.salarionaConta.add(2650.0);

        //cliente
        Cliente cliente1 = new Cliente("Ana", 35, "São Paulo", "Bela Vista", "Rua B");

        //a loja
        Loja loja1 = new Loja("Myy Plant", "Myy Plant LTDA", "123.456.789/0001-01", "São Paulo", "Centro", "Rua C");
        loja1.vendedores.add(vendedor1);
        loja1.clientes.add(cliente1);

    
        System.out.println("Informações da Loja:");
        System.out.println("Nome da loja: " + loja1.nomeInv);
        System.out.println("CNPJ: " + loja1.cnpj);
        System.out.println("Endereço: " + loja1.cidade + ", " + loja1.bairro + ", " + loja1.rua);

        System.out.println("\nInformações do Vendedor:");
        System.out.println("Nome: " + vendedor1.nome);
        System.out.println("Idade: " + vendedor1.idade);
        System.out.println("Loja: " + vendedor1.loja);
        System.out.println("Média salarial: " + vendedor1.calcularMedia());
        System.out.println("Bônus: " + vendedor1.calcularBonus());

        System.out.println("\nInformações do Cliente:");
        System.out.println("Nome: " + cliente1.nome);
        System.out.println("Idade: " + cliente1.idade);

        System.out.println("\nQuantidade de Clientes na Loja: " + loja1.clientes.size());
        System.out.println("Quantidade de Vendedores na Loja: " + loja1.vendedores.size());
    }
}