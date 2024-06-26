package primeirob.exemplos.aulaoito;

public class Mongo implements IBancoDados {
    public void salvar() {
        System.out.println("Salvando dados Mongo..");
    }
    
    public void buscar() {
        System.out.println("Buscar dados Mongo...");
    }
    
    public void alterar() {
        System.out.println("Alterar dados Mongo...");
    }
    
    public void deletar() {
        System.out.println("Deletar dados Mongo...");
    }
}
