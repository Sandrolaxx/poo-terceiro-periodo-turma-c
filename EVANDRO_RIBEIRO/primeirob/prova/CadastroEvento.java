package prova;

import java.util.Scanner;

public class CadastroEvento {
    private String nomeEvento;
    private String descricaoEvento;

    public CadastroEvento() {

    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public void lerInfoEvento(Scanner scanner) {
        scanner.nextLine(); 
        System.out.println("Digite o nome do evento:");
        setNomeEvento(scanner.nextLine());
        System.out.println("Digite a descrição do evento:");
        setDescricaoEvento(scanner.nextLine());
    }

    public void imprimirInfoEvento() {
        System.out.println("Nome do Evento: " + getNomeEvento());
        System.out.println("Descrição do Evento: " + getDescricaoEvento());
    }
}
