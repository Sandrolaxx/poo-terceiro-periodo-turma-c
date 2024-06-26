package primeiro_bimestre.lista7;
import java.util.ArrayList;

public class Loja {
    private int id;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private Endereco endereco;
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Vendedor> vendedores = new ArrayList<>();

    public Loja(int id, String nomeFantasia,String razaoSocial, String cnpj, Endereco endereco){
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    
    public int getId(){
        return id;
    } 

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Cliente cliente) {
        clientes.add(cliente);
    }

    public void contarClientes(){
        System.out.println("Quantidade de clientes: "+clientes.size()); 
    }
    public void contarVendedores(){
        System.out.println("Quantidade de vendedores: "+vendedores.size());
    }
    public String apresentarse(){
        return "Empresa: "+nomeFantasia+"\nCNPJ: "+cnpj+"\nEndereço: " + endereco.apresentarLogradouro();
        //System.out.println("Empresa: "+nomeFantasia+" CNPJ: "+cnpj+" Endereço: "+apresentarLogradouro());
    }
}
