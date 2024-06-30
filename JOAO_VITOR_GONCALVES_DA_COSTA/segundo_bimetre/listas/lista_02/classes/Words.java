package listas.lista_02.classes;

public class Words {
  private int seApareceu = 0;
  private int talvezApaerceu = 0;
  private int hojeApareceu = 0;
  private int sabadoApareceu = 0;
  private int quartaApareceu = 0;

  public int getHojeApareceu() {
    return hojeApareceu;
  }

  public int getQuartaApareceu() {
    return quartaApareceu;
  }

  public int getSabadoApareceu() {
    return sabadoApareceu;
  }

  public int getSeApareceu() {
    return seApareceu;
  }

  public int getTalvezApareceu() {
    return talvezApaerceu;
  }

  public void setHojeApareceu() {
    this.hojeApareceu++;
  }

  public void setQuartaApareceu() {
    this.quartaApareceu++;
  }

  public void setSabadoApareceu() {
    this.sabadoApareceu++;
  }

  public void setSeApareceu() {
    this.seApareceu++;
  }

  public void setTalvezApareceu() {
    this.talvezApaerceu++;
  }
}
