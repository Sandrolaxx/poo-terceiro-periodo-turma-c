package segundob.aulas.aulacinco;

public class Galinha extends Ave {
    
    @Override
    public void voar() {
        throw new RuntimeException("Não sei voar!");
    }

}
