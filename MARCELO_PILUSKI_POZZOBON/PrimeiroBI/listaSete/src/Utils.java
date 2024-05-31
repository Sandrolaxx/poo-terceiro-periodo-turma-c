package listaSete.src;

import java.util.Date;

public class Utils {
    public Item item = new Item();
    public int[] itensArray = new int[99];
    public int cont;

    public static boolean isDataMaior(Date dataUm, Date dataDois) {
        return dataUm.getTime() > dataDois.getTime();
    }

    public void contaItensArray() {
        for (int i = 0; i <= item.id - 1; i++) {
            itensArray[i] = item.id;
            cont++;
            item.gerarDescricao();
        }
    }
}
