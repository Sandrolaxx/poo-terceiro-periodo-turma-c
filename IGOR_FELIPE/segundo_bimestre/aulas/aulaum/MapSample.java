package segundo_bimestre.aulas.aulaum;

import java.util.Map;
import java.util.HashMap;

public class MapSample {
    public static void main(String[] args) {
       
        Map <String, Double> mapaNota = new HashMap<>();

        mapaNota.put("Rafael",5.5);
        mapaNota.put("Gabriel",7.0);
        mapaNota.put("Maria",8.5);

        System.out.println(mapaNota.get("Rafael"));

        mapaNota.forEach((key,value) ->{
            System.out.println(key + ":" +value);
        });

    }
}
