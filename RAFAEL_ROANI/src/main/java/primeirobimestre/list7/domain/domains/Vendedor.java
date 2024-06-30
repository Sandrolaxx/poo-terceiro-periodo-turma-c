package primeirobimestre.list7.domain.domains;

import primeirobimestre.list7.domain.abstracts.Funcionario;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class Vendedor extends Funcionario {
    public Vendedor(
            String nome, Integer idade, Endereco endereco, Loja loja, Double salarioBase, List<Double> salarioRecebido
    ) {
        super(nome, idade, endereco, loja, salarioBase, salarioRecebido);
    }

    public double calcularMedia() {
        double soma = 0;
        for (Double aDouble : salarioRecebido) {
            soma += aDouble;
        }
        Double soma2 = salarioRecebido.stream().reduce((num, acum) -> acum += num).get();
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }


    public static final class VendedorBuilderLista07 {
        private Endereco endereco;
        private Loja loja;
        private Double salarioBase;
        private List<Double> salarioRecebido;
        private String nome;
        private Integer idade;

        private VendedorBuilderLista07() {
        }

        public static VendedorBuilderLista07 builder() {
            return new VendedorBuilderLista07();
        }

        public VendedorBuilderLista07 endereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public VendedorBuilderLista07 loja(Loja loja) {
            this.loja = loja;
            return this;
        }

        public VendedorBuilderLista07 salarioBase(Double salarioBase) {
            this.salarioBase = salarioBase;
            return this;
        }

        public VendedorBuilderLista07 salarioRecebido(List<Double> salarioRecebido) {
            this.salarioRecebido = salarioRecebido;
            return this;
        }

        public VendedorBuilderLista07 nome(String nome) {
            this.nome = nome;
            return this;
        }

        public VendedorBuilderLista07 idade(Integer idade) {
            this.idade = idade;
            return this;
        }

        public Vendedor build() {
            return new Vendedor(nome, idade, endereco, loja, salarioBase, salarioRecebido);
        }
    }
}