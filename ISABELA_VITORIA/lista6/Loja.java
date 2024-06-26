package lista6;

public class Loja {
    String nomeFantasia;
    String razaoSocial;
    String cpnj;
    String cidade;
    String bairro;
    String rua;
    Vendedor [] vendedor = new Vendedor[10];
    Cliente [] cliente = new Cliente [10];

    public void contarClientes() {
        int quantidadeCliente = 0;
    
        for (int i = 0; i < 10; i++) {
          if (cliente[i] != null) {
            quantidadeCliente ++;
          }
        }
    
        System.out.println("Numero clientes: " + quantidadeCliente);
      }
    
      public void contarVendedor() {
        int quantidadeVendedor = 0;
    
        for (int i = 0; i < 10; i++) {
          if (cliente[i] != null) {
            quantidadeVendedor ++;
          }
        }
    
        System.out.println("Numero vendedores: " + quantidadeVendedor);
      }

      public void apresentacao (){
        System.out.println("oii somos "+ nomeFantasia + " esse é nosso CNPJ "+ cpnj + " nosso bairro é " + bairro + " na rua " + rua + " na cidade " + cidade);
      }
}

