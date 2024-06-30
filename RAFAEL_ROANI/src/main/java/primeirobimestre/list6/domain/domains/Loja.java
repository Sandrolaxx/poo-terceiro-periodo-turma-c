package primeirobimestre.list6.domain.domains;

import primeirobimestre.list6.domain.abstracts.Endereco;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class Loja {
    private Endereco endereco;
    private String nomeFantasia;
    private String razaoSocial;
    private Long cnpj;
    private List<Vendedor> vendedores = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Gerente> gerentes = new ArrayList<>();

    private Loja(
            Endereco endereco, String nomeFantasia, String razaoSocial, Long cnpj, List<Vendedor> vendedores,
            List<Cliente> clientes, List<Gerente> gerentes
    ) {
        this.endereco = endereco;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.vendedores = vendedores;
        this.clientes = clientes;
        this.gerentes = gerentes;
    }

    public void apresentarse() {
        log.info("Nome da empresa: {}, CNPJ: {}, Endereço: {}", nomeFantasia, cnpj, endereco.apresentarLogradouro());
    }

    @Override
    public String toString() {
        return "Loja: \n" +
                "Nome Fantasia: " + nomeFantasia + "\n" +
                "Razão Social: " + razaoSocial + "\n" +
                "Cnpj: " + cnpj + "\n" +
                "Endereço: " + endereco + "\n";
    }

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void addVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVendedores() {
        return vendedores.size();
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public static final class LojaBuilderLista06 {
        Endereco endereco;
        private String nomeFantasia;
        private String razaoSocial;
        private Long cnpj;
        private List<Vendedor> vendedores;
        private List<Cliente> clientes;
        private List<Gerente> gerentes;

        private LojaBuilderLista06() {
        }

        public static LojaBuilderLista06 builder() {
            return new LojaBuilderLista06();
        }

        public LojaBuilderLista06 endereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public LojaBuilderLista06 nomeFantasia(String nomeFantasia) {
            this.nomeFantasia = nomeFantasia;
            return this;
        }

        public LojaBuilderLista06 razaoSocial(String razaoSocial) {
            this.razaoSocial = razaoSocial;
            return this;
        }

        public LojaBuilderLista06 cnpj(Long cnpj) {
            this.cnpj = cnpj;
            return this;
        }

        public LojaBuilderLista06 vendedores(List<Vendedor> vendedores) {
            this.vendedores = vendedores;
            return this;
        }

        public LojaBuilderLista06 clientes(List<Cliente> clientes) {
            this.clientes = clientes;
            return this;
        }

        public LojaBuilderLista06 gerentes(List<Gerente> gerentes) {
            this.gerentes = gerentes;
            return this;
        }

        public Loja build() {
            return new Loja(
                    endereco, nomeFantasia, razaoSocial, cnpj, vendedores, clientes, gerentes
            );
        }
    }
}