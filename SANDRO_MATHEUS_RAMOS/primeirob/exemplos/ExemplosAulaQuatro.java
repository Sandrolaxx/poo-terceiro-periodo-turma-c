package primeirob.exemplos;

public class ExemplosAulaQuatro {

    public static void main(String[] args) {

        int[][] matrizBalaDeclarada;
        int[][] matrizBala = new int[3][3];
        int[][] matrizBalaComValor = new int[][] { { 34, 21 }, { 11, 23 } };
        // int[] vetorBala = new int[] { 34, 21 };

        System.out.println(matrizBalaComValor[1][1]);

        for (int i = 1; i < 8; i++) {
            if (i != 1 && i != 7) {
                continue;
            }

            System.out.println("Hoje é ".concat(i == 1 ? "Domingo" : "Sábado"));
        }

        // System.out.println("--------------PRINT VETOR");

        // for (int i = 0; i < vetorBala.length; i++) {
        // System.out.println(vetorBala[i]);
        // }

        System.out.println("--------------PRINT MATRIZ");
        System.out.print("[");
        for (int linha = 0; linha < matrizBalaComValor.length; linha++) {
            for (int coluna = 0; coluna < matrizBalaComValor.length; coluna++) {
                System.out.print(matrizBalaComValor[linha][coluna] + ",");
            }
        }
        System.out.print("]");
    }

}
