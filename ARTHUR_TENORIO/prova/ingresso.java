package ARTHUR_TENORIO.prova;

public class ingresso {

    private String codigo;
    private Cliente cliente;
    private eventos evento;
    private boolean utilizado;

    public ingresso(String codigo, Cliente cliente, eventos evento) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.evento = evento;
        this.utilizado = false;
    }

    public void setUtilizado(boolean utilizado) {
        this.utilizado = utilizado;
    }

    public boolean isUtilizado() {
        return utilizado;
    }

    @Override
    public String toString() {
        return "Ingresso{" +
                "codigo='" + codigo + '\'' +
                ", cliente=" + cliente +
                ", evento=" + evento +
                ", utilizado=" + utilizado +
                '}';
    }
}