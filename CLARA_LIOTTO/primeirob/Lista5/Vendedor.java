package CLARA_LIOTTO.Lista5;

class Vendedor {
    
    private String nome;
    private int idade;
    private Loja loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private double[] salarioRecebido;

    
    public Vendedor(String nome, int idade, Loja loja, String cidade, String bairro, String rua, double salarioBase, double[] salarioRecebido) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    
    public void apresentarSe() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja.getNomeFantasia());
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


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getIdade() {
        return idade;
    }


    public void setIdade(int idade) {
        this.idade = idade;
    }


    public Loja getLoja() {
        return loja;
    }


    public void setLoja(Loja loja) {
        this.loja = loja;
    }


    public String getCidade() {
        return cidade;
    }


    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public String getBairro() {
        return bairro;
    }


    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    public String getRua() {
        return rua;
    }


    public void setRua(String rua) {
        this.rua = rua;
    }


    public double getSalarioBase() {
        return salarioBase;
    }


    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }


    public double[] getSalarioRecebido() {
        return salarioRecebido;
    }


    public void setSalarioRecebido(double[] salarioRecebido) {
        this.salarioRecebido = salarioRecebido;
    }
    Vendedor vendedor = new Vendedor("João", 30, loja, "São Paulo", "Centro", "Rua das Flores", 2000.0, salarioRecebido);
}