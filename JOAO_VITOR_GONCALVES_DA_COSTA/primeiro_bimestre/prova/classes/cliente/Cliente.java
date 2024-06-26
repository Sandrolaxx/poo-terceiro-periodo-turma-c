package prova.classes.cliente;

import prova.classes.endereco.Endereco;
import prova.classes.ingresso.Ingresso;

public class Cliente {

  private int idade;
  private String nome;
  private Ingresso ingressos[] = new Ingresso[50];
  private int ingressosComprados = 0;
  private Endereco endereco;

  public Cliente(String nome, int idade, Endereco endereco) {
    this.idade = idade;
    this.nome = nome;
    this.endereco = endereco;
  }

  public void comprarIngresso(Ingresso ingressoParaComprar) {
    ingressos[this.getIngressosComprados()] = ingressoParaComprar;
    this.setIngressosComprados();
  }

  public void apresentarSe() {
    System.out.println("Nome: ".concat(getNome()));
    System.out.println("Ingressos comprados");
    this.listarIngressos();
  }

  public void listarIngressos() {
    for (int i = 0; i < ingressos.length; i++) {
      if (ingressos[i] != null) {
        System.out.println("Ingresso " + (i + 1) + ":");
        ingressos[i].mostrarEventoRelacionado();
      }
    }
  }

  public void usarIngresso(int indexDoIngresso) {
    if (ingressos[indexDoIngresso] == null) {
      System.out.println("Ingresso não existe");
      return;
    } else if (ingressos[indexDoIngresso].getUsado()) {
      System.out.println("Ingresso já usado");
      return;
    }

    ingressos[indexDoIngresso].usarIngresso();
    System.out.println("Ingresso usado");
  }

  // getters

  public int getIngressosComprados() {
    return ingressosComprados;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public String getNome() {
    return nome;
  }

  public int getIdade() {
    return idade;
  }

  public Ingresso[] getIngressos() {
    return ingressos;
  }

  // setters

  public void setIngressosComprados() {
    this.ingressosComprados++;
  }
}
