package segunda_versao.model;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Colaborador {
    private double bonus = 0.2;

    public Vendedor(String nome, int idade, Endereco endereco) {
        super.nome = nome;
        super.idade = idade;
        super.endereco = endereco;
    }

    public void calcularSalario() {
        double salarioTotal = super.calcularMedia() + super.calcularBonus(this.bonus);
        System.out.println("Salário total do vendedor: " + salarioTotal);
    }

    private static List<Vendedor> vendedoresExistentes = new ArrayList<>();

    public static void adicionarVendedor(Vendedor vendedor) {
        vendedoresExistentes.add(vendedor);
    }

    public static boolean vendedorExiste(String nomeVendedor) {
        for (Vendedor vendedor : vendedoresExistentes) {
            if (vendedor.getNome().equalsIgnoreCase(nomeVendedor)) {
                return true;
            }
        }
        return false;
    }
}