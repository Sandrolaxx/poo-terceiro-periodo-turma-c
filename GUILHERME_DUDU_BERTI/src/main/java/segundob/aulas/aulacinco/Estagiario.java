package segundob.aulas.aulacinco;

public class Estagiario implements IProcessaFolha {

    private Double salario;

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public void processar() {
        Double salario = getSalario() + (getSalario() * 0.01);

        System.out.println("Meu salário de estágiario: " + salario);
    }

}
