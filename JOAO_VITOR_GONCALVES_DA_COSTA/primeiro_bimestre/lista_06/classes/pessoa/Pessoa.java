package lista_06.classes.pessoa;

import lista_05.classes.endereco.Endereco;

public class Pessoa {
  private Endereco endereco;
  private int idade;
  private String nome;

  public Pessoa(String nome, int idade, String bairro, String cidade, String rua, String estado, String complemento,
      String numero) {
    this.endereco = new Endereco(rua, estado, cidade, bairro, numero, complemento);
    this.idade = idade;
    this.nome = nome;
  }

  public void apresentarse() {
    System.out.println("Prazer eu sou o "
        .concat(this.getNome())
        .concat(" e tenho " + this.getIdade())
        .concat(" anos de idade."));
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public int getIdade() {
    return idade;
  }

  public String getNome() {
    return nome;
  }
}
