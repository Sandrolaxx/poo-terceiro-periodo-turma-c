package KAUE_ORLANDINI.PrimeiroBimestre.Lista2;

public class Cliente {

    private String nome;
    
    private Double idade;
   
    private String cidade;
   
    private String bairro;

    private String rua;

    public Cliente(String nome, Double idade, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    
    
    void apresentarse() {
        System.out.println("nome: " + String.valueOf(nome) + String.valueOf(", idade: ") + String.valueOf(idade));
    }

    public String getNome() {
        return nome;
    }

    public Double getIdade() {
        return idade;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

}
