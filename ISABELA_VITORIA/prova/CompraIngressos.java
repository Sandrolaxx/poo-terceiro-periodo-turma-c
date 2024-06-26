package ISABELA_VITORIA.prova;

public class CompraIngressos {
    public void comprarIngresso(Cliente cliente, Evento evento) {
        Ingresso ingresso = new Ingresso(cliente, evento);

        System.out.println("Ingresso comprado com sucesso para o evento: " + evento.getNome());
    }
}