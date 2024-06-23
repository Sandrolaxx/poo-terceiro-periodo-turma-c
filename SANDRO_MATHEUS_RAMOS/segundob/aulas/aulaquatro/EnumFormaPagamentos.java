package segundob.aulas.aulaquatro;

public enum EnumFormaPagamentos {

    PIX("PIX", "Pagamentos Instantaneos"),
    CARTAO("CARTAO", "Cartão Crédito"),
    DINHEIRO("DINHEIRO", "Dinheiro");

    private String key;

    private String description;

    EnumFormaPagamentos(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public String getKey() {
        return this.key;
    }

    public String getDescription() {
        return this.description;
    }

    public static EnumFormaPagamentos parseByKey(String key) {
        for (EnumFormaPagamentos pgto : EnumFormaPagamentos.values()) {
            if (pgto.getKey().equalsIgnoreCase(key)) {
                return pgto;
            }
        }

        return null;
    }

}
