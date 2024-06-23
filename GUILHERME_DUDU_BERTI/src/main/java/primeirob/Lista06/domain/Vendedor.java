package primeirob.Lista06.domain;

import java.util.List;

public class Vendedor extends Pessoa {
    private Endereco endereco;
    private Loja loja;
    private double salarioBase;
    private List<Double> salarioRecebido;

    private Vendedor(String nomePessoa, Integer idade, Endereco endereco, Loja loja, double salarioBase, List<Double> salarioRecebido) {
        super(nomePessoa, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    // Met add
    @Override
    public String apresentarse() {
        return ("Nome: "
                .concat(nomePessoa + ", ")
                .concat("idade: ")
                .concat(idade + ", ")
                .concat("vendedor(a) da loja: ")
                .concat((loja == null) ? "null" : loja.getNomeFantasia())
                .concat("."));
    }

    public double calcularMedia() {
        double soma = salarioRecebido.stream().mapToDouble(Double::doubleValue).sum();
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }


    public static final class VendedorBuilder {
        private String nomePessoa;
        private Integer idade;
        private Endereco endereco;
        private Loja loja;
        private double salarioBase;
        private List<Double> salarioRecebido;

        private VendedorBuilder() {
        }

        public static VendedorBuilder builder() {
            return new VendedorBuilder();
        }

        public VendedorBuilder nomePessoa(String nomePessoa) {
            this.nomePessoa = nomePessoa;
            return this;
        }

        public VendedorBuilder idade(Integer idade) {
            this.idade = idade;
            return this;
        }

        public VendedorBuilder endereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public VendedorBuilder loja(Loja loja) {
            this.loja = loja;
            return this;
        }

        public VendedorBuilder salarioBase(double salarioBase) {
            this.salarioBase = salarioBase;
            return this;
        }

        public VendedorBuilder salarioRecebido(List<Double> salarioRecebido) {
            this.salarioRecebido = salarioRecebido;
            return this;
        }

        public Vendedor build() {
            return new Vendedor(nomePessoa, idade, endereco, loja, salarioBase, salarioRecebido);
        }
    }
}
