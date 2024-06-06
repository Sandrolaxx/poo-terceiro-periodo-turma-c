package prova.classes.eventinho;

import java.util.Date;

import prova.classes.endereco.Endereco;

public class Eventinho {

  private Endereco endereco;
  private String nome;
  private Long data;
  private int ingressosDisponiveis;
  private int ingressosJaVendidos = 0;

  public Eventinho(Endereco endereco, String nome, Long data, int ingressosDisponiveis) {
    this.endereco = endereco;
    this.nome = nome;
    this.data = data;
    this.ingressosDisponiveis = ingressosDisponiveis;
  }

  public void mostrarEvento() {
    System.out.println("Nome: ".concat(getNome()));
    System.out.println("Data: " + getDataFormated(this.getData()));
    System.out.println("Ingressos restantes: " + (this.getIngressosDisponiveis() - this.getIngressosJaVendidos()));
    System.out.println("Endereço: ");
    this.getEndereco().apresentarLogradouro();
  }

  public Date getDataFormated(Long dateInLong) {
    return new Date(dateInLong);
  }

  // getters

  public Long getData() {
    return data;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public String getNome() {
    return nome;
  }

  public int getIngressosDisponiveis() {
    return ingressosDisponiveis;
  }

  public int getIngressosJaVendidos() {
    return ingressosJaVendidos;
  }

  // setters

  public void setIngressosJaVendidos() {
    this.ingressosJaVendidos++;
  }
}
