package segundob.aulas.aulacinco;

public class ProcessaPedido {

    public void processa(Pedido pedido) {

        EnviaEmailConfirmacao emailConfirmacao = new EnviaEmailConfirmacao();
        PgRepository pgRepository = new PgRepository();

        boolean isSalvoDB = pgRepository.salvar(pedido);

        if (pedido.isValido() && isSalvoDB) {
            emailConfirmacao.enviarEmailConfirmacao(pedido);
        }

    }

}
