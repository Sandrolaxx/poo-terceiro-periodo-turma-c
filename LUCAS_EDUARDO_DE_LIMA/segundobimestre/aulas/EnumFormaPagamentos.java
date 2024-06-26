<<<<<<< HEAD
package segundobimestre.aulas;

public class EnumFormaPagamentos {

    PIX(key:"PIX", description: "ins"),
    CARTAO(key:"CARTAO"),
    DINHEIRO(key:"DINHEIRO");
=======
/*package segundobimestre.aulas;

public class EnumFormaPagamentos {

   // PIX(key:"PIX", description: "ins"),
   // CARTAO(key:"CARTAO"),
   // DINHEIRO(key:"DINHEIRO");
>>>>>>> ac19f0c294a06eda69abf66d9099cb555e97ebea

    private String key;

    EnumFormaPagamentos(String key, String description){
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }

    public EnumFormaPagamentos parseByKey(String key) {
        for (EnumFormaPagamentos pgto : EnumFormaPagamentos.value()){
            if (pgto.getKey().equalsIgnoreCase(key)){
            return pgto;
            }
        }
        
        return null;
    }

<<<<<<< HEAD
}
=======
} */
>>>>>>> ac19f0c294a06eda69abf66d9099cb555e97ebea
