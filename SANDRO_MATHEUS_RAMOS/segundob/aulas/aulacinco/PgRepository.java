package segundob.aulas.aulacinco;

public class PgRepository {
    
    public boolean salvar(Pedido pedido) {
        PgConnection connection = new PgConnection("url");

        System.out.println("persistir no banco");
        
        return true;
    }

}
