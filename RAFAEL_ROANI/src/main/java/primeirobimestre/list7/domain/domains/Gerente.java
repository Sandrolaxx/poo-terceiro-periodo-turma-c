package primeirobimestre.list7.domain.domains;

import primeirobimestre.list7.domain.abstracts.Funcionario;

import java.util.List;

public class Gerente extends Funcionario {
    private Gerente(
            String nome, Integer idade, Endereco endereco, Loja loja, Double salarioBase, List<Double> salarioRecebido
    ) {
        super(nome, idade, endereco, loja, salarioBase, salarioRecebido);
    }

    @Override
    public double calcularBonus() {
        return salarioBase * 0.35;
    }

    public static final class GerenteBuilderLista07 {
        private Endereco endereco;
        private Loja loja;
        private Double salarioBase;
        private List<Double> salarioRecebido;
        private String nome;
        private Integer idade;

        private GerenteBuilderLista07() {
        }

        public static GerenteBuilderLista07 builder() {
            return new GerenteBuilderLista07();
        }

        public GerenteBuilderLista07 endereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public GerenteBuilderLista07 loja(Loja loja) {
            this.loja = loja;
            return this;
        }

        public GerenteBuilderLista07 salarioBase(Double salarioBase) {
            this.salarioBase = salarioBase;
            return this;
        }

        public GerenteBuilderLista07 salarioRecebido(List<Double> salarioRecebido) {
            this.salarioRecebido = salarioRecebido;
            return this;
        }

        public GerenteBuilderLista07 nome(String nome) {
            this.nome = nome;
            return this;
        }

        public GerenteBuilderLista07 idade(Integer idade) {
            this.idade = idade;
            return this;
        }

        public Gerente build() {
            return new Gerente(nome, idade, endereco, loja, salarioBase, salarioRecebido);
        }
    }
}