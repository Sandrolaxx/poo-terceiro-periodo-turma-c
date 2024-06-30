package primeirobimestre.list5.domain;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Log4j2
public class Vendedor extends Pessoa {
    private Loja loja;
    private Double salarioBase;
    private List<Double> salarioRecebido = new ArrayList<>();

    private Vendedor(String nome, Integer idade, String cidade, String bairro, String rua, Loja loja, Double salarioBase, List<Double> salarioRecebido) {
        super(nome, idade, cidade, bairro, rua);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido.addAll(salarioRecebido);
    }

    @Override
    public void apresentarse() {
        log.info("Meu nome é {}, minha idade é {} e a loja que trabalho é {}", nome, idade, loja.getNomeFantasia());
    }

    @Override
    public String toString() {
        String salariosRecebidos = salarioRecebido.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", "));

        return "Vendedor: " + "\n" +
                "Nome: " + nome + "\n" +
                "Idade" + idade + "\n" +
                "Endereço: " + rua + ", " + bairro + " - " + cidade + "\n" +
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

    public static final class VendedorBuilderLista05 {
        private String cidade;
        private String bairro;
        private String rua;
        private String nome;
        private Integer idade;
        private Loja loja;
        private Double salarioBase;
        private List<Double> salarioRecebido = new ArrayList<>();

        private VendedorBuilderLista05() {
        }

        public static VendedorBuilderLista05 builder() {
            return new VendedorBuilderLista05();
        }

        public VendedorBuilderLista05 cidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public VendedorBuilderLista05 bairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public VendedorBuilderLista05 rua(String rua) {
            this.rua = rua;
            return this;
        }

        public VendedorBuilderLista05 nome(String nome) {
            this.nome = nome;
            return this;
        }

        public VendedorBuilderLista05 idade(Integer idade) {
            this.idade = idade;
            return this;
        }

        public VendedorBuilderLista05 loja(Loja loja) {
            this.loja = loja;
            return this;
        }

        public VendedorBuilderLista05 salarioBase(Double salarioBase) {
            this.salarioBase = salarioBase;
            return this;
        }

        public VendedorBuilderLista05 salarioRecebido(Double value1, Double value2, Double value3) {
            salarioRecebido.add(value1);
            salarioRecebido.add(value2);
            salarioRecebido.add(value3);
            return this;
        }

        public Vendedor build() {
            return new Vendedor(nome, idade, cidade, bairro, rua, loja, salarioBase, salarioRecebido);
        }
    }
}