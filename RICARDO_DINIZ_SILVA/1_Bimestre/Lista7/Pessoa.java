package RICARDO_DINIZ_SILVA.Lista7;

public class Pessoa {
  private String nome;
  private Integer idade;
  private Endereco endereco;

  public Pessoa() {}

  public Pessoa(String nome, Integer idade, Endereco endereco) {
    this.nome = nome;
    this.idade = idade;
    this.endereco = endereco;
  }

  public void apresentarse() {
    System.out.println("Meu nome é " + nome + ", eu tenho " + idade + " anos de idade.");
  }

  public String getNome() {
    return nome;
  }

  public Integer getIdade() {
    return idade;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }
}
