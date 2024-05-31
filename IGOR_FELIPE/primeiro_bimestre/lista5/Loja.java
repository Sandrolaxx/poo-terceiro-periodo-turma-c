package primeiro_bimestre.lista5;

import java.util.ArrayList;

public class Loja extends Endereco{
    public int id;
    public String nomeFantasia;
    public String razao;
    public String cnpj;
    public int armazenamentoVendedores = 5;
    public int armazenamentoClientes = 5;
    ArrayList<Vendedor> vendedores = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();
    int qtdVendedores;
    int qtdClientes;

    public Loja(int id,String nomeFantasia, String estado, String cidade, String bairro, String logradouro, String numero, String complemento, String razao,String cnpj){
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.razao = razao;
        this.cnpj = cnpj;
    }

    public void contarClientes(){
        System.out.println("Quantidade de clientes: "+clientes.size()); 
    }
    public void contarVendedores(){
        System.out.println("Quantidade de vendedores: "+vendedores.size());
    }
    public String apresentarse(){
        return "Empresa: "+nomeFantasia+"\nCNPJ: "+cnpj+"\nEndereço: " + apresentarLogradouro();
        //System.out.println("Empresa: "+nomeFantasia+" CNPJ: "+cnpj+" Endereço: "+apresentarLogradouro());
    }
}
//VERIFICAR QUESTÃO DO ENDEREÇO E RUA DEPOIS.
