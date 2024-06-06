package SegundoBI.aulas.aula01;

import java.util.HashMap;
import java.util.Map;

public class MapClasse {
      public static void main(String[] args) {
            //Salvar em chave e valor
            Map<String, Integer> veiculos = new HashMap<>();
            
            veiculos.put("BMW Monstra", 5);
            veiculos.put("Moto do Gonçalves", 10);

            veiculos.get("BMW Monstra"); // Vai buscar o valor de acordo com a chave
            // Lembrando que para cada valor em String é gerada uma chave em Integer
      }
}
