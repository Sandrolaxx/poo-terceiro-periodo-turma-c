package primeirobimestre.list6.domain.domains;

import primeirobimestre.list6.domain.abstracts.Endereco;
import primeirobimestre.list6.domain.abstracts.Funcionario;

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


    public static final class GerenteBuilderLista06 {
        private Endereco endereco;
        private Loja loja;
        private Double salarioBase;
        private List<Double> salarioRecebido;
        private String nome;
        private Integer idade;

        private GerenteBuilderLista06() {
        }

        public static GerenteBuilderLista06 builder() {
            return new GerenteBuilderLista06();
        }

        public GerenteBuilderLista06 endereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public GerenteBuilderLista06 loja(Loja loja) {
            this.loja = loja;
            return this;
        }

        public GerenteBuilderLista06 salarioBase(Double salarioBase) {
            this.salarioBase = salarioBase;
            return this;
        }

        public GerenteBuilderLista06 salarioRecebido(List<Double> salarioRecebido) {
            this.salarioRecebido = salarioRecebido;
            return this;
        }

        public GerenteBuilderLista06 nome(String nome) {
            this.nome = nome;
            return this;
        }

        public GerenteBuilderLista06 idade(Integer idade) {
            this.idade = idade;
            return this;
        }

        public Gerente build() {
            return new Gerente(nome, idade, endereco, loja, salarioBase, salarioRecebido);
        }
    }
}