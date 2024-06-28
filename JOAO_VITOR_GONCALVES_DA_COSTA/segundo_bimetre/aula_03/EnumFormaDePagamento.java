package aula_03;

public enum EnumFormaDePagamento {

  PIX("PIX"),
  CARTAO("CARTAO"),
  DINHEIRO("DINHEIRO");

  private String key;

  EnumFormaDePagamento(String key) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }

  static public EnumFormaDePagamento parseByKey(String key) {
    for (EnumFormaDePagamento pgto : EnumFormaDePagamento.values()) {
      if (pgto.getKey().equalsIgnoreCase(key)) {
        return pgto;
      }
    }

    return null;
  }
}
