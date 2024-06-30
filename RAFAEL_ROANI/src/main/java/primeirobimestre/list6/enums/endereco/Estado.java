package primeirobimestre.list6.enums.endereco;

public enum Estado {
    PR("Paraná"), SC("Santa Catarina"), RS("Rio Grande do Sul"), SP("São Paulo"), RJ("Rio de Janeiro");

    private final String estado;
    Estado(String estado) {
        this.estado = estado;
    }
}