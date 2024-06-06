import java.util.Arrays;

class Vendedor {
    private String nome;
    private int idade;
    private String nomeLoja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private double[] salarioRecebido;

    public Vendedor(String nome, int idade, String nomeLoja, String cidade, String bairro, String rua, double salarioBase, double[] salarioRecebido) {
        this.nome = nome;
        this.idade = idade;
        this.nomeLoja = nomeLoja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    public void apresentarSe() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Loja: " + nomeLoja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.length;
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}

class Cliente {
    private String nome;
    private int idade;
    private String cidade;
    private String bairro;
    private String rua;

    public Cliente(String nome, int idade, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    public void apresentarSe() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }
}

class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private Vendedor[] vendedores;
    private Cliente[] clientes;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua, Vendedor[] vendedores, Cliente[] clientes) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.vendedores = vendedores;
        this.clientes = clientes;
    }

    public void apresentarSe() {
        System.out.println("Nome Fantasia: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
    }

    public int contarClientes() {
        if (clientes != null) {
            return clientes.length;
        }
        return 0;
    }

    public int contarVendedores() {
        return vendedores.length;
    }
}

public class Lista05 {
    public static void main(String[] args) {
        Vendedor vendedor1 = new Vendedor("João", 30, "Loja A", "São Paulo", "Centro", "Rua A", 2000.0, new double[]{2000.0, 2100.0, 2200.0});
        Cliente cliente1 = new Cliente("Maria", 25, "São Paulo", "Centro", "Rua B");
        
        Vendedor[] vendedores = {vendedor1};
        Cliente[] clientes = {cliente1};
        
        Loja loja = new Loja("Loja XYZ", "Empresa XYZ LTDA", "12345678901234", "São Paulo", "Centro", "Rua C", vendedores, clientes);
        
        loja.apresentarSe();
        
        System.out.println("Total de clientes: " + loja.contarClientes());
        System.out.println("Total de vendedores: " + loja.contarVendedores());
    }
 }
