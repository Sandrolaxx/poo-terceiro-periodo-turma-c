package segundob.aulas.auladois;

import java.util.HashMap;
import java.util.Map;

public class MapSample {

    public static void main(String[] args) {

        Map<String, Double> mapaNota = new HashMap<>();

        mapaNota.put("Rafael", 5.5);
        mapaNota.put("Gabriel Marcolin", 6.5);
        mapaNota.put("Maria", 9.5);

        System.out.println(mapaNota.get("Maria"));

        mapaNota.forEach((key, value) -> {
            System.out.println(key + " : "  + value);
        });

        mapaNota.entrySet().forEach(kv -> {
            kv.getKey();
            kv.getValue();
        });

    }

}
