package GIULLIA_VILANOVA.prova;
public class Evento {
    
    private String nomeEvento;
    private String dataEvento;
    private Endereco enderecoEvento;

    public Evento(String nomeEvento, String dataEvento, Endereco enderecoEvento) {
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
        this.enderecoEvento = enderecoEvento;
    }

    public String getNomeEvento() {
		return this.nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public String getDataEvento() {
		return this.dataEvento;
	}

	public void setDataEvento(String dataEvento) {
		this.dataEvento = dataEvento;
	}

	public Endereco getEnderecoEvento() {
		return this.enderecoEvento;
	}

	public void setEnderecoEvento(Endereco enderecoEvento) {
		this.enderecoEvento = enderecoEvento;
	}
}
