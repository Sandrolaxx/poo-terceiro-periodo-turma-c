package primeirob.Lista05.domain;

public class Loja {
    String cidade;
    String bairro;
    String rua;
    String nomeFantasia;
    String razaoSocial;
    String cnpj;
    Vendedor[] vendedores;
    Cliente[] clientes;

    private Loja(String cidade, String bairro, String rua, String nomeFantasia, String razaoSocial, String cnpj,
                 Vendedor[] vendedores, Cliente[] clientes) {
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
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

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    // met add
    public int contarClientes() {
        return clientes.length;
    }

    public int contarVendedores() {
        return vendedores.length;
    }

    public String apresentarse() {
        return ("Nome Fantasia: "
                .concat(nomeFantasia)
                .concat(" CNPJ: ")
                .concat(cnpj)
                .concat(" Endereço: ")
                .concat(" Cidade: ")
                .concat(cidade)
                .concat(" Bairro: ")
                .concat(bairro)
                .concat(" Rua")
                .concat(rua));
    }

    public static final class LojaBuilder {
        private String cidade;
        private String bairro;
        private String rua;
        private String nomeFantasia;
        private String razaoSocial;
        private String cnpj;
        private Vendedor[] vendedores;
        private Cliente[] clientes;

        private LojaBuilder() {
        }

        public static LojaBuilder builder() {
            return new LojaBuilder();
        }

        public LojaBuilder cidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public LojaBuilder bairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public LojaBuilder rua(String rua) {
            this.rua = rua;
            return this;
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

        public LojaBuilder vendedores(Vendedor[] vendedores) {
            this.vendedores = vendedores;
            return this;
        }

        public LojaBuilder clientes(Cliente[] clientes) {
            this.clientes = clientes;
            return this;
        }

        public Loja build() {
            return new Loja(cidade, bairro, rua, nomeFantasia, razaoSocial, cnpj, vendedores, clientes);
        }
    }

}
