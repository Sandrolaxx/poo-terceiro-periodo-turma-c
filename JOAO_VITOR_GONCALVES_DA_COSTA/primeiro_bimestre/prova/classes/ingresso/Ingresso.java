package prova.classes.ingresso;

import prova.classes.eventinho.Eventinho;

public class Ingresso {

  private Eventinho eventinho;
  private boolean usado = false;

  public Ingresso(Eventinho eventinho) {
    this.eventinho = eventinho;
  }

  public void mostrarEventoRelacionado() {
    System.out.println(eventinho.getNome());
    System.out.println("Usado: " + this.foiUsado());
  }

  public void usarIngresso() {
    setUsado(true);
    System.out.println("Ingresso p para o evento foi usado, evento relacionado abaixo");
    mostrarEventoRelacionado();
    System.out.println("\n");

  }

  public boolean getUsado() {
    return usado;
  }

  public String foiUsado() {
    return usado ? "Sim" : "Não";
  }

  public void setUsado(boolean usado) {
    this.usado = usado;
  }

}
