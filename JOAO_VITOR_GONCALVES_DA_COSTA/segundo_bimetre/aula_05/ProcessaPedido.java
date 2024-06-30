package aula_05;

public class ProcessaPedido {

  public void processa(Pedido pedido) {

    PgConnection connection = new PgConnection("url");

    if (pedido.isValid() && connection.salvar(pedido)) {
      EnviarEmailConfirmacao.EnviarEmailConfirmacao(pedido);
    }

    System.out.println("Log: Pedido criado" + pedido.getId()

    );
  }

}
