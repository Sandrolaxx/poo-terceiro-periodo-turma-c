package aula_05;

public class PgConnection {
  private String url;

  public PgConnection(String url) {
    this.url = url;
  }

  public String getUString() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public boolean salvar(Pedido pedido) {
    PgConnection connection = new PgConnection("url");

    System.out.println("Persistir no banco");

    return true;
  }
}
