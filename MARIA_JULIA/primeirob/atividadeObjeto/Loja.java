package primeirob.atividadeObjeto;

import java.util.ArrayList;

// 3. Crie uma classe Loja com:
// Atributos, nome fantasia, razão social, cpnj, cidade, bairro, rua, array vendedores, array de clientes.
// contarClientes, mosta a quantidade de clientes
// contarVendedores, mosta a quantidade de vendedores.
// Método apresentarse, printa nomeFantasia, cnpj e endereco.

public class Loja{
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public ArrayList<Vendedor> getVendedores() {
        return vendedores;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public  void apresentarse() {
        System.out.println("Loja [rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado
                + ", nomeFantasia=" + nomeFantasia + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", vendedores="
                + vendedores + ", clientes=" + clientes + "]");
    }

    ArrayList<Vendedor> vendedores = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();



    public void setVendedores(Vendedor vendedor) {
        this.vendedores.add(vendedor);
    }

    public void setClientes(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public Loja(String rua, String bairro, String cidade, String estado, String nomeFantasia, String razaoSocial,
            String cnpj) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public void contarClientes() {
        int contador = 0;
        for (Cliente i : clientes) {
            contador = contador + 1;
            String apresentar = "Cliente - " + i;
            System.out.println(apresentar);
        }
        String contadorString = String.valueOf(contador);
        System.out.println(contadorString);

    }

    public void contarVendedores() {
        int contador = 0;
        for (Vendedor i : vendedores) {
            contador = contador + 1;
            String apresentar = "Vendedor - " + i;
            System.out.println(apresentar);
        }
        String contadorString = String.valueOf(contador);
        System.out.println(contadorString);

    }


}
