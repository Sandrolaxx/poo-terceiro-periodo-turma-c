package lista2.src;

import java.util.Scanner;
import java.util.ArrayList;

public class ArmazenarDados {

    protected static Scanner valorVenda = new Scanner(System.in);
    protected static Scanner quantidadePlantas = new Scanner(System.in);
    protected static Scanner descontosAplicados = new Scanner(System.in);

    public ArrayList<Double> produtos = new ArrayList<Double>();
    public ArrayList<Double> valores = new ArrayList<Double>();
    public ArrayList<Double> descontos = new ArrayList<Double>();

    public void armazenarDados() {

        // Pede pro usuário os dados
        System.out.print("Digite a quantidade: ");
        double quantidadeResponse = valorVenda.nextInt();
        System.out.print("Digite o preço: ");
        double valorResponse = quantidadePlantas.nextDouble();
        System.out.print("Digite o desconto aplicado (apenas número): ");
        double descontoResponse = descontosAplicados.nextInt();

        // Parte que vai dar o push nos arrays
        produtos.add(quantidadeResponse);
        valores.add(valorResponse);
        descontos.add(descontoResponse);

        for(int i = 0; i < produtos.size(); i++) {
            System.out.println("Venda " + (i+1) + " Quantidade :" + produtos.get(i) + " Descontos: " + descontos.get(i) + " Preço: R$" + valores.get(i));
        }
        
    }
}