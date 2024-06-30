package primeirobimestre.list5.domain;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class Loja extends Endereco{
    private String nomeFantasia;
    private String razaoSocial;
    private Long cnpj;
    private List<Vendedor> vendedores = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    private Loja(String cidade, String bairro, String rua, String nomeFantasia, String razaoSocial, Long cnpj) {
        super(cidade, bairro, rua);
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public void apresentarse() {
        log.info("Nome da empresa: {}, CNPJ: {}, Endereço: {}, {} - {}", nomeFantasia, cnpj, rua, bairro, cidade);
    }

    @Override
    public String toString() {
        return "Loja: \n" +
                "Nome Fantasia: " + nomeFantasia + "\n" +
                "Razão Social: " + razaoSocial + "\n" +
                "Cnpj: " + cnpj + "\n" +
                "Endereço: " + rua + ", " + bairro + " - " + cidade + "\n";
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


    public static final class LojaBuilderLista05 {
        private String cidade;
        private String bairro;
        private String rua;
        private String nomeFantasia;
        private String razaoSocial;
        private Long cnpj;

        private LojaBuilderLista05() {
        }

        public static LojaBuilderLista05 builder() {
            return new LojaBuilderLista05();
        }

        public LojaBuilderLista05 cidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public LojaBuilderLista05 bairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public LojaBuilderLista05 rua(String rua) {
            this.rua = rua;
            return this;
        }

        public LojaBuilderLista05 nomeFantasia(String nomeFantasia) {
            this.nomeFantasia = nomeFantasia;
            return this;
        }

        public LojaBuilderLista05 razaoSocial(String razaoSocial) {
            this.razaoSocial = razaoSocial;
            return this;
        }

        public LojaBuilderLista05 cnpj(Long cnpj) {
            this.cnpj = cnpj;
            return this;
        }

        public Loja build() {
            return new Loja(cidade, bairro, rua, nomeFantasia, razaoSocial, cnpj);
        }
    }
}