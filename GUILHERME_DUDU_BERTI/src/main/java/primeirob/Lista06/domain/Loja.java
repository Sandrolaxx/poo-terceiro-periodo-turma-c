package primeirob.Lista06.domain;

import java.util.List;

public class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private Endereco endereco;
    private List<Vendedor> vendedores;
    private List<Cliente> clientes;

    private Loja(String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco,
                 List<Vendedor> vendedores, List<Cliente> clientes) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.vendedores = vendedores;
        this.clientes = clientes;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVendedores() {
        return vendedores.size();
    }

    public String apresentarse() {
        return ("Nome Fantasia: "
                .concat(nomeFantasia)
                .concat(", CNPJ: ")
                .concat(cnpj)
                .concat(", Endereço: ")
                .concat(" Cidade: ")
                .concat(endereco.getCidade())
                .concat(", Bairro: ")
                .concat(endereco.getBairro())
                .concat(", Rua: ")
                .concat(endereco.getRua())
                .concat(".")
        );
    }

    public static final class LojaBuilder {
        private String nomeFantasia;
        private String razaoSocial;
        private String cnpj;
        private Endereco endereco;
        private List<Vendedor> vendedores;
        private List<Cliente> clientes;

        private LojaBuilder() {
        }

        public static LojaBuilder builder() {
            return new LojaBuilder();
        }

        public LojaBuilder nomeFantasia(String nomeFantasia) {
            this.nomeFantasia = nomeFantasia;
            return this;
        }

        public LojaBuilder razaoSocial(String razaoSocial) {
            this.razaoSocial = razaoSocial;
            return this;
        }

        public LojaBuilder cnpj(String cnpj) {
            this.cnpj = cnpj;
            return this;
        }

        public LojaBuilder endereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public LojaBuilder vendedores(List<Vendedor> vendedores) {
            this.vendedores = vendedores;
            return this;
        }

        public LojaBuilder clientes(List<Cliente> clientes) {
            this.clientes = clientes;
            return this;
        }

        public Loja build() {
            return new Loja(nomeFantasia, razaoSocial, cnpj, endereco, vendedores, clientes);
        }
    }
}
