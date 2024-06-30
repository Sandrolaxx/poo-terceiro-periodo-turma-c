package segundob.aulas.aulaquatro;

public enum EnumFormaPagamento {

    PIX("PIX", "Pagamentos Instantaneos"),
    CARTAO("CARTAO", ""),
    DINHEIRO("DINHEIRO", "");

    private String key;
    private String description;

    EnumFormaPagamento(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public String getKey() {
        return this.key;
    }

    public String getDescription() {
        return description;
    }

    public static EnumFormaPagamento parseByKey(String key) {
        for (EnumFormaPagamento pgto : EnumFormaPagamento.values()) {
            if (pgto.getKey().equalsIgnoreCase(key)) {
                return pgto;
            }
        }
        return null;
    }
}
