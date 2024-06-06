package primeirob.Lista07.domain;

import java.util.List;

public class Gerente extends Pessoa {
    private Endereco endereco;
    private Loja loja;
    private double salarioBase;
    private List<Double> salarioRecebido;

    private Gerente(String nomePessoa, Integer idade, Endereco endereco, Loja loja, double salarioBase,
                    List<Double> salarioRecebido) {
        super(nomePessoa, idade, endereco);
        this.endereco = endereco;
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Loja getLoja() {
        return loja;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public List<Double> getSalarioRecebido() {
        return salarioRecebido;
    }

    @Override
    public String apresentarse() {
        return ("Nome: "
                .concat(nomePessoa)
                .concat(", idade: ")
                .concat(String.valueOf(idade))
                .concat(", gerente da loja: ")
                .concat((loja == null) ? "null" : loja.getNomeFantasia())
                .concat("."));
    }

    public double calcularMedia() {
        double soma = salarioRecebido.stream().mapToDouble(Double::doubleValue).sum();
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }

    public static final class GerenteBuilder {
        private String nomePessoa;
        private Integer idade;
        private Endereco endereco;
        private Loja loja;
        private double salarioBase;
        private List<Double> salarioRecebido;

        private GerenteBuilder() {
        }

        public static GerenteBuilder builder() {
            return new GerenteBuilder();
        }

        public GerenteBuilder nomePessoa(String nomePessoa) {
            this.nomePessoa = nomePessoa;
            return this;
        }

        public GerenteBuilder idade(Integer idade) {
            this.idade = idade;
            return this;
        }

        public GerenteBuilder endereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public GerenteBuilder loja(Loja loja) {
            this.loja = loja;
            return this;
        }

        public GerenteBuilder salarioBase(double salarioBase) {
            this.salarioBase = salarioBase;
            return this;
        }

        public GerenteBuilder salarioRecebido(List<Double> salarioRecebido) {
            this.salarioRecebido = salarioRecebido;
            return this;
        }

        public Gerente build() {
            return new Gerente(nomePessoa, idade, endereco, loja, salarioBase, salarioRecebido);
        }
    }
}
