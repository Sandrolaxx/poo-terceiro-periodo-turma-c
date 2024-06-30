package primeirobimestre.list6.domain.domains;

import primeirobimestre.list6.domain.abstracts.Endereco;
import primeirobimestre.list6.domain.abstracts.Funcionario;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Log4j2
public class Vendedor extends Funcionario {
    public Vendedor(
            String nome, Integer idade, Endereco endereco, Loja loja, Double salarioBase, List<Double> salarioRecebido
    ) {
        super(nome, idade, endereco, loja, salarioBase, salarioRecebido);
    }

    @Override
    public String toString() {
        String salariosRecebidos = salarioRecebido.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", "));

        return "Vendedor: " + "\n" +
                "Nome: " + nome + "\n" +
                "Idade" + idade + "\n" +
                "Endereço: " + endereco + "\n" +
                "Salario Base: " + salarioBase + "\n" +
                salariosRecebidos + "\n";

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


    public static final class VendedorBuilderLista06 {
        private Endereco endereco;
        private Loja loja;
        private Double salarioBase;
        private List<Double> salarioRecebido;
        private String nome;
        private Integer idade;

        private VendedorBuilderLista06() {
        }

        public static VendedorBuilderLista06 builder() {
            return new VendedorBuilderLista06();
        }

        public VendedorBuilderLista06 endereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public VendedorBuilderLista06 loja(Loja loja) {
            this.loja = loja;
            return this;
        }

        public VendedorBuilderLista06 salarioBase(Double salarioBase) {
            this.salarioBase = salarioBase;
            return this;
        }

        public VendedorBuilderLista06 salarioRecebido(List<Double> salarioRecebido) {
            this.salarioRecebido = salarioRecebido;
            return this;
        }

        public VendedorBuilderLista06 nome(String nome) {
            this.nome = nome;
            return this;
        }

        public VendedorBuilderLista06 idade(Integer idade) {
            this.idade = idade;
            return this;
        }

        public Vendedor build() {
            return new Vendedor(nome, idade, endereco, loja, salarioBase, salarioRecebido);
        }
    }
}