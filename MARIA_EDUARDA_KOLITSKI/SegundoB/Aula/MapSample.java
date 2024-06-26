package SegundoB.Aula;

import java.util.HashMap;
import java.util.Map;

public class MapSample {
    
    public static void main(String[] args){
        Map<String, Double> mapaNota = new HashMap<>();

        mapaNota.put("Rafael", 5.5);
        mapaNota.put("Gabriel", 6.5);
        mapaNota.put("Maria", 9.0);
        mapaNota.put("Maria", 7.0);
        
        System.out.println(mapaNota.get("Maria"));

        mapaNota.forEach(key, value) -> {
            Sysrtem.out.println(key + " : " + value);
        });

        mapaNota.entrySet

    }

}
