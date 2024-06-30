package segundobimestre.aulas.aulacinco;

public class ProcessaPedido {
    
    public void processa(Pedido pedido){

        if (pedido.isValido() && salvar (pedido)) {
            enviarEmailConfirmacao(pedido);
        }
    }

    public boolean salvar (Pedido pedido) {
        PgConnection connection = new PgConnection(url)
    }




}
