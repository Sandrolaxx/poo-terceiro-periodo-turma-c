package segundob.aulas.auladois;

import java.util.HashMap;
import java.util.Map;

public class MapSample {
    
    public static void main(String[] args) {
        
        //Criando mapa com chaves String e valores Double
        Map<String, Double> mapaNota = new HashMap<>();

        //Adicionando chaves e valores
        mapaNota.put("Rafael", 5.5);
        mapaNota.put("Gabriel Marcolin", 6.5);
        mapaNota.put("Maria", 9.0);
        mapaNota.put("Maria", 7.0);
        
        //Recuperando um valor pela chave
        System.out.println(mapaNota.get("Maria"));
        
        //Iterando nas chaves e valores(o par)
        mapaNota.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
        
        //Iterando nas chaves e valores(o par) segundo modo
        mapaNota.entrySet().forEach(kv -> {
            kv.getKey();
            kv.getValue();
        });

    }

}
