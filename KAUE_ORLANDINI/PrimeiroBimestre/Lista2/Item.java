package KAUE_ORLANDINI.PrimeiroBimestre.Lista2;

import java.util.Scanner;

public class Item {
    Scanner scanner = new Scanner(System.in);

    public String[] itenss = new String[3];

    private String id;

    private String nome;
    
    private String tipo;
    
    private Double valor;
    
    public Item(String[] itenss, String id, String nome, String tipo, Double valor) {
        this.itenss = itenss;
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    void gerarDescricao() {
        System.out.println("id: ".concat(id).concat(", nome: ").concat(nome).concat(", tipo: ").concat(tipo).concat(", valor: ") + String.valueOf(valor));
    }

    void cadastrarItem(){
        System.out.println("qual o nome do item");
          itenss[2] = scanner.next();
        System.out.println("iten adicionado");
    }

    void listarItens(){
        System.out.println(itenss[0] + ", " + itenss[1] + ", " + itenss[2]);
    }
   
   
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getValor() {
        return valor;
    }

    public String[] getItenss() {
        return itenss;
    }

    
    
    
}
