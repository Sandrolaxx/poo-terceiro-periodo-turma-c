package segundob.aulas.aulaquatro;

import java.util.List;

public class EnumSample {
    
    public static void main(String[] args) {
        
        // final String PIX = "PIX";
        // final String CARTAO = "CARTAO";
        // final String DINHEIRO = "DINHEIRO";

        // String formaPgt = "teste";
        EnumFormaPagamentos formaPgt = EnumFormaPagamentos.CARTAO;
        EnumFormaPagamentos formaPgtParse = EnumFormaPagamentos.parseByKey("pix");

        System.out.println(formaPgtParse);
        System.out.println(formaPgtParse.getDescription());

        switch (formaPgt) {
            case PIX:

                break;
            case CARTAO:

                break;
            case DINHEIRO:

                break;
            default:
                break;
        }

    }

}
