package primeirob.listas.listaseis;

public class Gerente extends Pessoa {

    private Double salarioBase;

    public Double calcularBonus() {
        return salarioBase * 0.02;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

}
