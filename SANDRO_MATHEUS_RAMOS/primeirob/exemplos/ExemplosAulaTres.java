package primeirob.exemplos;

public class ExemplosAulaTres {

    public static void main(String[] args) {
        int idade = 20;
        String valorPrint = idade >= 18 ? "É maior de idade" : "É menor de idade";

        System.out.println(valorPrint);
        
        //-------

        int[] umNovoVetor;

        umNovoVetor = new int[] { 23, 34, 21, 34, 45 };

        System.out.println(umNovoVetor[3]);
        System.out.println(umNovoVetor[5]);
    }

}
