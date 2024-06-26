package primeirob.exemplos.aulasete;

public class Pato extends Ave {

    String cor;

    public void nadar() {
        System.out.println("Esout nadando..");
    }

    @Override
    public void voar() {
        System.out.println("Sou Pato e sei voar!");
    }

}
