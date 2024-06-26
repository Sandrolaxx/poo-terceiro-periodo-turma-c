package KAUE_ANDRADE_PADILHA.prova;

import java.util.Date;

public class Evento {
  private String nome;
  private String tipo;
  private Date data;
  private int id;
  private boolean ingressoComprado = false;
  private Cliente[] clientes = new Cliente[3];

  public Evento() {}

  public Evento(String nome, String tipo, Date data) {
    this.nome = nome;
    this.tipo = tipo;
    this.data = data;
  }

  public String getNome() { return nome; }
  public String getTipo() { return tipo; }
  public Date getData() { return data; }
  public Cliente[] getCliente() { return clientes; }

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public boolean getIngressoComprado() { return ingressoComprado; }
  public void setIngressoComprado(boolean ingressoComprado) { this.ingressoComprado = ingressoComprado; }

  public void adicionarCliente(Cliente cliente) {
    for (int i = 0; i < clientes.length; i++) {
      if (clientes[i] == null) {
        clientes[i] = cliente;
        break;
      }
    }
  }
}
