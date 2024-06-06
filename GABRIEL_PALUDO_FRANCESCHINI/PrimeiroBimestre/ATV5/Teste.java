/*Os negócios de Dona Gabrielinha iam de vento e polpa, com a abertura de sua primeira grande loja, no centro da cidade. Ela renomeou sua empresa para Myy Plant. O sistema simples de calculadora já não servia mais, ele precisava de algo para gerenciar sua empresa, funcionários e clientes. Ela entra novamente em contato e pede um sistema que suporte toda essa nova demanda.

Para suprir tais novas necessidades, precisamos conseguir, via sistema, representar a empresa, os funcionários e clientes.  

1. Crie uma classe Vendedor com:
Com os atributos nome, idade, Loja, cidade, bairro, rua, salarioBase e salarioRecebido.
Atributo salarioRecebido DEVE armazenar no mínimo três valores de lançamentos de salário.(Pode colocar no código os valores*)
Métodos apresentarse calcularMedia e calcularBonus.
Método apresentarse deve printar o nome, idade e Loja.
calcularMedia deve trazer a média dos salários.
calcularBonus onde a formula é [salarioBase * 0.2]

2. Criar classe Cliente:
com os atributos nome, idade, cidade, bairro e rua.
Método apresentarse deve printar o nome, idade.

3. Crie uma classe Loja com:
Atributos, nome fantasia, razão social, cpnj, cidade, bairro, rua, array vendedores, array de clientes.
contarClientes, mostra a quantidade de clientes
contarVendedores, mostra a quantidade de vendedores.
Método apresentarse, printa nomeFantasia, cnpj e endereco.*/
package ATV5;

import java.util.Scanner;
import ATV5.src.*;

public class Teste {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    //Criação da loja
    Loja myyPlantLoja = new Loja("MyyPlant", "MyyPlant LTDA.", "98765432101234", "Cascavel", "Coqueiral", "Rua Java");

    //Criação dos clientes
    myyPlantLoja.getClientes().add(new Cliente("Gabriel", 18, "Cascavel", "FAG", "Av. da FAG"));
    myyPlantLoja.getClientes().add(new Cliente("Lucas", 18, "Cascavel", "FAG", "Av. da FAG"));

    //Criação dos vendedores
    myyPlantLoja.getVendedores().add(new Vendedor("Rodrigo", 19, myyPlantLoja, 1000, new double[]{1225, 1350, 1400}));
    myyPlantLoja.getVendedores().add(new Vendedor("Roberto", 30, myyPlantLoja, 1800, new double[]{1975, 2008, 2115}));
    myyPlantLoja.getVendedores().add(new Vendedor("Cesar", 40, myyPlantLoja, 2500, new double[]{2630, 2700, 2720}));

    System.out.println("Loja MyyPlant");
    System.out.println("[1] - Apresentar loja");
    System.out.println("[2] - Apresentar vendedores");
    System.out.println("[3] - Apresentar clientes");
    System.out.println("[4] - Calcular média salarial dos vendedores");
    System.out.println("[5] - Calcular bônus dos vendedores");
    System.out.println("[6] - Contar vendedores");
    System.out.println("[7] - Contar clientes");
    System.out.println("[8] - Sair");

    int calculator;
    do {
    System.out.println("\nEscolha uma operação:");
    calculator = scanner.nextInt();

      switch (calculator) {
        case 1:
          myyPlantLoja.apresentarLoja();
          break;

        case 2:
          System.out.println("Lista de vendedores:");
          for (Vendedor vendedor : myyPlantLoja.getVendedores()) {
            vendedor.apresentarVendedor();
            System.out.println("----------------------");
          }
          break;

        case 3:
          System.out.println("Lista de clientes:");
          for (Cliente cliente : myyPlantLoja.getClientes()) {
            cliente.apresentarCliente();
            System.out.println("----------------------");
          }
          break;

        case 4:
          System.out.println("Média de salário dos vendedores:");
          for (Vendedor vendedor : myyPlantLoja.getVendedores()) {
            System.out.println(vendedor.getNome() + ": " + vendedor.calcularMediaSalarial());
          }
          break;

        case 5:
          System.out.println("Bônus dos vendedores:");
          for (Vendedor vendedor : myyPlantLoja.getVendedores()) {
            System.out.println(vendedor.getNome() + ": " + vendedor.calcularBonus());
          }
          break;
        
        case 6:
          System.out.println("Total de vendedores: " + myyPlantLoja.contarVendedores());
          break;
      
        case 7:
          System.out.println("Total de clientes: " + myyPlantLoja.contarClientes());
          break;

        case 8:
          break;
      }
    } while (calculator != 8);
    scanner.close();
  }
}