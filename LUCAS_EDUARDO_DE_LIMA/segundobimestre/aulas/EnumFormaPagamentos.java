/*package segundobimestre.aulas;

public class EnumFormaPagamentos {

   // PIX(key:"PIX", description: "ins"),
   // CARTAO(key:"CARTAO"),
   // DINHEIRO(key:"DINHEIRO");

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

} */
