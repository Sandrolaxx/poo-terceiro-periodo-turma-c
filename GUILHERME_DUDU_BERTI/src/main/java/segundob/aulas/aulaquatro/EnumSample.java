package segundob.aulas.aulaquatro;

public class EnumSample {
    public static void main(String[] args) {

        // final String PIX = "PIX";
        // final String CARTAO = "CARTAO";
        // final String DINHEIRO = "DINHEIRO";
        // String = formaPgmt = "teste";

        EnumFormaPagamento formaPgmt = EnumFormaPagamento.CARTAO;
        EnumFormaPagamento formaPgmtParse = EnumFormaPagamento.parseByKey("pix");

        System.out.println(formaPgmtParse);
        System.out.println(formaPgmtParse.getDescription());

        switch (formaPgmt) {
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
