package Listaseis;

public class Loja {
    String nomefantasia = "Loja da Dona Gabrielinha1";
    String razaosocial = "Vender plantas";
    String cnpj = "38.647.222/0001-73";
    String cidade = "Cascavel";
    String bairro = "Parque Vender";
    String rua = "Jacarandá";
    String endereco = "Rua Jacarandá 628";
    String vendedores [ ] = {"Joao", "Murilo", "Gabriel"};
    String clientes [ ] =  {"Jorge", "Ana", "Sofia"};

    public void apresentarse(){
        System.out.println("Nome de fantasia: " + nomefantasia);
        System.out.println("Cnpj: " + cnpj);
        System.out.println("Endereço: " + endereco);
    
    }

    public void contarClientes(String clientes[]){
        System.out.println("A quantidade de clientes é: " + clientes.length);
    }
    public void contarVendedores(String vendedores[]){
        System.out.println("A quantidade de vendedores é: " + vendedores.length);
    }




}
