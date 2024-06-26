package lista_04.classes.pessoa;

public class Pessoa {
  private String nome;
  private String bairro;
  private String cidade;
  private String rua;
  private int idade;

  public Pessoa(String nome, String bairro, String cidade, String rua, int idade) {
    this.nome = nome;
    this.bairro = bairro;
    this.cidade = cidade;
    this.rua = rua;
    this.idade = idade;
  }

  public void apresentarse() {
    System.out.println("Prazer eu sou o "
        .concat(this.getNome())
        .concat(" e tenho " + this.getIdade())
        .concat(" anos de idade."));
  }

  public String getBairro() {
    return bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public int getIdade() {
    return idade;
  }

  public String getNome() {
    return nome;
  }

  public String getRua() {
    return rua;
  }
}
