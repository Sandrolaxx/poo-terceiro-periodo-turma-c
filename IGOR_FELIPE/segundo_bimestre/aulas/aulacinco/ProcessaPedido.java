package segundo_bimestre.aulas.aulacinco;

public class ProcessaPedido {
    
    public void processa(Pedido pedido){

        if(pedido.isValido() && salvar(pedido)){
            enviarEmailConfirmacao(pedido);
        }
    }

    public boolean salvar(Pedido pedido){
        PgConnection connection = new PgConnection("url");

        System.out.println("Persistir no banco");

        return true;
    }

    public void enviarEmailConfirmacao(Pedido pedido){
        System.out.println("Realizando envio de e-mail");
    }
}
