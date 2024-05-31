package GABRIEL_PALUDO_FRANCESCHINI.prova.src;

import java.util.ArrayList;

public class AnaCastelaEventos {

    private ArrayList<Clientes> clientes = new ArrayList<>();
    private ArrayList<Eventos> eventos = new ArrayList<>();
    private String nomeEmpresa;
    private String cnpj;

    public AnaCastelaEventos(String nomeEmpresa, String cnpj) {
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
    }

    public ArrayList<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Clientes> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Eventos> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Eventos> eventos) {
        this.eventos = eventos;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}