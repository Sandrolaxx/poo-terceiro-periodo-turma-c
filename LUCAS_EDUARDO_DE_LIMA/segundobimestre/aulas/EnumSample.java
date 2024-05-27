package segundobimestre.aulas;

public class EnumSample {
    
    //final String PIX = "PIX";
    //final String CARTAO = "CARTAO";
    //final String DINHEIRO = "DINHEIRO";

static void main(String[] args){

    EnumFormaPagamentos formaPgt = EnumFormaPagamentos.CARTAO;
    EnumFormaPagamentos formaPgtParse = EnumFormaPagamentos.parseByKey(key:"pix");

    System.out.println(formaPgtParse);
    System.out.println(formaPgtParse.getDescription());

    switch (formaPgt) {
        case PIX:
            
        
            break;
    
        case CARTAO:
            
            break;

        case DINHEIRO :
            
            break;
        default:
            break;
    }
}    







}