package primeirobimestre.list6.domain.abstracts;

import primeirobimestre.list6.domain.domains.Loja;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public abstract class Funcionario extends Pessoa {
    protected Loja loja;
    protected Double salarioBase;
    protected List<Double> salarioRecebido;

    public Funcionario(
            String nome, Integer idade, Endereco endereco, Loja loja, Double salarioBase, List<Double> salarioRecebido
    ) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    @Override
    public void apresentarse() {
        log.info("Meu nome é {}, minha idade é {} e a loja que trabalho é {}", nome, idade, loja.getNomeFantasia());
    }

    public double calcularMedia() {
        double soma = 0;
        for (Double aDouble : salarioRecebido) {
            soma += aDouble;
        }
        Double soma2 = salarioRecebido.stream().reduce((num, acum) -> acum += num).get();
        return soma / salarioRecebido.size();
    }

    public abstract double calcularBonus();

    public Loja getLoja() {
        return loja;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public List<Double> getSalarioRecebido() {
        return salarioRecebido;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
}