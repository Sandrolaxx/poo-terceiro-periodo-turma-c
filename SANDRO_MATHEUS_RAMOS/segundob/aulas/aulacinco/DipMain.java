package segundob.aulas.aulacinco;

public class DipMain {
    
    public static void main(String[] args) {
        
        FolhaPagamentoService service = new FolhaPagamentoService();
        Estagiario estagiario = new Estagiario();
        Clt clt = new Clt();
        Pj pj = new Pj();

        estagiario.setSalario(650d);
        clt.setSalario(3200d);
        pj.setSalario(4500d);

        service.processa(pj);

    }

}
