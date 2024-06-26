package listaSeis.src;

import java.util.Date;

public class Utils {

    public static boolean isDataMaior(Date dataUm, Date dataDois) {
        return dataUm.getTime() > dataDois.getTime();
    }
    
}
