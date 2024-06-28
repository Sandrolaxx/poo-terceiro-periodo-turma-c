package CLARA_LIOTTO.Lista5;

import java.util.ArrayList;

public class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private ArrayList<Vendedor> arrayVendedores;
    private ArrayList<Cliente> arrayClientes;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.arrayVendedores = new ArrayList<>();
        this.arrayClientes = new ArrayList<>();
        System.out.println("Loja criada: " + this.nomeFantasia);
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

    public void contarClientes() {
        System.out.println("Quantidade de clientes: " + arrayClientes.size());
    }

    public void contarVendedores() {
        System.out.println("Quantidade de vendedores: " + arrayVendedores.size());
    }

    public void apresentarSe() {
        System.out.println("Nome Fantasia: " + nomeFantasia + ", CNPJ: " + cnpj + ", Endereço: " + rua + ", " + bairro + ", " + cidade);
    }
}