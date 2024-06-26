package KAUE_ANDRADE_PADILHA.prova;

public class Cliente {
  private int id;
  private String nome;
  private String cpf;

  public Cliente(String nome, String cpf, int id) {
    this.nome = nome;
    this.cpf = cpf;
    this.id = id;
  }

  public String getNome() { return nome; }
  public String getCpf() { return cpf; }
  public int getId() { return id; }
}