package segundob.aulas.aulacinco;

public class Clt implements IProcessaFolha {

    private Double salario;

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public void processar() {
        Double salario = getSalario() / 2;

        System.out.println("Meu salário de clt: " + salario);
    }

}
