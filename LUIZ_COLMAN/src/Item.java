class Item {
    int id;
    String nome;
    String tipo;
    double valor;

    // Método para gerar descrição do item
    void gerarDescricao() {
        System.out.println("ID: " + id + ", Nome: " + nome + ", Tipo: " + tipo + ", Valor: " + valor);
    }
}
